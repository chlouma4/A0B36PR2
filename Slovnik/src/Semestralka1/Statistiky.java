/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.util.Enumeration;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Marco
 */
public class Statistiky extends javax.swing.JPanel  {
    Gui gui;
 
    TableModel dataModelAktivni = new AbstractTableModel() {
        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public int getRowCount() {
            return gui.slovnik.getPocetBunek();
        }

        @Override
        public String getColumnName(int i) {
            switch (i) {
                case 0:
                    return "Preklad";
                case 1:
                    return "Spravne zodpovezeno";
                case 2:
                    return "Spatne zodpovezeno";
                case 3:
                    return "Uspesnost";
            }
            return "Chyba!";

        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            rowIndex++;
            switch (columnIndex) {
                case 0:
                    return gui.slovnik.vypisXZeSpojovehoSeznamu(rowIndex);
                case 1:
                    return gui.slovnik.getObsahBunky(rowIndex, 3);
                case 2:
                    return gui.slovnik.getObsahBunky(rowIndex, 4);
                case 3:
                    return gui.slovnik.vypoctiUspesnost(Integer.valueOf(gui.slovnik.getObsahBunky(rowIndex, 3)),
                            Integer.valueOf(gui.slovnik.getObsahBunky(rowIndex, 4)));

            }
            return "Chyba!";
        }
    };
    TableModel dataModelNeaktivni = new AbstractTableModel() {
        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public int getRowCount() {
            return gui.slovnik.neaktivni.size();
        }

        @Override
        public String getColumnName(int i) {
            switch (i) {
                case 0:
                    return "Preklad";
                case 1:
                    return "Spravne zodpovezeno";
                case 2:
                    return "Spatne zodpovezeno";
                case 3:
                    return "Uspesnost";
            }
            return "Chyba!";

        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    Slovo slovo0 = (Slovo) gui.slovnik.neaktivni.get(rowIndex);
                    return slovo0.toString();
                case 1:
                    Slovo slovo1 = (Slovo) gui.slovnik.neaktivni.get(rowIndex);
                    return slovo1.getPocetSpravnychOdpovedi();
                case 2:
                    Slovo slovo2 = (Slovo) gui.slovnik.neaktivni.get(rowIndex);
                    return slovo2.getPocetSpatnychOdpovedi();
                case 3:
                    Slovo slovo3 = (Slovo) gui.slovnik.neaktivni.get(rowIndex);
                    return gui.slovnik.vypoctiUspesnost(slovo3.getPocetSpravnychOdpovedi(), slovo3.getPocetSpatnychOdpovedi());

            }
            return "Chyba!";
        }
    };
 private void setWidth(){
           table.getColumnModel().getColumn(0).setPreferredWidth(250);
            table.getColumnModel().getColumn(1).setPreferredWidth(140);
            table.getColumnModel().getColumn(2).setPreferredWidth(140);
            table.getColumnModel().getColumn(3).setPreferredWidth(81);
 }
    private void  start(){
        if(this.gui.slovnik.getPocetBunek()==0){
            this.table.setModel(this.dataModelNeaktivni);
        }else{
            this.table.setModel(this.dataModelAktivni);
        }
    }
    /**
     * Creates new form Statistiky
     */
    public Statistiky(Gui gui) {
        this.gui = gui;
        initComponents();
        start();
        this.setWidth();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statistiky = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        statistikyZpet = new javax.swing.JButton();

        jLabel19.setText("Statistiky");

        table.setModel(this.dataModelAktivni);
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(table);

        jButton8.setText("Zobraz statistiku pro neaktivni slova");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        statistikyZpet.setText("Zpet");
        statistikyZpet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistikyZpetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statistikyLayout = new javax.swing.GroupLayout(statistiky);
        statistiky.setLayout(statistikyLayout);
        statistikyLayout.setHorizontalGroup(
            statistikyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statistikyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statistikyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statistikyLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statistikyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statistikyLayout.createSequentialGroup()
                        .addComponent(statistikyZpet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addContainerGap())))
        );
        statistikyLayout.setVerticalGroup(
            statistikyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statistikyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(statistikyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(statistikyZpet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(statistiky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statistiky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        if (this.jButton8.getText().equals("Zobrazit statistiku pro aktivni slova")) {
            if (this.gui.slovnik.getPocetBunek() == 0) {
                JOptionPane.showMessageDialog(this.gui, "Nejsou zadna slova k zobrazeni");
            } else {
                this.table.setModel(this.dataModelAktivni);
                this.setWidth();
                this.jButton8.setText("Zobraz statistiku pro neaktivni slova");
            }
        } else {
            if (this.gui.slovnik.neaktivni.isEmpty()) {
                JOptionPane.showMessageDialog(this.gui, "Nejsou zadna slova k zobrazeni");
            } else {
                this.table.setModel(this.dataModelNeaktivni);
                this.setWidth();
                this.jButton8.setText("Zobrazit statistiku pro aktivni slova");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void statistikyZpetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistikyZpetActionPerformed
        this.gui.setMyView(3);
    }//GEN-LAST:event_statistikyZpetActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel statistiky;
    private javax.swing.JButton statistikyZpet;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

  
}
