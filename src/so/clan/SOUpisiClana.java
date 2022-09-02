/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import db.DbBroker;
import domen.Clan;
import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP
 */
public class SOUpisiClana extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Clan)){
            throw new Exception("Greska...");
        }
         
        Clan clan = (Clan) odo;
        if (clan.getIme().isEmpty())  throw new Exception("Clan nema uneto ime!");
        if (clan.getPrezime().isEmpty())  throw new Exception("Clan nema uneto prezime!");
        if (clan.getBrojTelefona().isEmpty())  throw new Exception("Clan nema unet broj telefona!");
        if (clan.getEmail().isEmpty())  throw new Exception("Clan nema unet email!");
        if (clan.getDatumUpisa() == null)  throw new Exception("Clan nema unetdatum upisa!");

    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DbBroker.getInstance().kreiraj(odo);
    }
    
}
