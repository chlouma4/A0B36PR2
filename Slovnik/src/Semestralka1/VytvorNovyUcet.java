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
public class VytvorNovyUcet extends javax.swing.JPanel {
Slovník slovnik;
Uzivatel hrac;
private Gui gui;
    /**
     * Creates new form VytvorNovyUcet
     */
    public VytvorNovyUcet(Slovník slovnik, Uzivatel hrac,Gui frame) {
        this.slovnik=slovnik;
        this.hrac=hrac;
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

        novyUcet = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        vytvorUcetButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        zpetDoPrihlas = new javax.swing.JButton();

        jLabel3.setText("Zadejte jmeno uctu:");

        jLabel4.setText("Zadejte heslo pro ucet*:");

        jLabel5.setText("Opakujte heslo zadani uctu:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        vytvorUcetButton.setText("Vytvor");
        vytvorUcetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vytvorUcetButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("* Heslo musi mit delku 4 nebo 6 znaku.");

        zpetDoPrihlas.setText("Zpet");
        zpetDoPrihlas.setMaximumSize(new java.awt.Dimension(65, 23));
        zpetDoPrihlas.setMinimumSize(new java.awt.Dimension(65, 23));
        zpetDoPrihlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetDoPrihlasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout novyUcetLayout = new javax.swing.GroupLayout(novyUcet);
        novyUcet.setLayout(novyUcetLayout);
        novyUcetLayout.setHorizontalGroup(
            novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, novyUcetLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(408, 408, 408))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, novyUcetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(zpetDoPrihlas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(novyUcetLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vytvorUcetButton)
                        .addGap(398, 398, 398))
                    .addGroup(novyUcetLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        novyUcetLayout.setVerticalGroup(
            novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(novyUcetLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vytvorUcetButton)
                    .addComponent(zpetDoPrihlas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(novyUcet, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(novyUcet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void vytvorUcetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vytvorUcetButtonActionPerformed
        int uspesnost = hrac.vytvorUzivatele(this.jTextField1.getText(), this.jTextField2.getText(), this.jTextField3.getText());
        switch (uspesnost) {
            case 0:
            JOptionPane.showConfirmDialog(gui, "Ucet byl uspesne zalozen", "Informace", JOptionPane.WARNING_MESSAGE);
            
            break;
            case 1:
            JOptionPane.showConfirmDialog(gui, "Jmeno je jiy obsayene prosim vzberte si jine", "Chyba!", JOptionPane.WARNING_MESSAGE);
            break;
            case 2:
            JOptionPane.showConfirmDialog(gui, "Hesla se neshoduji", "Chyba!", JOptionPane.WARNING_MESSAGE);
            break;
            case 3:
            JOptionPane.showConfirmDialog(gui, "Heslo nema predepsanou delku", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_vytvorUcetButtonActionPerformed

    private void zpetDoPrihlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetDoPrihlasActionPerformed
        
    }//GEN-LAST:event_zpetDoPrihlasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel novyUcet;
    private javax.swing.JButton vytvorUcetButton;
    private javax.swing.JButton zpetDoPrihlas;
    // End of variables declaration//GEN-END:variables
}