/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class KomunikacijaSaServerom {

    private boolean zauzetPrijem = false;
    private static KomunikacijaSaServerom instance;
    private Socket socket;

    private KomunikacijaSaServerom() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static KomunikacijaSaServerom getInstance() {
        if (instance == null) {
            instance = new KomunikacijaSaServerom();
        }
        return instance;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) throws InterruptedException {
        try {
            if(zauzetPrijem){
                sleep(1000);
            }
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ServerskiOdgovor primiOdgovor() {

        zauzetPrijem = true;
        ServerskiOdgovor so = new ServerskiOdgovor();

        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
            zauzetPrijem = false;
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return so;
    }

    public boolean isZauzetPrijem() {
        return zauzetPrijem;
    }

    public void setZauzetPrijem(boolean zauzetPrijem) {
        this.zauzetPrijem = zauzetPrijem;
    }
    
    

}
