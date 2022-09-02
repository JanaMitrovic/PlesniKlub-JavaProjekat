/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.instruktor;

import db.DbBroker;
import domen.Instruktor;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP
 */
public class SOPronadjiInstruktora extends OpstaSistemskaOperacija{
    
    private List<OpstiDomenskiObjekat> lista;

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Instruktor)){
            throw new Exception("Greska...");
        }
        
        Instruktor instruktor = (Instruktor) odo;
        if (instruktor.getBrojLicence().isEmpty())  throw new Exception("Instruktor nema unet broj licence!");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = DbBroker.getInstance().vratiSaUslovom(odo);
    }
    
}
