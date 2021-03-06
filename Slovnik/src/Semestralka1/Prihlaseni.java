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
    /**
     * Creates new form Prihlaseni
     */
    public Prihlaseni(Gui gui) {
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

        prihlaseniPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        vyberUcet = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        vstupHesla = new javax.swing.JPasswordField();
        vytvorNovyUcet = new javax.swing.JButton();
        prihlas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        prihlaseniPanel.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setText("Vyberte svůj účet :");

        vyberUcet.setForeground(new java.awt.Color(0, 204, 0));
        vyberUcet.setModel(new javax.swing.DefaultComboBoxModel(gui.uzivatel.nactiUdajeOHracich(1)));
        vyberUcet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vyberUcetActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setText("Zadejte své heslo :");

        vstupHesla.setBackground(new java.awt.Color(0, 0, 204));
        vstupHesla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vstupHesla.setForeground(new java.awt.Color(0, 204, 0));

        vytvorNovyUcet.setBackground(new java.awt.Color(0, 0, 204));
        vytvorNovyUcet.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vytvorNovyUcet.setForeground(new java.awt.Color(0, 204, 0));
        vytvorNovyUcet.setText("Vytvořit nový účet");
        vytvorNovyUcet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vytvorNovyUcetActionPerformed(evt);
            }
        });

        prihlas.setBackground(new java.awt.Color(0, 0, 204));
        prihlas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        prihlas.setForeground(new java.awt.Color(0, 204, 0));
        prihlas.setText("Přihlaš");
        prihlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prihlasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 0));
        jLabel3.setText("Přihlášení");

        javax.swing.GroupLayout prihlaseniPanelLayout = new javax.swing.GroupLayout(prihlaseniPanel);
        prihlaseniPanel.setLayout(prihlaseniPanelLayout);
        prihlaseniPanelLayout.setHorizontalGroup(
            prihlaseniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prihlaseniPanelLayout.createSequentialGroup()
                .addGroup(prihlaseniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(prihlaseniPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(vytvorNovyUcet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(prihlas))
                    .addGroup(prihlaseniPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(prihlaseniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(prihlaseniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(vstupHesla)
                            .addComponent(vyberUcet, 0, 98, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
            .addGroup(prihlaseniPanelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        prihlaseniPanelLayout.setVerticalGroup(
            prihlaseniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prihlaseniPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(prihlaseniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vyberUcet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(prihlaseniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vstupHesla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(prihlaseniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prihlas)
                    .addComponent(vytvorNovyUcet))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prihlaseniPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prihlaseniPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void vyberUcetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vyberUcetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vyberUcetActionPerformed

    private void vytvorNovyUcetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vytvorNovyUcetActionPerformed
           this.gui.setMyView(4);
    }//GEN-LAST:event_vytvorNovyUcetActionPerformed

    private void prihlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prihlasActionPerformed
        boolean spravne = gui.uzivatel.prihlaseni(this.vyberUcet.getSelectedItem().toString(), 
                String.valueOf(this.vstupHesla.getPassword()), this.vyberUcet.getSelectedIndex());
        if (spravne) {
           this.gui.setMyView(2);
        } else {
            JOptionPane.showMessageDialog(this.gui, "Bylo zadano spatne heslo, zbavaji vam " + (3 - this.gui.uzivatel.getPokusy()) + " pokusy",
                    "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_prihlasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton prihlas;
    private javax.swing.JPanel prihlaseniPanel;
    private javax.swing.JPasswordField vstupHesla;
    private javax.swing.JComboBox vyberUcet;
    private javax.swing.JButton vytvorNovyUcet;
    // End of variables declaration//GEN-END:variables
}
