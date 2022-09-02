/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zakazivanjeTermina;

import db.DbBroker;
import domen.OpstiDomenskiObjekat;
import domen.ZakazivanjeTermina;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP
 */
public class SOZakazivanjeTermina extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof ZakazivanjeTermina)){
            throw new Exception("Greska...");
        }
         
        ZakazivanjeTermina zt = (ZakazivanjeTermina) odo;
        if (zt.getClan() == null)  throw new Exception("Zakazivanje nema unetog clana!");
        if (zt.getInstruktor() == null)  throw new Exception("Zakazivanje nema unetog instruktora!");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DbBroker.getInstance().sacuvaj(odo);
    }
    
}
