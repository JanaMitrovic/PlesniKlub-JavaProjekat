/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tecaj;

import db.DbBroker;
import domen.OpstiDomenskiObjekat;
import domen.Tecaj;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP
 */
public class SOPronadjiTecaj extends OpstaSistemskaOperacija{
    
    private int id;

    public int getId() {
        return id;
    }
    
    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Tecaj)){
            throw new Exception("Greska...");
        }
         
        Tecaj tecaj = (Tecaj) odo;
        if (tecaj.getNaziv().isEmpty())  throw new Exception("Tecaj nema unet naziv!");
        if (tecaj.getSala().isEmpty())  throw new Exception("Tecaj nema unetu salu!");
        if (tecaj.getVelicinaGrupe() == 0)  throw new Exception("Tecaj nema unetu velicinu grupe!");
        if (tecaj.getTrajanje() == 0)  throw new Exception("Tecaj nema uneto trajanje!");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        id = DbBroker.getInstance().dajID(odo);
    }
    
}
