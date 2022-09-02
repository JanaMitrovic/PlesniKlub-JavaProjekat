/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Tecaj;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KlijentskiZahtev;
import komunikacija.KomunikacijaSaServerom;
import komunikacija.ServerskiOdgovor;
import operacije.Operacije;

/**
 *
 * @author HP
 */
public class IzmeniTecajForma extends javax.swing.JDialog {

    private int id;

    /**
     * Creates new form IzmeniTecajForma
     */
    public IzmeniTecajForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTrajanje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtVelicina = new javax.swing.JTextField();
        btnOdustani = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        txtSala = new javax.swing.JTextField();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Naziv:");

        jLabel3.setText("Velicina grupe:");

        jLabel4.setText("Sala:");

        jLabel5.setText("Trajanje:");

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni tecaj");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi tecaj");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdustani))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(73, 73, 73)
                        .addComponent(txtNaziv))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addComponent(txtVelicina, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(78, 78, 78)
                        .addComponent(txtSala))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(54, 54, 54)
                        .addComponent(txtTrajanje)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtVelicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTrajanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdustani)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        String naziv = txtNaziv.getText();
        String velicina = txtVelicina.getText();
        String sala = txtSala.getText();
        String tr = txtTrajanje.getText();

        if (txtNaziv.getText().isEmpty() || txtVelicina.getText().isEmpty() || txtSala.getText().isEmpty() || txtTrajanje.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate popuniti sva polja!");
            return;
        }

        int velicinaGrupe = Integer.parseInt(txtVelicina.getText());
        int trajanje = Integer.parseInt(txtTrajanje.getText());

        Tecaj tecaj = new Tecaj(id, naziv, velicinaGrupe, sala, trajanje);

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_TECAJ);
        kz.setArgument(tecaj);

        try {
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tecaj.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();

        if (so.isUspesno()) {
            JOptionPane.showMessageDialog(this, so.getPoruka());
            PregledTecajaForma ptf = (PregledTecajaForma) getParent();
            ptf.popuniTabelu();
        } else {
            JOptionPane.showMessageDialog(this, so.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
        }

        this.dispose();
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        String naziv = txtNaziv.getText();
        String velicina = txtVelicina.getText();
        String sala = txtSala.getText();
        String tr = txtTrajanje.getText();

        int velicinaGrupe = Integer.parseInt(txtVelicina.getText());
        int trajanje = Integer.parseInt(txtTrajanje.getText());

        Tecaj tecaj = new Tecaj(id, naziv, velicinaGrupe, sala, trajanje);

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_TECAJ);
        kz.setArgument(tecaj);

        try {
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tecaj.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();

        if (so.isUspesno()) {
            JOptionPane.showMessageDialog(this, so.getPoruka());
            PregledTecajaForma ptf = (PregledTecajaForma) getParent();
            ptf.popuniTabelu();
        } else {
            JOptionPane.showMessageDialog(this, so.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
        }

        this.dispose();
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(IzmeniTecajForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IzmeniTecajForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IzmeniTecajForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IzmeniTecajForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IzmeniTecajForma dialog = new IzmeniTecajForma(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSala;
    private javax.swing.JTextField txtTrajanje;
    private javax.swing.JTextField txtVelicina;
    // End of variables declaration//GEN-END:variables

    void postaviVrednosti(Tecaj t) throws Exception{
        id = vratiIDTecaja(t);
        if(id == 0){
            throw new Exception();
        }
        txtNaziv.setText(t.getNaziv());
        txtVelicina.setText(String.valueOf(t.getVelicinaGrupe()));
        txtSala.setText(t.getSala());
        txtTrajanje.setText(String.valueOf(t.getTrajanje()));
    }

    private int vratiIDTecaja(Tecaj t) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRONADJI_TECAJ);
        kz.setArgument(t);

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

}
