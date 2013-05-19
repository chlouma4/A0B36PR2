/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class Test extends javax.swing.JPanel {

    private int citac;
    private Gui gui;
    private Integer[] generovanaCisla;
    private int pocetOtazek;
    private int prekladOdkud;
    private int prekladKam;
    private ArrayList spatneOdpovedi = new ArrayList();

    /**
     * Creates new form Test
     */
    /**Metoda  generuje nahodna cisla.Podle zadanych parametru
     * 
     * @param pocet - Pocet cisel ktere metoda navrati
     * @param max - Maximalni velikost cisla  ktere metoda navrati
     * @param arrayA - Vsechny cisla v tomto poli budou mezi generovanymi
     * cisli.Pokud bude  parametr pocet mensi nez pocet cisel v tomto poli.
     * Tak metoda navrati nahodne cisla z tohoto pole.
     * @return 
     */
    private Integer[] generatorNahodnychCisel(int pocet, int max, ArrayList arrayA) { // (Integer je zde pouzit misto int protoze int je promitivni datovy typ a s nim by tato metoda nefungovala)
        //Tato metoda generuje  cisla v zavislosti na promench pocet(udava kolik cisel chceme navratit), max (udava jake nejvissi cislo muze byt navraceno), arrayA(rikame generatoru ze tato cisla museji
        // byt mezi navracenimy. Metoda vraci pole s nahodne vygenerovanymi a prehazenimy cisli.
        Integer[] A = (Integer[]) arrayA.toArray(new Integer[arrayA.size()]); // prevod dynamickeho pole na pole Integer
        if (pocet <= A.length) {    // resi pripad kdyz je zadany pocet slovicek mensi  nebo roven poctu spatnych odpovedi v minulem testu
            ArrayList arrayList = new ArrayList(); //vytvoreni pomocneho dynamickeho pole 
            arrayList.addAll(Arrays.asList(A));
            Collections.shuffle(arrayList); // tento radek je duvod proc pracuji s dynamickym polem - nevim jak zamichat pole typu Integer
            Integer[] pole = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]); // prevedu array do pole Integer
            Integer B[] = new Integer[pocet]; // pole o pozadovane velikosti
            System.arraycopy(pole, 0, B, 0, B.length);
            return B;
        }
        if (pocet > A.length && pocet != max) { // resi pripad kdy je pozadovany pocet slovicek v intervalu (pocet spatne zodpovezenich , max)
            Set<Integer> seznam = new HashSet<Integer>(); // do setu se nedaji zadat dve stejne hodnoty - resi duplicitu
            Random random = new Random();
            seznam.addAll(Arrays.asList(A));
            int interval = max - 1;
            while (seznam.size() < pocet) {  // doplnime seznam nahodnymi  cisli na pocet zadany uzivatelem
                seznam.add(random.nextInt(interval) + 1);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(seznam);         // prvedeni seznamu do array
            Collections.shuffle(arrayList); // zamichani
            Integer[] pole = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
            Integer B[] = new Integer[pocet];
            System.arraycopy(pole, 0, B, 0, B.length);
            return B;
        }
        if (pocet == max) { // resi pripad kdz je pocet poyadovanych slovicek roven slovni zasobe 
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i <= max; i++) {
                arrayList.add(i);
            }
            Collections.shuffle(arrayList);
            Integer[] pole = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
            return pole;
        }


        return null; // na tento radek bz jse nemel nikdy program dostat - ochrana v metode main

    }

    /**Metoda ktera se vola jen v konstruktoru tridy Test.
     *Nastavi prvni otazku a tridni promene.
     * 
     */
    private void start() {
        this.prekladOdkud = this.gui.nasatveniTestu[0];
        if (this.prekladOdkud == 1) {
            this.prekladKam = 2;
        } else {
            this.prekladKam = 1;
        }
        this.pocetOtazek = this.gui.nasatveniTestu[1];
        generovanaCisla = new Integer[this.pocetOtazek];
        generovanaCisla = generatorNahodnychCisel(this.pocetOtazek,
                this.gui.slovnik.getPocetBunek(),
                this.gui.slovnik.sNejvissimPocetemSpatnychOdpovedi(this.pocetOtazek / 2));
        this.citac = 0;
        this.otazka.setText(this.gui.slovnik.getObsahBunky(generovanaCisla[citac], prekladOdkud));
        this.progresTest.setMaximum(this.pocetOtazek);
        this.progresTest.setValue(citac + 1);
    }

    /**Metoda kontroluje odpoved uzivatele.
     * Podle vysledku upravi statistiku uzivatele.
     * 
     */
    private void kontrola() {
        System.out.println("Kontroluji");
        boolean testOdpovedi;
        String prelozeno;
        prelozeno = this.odpoved.getText();
        prelozeno = prelozeno.toLowerCase();
        testOdpovedi = prelozeno.equals(this.gui.slovnik.getObsahBunky(this.generovanaCisla[citac], prekladKam).toLowerCase());
        System.out.println("vysledek " + testOdpovedi);
        if (testOdpovedi == true) {
            this.gui.slovnik.upravStatistiku(this.generovanaCisla[citac], 0);
        } else {
            this.gui.slovnik.upravStatistiku(this.generovanaCisla[citac], 1);
            this.spatneOdpovedi.add(this.generovanaCisla[citac]);
            System.out.println("pocet spatnych odpovedi " + spatneOdpovedi.size());
        }
    }

    public Test(Gui gui) {
        this.gui = gui;
        initComponents();
        start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        test = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        progresTest = new javax.swing.JProgressBar();
        okTest = new javax.swing.JButton();
        otazka = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        odpoved = new javax.swing.JTextField();

        jLabel28.setText("Test");

        okTest.setText("OK");
        okTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okTestActionPerformed(evt);
            }
        });

        otazka.setEditable(false);

        jLabel29.setText("prelozte");

        javax.swing.GroupLayout testLayout = new javax.swing.GroupLayout(test);
        test.setLayout(testLayout);
        testLayout.setHorizontalGroup(
            testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testLayout.createSequentialGroup()
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(progresTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(testLayout.createSequentialGroup()
                        .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(testLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel28))
                            .addGroup(testLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(okTest)
                                    .addGroup(testLayout.createSequentialGroup()
                                        .addComponent(otazka, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel29)))
                                .addGap(38, 38, 38)
                                .addComponent(odpoved, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        testLayout.setVerticalGroup(
            testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progresTest, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otazka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(odpoved, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(okTest)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okTestActionPerformed
        if (this.odpoved.getText().equals("")) {
            JOptionPane.showMessageDialog(this.gui, "Neviplnili jste policko", "Chyba!", JOptionPane.WARNING_MESSAGE);
        } else {
            this.kontrola();
            if (this.generovanaCisla.length - 1 == citac) {
                if (!this.spatneOdpovedi.isEmpty()) {
                    this.gui.spatneOdpovedi = new int[this.spatneOdpovedi.size() + 1];
                    for (int i = 0; i < this.spatneOdpovedi.size(); i++) {
                        this.gui.spatneOdpovedi[i] = (int) this.spatneOdpovedi.get(i);
                    }
                    this.gui.spatneOdpovedi[this.spatneOdpovedi.size()] = this.generovanaCisla.length;
                    this.gui.setMyView(14);
                } else {
                    this.gui.spatneOdpovedi = new int[1];
                    this.gui.spatneOdpovedi[0] = this.generovanaCisla.length;
                }
                this.gui.setMyView(14);
            } else {
                citac = citac + 1;
                this.progresTest.setValue(citac + 1);
                this.otazka.setText(this.gui.slovnik.getObsahBunky(generovanaCisla[citac], prekladOdkud));
                this.odpoved.setText("");
            }
        }
    }//GEN-LAST:event_okTestActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JTextField odpoved;
    private javax.swing.JButton okTest;
    private javax.swing.JTextField otazka;
    private javax.swing.JProgressBar progresTest;
    private javax.swing.JPanel test;
    // End of variables declaration//GEN-END:variables
}
