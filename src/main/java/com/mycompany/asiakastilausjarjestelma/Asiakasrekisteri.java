package com.mycompany.asiakastilausjarjestelma;

public class Asiakasrekisteri extends javax.swing.JFrame {

    public Asiakasrekisteri(String tunnus) {
        initComponents();
        this.setTitle("Tervetuloa: " + tunnus);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmnuTiedosto = new javax.swing.JMenu();
        jmnuAvaa = new javax.swing.JMenuItem();
        jmnuTallenna = new javax.swing.JMenuItem();
        jmnuLopeta = new javax.swing.JMenuItem();
        jmnuLaske = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmnuTiedosto.setText("Tiedosto");

        jmnuAvaa.setText("Avaa");
        jmnuAvaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuAvaaActionPerformed(evt);
            }
        });
        jmnuTiedosto.add(jmnuAvaa);

        jmnuTallenna.setText("Tallenna");
        jmnuTallenna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuTallennaActionPerformed(evt);
            }
        });
        jmnuTiedosto.add(jmnuTallenna);

        jmnuLopeta.setText("Lopeta");
        jmnuTiedosto.add(jmnuLopeta);

        jMenuBar1.add(jmnuTiedosto);

        jmnuLaske.setText("Hallinta");

        jMenuItem1.setText("ASIAKAS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmnuLaske.add(jMenuItem1);

        jMenuItem2.setText("TUOTE");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmnuLaske.add(jMenuItem2);

        jMenuItem3.setText("TILAUS");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmnuLaske.add(jMenuItem3);

        jMenuBar1.add(jmnuLaske);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Asiakasrekisterihallinta sk = new Asiakasrekisterihallinta();
        sk.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmnuAvaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuAvaaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnuAvaaActionPerformed

    private void jmnuTallennaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuTallennaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnuTallennaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Tuoterekisterihallinta sk = new Tuoterekisterihallinta();
        sk.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Tilaustenhallinta sk = new Tilaustenhallinta();
        sk.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Asiakasrekisteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asiakasrekisteri("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jmnuAvaa;
    private javax.swing.JMenu jmnuLaske;
    private javax.swing.JMenuItem jmnuLopeta;
    private javax.swing.JMenuItem jmnuTallenna;
    private javax.swing.JMenu jmnuTiedosto;
    // End of variables declaration//GEN-END:variables
}
