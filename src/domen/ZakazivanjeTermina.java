/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ZakazivanjeTermina implements OpstiDomenskiObjekat{
    
    private int zakazivanjeID;
    private Clan clan;
    private Instruktor instruktor;
    private ArrayList<StavkaZakazivanja> stavkeZakazivanja;
    private String filter;

    public ZakazivanjeTermina() {
    }

    public ZakazivanjeTermina(int zakazivanjeID, Clan clan, Instruktor instruktor, ArrayList<StavkaZakazivanja> stavkeZakazivanja) {
        this.zakazivanjeID = zakazivanjeID;
        this.clan = clan;
        this.instruktor = instruktor;
        this.stavkeZakazivanja = stavkeZakazivanja;
    }

    public ArrayList<StavkaZakazivanja> getStavkeZakazivanja() {
        return stavkeZakazivanja;
    }

    public void setStavkeZakazivanja(ArrayList<StavkaZakazivanja> stavkeZakazivanja) {
        this.stavkeZakazivanja = stavkeZakazivanja;
    }
    
    public ZakazivanjeTermina(int zakazivanjeID) {
        this.zakazivanjeID = zakazivanjeID;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public int getZakazivanjeID() {
        return zakazivanjeID;
    }

    public void setZakazivanjeID(int zakazivanjeID) {
        this.zakazivanjeID = zakazivanjeID;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ZakazivanjeTermina other = (ZakazivanjeTermina) obj;
        if (this.zakazivanjeID != other.zakazivanjeID) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "zakazivanjetermina";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "clan, instruktor";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return clan.getClanID() + ", " + instruktor.getInstruktorID();
    }

    @Override
    public String vratiJoinTabelu() {
        return "clan";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "zakazivanjetermina.clan = clan.clanID";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "instruktor";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "zakazivanjetermina.instruktor = instruktor.instruktorID";
    }

    @Override
    public String vratiUslovZaPretragu() {
        if(filter.equals("")){
           return "zakazivanjetermina.instruktor = " + instruktor.getInstruktorID() + " AND clan.prezime LIKE '%'"; 
        }
        return "zakazivanjetermina.instruktor = " + instruktor.getInstruktorID() + " AND clan.prezime LIKE " + "'" + filter + "%'";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaTermina = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("zakazivanjetermina.zakazivanjeID");
            
            int clanID = rs.getInt("clan.clanID");
            String ime = rs.getString("clan.ime");
            String prezime = rs.getString("clan.prezime");
            String brojTelefona = rs.getString("clan.brojTelefona");
            String email = rs.getString("clan.email");
            Date datumUpisa = rs.getDate("clan.datumUpisa");
            Clan clan =  new Clan(clanID, ime, prezime, brojTelefona, email, datumUpisa);
            
            int instruktorID = rs.getInt("instruktor.instruktorID");
            String i = rs.getString("instruktor.ime");
            String p = rs.getString("instruktor.prezime");
            String brojLicence = rs.getString("instruktor.brojLicence");
            boolean ulogovan = rs.getBoolean("instruktor.ulogovan");
            Instruktor instruktor = new Instruktor(instruktorID, i, p, brojLicence, ulogovan);
            
            ZakazivanjeTermina zt = new ZakazivanjeTermina(id, clan, instruktor, null);
            listaTermina.add(zt);
        }
        return listaTermina;
    }

    @Override
    public String uzmiID() {
        return "zakazivanjeID";
    }

    @Override
    public String vratiUslovZaID() {
        return "clan = " + clan.getClanID() + " AND instruktor = " + instruktor.getInstruktorID();
    }

    @Override
    public int vratiID(ResultSet rs) {
        int id = 0;
        try {
            while (rs.next()) {
                id = rs.getInt("zakazivanjeID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instruktor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    @Override
    public String vratiUslovZaPretragu2() {
        return "zakazivanjetermina.instruktor = " + instruktor.getInstruktorID();
    }

    @Override
    public String dajIme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajPrezime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiIme(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPrezime(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslov() {
        return "zakazivanjetermina.clan = " + clan.getClanID() + " AND zakazivanjetermina.instruktor = " + instruktor.getInstruktorID();
     }

    @Override
    public String vratiVrednostiZaInsert2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaDelete() {
        return "zakazivanjeID = " + zakazivanjeID;
    }

    @Override
    public String vratiUslovZaDelete2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
