/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class StavkaZakazivanja implements OpstiDomenskiObjekat{
    
    private int rb;
    private ZakazivanjeTermina zakazivanje;
    private Tecaj tecaj;
    private Termin termin;

    public StavkaZakazivanja() {
    }

    public StavkaZakazivanja(int rb, ZakazivanjeTermina zakazivanje, Tecaj tecaj, Termin termin) {
        this.rb = rb;
        this.zakazivanje = zakazivanje;
        this.tecaj = tecaj;
        this.termin = termin;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public ZakazivanjeTermina getZakazivanje() {
        return zakazivanje;
    }

    public void setZakazivanje(ZakazivanjeTermina zakazivanje) {
        this.zakazivanje = zakazivanje;
    }

    public Tecaj getTecaj() {
        return tecaj;
    }

    public void setTecaj(Tecaj tecaj) {
        this.tecaj = tecaj;
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
        final StavkaZakazivanja other = (StavkaZakazivanja) obj;
        if (this.rb != other.rb) {
            return false;
        }
        if (!Objects.equals(this.zakazivanje, other.zakazivanje)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkazakazivanja";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "zakazivanjeID, rb, tecaj, termin";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return rb + ", " + tecaj.getTecajID() + ", " + termin.getTerminID();
    }
    
    @Override
    public String vratiVrednostiZaInsert2() {
        return zakazivanje.getZakazivanjeID() + ", " + rb + ", " + tecaj.getTecajID() + ", " + termin.getTerminID();
    }
    
    @Override
    public String vratiJoinTabelu() {
        return "tecaj";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "stavkazakazivanja.tecaj = tecaj.tecajID";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "termin";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "stavkazakazivanja.termin = termin.terminID";
    }

    @Override
    public String vratiUslov() {
        return "stavkazakazivanja.zakazivanjeID = " + zakazivanje.getZakazivanjeID() + " ORDER BY stavkazakazivanja.rb";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaStavki = new ArrayList<>();
        while(rs.next()){
            int rb = rs.getInt("stavkazakazivanja.rb");
            
            int zakazivanjeID = rs.getInt("stavkazakazivanja.zakazivanjeID");
            ZakazivanjeTermina zakazivanje = new ZakazivanjeTermina();
            zakazivanje.setZakazivanjeID(zakazivanjeID);
            
            int tecajID = rs.getInt("tecaj.tecajID");
            String naziv = rs.getString("tecaj.naziv");
            int velicinaGrupe = rs.getInt("tecaj.velicinaGrupe");
            String sala = rs.getString("tecaj.sala");
            int trajanje = rs.getInt("tecaj.trajanje");
            Tecaj tecaj = new Tecaj(tecajID, naziv, velicinaGrupe, sala, trajanje);
            
            int terminID = rs.getInt("termin.terminID");
            Timestamp timestamp = rs.getTimestamp("termin.datumVreme");
            Date datumVreme = new Date(timestamp.getTime());
            Termin termin = new Termin(terminID, datumVreme);
            
            StavkaZakazivanja sz = new StavkaZakazivanja(rb, zakazivanje, tecaj, termin);
            
            listaStavki.add(sz);
            
        }
        
        return listaStavki;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "rb = " + rb;
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "zakazivanjeID = " + zakazivanje.getZakazivanjeID() + " AND tecaj = " + tecaj.getTecajID() + " AND termin = " + termin.getTerminID();
    }

    @Override
    public String vratiUslovZaDelete() {
        return "zakazivanjeID = " + zakazivanje.getZakazivanjeID();
    }

    @Override
    public String vratiUslovZaDelete2() {
        return "zakazivanjeID = " + zakazivanje.getZakazivanjeID() + " AND rb = " + rb;
    }

    @Override
    public String vratiUslovZaPretragu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String uzmiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiID(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
}
