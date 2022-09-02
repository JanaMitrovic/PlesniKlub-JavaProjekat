/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavkezakazivanja;

import db.DbBroker;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZakazivanja;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP
 */
public class SOVratiStavkeZakazivanja extends OpstaSistemskaOperacija{

    ArrayList<OpstiDomenskiObjekat> lista;

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof StavkaZakazivanja)){
            throw new Exception("Greska...");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = DbBroker.getInstance().vratiTriTabeleSaUslovom(odo);
    }
    
}
