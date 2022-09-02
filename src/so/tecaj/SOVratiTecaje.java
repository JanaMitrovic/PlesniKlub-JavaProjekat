/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tecaj;

import db.DbBroker;
import domen.OpstiDomenskiObjekat;
import domen.Tecaj;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP
 */
public class SOVratiTecaje extends OpstaSistemskaOperacija{

    List<OpstiDomenskiObjekat> lista;

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    
    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Tecaj)){
            throw new Exception("Greska...");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = DbBroker.getInstance().vratiBezUslova(odo);
    }
    
}
