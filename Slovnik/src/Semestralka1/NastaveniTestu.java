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
public class NastaveniTestu extends javax.swing.JPanel {
private Gui gui;
    
    /**
     * Creates new form NastaveniTestu
     */
    public NastaveniTestu(Gui gui) {
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

        jLabel3 = new MyLabel(this.gui,3);
        nastaveniTestu = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        kamPrekladat = new javax.swing.JButton();
        pocetOtazek = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel4 = new MyLabel(this.gui,3);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new MyLabel(this.gui,12);

        jLabel3.setText("Menu");

        nastaveniTestu.setBackground(new java.awt.Color(51, 102, 255));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 204, 0));
        jLabel25.setText("Nastavení testu");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 204, 0));
        jLabel26.setText("Chci překládat do :");

        kamPrekladat.setBackground(new java.awt.Color(0, 0, 204));
        kamPrekladat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kamPrekladat.setForeground(new java.awt.Color(0, 204, 0));
        kamPrekladat.setText("Češtiny");
        kamPrekladat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kamPrekladatActionPerformed(evt);
            }
        });

        pocetOtazek.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 204, 0));
        jLabel27.setText("Zadejte počet otázek testu :");

        jButton11.setBackground(new java.awt.Color(0, 0, 204));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 204, 0));
        jButton11.setText("Zpět");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 0, 204));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 204, 0));
        jButton12.setText("Spustit test");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel4.setText("Menu");

        jLabel1.setText("-->");

        jLabel2.setText("Nastavení testu");

        javax.swing.GroupLayout nastaveniTestuLayout = new javax.swing.GroupLayout(nastaveniTestu);
        nastaveniTestu.setLayout(nastaveniTestuLayout);
        nastaveniTestuLayout.setHorizontalGroup(
            nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nastaveniTestuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(pocetOtazek, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton11)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kamPrekladat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(nastaveniTestuLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        nastaveniTestuLayout.setVerticalGroup(
            nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(21, 21, 21)
                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(kamPrekladat))
                .addGap(18, 18, 18)
                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pocetOtazek, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nastaveniTestu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nastaveniTestu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kamPrekladatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kamPrekladatActionPerformed
        if (this.kamPrekladat.getText().equals("Češtiny")) {
            this.kamPrekladat.setText("Angličtiny");
        } else {
            this.kamPrekladat.setText("Češtiny");
        }
    }//GEN-LAST:event_kamPrekladatActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
this.gui.setMyView(3); 
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
  if(this.gui.slovnik.getPocetBunek()>=((Integer)this.pocetOtazek.getValue())){
        int preklad;
        if(this.kamPrekladat.getText().equals("Češtiny")){
            preklad=1;
        }else{
            preklad=2;
        }
        this.gui.nasatveniTestu=new int [2];
        this.gui.nasatveniTestu[0]=preklad;
        if((Integer)this.pocetOtazek.getValue()==1){
            JOptionPane.showMessageDialog(this.gui, "Test o jedne otazce je jednoduchy  nastavuji pocet otazek na maximum :D");
             this.gui.nasatveniTestu[1]=this.gui.slovnik.getPocetBunek();
        }else{
         this.gui.nasatveniTestu[1]=((Integer)this.pocetOtazek.getValue());   
        }
        this.gui.setMyView(13);
}else{
     JOptionPane.showMessageDialog(this.gui, "Takovy pocet slov  slovnik "+this.gui.slovnik.getTypSlovniku()+" neobsahuje", "Chyba!", JOptionPane.WARNING_MESSAGE);
}
    }//GEN-LAST:event_jButton12ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton kamPrekladat;
    private javax.swing.JPanel nastaveniTestu;
    private javax.swing.JSpinner pocetOtazek;
    // End of variables declaration//GEN-END:variables
}
