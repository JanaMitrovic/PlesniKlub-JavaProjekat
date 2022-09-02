/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Instruktor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HO
 */
public class PokretanjeServera extends Thread {

    private static boolean radi = false;
    private ServerSocket serverSocket;
    private static List<NitKlijenta> klijenti = new ArrayList<>();

    public static boolean isRadi() {
        return radi;
    }

    public static void setRadi(boolean aRadi) {
        radi = aRadi;
    }

    public PokretanjeServera() {
        try {
            serverSocket = new ServerSocket(9000);
        } catch (IOException ex) {
            System.out.println("GRESKA: Server nije pokrenut.");
        }
    }

    @Override
    public void run() {
        try {
            Socket socket;
            System.out.println("Server je pokrenut...");

            while (!isInterrupted()) {
                socket = serverSocket.accept();
                kontroler.Kontroler.getInstance().dodajKlijenta(socket);
                NitKlijenta nitKlijenta = new NitKlijenta(socket, klijenti);
                nitKlijenta.start();
                klijenti.add(nitKlijenta);
                System.out.println("Klijent se povezao...");

            }
        } catch (SocketException ex) {
            System.out.println("Prekinula se konekcija sa serverom!");
        } catch (IOException ex) {
            System.out.println("Greska prilikom povezivanja klijenta!");
        }

    }

    public void zaustaviSveKlijentNiti() {
        try {
            serverSocket.close();
            for (NitKlijenta nitKlijenta : klijenti) {
                nitKlijenta.getSocket().close();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
