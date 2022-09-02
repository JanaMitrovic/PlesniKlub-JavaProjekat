/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Tecaj implements OpstiDomenskiObjekat {

    private int tecajID;
    private String naziv;
    private int velicinaGrupe;
    private String sala;
    private int trajanje; //u mesecima

    public Tecaj() {
    }

    public Tecaj(int tecajID, String naziv, int velicinaGrupe, String sala, int trajanje) {
        this.tecajID = tecajID;
        this.naziv = naziv;
        this.velicinaGrupe = velicinaGrupe;
        this.sala = sala;
        this.trajanje = trajanje;
    }

    public Tecaj(int tecajID) {
        this.tecajID = tecajID;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getTecajID() {
        return tecajID;
    }

    public void setTecajID(int tecajID) {
        this.tecajID = tecajID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getVelicinaGrupe() {
        return velicinaGrupe;
    }

    public void setVelicinaGrupe(int velicinaGrupe) {
        this.velicinaGrupe = velicinaGrupe;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
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
        final Tecaj other = (Tecaj) obj;
        if (this.tecajID != other.tecajID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "tecaj";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "naziv, velicinaGrupe, sala, trajanje";
    }
    
    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + naziv + "', " + velicinaGrupe + ", '" + sala + "', " + trajanje;
    }
    
    @Override
    public String uzmiID() {
        return "tecajID";
    }
    
    @Override
    public String vratiUslovZaID() {
        return "naziv = '" + naziv + "' AND velicinaGrupe = " + velicinaGrupe + " AND sala = '" + sala + "' AND trajanje = " + trajanje;
    }

    @Override
    public int vratiID(ResultSet rs) {
        int id = 0;
        try {
            while (rs.next()) {
                id = rs.getInt("tecajID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instruktor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    @Override
    public String vratiVrednostiZaUpdate() {
        return "naziv = '" + naziv + "', velicinaGrupe = " + velicinaGrupe + ", sala = '" + sala + "', trajanje = " + trajanje;
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "tecajID = " + tecajID;
    }
    
    
    @Override
    public String vratiUslovZaDelete() {
        return "tecajID = " + tecajID;
    }
    
    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaTecaja = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("tecajID");
            String naziv = rs.getString("naziv");
            int velicinaGrupe = rs.getInt("velicinaGrupe");
            String sala = rs.getString("sala");
            int trajanje = rs.getInt("trajanje");

            Tecaj t = new Tecaj(id, naziv, velicinaGrupe, sala, trajanje);
            listaTecaja.add(t);
        }
        return listaTecaja;
    }

    @Override
    public String vratiUslovZaPretragu() {
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
    public String vratiJoinTabelu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaInsert2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaDelete2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
