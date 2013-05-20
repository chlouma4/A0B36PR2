/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class SmazaniSlovniku extends javax.swing.JPanel {
private Gui gui;
    /**
     * Creates new form SmazaniSlovniku
     */

private void  vypisSlovniky(){
    ArrayList seznam=this.gui.slovnik.getSeznamSlovniku();
        for (int i = 0; i < seznam.size(); i++) {
            this.textAreaSmazaniSlovniku.append("("+(i+1)+") "+seznam.get(i) +"\n");
}
}
    public SmazaniSlovniku(Gui gui) {
       this.gui=gui;
        initComponents();
        vypisSlovniky();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        smazaniSlovniku = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaSmazaniSlovniku = new javax.swing.JTextArea();
        jButton16 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        spinnerSmazaniSlovniku = new javax.swing.JSpinner();
        vymazatSlovnik = new javax.swing.JButton();
        jLabel3 = new MyLabel(this.gui,3);
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new MyLabel(this.gui,15);
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new MyLabel(this.gui,18);

        smazaniSlovniku.setBackground(new java.awt.Color(51, 102, 255));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 204, 0));
        jLabel35.setText("Smazání slovníku");

        textAreaSmazaniSlovniku.setEditable(false);
        textAreaSmazaniSlovniku.setBackground(new java.awt.Color(0, 0, 204));
        textAreaSmazaniSlovniku.setColumns(20);
        textAreaSmazaniSlovniku.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        textAreaSmazaniSlovniku.setForeground(new java.awt.Color(0, 204, 0));
        textAreaSmazaniSlovniku.setRows(5);
        jScrollPane7.setViewportView(textAreaSmazaniSlovniku);

        jButton16.setBackground(new java.awt.Color(0, 0, 204));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 204, 0));
        jButton16.setText("Zpět");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 204, 0));
        jLabel36.setText("Číslem vyberte slovník ke smazání :");

        spinnerSmazaniSlovniku.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        vymazatSlovnik.setBackground(new java.awt.Color(0, 0, 204));
        vymazatSlovnik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vymazatSlovnik.setForeground(new java.awt.Color(0, 204, 0));
        vymazatSlovnik.setText("Vymazat");
        vymazatSlovnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazatSlovnikActionPerformed(evt);
            }
        });

        jLabel3.setText("Menu");

        jLabel4.setText("-->");

        jLabel1.setText("Správa slovníků");

        jLabel5.setText("-->");

        jLabel2.setText("Smazání slovníku");

        javax.swing.GroupLayout smazaniSlovnikuLayout = new javax.swing.GroupLayout(smazaniSlovniku);
        smazaniSlovniku.setLayout(smazaniSlovnikuLayout);
        smazaniSlovnikuLayout.setHorizontalGroup(
            smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                        .addGroup(smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                                .addComponent(jButton16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smazaniSlovnikuLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spinnerSmazaniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(vymazatSlovnik))
                    .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smazaniSlovnikuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(81, 81, 81))
        );
        smazaniSlovnikuLayout.setVerticalGroup(
            smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16))
                    .addGroup(smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerSmazaniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vymazatSlovnik)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(smazaniSlovniku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(smazaniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
this.gui.setMyView(15);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void vymazatSlovnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazatSlovnikActionPerformed
        if(this.gui.slovnik.getPocetSlovniku()<=((Integer)this.spinnerSmazaniSlovniku.getValue())){
           this.gui.slovnik.smazSlovnik((Integer)this.spinnerSmazaniSlovniku.getValue());
        }else{
            JOptionPane.showMessageDialog(this.gui, "Slovnik s timto cislem neexistuje!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_vymazatSlovnikActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel smazaniSlovniku;
    private javax.swing.JSpinner spinnerSmazaniSlovniku;
    private javax.swing.JTextArea textAreaSmazaniSlovniku;
    private javax.swing.JButton vymazatSlovnik;
    // End of variables declaration//GEN-END:variables
}
