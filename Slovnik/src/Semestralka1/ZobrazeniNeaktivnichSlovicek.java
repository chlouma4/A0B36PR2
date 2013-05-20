/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

/**
 *
 * @author Marco
 */
public class ZobrazeniNeaktivnichSlovicek extends javax.swing.JPanel {
private Gui gui;

    /**
     * Creates new form ZobrazeniNeaktivnichSlovicek
     */

private void zobrazNeaktivni(){
       String[] slova = this.gui.slovnik.vypisNeaktivni();
        for (int i = 0; i < slova.length; i++) {
            this.zobrayeniNeaktivnichSlov.append("("+(i+1)+") "+slova[i] + "\n");
        }
}
    public ZobrazeniNeaktivnichSlovicek(Gui gui) {
        this.gui=gui;
        initComponents();
        this.zobrazNeaktivni();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new MyLabel(this.gui,3);
        zobrazeniNeaktivnichSlovicek = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        zobrayeniNeaktivnichSlov = new javax.swing.JTextArea();
        zpetNeaktivni = new javax.swing.JButton();
        jLabel5 = new MyLabel(this.gui,3);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new MyLabel(this.gui,5);
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new MyLabel(this.gui,9);

        jLabel4.setText("Menu");

        zobrazeniNeaktivnichSlovicek.setBackground(new java.awt.Color(51, 102, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 204, 0));
        jLabel17.setText("Zobrazení neaktivních slovíček");

        zobrayeniNeaktivnichSlov.setEditable(false);
        zobrayeniNeaktivnichSlov.setBackground(new java.awt.Color(0, 0, 204));
        zobrayeniNeaktivnichSlov.setColumns(20);
        zobrayeniNeaktivnichSlov.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        zobrayeniNeaktivnichSlov.setForeground(new java.awt.Color(0, 204, 0));
        zobrayeniNeaktivnichSlov.setRows(5);
        jScrollPane2.setViewportView(zobrayeniNeaktivnichSlov);

        zpetNeaktivni.setBackground(new java.awt.Color(0, 0, 204));
        zpetNeaktivni.setForeground(new java.awt.Color(0, 204, 0));
        zpetNeaktivni.setText("Zpět");
        zpetNeaktivni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetNeaktivniActionPerformed(evt);
            }
        });

        jLabel5.setText("Menu");

        jLabel1.setText("-->");

        jLabel2.setText("Správa slovíček");

        jLabel3.setText("-->");

        jLabel6.setText("Zobrazení neaktivních slovíček");

        javax.swing.GroupLayout zobrazeniNeaktivnichSlovicekLayout = new javax.swing.GroupLayout(zobrazeniNeaktivnichSlovicek);
        zobrazeniNeaktivnichSlovicek.setLayout(zobrazeniNeaktivnichSlovicekLayout);
        zobrazeniNeaktivnichSlovicekLayout.setHorizontalGroup(
            zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                .addGroup(zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                                .addComponent(zpetNeaktivni)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(19, 19, 19))
        );
        zobrazeniNeaktivnichSlovicekLayout.setVerticalGroup(
            zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zpetNeaktivni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(zobrazeniNeaktivnichSlovicek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(zobrazeniNeaktivnichSlovicek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void zpetNeaktivniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetNeaktivniActionPerformed
 this.gui.setMyView(5);     
    }//GEN-LAST:event_zpetNeaktivniActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea zobrayeniNeaktivnichSlov;
    private javax.swing.JPanel zobrazeniNeaktivnichSlovicek;
    private javax.swing.JButton zpetNeaktivni;
    // End of variables declaration//GEN-END:variables
}
