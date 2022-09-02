/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Instruktor;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZakazivanja;
import domen.Tecaj;
import domen.ZakazivanjeTermina;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DbBroker {

    private Connection konekcija;
    private static DbBroker instance;

    private DbBroker() throws IOException, SQLException {

        DbProperties dbp = new DbProperties();
        String url = dbp.vratiDbUrl();
        String user = dbp.vratiDbUsername();
        String password = dbp.vratiDbPassword();
        konekcija = DriverManager.getConnection(url, user, password);
        konekcija.setAutoCommit(false);

    }

    public static DbBroker getInstance() throws IOException, SQLException, Exception {
        if (instance == null) {
            instance = new DbBroker();
        }
        return instance;
    }

    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
    }

    public void potvrdiTransakciju() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ponistiTransakciju() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public ArrayList<OpstiDomenskiObjekat> vratiSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public String dajIme(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT " + odo.dajIme() + " FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaID();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.vratiIme(rs);
    }

    public String dajPrezime(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT " + odo.dajPrezime() + " FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaID();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.vratiPrezime(rs);
    }
    
    public void kreiraj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiKoloneZaInsert() + ") " + " VALUES (" + odo.vratiVrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.executeUpdate(upit);
    }
    
    public int dajID(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT " + odo.uzmiID() + " FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaID();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.vratiID(rs);
    }
    
    public ArrayList<OpstiDomenskiObjekat> vratiBezUslova(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiUslovZaUpdate();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        st.executeUpdate(upit);
        st.close();
    }
    
    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaDelete();
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.executeUpdate(upit);
    }
    
    public void izbrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaDelete2();
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.executeUpdate(upit);
    }
    
    public void kreiraj2(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiKoloneZaInsert() + ") " + " VALUES (" + odo.vratiVrednostiZaInsert2() + ")";
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.executeUpdate(upit);
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiKoloneZaInsert() + ") " + " VALUES (" + odo.vratiVrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int zakazivanjeID = (int) keys.getLong(1);

        ArrayList<StavkaZakazivanja> stavke = ((ZakazivanjeTermina) odo).getStavkeZakazivanja();

        for (OpstiDomenskiObjekat s : stavke) {
            upit = "INSERT INTO " + s.vratiNazivTabele() + "(" + s.vratiKoloneZaInsert() + ") " + " VALUES (" + zakazivanjeID + ", " + s.vratiVrednostiZaInsert() + ")";
            System.out.println(upit);
            ps = konekcija.prepareStatement(upit);
            ps.executeUpdate();
        }

    }
    
    public void ukloni(OpstiDomenskiObjekat odo) throws SQLException {
        OpstiDomenskiObjekat o = new StavkaZakazivanja();
        ((StavkaZakazivanja) o).setZakazivanje((ZakazivanjeTermina) odo);
        String upit = "DELETE FROM " + o.vratiNazivTabele() + " WHERE " + o.vratiUslovZaDelete();
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.executeUpdate();
        
        upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaDelete();
        System.out.println(upit);
        PreparedStatement ps2 = konekcija.prepareStatement(upit);
        ps2.executeUpdate();
    }
    
    public ArrayList<OpstiDomenskiObjekat> vratiJoinovaneTriTabele(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM "+odo.vratiNazivTabele() + " JOIN "
                +odo.vratiJoinTabelu()+ " ON "+odo.vratiUslovZaJoin()+" JOIN "
                +odo.vratiJoinTabelu2()+ " ON "+odo.vratiUslovZaJoin2() + " WHERE " + odo.vratiUslovZaPretragu2();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public ArrayList<OpstiDomenskiObjekat> vratiJoinovaneTriTabeleSaFilterom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM "+ odo.vratiNazivTabele() + " JOIN "
                +odo.vratiJoinTabelu()+ " ON "+odo.vratiUslovZaJoin()+" JOIN "
                +odo.vratiJoinTabelu2()+ " ON "+odo.vratiUslovZaJoin2() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public ArrayList<OpstiDomenskiObjekat> vratiTriTabeleSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON "+odo.vratiUslovZaJoin() +" JOIN "
                + odo.vratiJoinTabelu2() + " ON "+odo.vratiUslovZaJoin2() + " WHERE " + odo.vratiUslov();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    

}
