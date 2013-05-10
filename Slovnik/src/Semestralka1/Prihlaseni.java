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
public class Prihlaseni extends javax.swing.JPanel {
private Gui gui;
Slovník slovnik;
Hrac hrac;
    /**
     * Creates new form Prihlaseni
     */
    public Prihlaseni(Slovník slovnik, Hrac hrac,Gui frame) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vyberUcet = new javax.swing.JComboBox();
        hesloTextField = new javax.swing.JTextField();
        vytvorNovyUcet = new javax.swing.JButton();
        prihlas = new javax.swing.JButton();

        jLabel1.setText("Vyberte svuj ucet :");

        jLabel2.setText("Zadejte své heslo");

        vyberUcet.setModel(new javax.swing.DefaultComboBoxModel(hrac.nactiHrace(1)));
        vyberUcet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vyberUcetActionPerformed(evt);
            }
        });

        vytvorNovyUcet.setText("Vytvorit novy ucet");
        vytvorNovyUcet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vytvorNovyUcetActionPerformed(evt);
            }
        });

        prihlas.setText("Prihlas");
        prihlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prihlasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vyberUcet, 0, 113, Short.MAX_VALUE)
                            .addComponent(hesloTextField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vytvorNovyUcet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(prihlas)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vyberUcet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hesloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vytvorNovyUcet)
                    .addComponent(prihlas))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void vyberUcetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vyberUcetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vyberUcetActionPerformed

    private void vytvorNovyUcetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vytvorNovyUcetActionPerformed

    }//GEN-LAST:event_vytvorNovyUcetActionPerformed

    private void prihlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prihlasActionPerformed
        boolean spravne = hrac.prihlaseni(this.vyberUcet.getSelectedItem().toString(), this.hesloTextField.getText(), this.vyberUcet.getSelectedIndex());
        System.out.println(spravne);
        if (spravne) {
            this.hesloTextField.setText("");
            System.out.println("test");  
            this.gui.setView(2);
        } else {
            JOptionPane.showConfirmDialog(gui, "Bylo zadano spatne heslo, zbavaji vam" + (3 - this.hrac.getPokusy()) + "pokusy", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_prihlasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hesloTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton prihlas;
    private javax.swing.JComboBox vyberUcet;
    private javax.swing.JButton vytvorNovyUcet;
    // End of variables declaration//GEN-END:variables
}
