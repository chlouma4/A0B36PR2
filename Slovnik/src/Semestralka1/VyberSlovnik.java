/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.util.ArrayList;



/**
 *
 * @author Marco
 */
public class VyberSlovnik extends javax.swing.JPanel {
private Gui gui;

/**Metoda prevadi ArrayList do pole.
 * 
 * 
 * @return 
 */
private String [] fromArrayListToArray(){
    ArrayList seznam= this.gui.slovnik.getSeznamSlovniku();
    String [] seznamX= new String[seznam.size()];
    for (int i = 0; i < seznam.size(); i++) {
       seznamX[i]=String.valueOf(seznam.get(i));
    }
    return seznamX;
}
    /**
     * Creates new form VyberSlovnik
     */
    public VyberSlovnik(Gui gui) {
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

        vyberSlovnikPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        potvrdSlovnik = new javax.swing.JButton();
        vyberSlovnik = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(280, 120));

        vyberSlovnikPanel.setBackground(new java.awt.Color(51, 102, 255));
        vyberSlovnikPanel.setMinimumSize(new java.awt.Dimension(300, 120));
        vyberSlovnikPanel.setPreferredSize(new java.awt.Dimension(300, 120));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setText("Vyberte slovník s kterým chcete pracovat : ");

        potvrdSlovnik.setBackground(new java.awt.Color(0, 0, 204));
        potvrdSlovnik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        potvrdSlovnik.setForeground(new java.awt.Color(0, 204, 0));
        potvrdSlovnik.setText("Ok");
        potvrdSlovnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                potvrdSlovnikActionPerformed(evt);
            }
        });

        vyberSlovnik.setModel(new javax.swing.DefaultComboBoxModel(this.fromArrayListToArray()));
        vyberSlovnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vyberSlovnikActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vyberSlovnikPanelLayout = new javax.swing.GroupLayout(vyberSlovnikPanel);
        vyberSlovnikPanel.setLayout(vyberSlovnikPanelLayout);
        vyberSlovnikPanelLayout.setHorizontalGroup(
            vyberSlovnikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vyberSlovnikPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vyberSlovnikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(vyberSlovnikPanelLayout.createSequentialGroup()
                        .addComponent(vyberSlovnik, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(potvrdSlovnik, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        vyberSlovnikPanelLayout.setVerticalGroup(
            vyberSlovnikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vyberSlovnikPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(vyberSlovnikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(potvrdSlovnik)
                    .addComponent(vyberSlovnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vyberSlovnikPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vyberSlovnikPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void potvrdSlovnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_potvrdSlovnikActionPerformed
        gui.slovnik.nactiSlovnik(this.vyberSlovnik.getSelectedItem().toString(), gui.uzivatel.getJmeno());
        this.gui.slovnik.presunNeaktivni();
        gui.setMyView(3);
      
    }//GEN-LAST:event_potvrdSlovnikActionPerformed

    private void vyberSlovnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vyberSlovnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vyberSlovnikActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton potvrdSlovnik;
    private javax.swing.JComboBox vyberSlovnik;
    private javax.swing.JPanel vyberSlovnikPanel;
    // End of variables declaration//GEN-END:variables
}
