/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public interface OpstiDomenskiObjekat extends Serializable{
    
    public String dajIme();
    public String dajPrezime();
    public String vratiIme(ResultSet rs);
    public String vratiPrezime(ResultSet rs);
    
    public String vratiNazivTabele();
    public String vratiKoloneZaInsert();
    public String vratiVrednostiZaInsert();
    
    public String uzmiID();
    public String vratiUslovZaID();
    public int vratiID(ResultSet rs);
    
    public String vratiVrednostiZaUpdate();
    public String vratiUslovZaUpdate();
    public String vratiUslovZaDelete();
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;
    
    public String vratiUslovZaPretragu();
    

    public String vratiJoinTabelu();
    public String vratiUslovZaJoin();
    public String vratiJoinTabelu2();
    public String vratiUslovZaJoin2();

    public String vratiUslov();

    public String vratiVrednostiZaInsert2();

    public String vratiUslovZaPretragu2();

    public String vratiUslovZaDelete2();
    
    
}
