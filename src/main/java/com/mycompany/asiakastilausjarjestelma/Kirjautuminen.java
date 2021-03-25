package com.mycompany.asiakastilausjarjestelma;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Kirjautuminen extends javax.swing.JFrame {

    public Kirjautuminen() {
        initComponents();
    }

    public void sulje() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtTunnus = new javax.swing.JTextField();
        jpswSalasana = new javax.swing.JPasswordField();
        jbtnKirjaudu = new javax.swing.JButton();
        jchkSalasana = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tervetuloa Asiakastilaus-tietojärjestelmään.");

        jLabel2.setText("Tunnus:");

        jLabel3.setText("Salasana:");

        jpswSalasana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpswSalasanaActionPerformed(evt);
            }
        });

        jbtnKirjaudu.setText("Kirjaudu");
        jbtnKirjaudu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnKirjauduActionPerformed(evt);
            }
        });

        jchkSalasana.setText("Näytä salasana");
        jchkSalasana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkSalasanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtTunnus, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpswSalasana)
                            .addComponent(jbtnKirjaudu, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addComponent(jchkSalasana)
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtTunnus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpswSalasana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkSalasana))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnKirjaudu)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpswSalasanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpswSalasanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpswSalasanaActionPerformed

    public Connection luoYhteys() {

        Connection cn = null;

        try {
            cn = DriverManager.getConnection("jdbc:mariadb://" + "ec2-13-49-231-56.eu-north-1.compute.amazonaws.com" + ":3306/ASIAKASTILAUS", "kehittaja", "Koira123!");
            return cn;
        } catch (SQLException e) {
            System.out.println("Yhteyden luominen epäonnistui!:\n" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private void jbtnKirjauduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnKirjauduActionPerformed

        // HeikkiHuoltoHenkilO
        // KiSsa123#!
        String tunnus = jtxtTunnus.getText();
        String oikeasalasanatietokannassa = "";

        char annettusalasana[] = jpswSalasana.getPassword();
        char[] oikeasalasanataulukkona = null;

        Connection cn = luoYhteys();

        String sqlKysely = "SELECT TUNNUS, DES_DECRYPT (SALASANA, 'salainenavain') AS SALASANA FROM KAYTTAJA WHERE TUNNUS ='" + tunnus + "'";
        
        try {
            PreparedStatement stm = cn.prepareStatement(sqlKysely);
            ResultSet tulos = stm.executeQuery();

            if (tulos.next()) {
                oikeasalasanatietokannassa = tulos.getString("SALASANA").trim();
                oikeasalasanataulukkona = oikeasalasanatietokannassa.toCharArray();

                if (Arrays.equals(annettusalasana, oikeasalasanataulukkona)) {
                    Asiakasrekisteri g = new Asiakasrekisteri(tunnus);
                    g.setVisible(true);
                    sulje();
                } else {
                    JOptionPane.showMessageDialog(this, "Tunnus tai salasana on väärin. Yritä uudelleen.");
                    jtxtTunnus.requestFocus();
                    return;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Arrays.fill(oikeasalasanataulukkona, '0');
        oikeasalasanatietokannassa = "";
    }//GEN-LAST:event_jbtnKirjauduActionPerformed

    private void jchkSalasanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkSalasanaActionPerformed
        if (jchkSalasana.isSelected()) {
            jpswSalasana.setEchoChar((char) 0);
            jchkSalasana.setSelected(true);
        } else {
            jpswSalasana.setEchoChar('*');
            jchkSalasana.setSelected(false);
        }
    }//GEN-LAST:event_jchkSalasanaActionPerformed

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
            java.util.logging.Logger.getLogger(Kirjautuminen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kirjautuminen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kirjautuminen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kirjautuminen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kirjautuminen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnKirjaudu;
    private javax.swing.JCheckBox jchkSalasana;
    private javax.swing.JPasswordField jpswSalasana;
    private javax.swing.JTextField jtxtTunnus;
    // End of variables declaration//GEN-END:variables
}
