/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

/**
 *
 * @author Marco
 */
public class NovySlovnik extends javax.swing.JPanel {
private Gui gui;
    /**
     * Creates new form NovySlovnik
     */
    public NovySlovnik(Gui gui) {
        initComponents();
        this.gui=gui;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vytvoreniSlovniku = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        nazevNovehoSlovniku = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        vytvorNovySlovnik = new javax.swing.JButton();
        jLabel3 = new MyLabel(this.gui,3);
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new MyLabel(this.gui,15);
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new MyLabel(this.gui,17);

        vytvoreniSlovniku.setBackground(new java.awt.Color(51, 102, 255));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 204, 0));
        jLabel33.setText("Vytvoření slovníku");

        nazevNovehoSlovniku.setBackground(new java.awt.Color(0, 0, 204));
        nazevNovehoSlovniku.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nazevNovehoSlovniku.setForeground(new java.awt.Color(0, 204, 0));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 204, 0));
        jLabel34.setText("Zadejte jméno slovníku :");

        jButton15.setBackground(new java.awt.Color(0, 0, 204));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 204, 0));
        jButton15.setText("Zpět");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        vytvorNovySlovnik.setBackground(new java.awt.Color(0, 0, 204));
        vytvorNovySlovnik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vytvorNovySlovnik.setForeground(new java.awt.Color(0, 204, 0));
        vytvorNovySlovnik.setText("Vytvořit");
        vytvorNovySlovnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vytvorNovySlovnikActionPerformed(evt);
            }
        });

        jLabel3.setText("Menu");

        jLabel4.setText("-->");

        jLabel1.setText("Správa slovníků");

        jLabel5.setText("-->");

        jLabel2.setText("Vytvoření slovníku");

        javax.swing.GroupLayout vytvoreniSlovnikuLayout = new javax.swing.GroupLayout(vytvoreniSlovniku);
        vytvoreniSlovniku.setLayout(vytvoreniSlovnikuLayout);
        vytvoreniSlovnikuLayout.setHorizontalGroup(
            vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                .addGroup(vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vytvorNovySlovnik))
                    .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                        .addGroup(vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nazevNovehoSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel33)))
                            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)))
                        .addGap(20, 20, 20)))
                .addContainerGap())
        );
        vytvoreniSlovnikuLayout.setVerticalGroup(
            vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(24, 24, 24)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nazevNovehoSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(vytvorNovySlovnik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
            .addComponent(vytvoreniSlovniku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(vytvoreniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
this.gui.setMyView(15);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void vytvorNovySlovnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vytvorNovySlovnikActionPerformed
        this.gui.slovnik.vytvorNovySlovnik(this.nazevNovehoSlovniku.getText(),this.gui.uzivatel.getJmeno());
        this.nazevNovehoSlovniku.setText("");
    }//GEN-LAST:event_vytvorNovySlovnikActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nazevNovehoSlovniku;
    private javax.swing.JButton vytvorNovySlovnik;
    private javax.swing.JPanel vytvoreniSlovniku;
    // End of variables declaration//GEN-END:variables
}
