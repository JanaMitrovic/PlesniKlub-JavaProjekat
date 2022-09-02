/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavkezakazivanja;

import db.DbBroker;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZakazivanja;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP
 */
public class SOSacuvajStavku extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof StavkaZakazivanja)){
            throw new Exception("Greska...");
        }
         
        StavkaZakazivanja sz = (StavkaZakazivanja) odo;
        if (sz.getTecaj()== null)  throw new Exception("Stavka nema unet tecaj!");
        if (sz.getTermin()== null)  throw new Exception("Stavka nema unet termin!");
        if (sz.getZakazivanje()== null)  throw new Exception("Stavka nema uneto zakazivanje!");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DbBroker.getInstance().kreiraj2(odo);
    }
    
}
