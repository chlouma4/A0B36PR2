/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

/**
 *
 * @author Marco
 */
public class VyhodnoceniTestu extends javax.swing.JPanel {
        Slovník slovnik;
         Gui gui;

    /**
     * Creates new form VyhodnoceniTestu
     */
    
    
    private void  vyhodnot (){
           if (this.gui.spatneOdpovedi.length==1) {
                this.textAreaVyhodnoceniTestu.append("Byl/a jste vzykousen/a z " + 
                        this.gui.spatneOdpovedi[this.gui.spatneOdpovedi.length-1] + 
                        " slovicek   z nichz jste na"
                        + "vsechny  odpovedel/a spravne. \n Gratuluji! - Congratulations!");
            } else {
                this.textAreaVyhodnoceniTestu.append("Byl/a jste vzykousen/a z " + 
                        this.gui.spatneOdpovedi[this.gui.spatneOdpovedi.length-1]+ 
                        " slovicek  \n z nichz jste na " + (this.gui.spatneOdpovedi.length-1) + ""
                        + " odpovedel/a spatne\n");
                
                System.out.println("pocet otazek "+ this.gui.spatneOdpovedi[this.gui.spatneOdpovedi.length-1]);
                System.out.println("pocet spatnzch odpovedi "+(this.gui.spatneOdpovedi.length-1));
                int procenta = (100 * ( this.gui.spatneOdpovedi[this.gui.spatneOdpovedi.length-1]
                        - (this.gui.spatneOdpovedi.length-1))) /
                     this.gui.spatneOdpovedi[this.gui.spatneOdpovedi.length-1];
                this.textAreaVyhodnoceniTestu.append("Vase uspesnost je " + procenta + "% \n Slovicka ktera jste zodpovedel/a spatne ve spravnem prekladu\n");
            }
            for (int i = 0; i < this.gui.spatneOdpovedi.length-1; i++) {
                this.textAreaVyhodnoceniTestu.append("" + this.slovnik.vypisXZeSpojovehoSeznamu(this.gui.spatneOdpovedi[i])+"\n");
            }
    }
    public VyhodnoceniTestu(Slovník slovnik, Gui gui) {
        this.slovnik = slovnik;
        this.gui = gui;
        initComponents();
        vyhodnot();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vyhodnoceniTestu = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaVyhodnoceniTestu = new javax.swing.JTextArea();
        doMenuZVyhodnoceniTestu = new javax.swing.JButton();

        jLabel30.setText("Vyhodnoceni Testu");

        textAreaVyhodnoceniTestu.setEditable(false);
        textAreaVyhodnoceniTestu.setColumns(20);
        textAreaVyhodnoceniTestu.setRows(5);
        jScrollPane5.setViewportView(textAreaVyhodnoceniTestu);

        doMenuZVyhodnoceniTestu.setText("Navrat do menu");
        doMenuZVyhodnoceniTestu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doMenuZVyhodnoceniTestuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vyhodnoceniTestuLayout = new javax.swing.GroupLayout(vyhodnoceniTestu);
        vyhodnoceniTestu.setLayout(vyhodnoceniTestuLayout);
        vyhodnoceniTestuLayout.setHorizontalGroup(
            vyhodnoceniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vyhodnoceniTestuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(196, 196, 196))
            .addGroup(vyhodnoceniTestuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(vyhodnoceniTestuLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(doMenuZVyhodnoceniTestu)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        vyhodnoceniTestuLayout.setVerticalGroup(
            vyhodnoceniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vyhodnoceniTestuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doMenuZVyhodnoceniTestu)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vyhodnoceniTestu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vyhodnoceniTestu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doMenuZVyhodnoceniTestuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doMenuZVyhodnoceniTestuActionPerformed
this.gui.setMyView(3);
    }//GEN-LAST:event_doMenuZVyhodnoceniTestuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doMenuZVyhodnoceniTestu;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea textAreaVyhodnoceniTestu;
    private javax.swing.JPanel vyhodnoceniTestu;
    // End of variables declaration//GEN-END:variables
}
