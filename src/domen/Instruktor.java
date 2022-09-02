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
public class Instruktor implements OpstiDomenskiObjekat {

    private int instruktorID;
    private String ime;
    private String prezime;
    private String brojLicence;
    private boolean ulogovan;

    public Instruktor() {
    }

    public Instruktor(int instruktorID, String ime, String prezime, String brojLicence, boolean ulogovan) {
        this.instruktorID = instruktorID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojLicence = brojLicence;
        this.ulogovan = ulogovan;
    }

    public Instruktor(int instruktorID) {
        this.instruktorID = instruktorID;
    }

    public String getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(String brojLicence) {
        this.brojLicence = brojLicence;
    }

    public int getInstruktorID() {
        return instruktorID;
    }

    public void setInstruktorID(int instruktorID) {
        this.instruktorID = instruktorID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
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
        final Instruktor other = (Instruktor) obj;
        if (this.instruktorID != other.instruktorID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "instruktor";
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "instruktor.brojLicence = '" + brojLicence + "'";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaInstruktora = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("instruktorID");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String brojLicence = rs.getString("brojLicence");
            boolean ulogovan = rs.getBoolean("ulogovan");

            Instruktor i = new Instruktor(id, ime, prezime, brojLicence, ulogovan);
            listaInstruktora.add(i);
        }
        return listaInstruktora;
    }

    @Override
    public String uzmiID() {
        return "instruktorID";
    }

    @Override
    public String vratiUslovZaID() {
        return "instruktor.brojLicence = '" + brojLicence + "'";
    }

    @Override
    public int vratiID(ResultSet rs) {
        int id = 0;
        try {
            while (rs.next()) {
                id = rs.getInt("instruktorID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instruktor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public String dajIme() {
        return "ime";
    }

    @Override
    public String dajPrezime() {
        return "prezime";
    }

    @Override
    public String vratiIme(ResultSet rs) {
        String ime = "";
        try {
            while(rs.next()){
                ime = rs.getString("ime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instruktor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ime;
    }

    @Override
    public String vratiPrezime(ResultSet rs) {
        String prez = "";
        try {
            while(rs.next()){
                prez = rs.getString("prezime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instruktor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prez;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        int login = 1;
        if(ulogovan){
            login = 0;
        }
        
        return "instruktor.ulogovan = " + login;
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "instruktor.brojLicence = '" + brojLicence + "'";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKoloneZaInsert() {
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
    public String vratiUslovZaDelete() {
        return "instruktor.brojLicence = '" + brojLicence + "'";
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
