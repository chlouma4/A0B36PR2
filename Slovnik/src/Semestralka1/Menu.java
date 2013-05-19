/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;


import javax.swing.JOptionPane;


/**
 *
 * @author Marco
 */
public class Menu extends javax.swing.JPanel {
  private Gui gui;
    /**
     * Creates new form Menu
     */
    public Menu(Gui frame) {
        this.gui=frame;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        spravaSlovicekButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        zmenaSlovniku = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        odhlasitSe = new javax.swing.JButton();
        ukoncitProgram = new javax.swing.JButton();
        spravaSlovnikuButon = new javax.swing.JButton();
        spravaHracuButton = new javax.swing.JButton();

        Menu.setBackground(new java.awt.Color(0, 102, 204));

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setForeground(new java.awt.Color(0, 204, 0));
        jButton1.setText("Zkouseni");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        spravaSlovicekButton.setBackground(new java.awt.Color(0, 0, 204));
        spravaSlovicekButton.setForeground(new java.awt.Color(0, 204, 0));
        spravaSlovicekButton.setText("Sprava slovicek");
        spravaSlovicekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spravaSlovicekButtonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setForeground(new java.awt.Color(0, 204, 0));
        jButton3.setText("Statistiky");
        jButton3.setMaximumSize(new java.awt.Dimension(146, 46));
        jButton3.setMinimumSize(new java.awt.Dimension(146, 46));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        zmenaSlovniku.setBackground(new java.awt.Color(0, 0, 204));
        zmenaSlovniku.setForeground(new java.awt.Color(0, 204, 0));
        zmenaSlovniku.setText("Zmena slovniku");
        zmenaSlovniku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zmenaSlovnikuActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 0));
        jLabel8.setText("Menu");

        odhlasitSe.setBackground(new java.awt.Color(0, 0, 204));
        odhlasitSe.setForeground(new java.awt.Color(0, 204, 0));
        odhlasitSe.setText("Odhlsit se");
        odhlasitSe.setMaximumSize(new java.awt.Dimension(107, 23));
        odhlasitSe.setMinimumSize(new java.awt.Dimension(107, 23));
        odhlasitSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odhlasitSeActionPerformed(evt);
            }
        });

        ukoncitProgram.setBackground(new java.awt.Color(0, 0, 204));
        ukoncitProgram.setForeground(new java.awt.Color(0, 204, 0));
        ukoncitProgram.setText("Ukoncit program");
        ukoncitProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ukoncitProgramActionPerformed(evt);
            }
        });

        spravaSlovnikuButon.setBackground(new java.awt.Color(0, 0, 204));
        spravaSlovnikuButon.setForeground(new java.awt.Color(0, 204, 0));
        spravaSlovnikuButon.setText("Sprava slovniku");
        spravaSlovnikuButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spravaSlovnikuButonActionPerformed(evt);
            }
        });

        spravaHracuButton.setBackground(new java.awt.Color(0, 0, 204));
        spravaHracuButton.setForeground(new java.awt.Color(0, 204, 0));
        spravaHracuButton.setText("Sprava Uzivatelu");
        spravaHracuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spravaHracuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel8))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spravaSlovicekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(odhlasitSe, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spravaSlovnikuButon, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zmenaSlovniku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ukoncitProgram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spravaHracuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spravaSlovicekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zmenaSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spravaHracuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spravaSlovnikuButon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(odhlasitSe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ukoncitProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     this.gui.setMyView(12);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void spravaSlovicekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spravaSlovicekButtonActionPerformed
          this.gui.setMyView(5);
    }//GEN-LAST:event_spravaSlovicekButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (this.gui.slovnik.getPocetBunek() == 0 && this.gui.slovnik.neaktivni.isEmpty() == true) {
            JOptionPane.showMessageDialog(this.gui, "Nejsou zadna slova k zobrazeni");
        } else {
      this.gui.setMyView(11);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void zmenaSlovnikuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zmenaSlovnikuActionPerformed
        this.gui.slovnik.vycistiSpojovySeznam();
       this.gui.setMyView(2);
    }//GEN-LAST:event_zmenaSlovnikuActionPerformed

    private void odhlasitSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odhlasitSeActionPerformed
        this.gui.slovnik.ulozSlovnik(this.gui.uzivatel.getJmeno());
        this.gui.slovnik.vycistiSpojovySeznam();
        this.gui.setMyView(1);
    }//GEN-LAST:event_odhlasitSeActionPerformed

    private void ukoncitProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukoncitProgramActionPerformed
        this.gui.slovnik.ulozSlovnik(this.gui.uzivatel.getJmeno());
        this.gui.slovnik.vycistiSpojovySeznam();
        System.exit(0);
    }//GEN-LAST:event_ukoncitProgramActionPerformed

    private void spravaSlovnikuButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spravaSlovnikuButonActionPerformed
      this.gui.setMyView(15);
    }//GEN-LAST:event_spravaSlovnikuButonActionPerformed

    private void spravaHracuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spravaHracuButtonActionPerformed
     this.gui.setMyView(19);
    }//GEN-LAST:event_spravaHracuButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton odhlasitSe;
    private javax.swing.JButton spravaHracuButton;
    private javax.swing.JButton spravaSlovicekButton;
    private javax.swing.JButton spravaSlovnikuButon;
    private javax.swing.JButton ukoncitProgram;
    private javax.swing.JButton zmenaSlovniku;
    // End of variables declaration//GEN-END:variables
}
