/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Clan;
import domen.Instruktor;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZakazivanja;
import domen.Tecaj;
import domen.Termin;
import domen.ZakazivanjeTermina;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KlijentskiZahtev;
import komunikacija.ServerskiOdgovor;
import kontroler.Kontroler;
import operacije.Operacije;

/**
 *
 * @author HP
 */
public class NitKlijenta extends Thread {

    private Socket socket;
    private List<NitKlijenta> klijenti;
    private Instruktor instruktor;
    boolean kraj;

    public NitKlijenta(Socket socket, List<NitKlijenta> klijenti) {
        this.socket = socket;
        this.klijenti = klijenti;
        instruktor = new Instruktor();
    }

    @Override
    public void run() {

        while (!kraj) {

            try {
                System.out.println("Ceka se zahtev klijenta...");
                KlijentskiZahtev kz = primiZahtev();
                ServerskiOdgovor so = new ServerskiOdgovor();

                switch (kz.getOperacija()) {

                    case Operacije.LOGIN:
                        try {
                            instruktor = (Instruktor) kz.getArgument();

                            List<Instruktor> listaInstruktora = (List<Instruktor>) Kontroler.getInstance().pronadjiInstruktora(instruktor);
                            if (listaInstruktora.isEmpty()) {
                                throw new Exception();
                            }
                            for (int i = 0; i < listaInstruktora.size(); i++) {
                                Instruktor ins = listaInstruktora.get(i);
                                if (instruktor.getBrojLicence().equals(ins.getBrojLicence()) && ins.isUlogovan()) {
                                    so.setPoruka("Vec ste ulogovani!");
                                    so.setUspesno(false);
                                } else {
                                    instruktor.setInstruktorID(Kontroler.getInstance().dajIDInstruktora((OpstiDomenskiObjekat) kz.getArgument()));
                                    instruktor.setIme(Kontroler.getInstance().dajImeInstruktora((OpstiDomenskiObjekat) kz.getArgument()));
                                    instruktor.setPrezime(Kontroler.getInstance().dajPrezimeInstruktora((OpstiDomenskiObjekat) kz.getArgument()));

                                    Kontroler.getInstance().izmeniInstruktora((OpstiDomenskiObjekat) kz.getArgument());
                                    instruktor.setUlogovan(true);
                                    so.setArgument(instruktor);
                                    so.setPoruka("Instruktor " + instruktor.toString() + " se uspesno prijavio!");
                                    so.setUspesno(true);

                                }
                            }
                        } catch (Exception ex) {
                            so.setPoruka("Sistem ne moze da vas prijavi!");
                            so.setUspesno(false);
                            System.out.println("Korisnik nije u bazi!");
                        }
                        break;
                    case Operacije.LOGOUT:
                        try {
                            Kontroler.getInstance().izmeniInstruktora((OpstiDomenskiObjekat) kz.getArgument());
                            kraj = true;
                            so.setUspesno(true);
                            so.setPoruka("Uspesno ste se izlogovali!");
                        } catch (Exception ex) {
                            so.setUspesno(false);
                            so.setPoruka("Greska prilikom pokusaja da se izlogujete!");
                        }
                        break;
                    case Operacije.ZAPAMTI_TECAJ:
                        try {
                            Kontroler.getInstance().zapamtiTecaj((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je zapamtio tecaj!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da zapamti tecaj!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.UCITAJ_LISTU_TECAJA:
                        try {
                            List<OpstiDomenskiObjekat> tecaji = Kontroler.getInstance().ucitajListuTecaja(new Tecaj());
                            so.setArgument(tecaji);
                            so.setPoruka("Uspesno su ucitani tecaji!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da ucita tecaje!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.PRONADJI_TECAJ:
                        try {
                            int id = Kontroler.getInstance().pronadjiTecaj((OpstiDomenskiObjekat) kz.getArgument());
                            so.setArgument(id);
                            so.setPoruka("Sistem nasao izabrani tecaj!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da nadje izabrani tecaj!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.IZMENI_TECAJ:
                        try {
                            Kontroler.getInstance().izmeniTecaj((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je izmenio tecaj!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da izmeni tecaj!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.OBRISI_TECAJ:
                        try {
                            Kontroler.getInstance().obrisiTecaj((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je obrisao tecaj!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da obrise tecaj!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.UPISI_CLANA:
                        try {
                            Kontroler.getInstance().upisiClana((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je uspesno upisao novog clana!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem nije uspeo da upise novog clana!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.PRONADJI_CLANOVE:
                        try {
                            ArrayList<OpstiDomenskiObjekat> listaClanova = Kontroler.getInstance().pronadjiClanove((OpstiDomenskiObjekat) kz.getArgument());
                            so.setArgument(listaClanova);
                            so.setPoruka("Sistem je nasao clanove po zadatoj vrednosti!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da nadje clanove po zadatoj vrednosti!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.PRONADJI_CLANA:
                        try {
                            int id = Kontroler.getInstance().pronadjiClana((OpstiDomenskiObjekat) kz.getArgument());
                            so.setArgument(id);
                            so.setPoruka("Sistem je nasao izabrang clana!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da nadje izabranog clana!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.IZMENI_CLANA:
                        try {
                            Kontroler.getInstance().izmeniClana((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je izmenio podatke o clanu!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da izmeni clana!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.UCITAJ_LISTU_TERMINA:
                        try {
                            List<OpstiDomenskiObjekat> termini = Kontroler.getInstance().ucitajListuTermina(new Termin());
                            so.setArgument(termini);
                            so.setPoruka("Uspesno su ucitani termini!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da ucita termine!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.POSTOJI_ZAKAZIVANJE:
                        try {
                            boolean postoji = Kontroler.getInstance().postojiZakazivanje((OpstiDomenskiObjekat) kz.getArgument());
                            so.setArgument(postoji);
                            so.setPoruka("Vec postoji zakazivanje za ovog clana!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Ne postoji zakazivanje za ovog clana");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.ZAKAZIVANJE_TERMINA:
                        try {
                            Kontroler.getInstance().zakazivanjeTermina((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je zakazao termine!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da zakaze termine!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.PRONADJI_ZAKAZIVANJA:
                        try {
                            ArrayList<OpstiDomenskiObjekat> listaTermina = Kontroler.getInstance().pronadjiZakazivanja((OpstiDomenskiObjekat) kz.getArgument());
                            so.setArgument(listaTermina);
                            if(((ArrayList<ZakazivanjeTermina>) so.getArgument()).isEmpty()){
                                throw new Exception();
                            }
                            so.setPoruka("Sistem je nasao zakazane termine po zadatoj vrednosti!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da nadje zakazane termine po zadatoj vrednosti!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.PRONADJI_ZAKAZIVANJE:
                        try {
                            int id = Kontroler.getInstance().pronadjiZakazivanje((OpstiDomenskiObjekat) kz.getArgument());
                            so.setArgument(id);
                            so.setPoruka("Sistem je nasao izabrano zakazivanje termina!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da nadje izabrano zakazivanje termina!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.UCITAJ_LISTU_STAVKI_ZAKAZIVANJA:
                        try {
                            ZakazivanjeTermina zakazivanje = (ZakazivanjeTermina) kz.getArgument();
                            StavkaZakazivanja s = new StavkaZakazivanja();
                            s.setZakazivanje(zakazivanje);
                            ArrayList<OpstiDomenskiObjekat> stavke = Kontroler.getInstance().ucitajListuStavkiZakazivanja((OpstiDomenskiObjekat)s);
                            so.setArgument(stavke);
                            so.setPoruka("Uspesno su pronadjene stavke!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da pronadje stavke!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.IZMENI_ZAKAZIVANJE:
                        try {
                            Kontroler.getInstance().izmeniZakazivanje((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je promenio podatke o zakazivanju termina!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da promeni zakazivanje termina!");
                            so.setUspesno(false);
                        }
                        break;
                        
                    case Operacije.SACUVAJ_STAVKU:
                        try {
                            Kontroler.getInstance().sacuvajStavku((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je uspesno sacuvao stavku zakazivanja!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem nije uspeo da sacuva stavku zakazivanja!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.IZBRISI_STAVKU:
                        try {
                            Kontroler.getInstance().izbrisiStavku((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je uspesno izbrisao stavku zakazivanja!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem nije uspeo da izbrise stavku zakazivanja!");
                            so.setUspesno(false);
                        }
                        break;
                    case Operacije.OTKAZIVANJE_TERMINA:
                        try {
                            Kontroler.getInstance().otkazivanjeTermina((OpstiDomenskiObjekat) kz.getArgument());
                            so.setPoruka("Sistem je obrisao podatke o zakazivanju termina!");
                            so.setUspesno(true);
                        }catch(Exception ex){
                            so.setPoruka("Sistem ne moze da obrise podatke o zakazivanju termina!");
                            so.setUspesno(false);
                        }
                        break;
                        
                }

                posaljiOdgovor(so);

            } catch (Exception ex) {
                Logger.getLogger(NitKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(NitKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private KlijentskiZahtev primiZahtev() throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        kz = (KlijentskiZahtev) ois.readObject();

        return kz;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public OpstiDomenskiObjekat getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

}
