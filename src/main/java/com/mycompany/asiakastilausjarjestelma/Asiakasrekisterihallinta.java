package com.mycompany.asiakastilausjarjestelma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Asiakasrekisterihallinta extends javax.swing.JFrame {

    public Asiakasrekisterihallinta() {
        initComponents();
        Naytaasiakkaat();
    }

    class Asiakas {

        private int asiakasnumero;
        private String etunimi;
        private String sukunimi;
        private String yritys;
        private String katuosoite;
        private String postinumero;
        private String postitoimipaikka;
        private String puhelin;
        private String email;

        public Asiakas(int id, String etunimi, String sukunimi, String yritys,
                String katuosoite, String postinumero, String postitoimipaikka,
                String puhelin, String email) {
            this.asiakasnumero = id;
            this.etunimi = etunimi;
            this.sukunimi = sukunimi;
            this.yritys = yritys;
            this.katuosoite = katuosoite;
            this.postinumero = postinumero;
            this.postitoimipaikka = postitoimipaikka;
            this.puhelin = puhelin;
            this.email = email;
        }

        public int HaeAsiakasnumero() {
            return this.asiakasnumero;
        }

        public String HaeEtunimi() {
            return this.etunimi;
        }

        public String HaeSukunimi() {
            return this.sukunimi;
        }

        public String HaeYritys() {
            return this.yritys;
        }

        public String HaeKatuosoite() {
            return this.katuosoite;
        }

        public String HaePostinumero() {
            return this.postinumero;
        }

        public String HaePostitoimipaikka() {
            return this.postitoimipaikka;
        }

        public String HaePuhelin() {
            return this.puhelin;
        }

        public String HaeEmail() {
            return this.email;
        }
    }

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

    public ArrayList<Asiakas> HaeAsiakasTaulukko() {
        ArrayList<Asiakas> Asiakastaulukko = new ArrayList<Asiakas>();

        Connection yhteys = luoYhteys();

        String query = "Select asiakasnumero, etunimi, sukunimi, yritys, katuosoite, postinumero, postitoimipaikka, puhelin, email FROM ASIAKAS";
        Statement st;
        ResultSet rs;

        try {
            st = yhteys.createStatement();
            rs = st.executeQuery(query);

            Asiakas a;

            while (rs.next()) {
                a = new Asiakas(rs.getInt("Asiakasnumero"), rs.getString("Etunimi"),
                        rs.getString("Sukunimi"), rs.getString("Yritys"),
                        rs.getString("Katuosoite"), rs.getString("Postinumero"),
                        rs.getString("Postitoimipaikka"), rs.getString("Puhelin"),
                        rs.getString("Email"));
                Asiakastaulukko.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Asiakastaulukko;
    }

    public void Naytaasiakkaat() {
        ArrayList<Asiakas> list = HaeAsiakasTaulukko();
        DefaultTableModel model = (DefaultTableModel) jtblAsiakkaat.getModel();

        model.setColumnIdentifiers(new Object[]{"Asiakasnumero", "Etunimi", "Sukunimi",
            "Yritys", "Katuosoite", "Postinumero", "Postitoimipaikka", "Puhelin", "Email"});
        Object[] row = new Object[9];

        for (int i = jtblAsiakkaat.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).HaeAsiakasnumero();
            row[1] = list.get(i).HaeEtunimi();
            row[2] = list.get(i).HaeSukunimi();
            row[3] = list.get(i).HaeYritys();
            row[4] = list.get(i).HaeKatuosoite();
            row[5] = list.get(i).HaePostinumero();
            row[6] = list.get(i).HaePostitoimipaikka();
            row[7] = list.get(i).HaePuhelin();
            row[8] = list.get(i).HaeEmail();
            model.addRow(row);
        }
    }

    public void suoritaSQLKysely(String query, String message) {
        Connection yhteys = luoYhteys();
        Statement st;
        try {
            st = yhteys.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                DefaultTableModel model = (DefaultTableModel) jtblAsiakkaat.getModel();
                model.setRowCount(0);
                Naytaasiakkaat();

                JOptionPane.showMessageDialog(null, "Data " + message + " onnistuneesti");
            } else {
                JOptionPane.showMessageDialog(null, "Data ei " + message);
            }
            yhteys.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtAsiakasnumero = new javax.swing.JTextField();
        jtxtEtunimi = new javax.swing.JTextField();
        jbtnUusi = new javax.swing.JButton();
        jtxtSukunimi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtYritys = new javax.swing.JTextField();
        jbtnPäivitä = new javax.swing.JButton();
        jbtnPoista = new javax.swing.JButton();
        jbtnTestaa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAsiakkaat = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jtxtKatuosoite = new javax.swing.JTextField();
        jtxtPostinumero = new javax.swing.JTextField();
        jtxtPostitoimipaikka = new javax.swing.JTextField();
        jtxtPuhelin = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Asiakasrekisteri");

        jLabel2.setText("Asiakasnumero:");

        jLabel3.setText("Etunimi:");

        jbtnUusi.setText("Uusi");
        jbtnUusi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUusiActionPerformed(evt);
            }
        });

        jLabel4.setText("Sukunimi:");

        jLabel5.setText("Yritys:");

        jbtnPäivitä.setText("Päivitä");
        jbtnPäivitä.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPäivitäActionPerformed(evt);
            }
        });

        jbtnPoista.setText("Poista");
        jbtnPoista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPoistaActionPerformed(evt);
            }
        });

        jbtnTestaa.setText("Testaa tietokantayhteys Amazon MarianDB-palvelimeen");
        jbtnTestaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTestaaActionPerformed(evt);
            }
        });

        jtblAsiakkaat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jtblAsiakkaat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblAsiakkaatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblAsiakkaat);

        jLabel6.setText("Katuosoite:");

        jLabel7.setText("Postinumero:");

        jLabel8.setText("Postitoimipaikka:");

        jLabel9.setText("Puhelin:");

        jLabel10.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnUusi, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnPäivitä, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnPoista, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnTestaa))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(54, 54, 54)
                                .addComponent(jtxtEtunimi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtAsiakasnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtEmail)
                                    .addComponent(jtxtPuhelin)
                                    .addComponent(jtxtPostitoimipaikka)
                                    .addComponent(jtxtPostinumero)
                                    .addComponent(jtxtSukunimi)
                                    .addComponent(jtxtYritys)
                                    .addComponent(jtxtKatuosoite))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtAsiakasnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtEtunimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtSukunimi)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtYritys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtKatuosoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtPostinumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtPostitoimipaikka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtPuhelin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnUusi)
                    .addComponent(jbtnPoista)
                    .addComponent(jbtnPäivitä)
                    .addComponent(jbtnTestaa))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean Tarkistaa() {
        if (jtxtAsiakasnumero.getText().isBlank() || jtxtEtunimi.getText().isBlank()
                || jtxtSukunimi.getText().isBlank() || jtxtYritys.getText().isBlank() || jtxtKatuosoite.getText().isBlank()
                || jtxtPostinumero.getText().isBlank() || jtxtPostitoimipaikka.getText().isBlank() || jtxtPuhelin.getText().isBlank() || jtxtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Kentät eivät täytyy olla tyhjiä.", "HUOM!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void jbtnUusiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUusiActionPerformed
        try {
            Integer.parseInt(jtxtAsiakasnumero.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Asiakasnumero täytyy olla lukuna.", "HUOM!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Tarkistaa()==false) {
            return;
        }

        int tulos = JOptionPane.showConfirmDialog(null, "Haluaanko suorittaa asiakkaan lisäys?", "Varmistuskysymys", JOptionPane.YES_NO_OPTION);

        if (tulos == JOptionPane.YES_OPTION) {
            // Muotoillaan päivämäärä muotoon yyyy/MM/dd 
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            // Haetaan järjestelmän päiväys 
            Date tamapaiva = new Date();
            // Muodostetaan INSERT lause, huomaa + ja ' merkkien käyttäminen 
            String query = "INSERT INTO `ASIAKAS`(`ASIAKKAAKSITULOPAIVA`, `YRITYS`, "
                    + "`ETUNIMI`, `SUKUNIMI`, `KATUOSOITE`, `POSTINUMERO`, `POSTITOIMIPAIKKA`, `PUHELIN`, `EMAIL`)";
            query = query + " VALUES('" + dateFormat.format(tamapaiva) + "','" + jtxtYritys.getText() + "','"
                    + jtxtEtunimi.getText() + "', '" + jtxtSukunimi.getText() + "','" + jtxtKatuosoite.getText()
                    + "','" + jtxtPostinumero.getText() + "','" + jtxtPostitoimipaikka.getText() + "','"
                    + jtxtPuhelin.getText() + "','" + jtxtEmail.getText() + "')";
            //JOptionPane.showMessageDialog(null, query); 
            // luomisvaiheessa SQL merkkijonoa kannattaa testata ja kehittää phpMyAdmin-ohjelmassa, välituloksia, joita voi kopioida, kannattaa tulostaa sovelluksen käyttöliittymän tai Debug-ikkunaan 
            //jtxtSQL.setText(query); 
            suoritaSQLKysely(query, "lisätty");
        }
    }//GEN-LAST:event_jbtnUusiActionPerformed

    private void jbtnTestaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTestaaActionPerformed
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Missä on MariaDB JDBC ajuri? Oletko ladannut mariadb connectorin osoitteesta: https://mariadb.com/downloads/#connectors ja lisännyt sen Netbeansissä Asiakasrekisteri-Libraries-Add JAR/Folder kohdassa? ");
            e.printStackTrace();
            return;
        }

        System.out.println("Mariadb JDBC Driver rekisteröity!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mariadb://" + "ec2-13-49-231-56.eu-north-1.compute.amazonaws.com" + ":3306/ASIAKASTILAUS", "kehittaja", "Koira123!");
        } catch (SQLException e) {
            System.out.println("Yhteyden luominen epäonnistui!:\n" + e.getMessage());
        }

        if (connection != null) {
            System.out.println("Hienoa ja onnittelut! Sait luotua yhteyden tietokantaasi. Voit aloittaa käyttöliittymän koodaamisen!");
        } else {
            System.out.println("Pahus, tarkista vielä, että kaikki tarvittava on tehty ja virheitä ei ole!");
        }
    }//GEN-LAST:event_jbtnTestaaActionPerformed

    private void jtblAsiakkaatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblAsiakkaatMouseClicked
        int i = jtblAsiakkaat.getSelectedRow();
        TableModel model = jtblAsiakkaat.getModel();
        jtxtAsiakasnumero.setText(model.getValueAt(i, 0).toString());
        jtxtEtunimi.setText(model.getValueAt(i, 1).toString());
        jtxtSukunimi.setText(model.getValueAt(i, 2).toString());
        jtxtYritys.setText(model.getValueAt(i, 3).toString());
        jtxtKatuosoite.setText(model.getValueAt(i, 4).toString());
        jtxtPostinumero.setText(model.getValueAt(i, 5).toString());
        jtxtPostitoimipaikka.setText(model.getValueAt(i, 6).toString());
        jtxtPuhelin.setText(model.getValueAt(i, 7).toString());
        jtxtEmail.setText(model.getValueAt(i, 8).toString());
    }//GEN-LAST:event_jtblAsiakkaatMouseClicked

    private void jbtnPäivitäActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPäivitäActionPerformed
        if (Tarkistaa()==false) {
            return;
        }
        
        int tulos = JOptionPane.showConfirmDialog(null, "Haluaanko suorittaa asiakkaan päivitys?", "Varmistuskysymys", JOptionPane.YES_NO_OPTION);

        if (tulos == JOptionPane.YES_OPTION) {
            String query = "UPDATE ASIAKAS SET ETUNIMI='" + jtxtEtunimi.getText() + "', "
                    + "SUKUNIMI='" + jtxtSukunimi.getText() + "', YRITYS='" + jtxtYritys.getText()
                    + "', KATUOSOITE='" + jtxtKatuosoite.getText() + "', POSTINUMERO='" + jtxtPostinumero.getText()
                    + "', POSTITOIMIPAIKKA='" + jtxtPostitoimipaikka.getText() + "', PUHELIN='" + jtxtPuhelin.getText()
                    + "', EMAIL='" + jtxtEmail.getText() + "' WHERE ASIAKASNUMERO = " + jtxtAsiakasnumero.getText();
            JOptionPane.showMessageDialog(null, query);
            //jtxtSQL.setText(query); 
            suoritaSQLKysely(query, "Päivitetty");
        }
    }//GEN-LAST:event_jbtnPäivitäActionPerformed

    private void jbtnPoistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPoistaActionPerformed
        int tulos = JOptionPane.showConfirmDialog(null, "Haluaanko suorittaa asiakkaan poisto?", "Varmistuskysymys", JOptionPane.YES_NO_OPTION);

        if (tulos == JOptionPane.YES_OPTION) {
            String query = "DELETE FROM ASIAKAS WHERE ASIAKASNUMERO = '" + jtxtAsiakasnumero.getText()+"'";
            //JOptionPane.showMessageDialog(null, query); 
            //jtxtSQL.setText(query);  
            suoritaSQLKysely(query, "Poistettu");
        }
    }//GEN-LAST:event_jbtnPoistaActionPerformed

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
            java.util.logging.Logger.getLogger(Asiakasrekisterihallinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisterihallinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisterihallinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisterihallinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asiakasrekisterihallinta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnPoista;
    private javax.swing.JButton jbtnPäivitä;
    private javax.swing.JButton jbtnTestaa;
    private javax.swing.JButton jbtnUusi;
    private javax.swing.JTable jtblAsiakkaat;
    private javax.swing.JTextField jtxtAsiakasnumero;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtEtunimi;
    private javax.swing.JTextField jtxtKatuosoite;
    private javax.swing.JTextField jtxtPostinumero;
    private javax.swing.JTextField jtxtPostitoimipaikka;
    private javax.swing.JTextField jtxtPuhelin;
    private javax.swing.JTextField jtxtSukunimi;
    private javax.swing.JTextField jtxtYritys;
    // End of variables declaration//GEN-END:variables
}
