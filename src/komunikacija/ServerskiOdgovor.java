/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class ServerskiOdgovor implements Serializable{
    
   private String poruka;
   private int operacija;
   private Object argument;
   private boolean uspesno;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(String poruka, Object argument, boolean uspesno) {
        this.poruka = poruka;
        this.argument = argument;
        this.uspesno = uspesno;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
   
   
   
    
}
