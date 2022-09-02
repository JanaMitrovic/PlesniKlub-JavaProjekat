/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Clan;
import domen.Instruktor;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZakazivanja;
import domen.Termin;
import domen.ZakazivanjeTermina;
import forme.ServerskaForma;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;
import so.zakazivanjeTermina.SOZakazivanjeTermina;
import so.clan.SOIzmeniClana;
import so.clan.SOPronadjiClanove;
import so.clan.SOUpisiClana;
import so.clan.SOPronadjiClana;
import so.instruktor.SODajIDInstruktora;
import so.instruktor.SODajImeInstruktora;
import so.instruktor.SODajPrezimeInstruktora;
import so.instruktor.SOIzmeniInstruktora;
import so.instruktor.SOPronadjiInstruktora;
import so.stavkezakazivanja.SOIzbrisiStavku;
import so.stavkezakazivanja.SOSacuvajStavku;
import so.stavkezakazivanja.SOVratiStavkeZakazivanja;
import so.tecaj.SOObrisiTecaj;
import so.tecaj.SOIzmeniTecaj;
import so.tecaj.SOPronadjiTecaj;
import so.tecaj.SOZapamtiTecaj;
import so.tecaj.SOVratiTecaje;
import so.termin.SOVratiTermine;
import so.zakazivanjeTermina.SOOtkazivanjeTermina;
import so.zakazivanjeTermina.SOPronadjiZakazivanja;
import so.zakazivanjeTermina.SOPronadjiZakazivanje;
import so.zakazivanjeTermina.SOVratiZakazivanjaSaUslovom;

/**
 *
 * @author HP
 */
public class Kontroler {

    private static Kontroler instance;
    private ServerskaForma forma;
    ArrayList<Socket> klijenti = new ArrayList<>();

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ServerskaForma getForma() {
        return forma;
    }

    public void setForma(ServerskaForma forma) {
        this.forma = forma;
    }

    public ArrayList<Socket> getKlijenti() {
        return klijenti;
    }

    public void dodajKlijenta(Socket socket) {
        klijenti.add(socket);
    }

    public Object pronadjiInstruktora(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiInstruktora();
        oso.izvrsi(odo);
        return ((SOPronadjiInstruktora) oso).getLista();
    }

    public int dajIDInstruktora(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SODajIDInstruktora();
        oso.izvrsi(odo);
        return ((SODajIDInstruktora) oso).getId();

    }

    public String dajImeInstruktora(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SODajImeInstruktora();
        oso.izvrsi(odo);
        return ((SODajImeInstruktora) oso).getIme();
    }

    public String dajPrezimeInstruktora(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SODajPrezimeInstruktora();
        oso.izvrsi(odo);
        return ((SODajPrezimeInstruktora) oso).getPrezime();
    }

    public void izmeniInstruktora(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzmeniInstruktora();
        oso.izvrsi(odo);
    }

    public void zapamtiTecaj(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOZapamtiTecaj();
        oso.izvrsi(odo);
    }

    public List<OpstiDomenskiObjekat> ucitajListuTecaja(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiTecaje();
        oso.izvrsi(odo);
        return ((SOVratiTecaje) oso).getLista();
    }

    public int pronadjiTecaj(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiTecaj();
        oso.izvrsi(odo);
        return ((SOPronadjiTecaj) oso).getId();
    }

    public void izmeniTecaj(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzmeniTecaj();
        oso.izvrsi(odo);
    }

    public void obrisiTecaj(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOObrisiTecaj();
        oso.izvrsi(odo);
    }

    public void upisiClana(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOUpisiClana();
        oso.izvrsi(odo);
    }

    public ArrayList<OpstiDomenskiObjekat> pronadjiClanove(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiClanove();
        oso.izvrsi(odo);
        return ((SOPronadjiClanove) oso).getLista();
    }

    public int pronadjiClana(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiClana();
        oso.izvrsi(odo);
        return ((SOPronadjiClana) oso).getId();
    }

    public void izmeniClana(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzmeniClana();
        oso.izvrsi(odo);
    }

    public List<OpstiDomenskiObjekat> ucitajListuTermina(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiTermine();
        oso.izvrsi(odo);
        return ((SOVratiTermine) oso).getLista();
    }

    public boolean postojiZakazivanje(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiZakazivanjaSaUslovom();
        oso.izvrsi(odo);
        ArrayList<OpstiDomenskiObjekat> lista = ((SOVratiZakazivanjaSaUslovom) oso).getLista();
        if (lista.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void zakazivanjeTermina(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOZakazivanjeTermina();
        oso.izvrsi(odo);
    }

    public ArrayList<OpstiDomenskiObjekat> pronadjiZakazivanja(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiZakazivanja();
        oso.izvrsi(odo);
        return ((SOPronadjiZakazivanja) oso).getLista();
    }

    public int pronadjiZakazivanje(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiZakazivanje();
        oso.izvrsi(odo);
        return ((SOPronadjiZakazivanje) oso).getId();
    }

    public ArrayList<OpstiDomenskiObjekat> ucitajListuStavkiZakazivanja(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiStavkeZakazivanja();
        oso.izvrsi(odo);
        return ((SOVratiStavkeZakazivanja) oso).getLista();
    }

    public void sacuvajStavku(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOSacuvajStavku();
        oso.izvrsi(odo);
    }

    public void izbrisiStavku(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzbrisiStavku();
        oso.izvrsi(odo);
    }

    public void izmeniZakazivanje(OpstiDomenskiObjekat odo) throws Exception {

        ArrayList<StavkaZakazivanja> NoveStavke = ((ZakazivanjeTermina) odo).getStavkeZakazivanja();

        StavkaZakazivanja stavka = new StavkaZakazivanja();
        stavka.setZakazivanje((ZakazivanjeTermina) odo);
        ArrayList<OpstiDomenskiObjekat> StareStavke = ucitajListuStavkiZakazivanja(stavka);

        for (OpstiDomenskiObjekat stara : StareStavke) {
            OpstaSistemskaOperacija oso = new SOIzbrisiStavku();
            oso.izvrsi(stara);
        }

        for (StavkaZakazivanja nova : NoveStavke) {
            OpstaSistemskaOperacija oso = new SOSacuvajStavku();
            oso.izvrsi(nova);
        }

    }

    public void otkazivanjeTermina(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOOtkazivanjeTermina();
        oso.izvrsi(odo);
    }

}
