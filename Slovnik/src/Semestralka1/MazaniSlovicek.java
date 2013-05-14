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
public class MazaniSlovicek extends javax.swing.JPanel {
    Slovník slovnik;
Uzivatel hrac;
private Gui gui;

    /**
     * Creates new form MazaniSlovicek
     */
    public MazaniSlovicek(Slovník slovnik, Uzivatel hrac,Gui frame) {
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

        mazaniSlovicekPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        slovickoKeSmazani = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Smaz = new javax.swing.JButton();
        uplneVymazani = new javax.swing.JButton();
        zpetMazaniSlovicek = new javax.swing.JButton();

        jLabel14.setText("Mazani Slovicek");

        jLabel15.setText("Cislem vyberete dvojci slovicek ke smazani.");

        jLabel16.setText("Pred provedenim akce se dana dvojce slovicek zabrazi.");

        Smaz.setText("Smaz");
        Smaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmazActionPerformed(evt);
            }
        });

        uplneVymazani.setText("Uplne Vymazani");
        uplneVymazani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uplneVymazaniActionPerformed(evt);
            }
        });

        zpetMazaniSlovicek.setText("Zpet");
        zpetMazaniSlovicek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetMazaniSlovicekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mazaniSlovicekPanelLayout = new javax.swing.GroupLayout(mazaniSlovicekPanel);
        mazaniSlovicekPanel.setLayout(mazaniSlovicekPanelLayout);
        mazaniSlovicekPanelLayout.setHorizontalGroup(
            mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mazaniSlovicekPanelLayout.createSequentialGroup()
                .addGroup(mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mazaniSlovicekPanelLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel14))
                    .addGroup(mazaniSlovicekPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mazaniSlovicekPanelLayout.createSequentialGroup()
                                .addComponent(slovickoKeSmazani, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(Smaz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(uplneVymazani))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mazaniSlovicekPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(zpetMazaniSlovicek)))
                .addContainerGap())
        );
        mazaniSlovicekPanelLayout.setVerticalGroup(
            mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mazaniSlovicekPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slovickoKeSmazani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Smaz)
                    .addComponent(uplneVymazani))
                .addGap(18, 18, 18)
                .addComponent(zpetMazaniSlovicek)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mazaniSlovicekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mazaniSlovicekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SmazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmazActionPerformed
        JOptionPane.showConfirmDialog(gui, "Opravdu chcete smazat dvojci slovicek"
            + this.slovnik.vypisX(Integer.getInteger(this.slovickoKeSmazani.getText())), "Chyba!", JOptionPane.OK_CANCEL_OPTION);
        // pokud bude stisknuto ok tak zavolat metodu setAktivita(0)a spustit metodu vzmay neaktivni
    }//GEN-LAST:event_SmazActionPerformed

    private void uplneVymazaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uplneVymazaniActionPerformed
        if (this.hrac.testPravomoc(this.slovnik.getTvurceSlovniku(), 3)) {
            JOptionPane.showConfirmDialog(gui, "Opravdu chcete smazat dvojci slovicek"
                + this.slovnik.vypisX(Integer.getInteger(this.slovickoKeSmazani.getText())), "Chyba!", JOptionPane.OK_CANCEL_OPTION);
            // pokud bude stisknuto ok tak zavolat metodu slovnik.smaz(this.slovickoKeSmazani.getText())
        } else {
            JOptionPane.showConfirmDialog(gui, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_uplneVymazaniActionPerformed

    private void zpetMazaniSlovicekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetMazaniSlovicekActionPerformed
        
    }//GEN-LAST:event_zpetMazaniSlovicekActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Smaz;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel mazaniSlovicekPanel;
    private javax.swing.JTextField slovickoKeSmazani;
    private javax.swing.JButton uplneVymazani;
    private javax.swing.JButton zpetMazaniSlovicek;
    // End of variables declaration//GEN-END:variables
}
