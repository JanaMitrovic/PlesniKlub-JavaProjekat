/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Clan;
import domen.Instruktor;
import domen.ZakazivanjeTermina;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import komunikacija.KlijentskiZahtev;
import komunikacija.KomunikacijaSaServerom;
import komunikacija.ServerskiOdgovor;
import kontroler.Kontroler;
import modeli.ModelTabeleClanovi;
import operacije.Operacije;

/**
 *
 * @author HP
 */
public class PretraziClanoveForma extends javax.swing.JFrame {

    /**
     * Creates new form PretraziClanoveForma
     */
    public PretraziClanoveForma() {
        initComponents();
        this.setLocationRelativeTo(null);
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClanovi = new javax.swing.JTable();
        btnIzmeniClana = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();
        btnZakaziTermine = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pregled svih clanova");

        jLabel1.setText("Pretrazite clanove po prezimenu:");

        tblClanovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblClanovi);

        btnIzmeniClana.setText("Izmeni podatke o clanu");
        btnIzmeniClana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniClanaActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnZakaziTermine.setText("Zakazi termine");
        btnZakaziTermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZakaziTermineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrezime)
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeniClana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnZakaziTermine, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdustani)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeniClana)
                    .addComponent(btnZakaziTermine)
                    .addComponent(btnOdustani))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnIzmeniClanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniClanaActionPerformed
        int red = tblClanovi.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati clana iz tabele!");
            return;
        }

        ModelTabeleClanovi mtc = (ModelTabeleClanovi) tblClanovi.getModel();
        Clan c = mtc.vratiClana(red);
        c.setClanID(vratiIDClana(c));

        if (c.getClanID() != 0) {
            IzmeniClanaForma icf = new IzmeniClanaForma();
            icf.postaviVrednosti(c);
            icf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            icf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnIzmeniClanaActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        String filter = txtPrezime.getText().trim();

        Clan c = new Clan();

        if (filter.isEmpty()) {
            filter = "";
        }

        c.setFilter(filter);

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRONADJI_CLANOVE);
        kz.setArgument(c);

        try {
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        } catch (InterruptedException ex) {
            Logger.getLogger(PretraziClanoveForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();

        if (so.isUspesno()) {
            ArrayList<Clan> lista = (ArrayList<Clan>) so.getArgument();
            ModelTabeleClanovi mtc = (ModelTabeleClanovi) tblClanovi.getModel();
            mtc.setLista(lista);
            JOptionPane.showMessageDialog(this, so.getPoruka());
        } else {
            JOptionPane.showMessageDialog(this, so.getPoruka());
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnZakaziTermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZakaziTermineActionPerformed
        int red = tblClanovi.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati clana iz tabele!");
            return;
        }

        ModelTabeleClanovi mtc = (ModelTabeleClanovi) tblClanovi.getModel();
        Clan c = mtc.vratiClana(red);
        c.setClanID(vratiIDClana(c));

        if (postojiZakazivanje(c, Kontroler.getInstance().getInstruktor())) {
            JOptionPane.showMessageDialog(this, "Vec postiji zakazivanje za ovog clana!");
            PregledTerminaForma ptf = new PregledTerminaForma();
            ptf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ptf.setVisible(true);
        } else {
            ZakazivanjeTerminaForma ztf = new ZakazivanjeTerminaForma();
            ztf.postaviClana(c);
            ztf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ztf.setVisible(true);

        }


    }//GEN-LAST:event_btnZakaziTermineActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PretraziClanoveForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretraziClanoveForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretraziClanoveForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretraziClanoveForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PretraziClanoveForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeniClana;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnZakaziTermine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClanovi;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        ModelTabeleClanovi mtc = new ModelTabeleClanovi();
        tblClanovi.setModel(mtc);
    }

    private int vratiIDClana(Clan c) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRONADJI_CLANA);
        kz.setArgument(c);

        try {
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        } catch (InterruptedException ex) {
            Logger.getLogger(IzmeniClanaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();

        if (so.isUspesno()) {
            JOptionPane.showMessageDialog(this, so.getPoruka());
            return (int) so.getArgument();
        } else {
            JOptionPane.showMessageDialog(this, so.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    private boolean postojiZakazivanje(Clan c, Instruktor instruktor) {
        ZakazivanjeTermina zt = new ZakazivanjeTermina(0, c, instruktor, null);
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.POSTOJI_ZAKAZIVANJE);
        kz.setArgument(zt);

        try {
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        } catch (InterruptedException ex) {
            Logger.getLogger(PretraziClanoveForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();

        if (so.isUspesno()) {
            return (boolean) so.getArgument();
        } else {
            JOptionPane.showMessageDialog(this, so.getPoruka());
            return false;
        }

    }
}