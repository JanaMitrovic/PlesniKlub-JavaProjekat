/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zakazivanjeTermina;

import db.DbBroker;
import domen.OpstiDomenskiObjekat;
import domen.ZakazivanjeTermina;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP
 */
public class SOPronadjiZakazivanja extends OpstaSistemskaOperacija{
    
    private ArrayList<OpstiDomenskiObjekat> lista;

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof ZakazivanjeTermina)){
            throw new Exception("Greska...");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = DbBroker.getInstance().vratiJoinovaneTriTabeleSaFilterom(odo);
    }
}