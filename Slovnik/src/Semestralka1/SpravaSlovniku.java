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
public class SpravaSlovniku extends javax.swing.JPanel {
 private Gui gui;
 

    /**
     * Creates new form SpravaSlovniku
     */
    public SpravaSlovniku(Gui gui) {
        this.gui=gui;
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

        spravaSlovniku = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        zpetDoMenuZSpravaSlovicek = new javax.swing.JButton();
        jLabel3 = new MyLabel(this.gui,3);
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new MyLabel(this.gui,15);

        spravaSlovniku.setBackground(new java.awt.Color(51, 102, 255));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 204, 0));
        jLabel31.setText("Správa slovníků");

        jButton10.setBackground(new java.awt.Color(0, 0, 204));
        jButton10.setForeground(new java.awt.Color(0, 204, 0));
        jButton10.setText("Zobrazit slovníky");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 0, 204));
        jButton13.setForeground(new java.awt.Color(0, 204, 0));
        jButton13.setText("Nový slovník");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 0, 204));
        jButton14.setForeground(new java.awt.Color(0, 204, 0));
        jButton14.setText("Smazat slovník");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        zpetDoMenuZSpravaSlovicek.setBackground(new java.awt.Color(0, 0, 204));
        zpetDoMenuZSpravaSlovicek.setForeground(new java.awt.Color(0, 204, 0));
        zpetDoMenuZSpravaSlovicek.setText("Zpět");
        zpetDoMenuZSpravaSlovicek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetDoMenuZSpravaSlovicekActionPerformed(evt);
            }
        });

        jLabel3.setText("Menu");

        jLabel4.setText("-->");

        jLabel1.setText("Správa slovníků");

        javax.swing.GroupLayout spravaSlovnikuLayout = new javax.swing.GroupLayout(spravaSlovniku);
        spravaSlovniku.setLayout(spravaSlovnikuLayout);
        spravaSlovnikuLayout.setHorizontalGroup(
            spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spravaSlovnikuLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(36, 36, 36))
            .addGroup(spravaSlovnikuLayout.createSequentialGroup()
                .addGroup(spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spravaSlovnikuLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zpetDoMenuZSpravaSlovicek, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(spravaSlovnikuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        spravaSlovnikuLayout.setVerticalGroup(
            spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spravaSlovnikuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(27, 27, 27)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(zpetDoMenuZSpravaSlovicek, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spravaSlovniku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spravaSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
this.gui.setMyView(16);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
this.gui.setMyView(17);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(this.gui.uzivatel.testPravomoc(this.gui.uzivatel.getJmeno(), 3)){
             this.gui.setMyView(18);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void zpetDoMenuZSpravaSlovicekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetDoMenuZSpravaSlovicekActionPerformed
this.gui.setMyView(3);
    }//GEN-LAST:event_zpetDoMenuZSpravaSlovicekActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel spravaSlovniku;
    private javax.swing.JButton zpetDoMenuZSpravaSlovicek;
    // End of variables declaration//GEN-END:variables
}
