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
public class Clan implements OpstiDomenskiObjekat{
    
    private int clanID;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private String email;
    private Date datumUpisa;
    private String filter;

    public Clan() {
    }

    public Clan(int clanID, String ime, String prezime, String brojTelefona, String email, Date datumUpisa) {
        this.clanID = clanID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.datumUpisa = datumUpisa;
    }
    
    public Clan(int clanID) {
        this.clanID = clanID;
    }


    public int getClanID() {
        return clanID;
    }

    public void setClanID(int clanID) {
        this.clanID = clanID;
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

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumUpisa() {
        return datumUpisa;
    }

    public void setDatumUpisa(Date datumUpisa) {
        this.datumUpisa = datumUpisa;
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
        final Clan other = (Clan) obj;
        if (this.clanID != other.clanID) {
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
        return "clan";
    }
    
    @Override
    public String vratiKoloneZaInsert() {
        return "ime, prezime, brojTelefona, email, datumUpisa";
    }
    
    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" + brojTelefona + "', '" + email + "', '" + new java.sql.Date(datumUpisa.getTime()) + "'";
    }

    @Override
    public String vratiUslovZaPretragu() {
        if(filter.equals("")){
            return "prezime LIKE '%'"; 
        }
        return "prezime LIKE " + "'" + filter + "%'";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaClanova = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("clanID");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String brojTelefona = rs.getString("brojTelefona");
            String email = rs.getString("email");
            Date datumUpisa = rs.getDate("datumUpisa");
            
            Clan c = new Clan(clanID, ime, prezime, brojTelefona, email, datumUpisa);
            listaClanova.add(c);
        }
        return listaClanova;
    }

    @Override
    public String uzmiID() {
        return "clanID";
    }

    @Override
    public String vratiUslovZaID() {
        return "ime = '" + ime + "' AND prezime = '" + prezime + "' AND brojTelefona = '" + brojTelefona + "' AND email ='" + email + "' AND datumUpisa = '" + new java.sql.Date(datumUpisa.getTime()) + "'";
    }

    @Override
    public int vratiID(ResultSet rs) {
        int id = 0;
        try {
            while (rs.next()) {
                id = rs.getInt("clanID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instruktor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "ime = '" + ime + "', prezime = '" + prezime + "', brojTelefona = '" + brojTelefona + "', email = '" + email + "', datumUpisa = '" + new java.sql.Date(datumUpisa.getTime()) + "'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "clanID = " + clanID;
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
    public String vratiUslovZaDelete() {
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
