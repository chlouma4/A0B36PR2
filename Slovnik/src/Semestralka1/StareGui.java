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
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Marco
 */
public class StareGui extends javax.swing.JFrame {

    Uzivatel uzivatel = new Uzivatel(this.rootPane);
    Slovník slovnik = new Slovník(this.rootPane);
    ArrayList spatneOdpovedi = new ArrayList();
    Integer[] generovanaCisla;
    int preklad;
    int citac;
    TableModel dataModelAktivni = new AbstractTableModel() {
        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public int getRowCount() {
            return 4;
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
                    return slovnik.vypisXZeSpojovehoSeznamu(rowIndex);
                case 1:
                    return slovnik.getObsahBunky(rowIndex, 3);
                case 2:
                    return slovnik.getObsahBunky(rowIndex, 4);
                case 3:
                    return slovnik.vypoctiUspesnost(Integer.valueOf(slovnik.getObsahBunky(rowIndex, 3)),
                            Integer.valueOf(slovnik.getObsahBunky(rowIndex, 4)));

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
            return 1;
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
                    Slovo slovo0 = (Slovo) slovnik.neaktivni.get(rowIndex);
                    return slovo0.toString();
                case 1:
                    Slovo slovo1 = (Slovo) slovnik.neaktivni.get(rowIndex);
                    return slovo1.getPocetSpravnychOdpovedi();
                case 2:
                    Slovo slovo2 = (Slovo) slovnik.neaktivni.get(rowIndex);
                    return slovo2.getPocetSpatnychOdpovedi();
                case 3:
                    Slovo slovo3 = (Slovo) slovnik.neaktivni.get(rowIndex);
                    return slovnik.vypoctiUspesnost(slovo3.getPocetSpravnychOdpovedi(), slovo3.getPocetSpatnychOdpovedi());

            }
            return "Chyba!";
        }
    };

    static private Integer[] generatorNahodnychCisel(int pocet, int max, ArrayList arrayA) { // (Integer je zde pouzit misto int protoze int je promitivni datovy typ a s nim by tato metoda nefungovala)
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

    /**
     * Creates new form StareGui
     */
    public StareGui() {
        initComponents();
        this.setTitle("Slovnik");
        this.setSize(250, 200);
        this.zobrazeniSlovniku.setVisible(false);
        this.novyUcet.setVisible(false);
        this.spravaSlovniku.setVisible(false);
        this.vyberSlovnikPanel.setVisible(false);
        this.mazaniSlovicekPanel.setVisible(false);
        this.pridaniSlovicekPanel1.setVisible(false);
        this.spravaSlovicek1.setVisible(false);
        this.spravaSlovicek.setVisible(false);
        this.zobrazeniNeaktivnichSlovicek.setVisible(false);
        this.zobrazeniSlovicekPanel.setVisible(false);
        this.statistiky.setVisible(false);
        this.aktivaceSlovicek12.setVisible(false);
        this.nastaveniTestu.setVisible(false);
        this.test.setVisible(false);
        this.vyhodnoceniTestu.setVisible(false);
        this.test.setVisible(false);
        this.vytvoreniSlovniku.setVisible(false);
        this.smazaniSlovniku.setVisible(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(250);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        Prihlaseni = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vyberUcet = new javax.swing.JComboBox();
        prihlas = new javax.swing.JButton();
        vytvorNovyUcet = new javax.swing.JButton();
        vstupHesla = new javax.swing.JPasswordField();
        novyUcet = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vytvorUcetButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        zpetDoPrihlas = new javax.swing.JButton();
        jmenoUctu = new javax.swing.JTextField();
        hesloNovehoUctu = new javax.swing.JPasswordField();
        opakovaneHesloNovehoUctu = new javax.swing.JPasswordField();
        jLabel20 = new javax.swing.JLabel();
        vyberSlovnikPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        vyberSlovnik = new javax.swing.JComboBox();
        potvrdSlovnik = new javax.swing.JButton();
        pridaniSlovicekPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ceskyVyraz = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        anglickyVyraz = new javax.swing.JTextField();
        Uloz = new javax.swing.JButton();
        spravaSlovicek = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pridaniSlovicekButton = new javax.swing.JButton();
        smazaniSlovicekButton = new javax.swing.JButton();
        zobrazeniSlovicekButton = new javax.swing.JButton();
        zobrazeniNeaktivnichSlovicekButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        aktivovaniNeaktivnichSlov = new javax.swing.JToggleButton();
        Menu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        spravaSlovicekButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        zmenaSlovniku = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        odhlasitSe = new javax.swing.JButton();
        ukoncitProgram = new javax.swing.JButton();
        spravaSlovnikuButon = new javax.swing.JButton();
        spravaHracuButton = new javax.swing.JButton();
        zobrazeniSlovicekPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        zobrayeniSlovicekText = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        zobrazVse = new javax.swing.JButton();
        mazaniSlovicekPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        deaktivujDvojci = new javax.swing.JButton();
        uplneVymazani = new javax.swing.JButton();
        zpetMazaniSlovicek = new javax.swing.JButton();
        cisloKeSmazani = new javax.swing.JSpinner();
        spravaSlovicek1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        pridaniSlovicekButton1 = new javax.swing.JButton();
        smazaniSlovicekButton1 = new javax.swing.JButton();
        zobrazeniSlovicekButton1 = new javax.swing.JButton();
        zobrazeniNeaktivnichSlovicekButton1 = new javax.swing.JButton();
        zpetSpravaSlovicek = new javax.swing.JButton();
        aktivovaniNeaktivnichSlov1 = new javax.swing.JToggleButton();
        pridaniSlovicekPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ceskyVyraz1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        anglickyVyraz1 = new javax.swing.JTextField();
        Uloz1 = new javax.swing.JButton();
        zobrazeniNeaktivnichSlovicek = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        zobrayVseNeaktivni = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        zobrayeniNeaktivnichSlov = new javax.swing.JTextArea();
        zpetNeaktivni = new javax.swing.JButton();
        prejitDoMenuNeaktivni = new javax.swing.JButton();
        aktivaceSlovicek12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        zobrazeniAktivaceSlovicek = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        aktivovatVse = new javax.swing.JButton();
        aktivovatVybrane = new javax.swing.JButton();
        coAktivovat = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        cleanAktivaceSlovicek = new javax.swing.JButton();
        statistiky = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        statistikyZpet = new javax.swing.JButton();
        nastaveniTestu = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        kamPrekladat = new javax.swing.JButton();
        pocetOtazek = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        test = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        progresTest = new javax.swing.JProgressBar();
        okTest = new javax.swing.JButton();
        kPrekladu1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        kPrekladu2 = new javax.swing.JTextField();
        vyhodnoceniTestu = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaVyhodnoceniTestu = new javax.swing.JTextArea();
        doMenuZVyhodnoceniTestu = new javax.swing.JButton();
        spravaSlovniku = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        zpetDoMenuZSpravaSlovicek = new javax.swing.JButton();
        zobrazeniSlovniku = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textAreaZobrazeniSlovniku = new javax.swing.JTextArea();
        zpetZezobrazeniSlovnku = new javax.swing.JButton();
        vytvoreniSlovniku = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        nazevNovehoSlovniku = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        vytvorNovySlovnik = new javax.swing.JButton();
        smazaniSlovniku = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaSmazaniSlovniku = new javax.swing.JTextArea();
        jButton16 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        spinnerSmazaniSlovniku = new javax.swing.JSpinner();
        vymazatSlovnik = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jTabbedPane2.addTab("tab1", jTabbedPane3);

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.Menu.setVisible(false);

        jLabel1.setText("Vyberte svuj ucet :");

        jLabel2.setText("Zadejte své heslo");

        vyberUcet.setModel(new javax.swing.DefaultComboBoxModel(uzivatel.nactiUdajeOHracich(1)));
        vyberUcet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vyberUcetActionPerformed(evt);
            }
        });

        prihlas.setText("Prihlas");
        prihlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prihlasActionPerformed(evt);
            }
        });

        vytvorNovyUcet.setText("Vytvorit novy ucet");
        vytvorNovyUcet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vytvorNovyUcetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PrihlaseniLayout = new javax.swing.GroupLayout(Prihlaseni);
        Prihlaseni.setLayout(PrihlaseniLayout);
        PrihlaseniLayout.setHorizontalGroup(
            PrihlaseniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrihlaseniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PrihlaseniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrihlaseniLayout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(vytvorNovyUcet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prihlas))
                    .addGroup(PrihlaseniLayout.createSequentialGroup()
                        .addGroup(PrihlaseniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PrihlaseniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vyberUcet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PrihlaseniLayout.createSequentialGroup()
                                .addComponent(vstupHesla, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        PrihlaseniLayout.setVerticalGroup(
            PrihlaseniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrihlaseniLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PrihlaseniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vyberUcet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PrihlaseniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vstupHesla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PrihlaseniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prihlas)
                    .addComponent(vytvorNovyUcet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Zadejte jmeno uctu:");

        jLabel4.setText("Zadejte heslo pro ucet*:");

        jLabel5.setText("Opakujte heslo zadani uctu:");

        vytvorUcetButton.setText("Vytvor");
        vytvorUcetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vytvorUcetButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("* Heslo musi mit delku 4 nebo 6 znaku.");

        zpetDoPrihlas.setText("Zpet");
        zpetDoPrihlas.setMaximumSize(new java.awt.Dimension(65, 23));
        zpetDoPrihlas.setMinimumSize(new java.awt.Dimension(65, 23));
        zpetDoPrihlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetDoPrihlasActionPerformed(evt);
            }
        });

        jmenoUctu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenoUctuActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Vytvoření nového účtu");

        javax.swing.GroupLayout novyUcetLayout = new javax.swing.GroupLayout(novyUcet);
        novyUcet.setLayout(novyUcetLayout);
        novyUcetLayout.setHorizontalGroup(
            novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, novyUcetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(zpetDoPrihlas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jmenoUctu, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(hesloNovehoUctu)
                    .addComponent(opakovaneHesloNovehoUctu)
                    .addComponent(vytvorUcetButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(novyUcetLayout.createSequentialGroup()
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(novyUcetLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6))
                    .addGroup(novyUcetLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel20)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        novyUcetLayout.setVerticalGroup(
            novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(novyUcetLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jmenoUctu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hesloNovehoUctu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(opakovaneHesloNovehoUctu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(novyUcetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vytvorUcetButton)
                    .addComponent(zpetDoPrihlas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Vyberte slonik s kterym chcete pacovat: ");

        vyberSlovnik.setModel(new javax.swing.DefaultComboBoxModel(slovnik.getSeznamSlovniku()));
        vyberSlovnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vyberSlovnikActionPerformed(evt);
            }
        });

        potvrdSlovnik.setText("Ok");
        potvrdSlovnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                potvrdSlovnikActionPerformed(evt);
            }
        });

        jLabel11.setText("Pridani Slovicek");

        jLabel12.setText("Zadejte cesky vyraz:");

        ceskyVyraz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceskyVyrazActionPerformed(evt);
            }
        });

        jLabel13.setText("Zadejte jeho anglicky preklad:");

        Uloz.setText("Uloz");
        Uloz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UlozActionPerformed(evt);
            }
        });

        spravaSlovicek.setBackground(new java.awt.Color(0, 102, 204));

        jLabel9.setText("Sprava Slovicek");

        pridaniSlovicekButton.setText("Pridani slovicek");
        pridaniSlovicekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridaniSlovicekButtonActionPerformed(evt);
            }
        });

        smazaniSlovicekButton.setText("Smazani slovicek");
        smazaniSlovicekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smazaniSlovicekButtonActionPerformed(evt);
            }
        });

        zobrazeniSlovicekButton.setText("Zobrazeni slovicek");
        zobrazeniSlovicekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazeniSlovicekButtonActionPerformed(evt);
            }
        });

        zobrazeniNeaktivnichSlovicekButton.setText("Zobrazeni neaktivnich slovicek");
        zobrazeniNeaktivnichSlovicekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazeniNeaktivnichSlovicekButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Zpet");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        aktivovaniNeaktivnichSlov.setText("Aktivovat neaktivni slovicka");
        aktivovaniNeaktivnichSlov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktivovaniNeaktivnichSlovActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout spravaSlovicekLayout = new javax.swing.GroupLayout(spravaSlovicek);
        spravaSlovicek.setLayout(spravaSlovicekLayout);
        spravaSlovicekLayout.setHorizontalGroup(
            spravaSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spravaSlovicekLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel9)
                .addContainerGap())
            .addGroup(spravaSlovicekLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(spravaSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spravaSlovicekLayout.createSequentialGroup()
                        .addComponent(pridaniSlovicekButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(smazaniSlovicekButton)
                        .addGap(39, 39, 39))
                    .addGroup(spravaSlovicekLayout.createSequentialGroup()
                        .addComponent(zobrazeniSlovicekButton)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(spravaSlovicekLayout.createSequentialGroup()
                        .addGroup(spravaSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aktivovaniNeaktivnichSlov)
                            .addComponent(zobrazeniNeaktivnichSlovicekButton))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        spravaSlovicekLayout.setVerticalGroup(
            spravaSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spravaSlovicekLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addGap(31, 31, 31)
                .addGroup(spravaSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridaniSlovicekButton)
                    .addComponent(smazaniSlovicekButton))
                .addGap(18, 18, 18)
                .addGroup(spravaSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zobrazeniSlovicekButton)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(zobrazeniNeaktivnichSlovicekButton)
                .addGap(18, 18, 18)
                .addComponent(aktivovaniNeaktivnichSlov)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pridaniSlovicekPanelLayout = new javax.swing.GroupLayout(pridaniSlovicekPanel);
        pridaniSlovicekPanel.setLayout(pridaniSlovicekPanelLayout);
        pridaniSlovicekPanelLayout.setHorizontalGroup(
            pridaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pridaniSlovicekPanelLayout.createSequentialGroup()
                .addGroup(pridaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pridaniSlovicekPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(anglickyVyraz, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pridaniSlovicekPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Uloz))
                    .addGroup(pridaniSlovicekPanelLayout.createSequentialGroup()
                        .addGroup(pridaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pridaniSlovicekPanelLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pridaniSlovicekPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ceskyVyraz, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spravaSlovicek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pridaniSlovicekPanelLayout.setVerticalGroup(
            pridaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pridaniSlovicekPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pridaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pridaniSlovicekPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(pridaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(ceskyVyraz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(spravaSlovicek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pridaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(anglickyVyraz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Uloz)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout vyberSlovnikPanelLayout = new javax.swing.GroupLayout(vyberSlovnikPanel);
        vyberSlovnikPanel.setLayout(vyberSlovnikPanelLayout);
        vyberSlovnikPanelLayout.setHorizontalGroup(
            vyberSlovnikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vyberSlovnikPanelLayout.createSequentialGroup()
                .addComponent(pridaniSlovicekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(vyberSlovnikPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vyberSlovnikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vyberSlovnikPanelLayout.createSequentialGroup()
                        .addComponent(vyberSlovnik, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(potvrdSlovnik, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vyberSlovnikPanelLayout.setVerticalGroup(
            vyberSlovnikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vyberSlovnikPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vyberSlovnikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(potvrdSlovnik)
                    .addComponent(vyberSlovnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(278, 278, 278)
                .addComponent(pridaniSlovicekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(0, 102, 204));

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setForeground(new java.awt.Color(0, 204, 0));
        jButton1.setText("Zkouseni");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        spravaSlovicekButton.setBackground(new java.awt.Color(0, 0, 204));
        spravaSlovicekButton.setForeground(new java.awt.Color(0, 204, 0));
        spravaSlovicekButton.setText("Sprava slovicek");
        spravaSlovicekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spravaSlovicekButtonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setForeground(new java.awt.Color(0, 204, 0));
        jButton3.setText("Statistiky");
        jButton3.setMaximumSize(new java.awt.Dimension(146, 46));
        jButton3.setMinimumSize(new java.awt.Dimension(146, 46));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        zmenaSlovniku.setBackground(new java.awt.Color(0, 0, 204));
        zmenaSlovniku.setForeground(new java.awt.Color(0, 204, 0));
        zmenaSlovniku.setText("Zmena slovniku");
        zmenaSlovniku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zmenaSlovnikuActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 0));
        jLabel8.setText("Menu");

        odhlasitSe.setBackground(new java.awt.Color(0, 0, 204));
        odhlasitSe.setForeground(new java.awt.Color(0, 204, 0));
        odhlasitSe.setText("Odhlsit se");
        odhlasitSe.setMaximumSize(new java.awt.Dimension(107, 23));
        odhlasitSe.setMinimumSize(new java.awt.Dimension(107, 23));
        odhlasitSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odhlasitSeActionPerformed(evt);
            }
        });

        ukoncitProgram.setBackground(new java.awt.Color(0, 0, 204));
        ukoncitProgram.setForeground(new java.awt.Color(0, 204, 0));
        ukoncitProgram.setText("Ukoncit program");
        ukoncitProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ukoncitProgramActionPerformed(evt);
            }
        });

        spravaSlovnikuButon.setBackground(new java.awt.Color(0, 0, 204));
        spravaSlovnikuButon.setForeground(new java.awt.Color(0, 204, 0));
        spravaSlovnikuButon.setText("Sprava slovniku");
        spravaSlovnikuButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spravaSlovnikuButonActionPerformed(evt);
            }
        });

        spravaHracuButton.setBackground(new java.awt.Color(0, 0, 204));
        spravaHracuButton.setForeground(new java.awt.Color(0, 204, 0));
        spravaHracuButton.setText("Sprava Hracu");

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel8))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spravaSlovicekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(odhlasitSe, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spravaSlovnikuButon, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zmenaSlovniku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ukoncitProgram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spravaHracuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spravaSlovicekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zmenaSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spravaHracuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spravaSlovnikuButon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(odhlasitSe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ukoncitProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel10.setText("Zobrazeni slovicek");

        zobrayeniSlovicekText.setEditable(false);
        zobrayeniSlovicekText.setColumns(20);
        zobrayeniSlovicekText.setRows(5);
        jScrollPane1.setViewportView(zobrayeniSlovicekText);

        jButton7.setText("Zpet");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Prejit do Menu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        zobrazVse.setText("Zobraz");
        zobrazVse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazVseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout zobrazeniSlovicekPanelLayout = new javax.swing.GroupLayout(zobrazeniSlovicekPanel);
        zobrazeniSlovicekPanel.setLayout(zobrazeniSlovicekPanelLayout);
        zobrazeniSlovicekPanelLayout.setHorizontalGroup(
            zobrazeniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zobrazeniSlovicekPanelLayout.createSequentialGroup()
                .addGroup(zobrazeniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zobrazeniSlovicekPanelLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel10))
                    .addGroup(zobrazeniSlovicekPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(zobrazeniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(zobrazeniSlovicekPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9)
                                .addGap(9, 9, 9))
                            .addComponent(zobrazVse, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        zobrazeniSlovicekPanelLayout.setVerticalGroup(
            zobrazeniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zobrazeniSlovicekPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(7, 7, 7)
                .addComponent(zobrazVse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(zobrazeniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton9))
                .addGap(19, 19, 19))
        );

        jLabel14.setText("Mazani Slovicek");

        jLabel15.setText("Cislem vyberete dvojci slovicek ke smazani.");

        jLabel16.setText("Pred provedenim akce se dana dvojce slovicek zabrazi.");

        deaktivujDvojci.setText("deaktivivat dvojci");
        deaktivujDvojci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deaktivujDvojciActionPerformed(evt);
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

        cisloKeSmazani.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cisloKeSmazani.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

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
                        .addGroup(mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addGroup(mazaniSlovicekPanelLayout.createSequentialGroup()
                                .addGroup(mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mazaniSlovicekPanelLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(zpetMazaniSlovicek))
                                    .addComponent(cisloKeSmazani, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deaktivujDvojci, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(uplneVymazani, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(25, Short.MAX_VALUE))
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
                    .addComponent(deaktivujDvojci)
                    .addComponent(cisloKeSmazani, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(mazaniSlovicekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zpetMazaniSlovicek)
                    .addComponent(uplneVymazani))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        spravaSlovicek1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Sprava Slovicek");

        pridaniSlovicekButton1.setText("Pridani slovicek");
        pridaniSlovicekButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridaniSlovicekButton1ActionPerformed(evt);
            }
        });

        smazaniSlovicekButton1.setText("Smazani slovicek");
        smazaniSlovicekButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smazaniSlovicekButton1ActionPerformed(evt);
            }
        });

        zobrazeniSlovicekButton1.setText("Zobrazeni slovicek");
        zobrazeniSlovicekButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazeniSlovicekButton1ActionPerformed(evt);
            }
        });

        zobrazeniNeaktivnichSlovicekButton1.setText("Zobrazeni neaktivnich slovicek");
        zobrazeniNeaktivnichSlovicekButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazeniNeaktivnichSlovicekButton1ActionPerformed(evt);
            }
        });

        zpetSpravaSlovicek.setText("Zpet");
        zpetSpravaSlovicek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetSpravaSlovicekActionPerformed(evt);
            }
        });

        aktivovaniNeaktivnichSlov1.setText("Aktivovat neaktivni slovicka");
        aktivovaniNeaktivnichSlov1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktivovaniNeaktivnichSlov1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout spravaSlovicek1Layout = new javax.swing.GroupLayout(spravaSlovicek1);
        spravaSlovicek1.setLayout(spravaSlovicek1Layout);
        spravaSlovicek1Layout.setHorizontalGroup(
            spravaSlovicek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spravaSlovicek1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(spravaSlovicek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spravaSlovicek1Layout.createSequentialGroup()
                        .addComponent(pridaniSlovicekButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(smazaniSlovicekButton1)
                        .addGap(630, 630, 630))
                    .addGroup(spravaSlovicek1Layout.createSequentialGroup()
                        .addComponent(zobrazeniSlovicekButton1)
                        .addGap(33, 33, 33)
                        .addComponent(zpetSpravaSlovicek)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(spravaSlovicek1Layout.createSequentialGroup()
                        .addGroup(spravaSlovicek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aktivovaniNeaktivnichSlov1)
                            .addComponent(zobrazeniNeaktivnichSlovicekButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(spravaSlovicek1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        spravaSlovicek1Layout.setVerticalGroup(
            spravaSlovicek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spravaSlovicek1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel21)
                .addGap(36, 36, 36)
                .addGroup(spravaSlovicek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridaniSlovicekButton1)
                    .addComponent(smazaniSlovicekButton1))
                .addGap(18, 18, 18)
                .addGroup(spravaSlovicek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zobrazeniSlovicekButton1)
                    .addComponent(zpetSpravaSlovicek))
                .addGap(18, 18, 18)
                .addComponent(zobrazeniNeaktivnichSlovicekButton1)
                .addGap(18, 18, 18)
                .addComponent(aktivovaniNeaktivnichSlov1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel22.setText("Pridani Slovicek");

        jLabel23.setText("Zadejte cesky vyraz:");

        ceskyVyraz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceskyVyraz1ActionPerformed(evt);
            }
        });

        jLabel24.setText("Zadejte jeho anglicky preklad:");

        Uloz1.setText("Uloz");
        Uloz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uloz1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pridaniSlovicekPanel1Layout = new javax.swing.GroupLayout(pridaniSlovicekPanel1);
        pridaniSlovicekPanel1.setLayout(pridaniSlovicekPanel1Layout);
        pridaniSlovicekPanel1Layout.setHorizontalGroup(
            pridaniSlovicekPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pridaniSlovicekPanel1Layout.createSequentialGroup()
                .addGroup(pridaniSlovicekPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pridaniSlovicekPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ceskyVyraz1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pridaniSlovicekPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(anglickyVyraz1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pridaniSlovicekPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Uloz1))
                    .addGroup(pridaniSlovicekPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pridaniSlovicekPanel1Layout.setVerticalGroup(
            pridaniSlovicekPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pridaniSlovicekPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(pridaniSlovicekPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(ceskyVyraz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pridaniSlovicekPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(anglickyVyraz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Uloz1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel17.setText("Zobrazeni neaktivnich slovicek");

        zobrayVseNeaktivni.setText("Zobraz ");
        zobrayVseNeaktivni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrayVseNeaktivniActionPerformed(evt);
            }
        });

        zobrayeniNeaktivnichSlov.setEditable(false);
        zobrayeniNeaktivnichSlov.setColumns(20);
        zobrayeniNeaktivnichSlov.setRows(5);
        jScrollPane2.setViewportView(zobrayeniNeaktivnichSlov);

        zpetNeaktivni.setText("Zpet");
        zpetNeaktivni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetNeaktivniActionPerformed(evt);
            }
        });

        prejitDoMenuNeaktivni.setText("Prejit do Menu");
        prejitDoMenuNeaktivni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prejitDoMenuNeaktivniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout zobrazeniNeaktivnichSlovicekLayout = new javax.swing.GroupLayout(zobrazeniNeaktivnichSlovicek);
        zobrazeniNeaktivnichSlovicek.setLayout(zobrazeniNeaktivnichSlovicekLayout);
        zobrazeniNeaktivnichSlovicekLayout.setHorizontalGroup(
            zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                .addGroup(zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel17)
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(zpetNeaktivni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prejitDoMenuNeaktivni))
                    .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(zobrayVseNeaktivni)))
                .addContainerGap())
        );
        zobrazeniNeaktivnichSlovicekLayout.setVerticalGroup(
            zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zobrazeniNeaktivnichSlovicekLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zobrayVseNeaktivni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zobrazeniNeaktivnichSlovicekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zpetNeaktivni)
                    .addComponent(prejitDoMenuNeaktivni))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel18.setText("Aktivace slovicek");

        zobrazeniAktivaceSlovicek.setEditable(false);
        zobrazeniAktivaceSlovicek.setColumns(20);
        zobrazeniAktivaceSlovicek.setRows(5);
        jScrollPane3.setViewportView(zobrazeniAktivaceSlovicek);

        jButton5.setText("Zpet");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Prejit do Menu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        aktivovatVse.setText("Aktivovat vse");
        aktivovatVse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktivovatVseActionPerformed(evt);
            }
        });

        aktivovatVybrane.setText("Aktivovat vybrane");
        aktivovatVybrane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktivovatVybraneActionPerformed(evt);
            }
        });

        coAktivovat.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jButton4.setText("Zobraz");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cleanAktivaceSlovicek.setText("Vycisti");
        cleanAktivaceSlovicek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanAktivaceSlovicekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aktivaceSlovicek12Layout = new javax.swing.GroupLayout(aktivaceSlovicek12);
        aktivaceSlovicek12.setLayout(aktivaceSlovicek12Layout);
        aktivaceSlovicek12Layout.setHorizontalGroup(
            aktivaceSlovicek12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aktivaceSlovicek12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(aktivaceSlovicek12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aktivaceSlovicek12Layout.createSequentialGroup()
                        .addComponent(cleanAktivaceSlovicek)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(37, 37, 37)
                        .addComponent(jButton4))
                    .addGroup(aktivaceSlovicek12Layout.createSequentialGroup()
                        .addComponent(aktivovatVse)
                        .addGap(18, 18, 18)
                        .addComponent(coAktivovat)
                        .addGap(18, 18, 18)
                        .addComponent(aktivovatVybrane))
                    .addGroup(aktivaceSlovicek12Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(aktivaceSlovicek12Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        aktivaceSlovicek12Layout.setVerticalGroup(
            aktivaceSlovicek12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aktivaceSlovicek12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(aktivaceSlovicek12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aktivaceSlovicek12Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aktivaceSlovicek12Layout.createSequentialGroup()
                        .addGroup(aktivaceSlovicek12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(cleanAktivaceSlovicek))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(aktivaceSlovicek12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aktivaceSlovicek12Layout.createSequentialGroup()
                        .addGroup(aktivaceSlovicek12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aktivovatVse)
                            .addComponent(aktivovatVybrane))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(aktivaceSlovicek12Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(coAktivovat)))
                .addGap(18, 18, 18)
                .addGroup(aktivaceSlovicek12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(20, 20, 20))
        );

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
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                        .addContainerGap())
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

        jLabel25.setText("Nastaveni testu");

        jLabel26.setText("Chci prekladat do");

        kamPrekladat.setText("Cestiny");
        kamPrekladat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kamPrekladatActionPerformed(evt);
            }
        });

        pocetOtazek.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel27.setText("Zadejte pocet otazek testu");

        jButton11.setText("Zpet");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Spustit test");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nastaveniTestuLayout = new javax.swing.GroupLayout(nastaveniTestu);
        nastaveniTestu.setLayout(nastaveniTestuLayout);
        nastaveniTestuLayout.setHorizontalGroup(
            nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nastaveniTestuLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pocetOtazek, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kamPrekladat)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(nastaveniTestuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nastaveniTestuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(68, 68, 68))
        );
        nastaveniTestuLayout.setVerticalGroup(
            nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nastaveniTestuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nastaveniTestuLayout.createSequentialGroup()
                        .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(kamPrekladat))
                        .addGap(18, 18, 18)
                        .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pocetOtazek, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nastaveniTestuLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(nastaveniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(jButton11))
                        .addContainerGap())))
        );

        jLabel28.setText("Test");

        okTest.setText("OK");
        okTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okTestActionPerformed(evt);
            }
        });

        kPrekladu1.setEditable(false);

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
                                .addComponent(kPrekladu1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(okTest)
                                    .addGroup(testLayout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(38, 38, 38)
                                        .addComponent(kPrekladu2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(kPrekladu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(kPrekladu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(okTest)
                .addContainerGap(25, Short.MAX_VALUE))
        );

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
            .addGroup(vyhodnoceniTestuLayout.createSequentialGroup()
                .addGroup(vyhodnoceniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vyhodnoceniTestuLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel30))
                    .addGroup(vyhodnoceniTestuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vyhodnoceniTestuLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(doMenuZVyhodnoceniTestu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vyhodnoceniTestuLayout.setVerticalGroup(
            vyhodnoceniTestuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vyhodnoceniTestuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(doMenuZVyhodnoceniTestu))
        );

        jLabel31.setText("Sprava slovniku");

        jButton10.setText("Zobrazit Slovniky");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton13.setText("Vytvorit Slovnik");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Smazat Slovnik");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        zpetDoMenuZSpravaSlovicek.setText("Zpet");
        zpetDoMenuZSpravaSlovicek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetDoMenuZSpravaSlovicekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout spravaSlovnikuLayout = new javax.swing.GroupLayout(spravaSlovniku);
        spravaSlovniku.setLayout(spravaSlovnikuLayout);
        spravaSlovnikuLayout.setHorizontalGroup(
            spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spravaSlovnikuLayout.createSequentialGroup()
                .addGroup(spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spravaSlovnikuLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel31))
                    .addGroup(spravaSlovnikuLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zpetDoMenuZSpravaSlovicek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        spravaSlovnikuLayout.setVerticalGroup(
            spravaSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spravaSlovnikuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zpetDoMenuZSpravaSlovicek)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel32.setText("Zobrazeni Slovniku");

        textAreaZobrazeniSlovniku.setEditable(false);
        textAreaZobrazeniSlovniku.setColumns(20);
        textAreaZobrazeniSlovniku.setRows(5);
        jScrollPane6.setViewportView(textAreaZobrazeniSlovniku);

        zpetZezobrazeniSlovnku.setText("Zpet");
        zpetZezobrazeniSlovnku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zpetZezobrazeniSlovnkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout zobrazeniSlovnikuLayout = new javax.swing.GroupLayout(zobrazeniSlovniku);
        zobrazeniSlovniku.setLayout(zobrazeniSlovnikuLayout);
        zobrazeniSlovnikuLayout.setHorizontalGroup(
            zobrazeniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zobrazeniSlovnikuLayout.createSequentialGroup()
                .addGroup(zobrazeniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zobrazeniSlovnikuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6))
                    .addGroup(zobrazeniSlovnikuLayout.createSequentialGroup()
                        .addGroup(zobrazeniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(zobrazeniSlovnikuLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel32))
                            .addGroup(zobrazeniSlovnikuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(zpetZezobrazeniSlovnku)))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );
        zobrazeniSlovnikuLayout.setVerticalGroup(
            zobrazeniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zobrazeniSlovnikuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zpetZezobrazeniSlovnku)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel33.setText("Vytvoreni Slovniku");

        jLabel34.setText("Zadejte jmeno slovniku");

        jButton15.setText("Zpet");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        vytvorNovySlovnik.setText("Vytvorit");
        vytvorNovySlovnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vytvorNovySlovnikActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vytvoreniSlovnikuLayout = new javax.swing.GroupLayout(vytvoreniSlovniku);
        vytvoreniSlovniku.setLayout(vytvoreniSlovnikuLayout);
        vytvoreniSlovnikuLayout.setHorizontalGroup(
            vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                .addGroup(vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(vytvorNovySlovnik))
                    .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                        .addGroup(vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nazevNovehoSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel34))
                            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel33)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        vytvoreniSlovnikuLayout.setVerticalGroup(
            vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vytvoreniSlovnikuLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nazevNovehoSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(vytvoreniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(vytvorNovySlovnik))
                .addGap(20, 20, 20))
        );

        jLabel35.setText("Smazani Slovniku");

        textAreaSmazaniSlovniku.setEditable(false);
        textAreaSmazaniSlovniku.setColumns(20);
        textAreaSmazaniSlovniku.setRows(5);
        jScrollPane7.setViewportView(textAreaSmazaniSlovniku);

        jButton16.setText("Zpet");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel36.setText("Vybetre slovnik ke smazani:");

        spinnerSmazaniSlovniku.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        vymazatSlovnik.setText("Vymazat");
        vymazatSlovnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazatSlovnikActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout smazaniSlovnikuLayout = new javax.swing.GroupLayout(smazaniSlovniku);
        smazaniSlovniku.setLayout(smazaniSlovnikuLayout);
        smazaniSlovnikuLayout.setHorizontalGroup(
            smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                .addGroup(smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton16)
                        .addGap(26, 26, 26)
                        .addComponent(spinnerSmazaniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vymazatSlovnik))
                    .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel35))
                    .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smazaniSlovnikuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addGap(57, 57, 57))
        );
        smazaniSlovnikuLayout.setVerticalGroup(
            smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smazaniSlovnikuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(smazaniSlovnikuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerSmazaniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16)
                    .addComponent(vymazatSlovnik))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(aktivaceSlovicek12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statistiky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nastaveniTestu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vyhodnoceniTestu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Prihlaseni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(novyUcet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vyberSlovnikPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mazaniSlovicekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pridaniSlovicekPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spravaSlovicek1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(zobrazeniSlovicekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(zobrazeniNeaktivnichSlovicek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spravaSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zobrazeniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vytvoreniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(smazaniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1548, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(novyUcet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Prihlaseni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vyberSlovnikPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mazaniSlovicekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pridaniSlovicekPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(aktivaceSlovicek12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(zobrazeniSlovicekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(zobrazeniNeaktivnichSlovicek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(spravaSlovicek1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(zobrazeniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spravaSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vytvoreniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(smazaniSlovniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(statistiky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nastaveniTestu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vyhodnoceniTestu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vytvorNovyUcetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vytvorNovyUcetActionPerformed
        this.Prihlaseni.setVisible(false);
        this.novyUcet.setVisible(true);
        this.setSize(350, 300);

    }//GEN-LAST:event_vytvorNovyUcetActionPerformed

    private void vyberUcetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vyberUcetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vyberUcetActionPerformed

    private void prihlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prihlasActionPerformed
        boolean spravne = uzivatel.prihlaseni(this.vyberUcet.getSelectedItem().toString(), String.valueOf(this.vstupHesla.getPassword()), this.vyberUcet.getSelectedIndex());
        if (spravne) {
            this.vstupHesla.setText("");
            this.Prihlaseni.setVisible(false);
            this.vyberSlovnikPanel.setVisible(true);
            this.setSize(250, 150);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Bylo zadano spatne heslo, zbavaji vam " + (3 - this.uzivatel.getPokusy()) + " pokusy", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_prihlasActionPerformed

    private void zpetDoPrihlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetDoPrihlasActionPerformed
        this.Prihlaseni.setVisible(true);
        this.novyUcet.setVisible(false);
        this.setSize(250, 200);
    }//GEN-LAST:event_zpetDoPrihlasActionPerformed

    private void vytvorUcetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vytvorUcetButtonActionPerformed
        /*        int uspesnost = uzivatel.vytvorUzivatele(this.jmenoUctu.getText(),
         String.valueOf(this.hesloNovehoUctu.getPassword()),
         String.valueOf(this.opakovaneHesloNovehoUctu.getPassword()));
         switch (uspesnost) {
         case 0:
         JOptionPane.showMessageDialog(rootPane, "Ucet byl uspesne zalozen");
         this.novyUcet.setVisible(false);
         this.Prihlaseni.setVisible(true);
         this.setSize(250, 200);
         break;
         case 1:
         JOptionPane.showMessageDialog(rootPane, "Jmeno je jiz obsazene prosim vyberte si jine", "Chyba!", JOptionPane.WARNING_MESSAGE);
         break;
         case 2:
         JOptionPane.showMessageDialog(rootPane, "Hesla se neshoduji", "Chyba!", JOptionPane.WARNING_MESSAGE);
         break;
         case 3:
         JOptionPane.showMessageDialog(rootPane, "Heslo nema predepsanou delku", "Chyba!", JOptionPane.WARNING_MESSAGE);
         break;
         case 4:
         JOptionPane.showMessageDialog(rootPane, "Některý z údajů nebyl zadán", "Chyba!", JOptionPane.WARNING_MESSAGE);
         }*/
    }//GEN-LAST:event_vytvorUcetButtonActionPerformed

    private void jmenoUctuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenoUctuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmenoUctuActionPerformed

    private void aktivovatVybraneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktivovatVybraneActionPerformed
        if ((Integer) this.coAktivovat.getValue() > this.slovnik.neaktivni.size()) {
            JOptionPane.showMessageDialog(rootPane, "Zadana dvojce slovicek neexistuje", "Chyba!", JOptionPane.WARNING_MESSAGE);
        } else {
            this.slovnik.aktivaceDeaktivaceSlova((Integer) this.coAktivovat.getValue(), 1);
            JOptionPane.showMessageDialog(rootPane, "Aktivovano");
        }
    }//GEN-LAST:event_aktivovatVybraneActionPerformed

    private void aktivovatVseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktivovatVseActionPerformed
        this.slovnik.aktivaceDeaktivaceSlova(0, 1);
        JOptionPane.showMessageDialog(rootPane, "Vsechna slova byla aktivovana");
    }//GEN-LAST:event_aktivovatVseActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.Menu.setVisible(true);
        this.aktivaceSlovicek12.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.spravaSlovicek1.setVisible(true);
        this.aktivaceSlovicek12.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void prejitDoMenuNeaktivniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prejitDoMenuNeaktivniActionPerformed
        this.Menu.setVisible(true);
        this.zobrazeniNeaktivnichSlovicek.setVisible(false);
    }//GEN-LAST:event_prejitDoMenuNeaktivniActionPerformed

    private void zpetNeaktivniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetNeaktivniActionPerformed
        this.spravaSlovicek1.setVisible(true);
        this.zobrazeniNeaktivnichSlovicek.setVisible(false);
    }//GEN-LAST:event_zpetNeaktivniActionPerformed

    private void zobrayVseNeaktivniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrayVseNeaktivniActionPerformed
        String[] slova = this.slovnik.vypisNeaktivni();
        for (int i = 0; i < slova.length; i++) {
            this.zobrayeniNeaktivnichSlov.append(slova[i] + "\n");
        }


    }//GEN-LAST:event_zobrayVseNeaktivniActionPerformed

    private void zobrazVseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazVseActionPerformed
        String[] slova = slovnik.vypisSpojovySeznam();
        for (int i = 0; i < slova.length; i++) {
            this.zobrayeniSlovicekText.append(slova[i] + "\n");
        }
    }//GEN-LAST:event_zobrazVseActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.zobrazeniSlovicekPanel.setVisible(false);
        this.Menu.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.zobrazeniSlovicekPanel.setVisible(false);
        this.spravaSlovicek1.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void zpetMazaniSlovicekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetMazaniSlovicekActionPerformed
        this.spravaSlovicek1.setVisible(true);
        this.mazaniSlovicekPanel.setVisible(false);
    }//GEN-LAST:event_zpetMazaniSlovicekActionPerformed

    private void uplneVymazaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uplneVymazaniActionPerformed
        int volba;
        if (this.uzivatel.testPravomoc(this.slovnik.getTvurceSlovniku(), 3)) {
            if (((Integer) this.cisloKeSmazani.getValue()) > slovnik.getPocetBunek()) {
                JOptionPane.showMessageDialog(rootPane, "Zadana dvojce neexistuje", "Chyba", JOptionPane.WARNING_MESSAGE);
            } else {
                volba = JOptionPane.showConfirmDialog(rootPane, "Opravdu chcete smazat dvojci slovicek"
                        + this.slovnik.vypisXZeSpojovehoSeznamu((Integer) this.cisloKeSmazani.getValue()), "Chyba!", JOptionPane.YES_NO_OPTION);
                if (volba == 0) {
                    this.slovnik.smaz((Integer) this.cisloKeSmazani.getValue());
                    JOptionPane.showMessageDialog(rootPane, "Dvojce byla smazana");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dvojce nebyla smazana");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_uplneVymazaniActionPerformed

    private void deaktivujDvojciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deaktivujDvojciActionPerformed
        if (((Integer) this.cisloKeSmazani.getValue()) > slovnik.getPocetBunek()) {
            JOptionPane.showMessageDialog(rootPane, "Zadana dvojce neexistuje", "Chyba", JOptionPane.WARNING_MESSAGE);
        } else {
            int volba = JOptionPane.showConfirmDialog(rootPane, "Opravdu chcete deaktivovat dvojci slovicek "
                    + this.slovnik.vypisXZeSpojovehoSeznamu((Integer) this.cisloKeSmazani.getValue()), "Chyba!", JOptionPane.YES_NO_OPTION);

            if (volba == 0) {
                this.slovnik.aktivaceDeaktivaceSlova((Integer) this.cisloKeSmazani.getValue(), volba);
                this.slovnik.presunNeaktivni();
                JOptionPane.showMessageDialog(rootPane, "Dvojce slovicek byla deaktivovana");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dvojce slovicek nebyla deaktivovana");
            }
        }
    }//GEN-LAST:event_deaktivujDvojciActionPerformed

    private void aktivovaniNeaktivnichSlovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktivovaniNeaktivnichSlovActionPerformed
        if (this.uzivatel.testPravomoc(this.slovnik.getTvurceSlovniku(), 1)) {
            this.spravaSlovicek.setVisible(false);
            this.mazaniSlovicekPanel.setVisible(true);

        } else {
            JOptionPane.showConfirmDialog(rootPane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_aktivovaniNeaktivnichSlovActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.spravaSlovicek.setVisible(false);
        this.Menu.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void zobrazeniNeaktivnichSlovicekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazeniNeaktivnichSlovicekButtonActionPerformed
        this.spravaSlovicek.setVisible(false);
        this.zobrazeniNeaktivnichSlovicek.setVisible(true);
    }//GEN-LAST:event_zobrazeniNeaktivnichSlovicekButtonActionPerformed

    private void zobrazeniSlovicekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazeniSlovicekButtonActionPerformed
        this.spravaSlovicek.setVisible(false);
        this.zobrazeniSlovicekPanel.setVisible(true);
    }//GEN-LAST:event_zobrazeniSlovicekButtonActionPerformed

    private void smazaniSlovicekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smazaniSlovicekButtonActionPerformed
        if (this.uzivatel.testPravomoc(this.slovnik.getTvurceSlovniku(), 1)) {
            this.spravaSlovicek.setVisible(false);
            this.mazaniSlovicekPanel.setVisible(true);
        } else {
            JOptionPane.showConfirmDialog(rootPane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_smazaniSlovicekButtonActionPerformed

    private void pridaniSlovicekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridaniSlovicekButtonActionPerformed
        if (this.uzivatel.testPravomoc(this.slovnik.getTvurceSlovniku(), 2)) {
            this.spravaSlovicek.setVisible(false);
            this.pridaniSlovicekPanel.setVisible(true);
        } else {
            JOptionPane.showConfirmDialog(rootPane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pridaniSlovicekButtonActionPerformed

    private void UlozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UlozActionPerformed
        this.slovnik.vlozNaKonec(this.anglickyVyraz.getText(), this.ceskyVyraz.getText(), 0, 0, this.slovnik.vytvorNoveIdSlova(), 1);
        this.pridaniSlovicekPanel.setVisible(false);
        this.spravaSlovicek.setVisible(true);
    }//GEN-LAST:event_UlozActionPerformed

    private void ceskyVyrazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceskyVyrazActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ceskyVyrazActionPerformed

    private void potvrdSlovnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_potvrdSlovnikActionPerformed
        slovnik.nactiSlovnik(this.vyberSlovnik.getSelectedItem().toString(), uzivatel.getJmeno());
        this.slovnik.presunNeaktivni();
        this.setSize(330, 230);
        this.Menu.setVisible(true);
        this.vyberSlovnikPanel.setVisible(false);
    }//GEN-LAST:event_potvrdSlovnikActionPerformed

    private void vyberSlovnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vyberSlovnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vyberSlovnikActionPerformed

    private void pridaniSlovicekButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridaniSlovicekButton1ActionPerformed
        if (this.uzivatel.testPravomoc(this.slovnik.getTvurceSlovniku(), 2)) {
            this.pridaniSlovicekPanel1.setVisible(true);
            this.spravaSlovicek1.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pridaniSlovicekButton1ActionPerformed

    private void smazaniSlovicekButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smazaniSlovicekButton1ActionPerformed
        if (this.uzivatel.testPravomoc(this.slovnik.getTvurceSlovniku(), 1)) {
            this.mazaniSlovicekPanel.setVisible(true);
            this.spravaSlovicek1.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_smazaniSlovicekButton1ActionPerformed

    private void zobrazeniSlovicekButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazeniSlovicekButton1ActionPerformed
        this.spravaSlovicek1.setVisible(false);
        this.zobrazeniSlovicekPanel.setVisible(true);
    }//GEN-LAST:event_zobrazeniSlovicekButton1ActionPerformed

    private void zobrazeniNeaktivnichSlovicekButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazeniNeaktivnichSlovicekButton1ActionPerformed
        this.spravaSlovicek1.setVisible(false);
        this.zobrazeniNeaktivnichSlovicek.setVisible(true);
    }//GEN-LAST:event_zobrazeniNeaktivnichSlovicekButton1ActionPerformed

    private void zpetSpravaSlovicekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetSpravaSlovicekActionPerformed
        this.spravaSlovicek.setVisible(false);
        this.Menu.setVisible(true);
    }//GEN-LAST:event_zpetSpravaSlovicekActionPerformed

    private void aktivovaniNeaktivnichSlov1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktivovaniNeaktivnichSlov1ActionPerformed
        if (this.uzivatel.testPravomoc(this.slovnik.getTvurceSlovniku(), 1)) {
            this.spravaSlovicek1.setVisible(false);
            this.aktivaceSlovicek12.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_aktivovaniNeaktivnichSlov1ActionPerformed

    private void ceskyVyraz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceskyVyraz1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ceskyVyraz1ActionPerformed

    private void Uloz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uloz1ActionPerformed
        this.slovnik.vlozNaKonec(this.anglickyVyraz1.getText(), this.ceskyVyraz1.getText(), 0, 0, this.slovnik.vytvorNoveIdSlova(), 1);
        this.pridaniSlovicekPanel1.setVisible(false);
        this.spravaSlovicek1.setVisible(true);

    }//GEN-LAST:event_Uloz1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (this.slovnik.neaktivni.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nejsou zadna slova ktere by bylo mozne aktivovat");
        } else {
            String[] slova = this.slovnik.vypisNeaktivni();
            int citac = 1;
            for (int i = 0; i < slova.length; i++) {
                this.zobrazeniAktivaceSlovicek.append("(" + (citac) + ")" + slova[i] + "\n");
                citac++;
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cleanAktivaceSlovicekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanAktivaceSlovicekActionPerformed
        this.zobrazeniAktivaceSlovicek.setText("");
    }//GEN-LAST:event_cleanAktivaceSlovicekActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (this.jButton8.getText().equals("Zobrazit statistiku pro aktivni slova")) {
            if (this.slovnik.getPocetBunek() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Nejsou zadna slova k zobrazeni");
            } else {
                this.table.setModel(this.dataModelAktivni);
                this.jButton8.setText("Zobraz statistiku pro neaktivni slova");
            }
        } else {
            if (this.slovnik.neaktivni.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Nejsou zadna slova k zobrazeni");
            } else {
                this.table.setModel(this.dataModelNeaktivni);
                this.jButton8.setText("Zobrazit statistiku pro aktivni slova");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void statistikyZpetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistikyZpetActionPerformed
        this.statistiky.setVisible(false);
        this.Menu.setVisible(true);
    }//GEN-LAST:event_statistikyZpetActionPerformed

    private void kamPrekladatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kamPrekladatActionPerformed
        if (this.kamPrekladat.getText().equals("Cestiny")) {
            this.kamPrekladat.setText("Anglictiny");
        } else {
            this.kamPrekladat.setText("Cestiny");
        }
    }//GEN-LAST:event_kamPrekladatActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.nastaveniTestu.setVisible(false);
        this.Menu.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        this.nastaveniTestu.setVisible(false);
        this.test.setVisible(true);
        generovanaCisla = new Integer[(Integer) this.pocetOtazek.getValue()];
        generovanaCisla = generatorNahodnychCisel((Integer) this.pocetOtazek.getValue(),
                this.slovnik.getPocetBunek(),
                this.slovnik.sNejvissimPocetemSpatnychOdpovedi(((Integer) this.pocetOtazek.getValue()) / 2));
        this.spatneOdpovedi.clear();
        if (this.kamPrekladat.getText().equals("Cestiny")) {
            preklad = 1;
        } else {
            preklad = 2;
        }
        this.citac = 0;
        this.kPrekladu1.setText(this.slovnik.getObsahBunky(generovanaCisla[citac], preklad));
        this.progresTest.setMaximum((Integer) this.pocetOtazek.getValue());
        this.progresTest.setValue(citac + 1);


    }//GEN-LAST:event_jButton12ActionPerformed

    private void okTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okTestActionPerformed
        if (this.kPrekladu2.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Neviplnili jste policko", "Chyba!", JOptionPane.WARNING_MESSAGE);
        } else if (this.generovanaCisla.length == citac) {
            this.test.setVisible(false);
            this.vyhodnoceniTestu.setVisible(true);
            if (this.spatneOdpovedi.isEmpty()) {
                this.textAreaVyhodnoceniTestu.append("Byl/a jste vzykousen/a z " + this.generovanaCisla.length + " slovicek  \n z nichz jste na"
                        + "vsechny  odpovedel/a spravne. \n Gratuluji! - Congratulations!");
            } else {
                this.textAreaVyhodnoceniTestu.append("Byl/a jste vzykousen/a z " + this.generovanaCisla.length + " slovicek  \n z nichz jste na " + spatneOdpovedi.size() + ""
                        + " odpovedel/a spatne");
                int procenta = (100 * (this.generovanaCisla.length - spatneOdpovedi.size())) / this.generovanaCisla.length;
                this.textAreaVyhodnoceniTestu.append("Vase uspesnost je" + procenta + "% \n Slovicka ktera jste zodpovedel/a spatne ve spravnem prekladu");
            }
            for (int i = 0; i < this.spatneOdpovedi.size(); i++) {
                this.textAreaVyhodnoceniTestu.append("" + this.slovnik.vypisXZeSpojovehoSeznamu(Integer.valueOf((String) this.spatneOdpovedi.get(i))));
            }


        }
        citac = citac + 1;
        boolean testOdpovedi;
        String prelozeno;
        this.kPrekladu1.setText(this.slovnik.getObsahBunky(generovanaCisla[citac], preklad));
        this.progresTest.setValue(citac + 1);
        prelozeno = this.kPrekladu2.getText();
        prelozeno = prelozeno.toLowerCase();
        testOdpovedi = prelozeno.equals(this.slovnik.getObsahBunky(this.generovanaCisla[citac], preklad));
        if (testOdpovedi == true) {
            this.slovnik.upravStatistiku(this.generovanaCisla[citac], 0);
        } else {
            this.slovnik.upravStatistiku(this.generovanaCisla[citac], 1);
            this.spatneOdpovedi.add(this.generovanaCisla[citac]);
        }


    }//GEN-LAST:event_okTestActionPerformed

    private void doMenuZVyhodnoceniTestuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doMenuZVyhodnoceniTestuActionPerformed
        this.vyhodnoceniTestu.setVisible(false);
        this.Menu.setVisible(true);
    }//GEN-LAST:event_doMenuZVyhodnoceniTestuActionPerformed

    private void zpetDoMenuZSpravaSlovicekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetDoMenuZSpravaSlovicekActionPerformed
        this.spravaSlovniku.setVisible(false);
        this.Menu.setVisible(true);
    }//GEN-LAST:event_zpetDoMenuZSpravaSlovicekActionPerformed

    private void zpetZezobrazeniSlovnkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zpetZezobrazeniSlovnkuActionPerformed
        this.zobrazeniSlovniku.setVisible(false);
        this.spravaSlovniku.setVisible(true);
    }//GEN-LAST:event_zpetZezobrazeniSlovnkuActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.spravaSlovniku.setVisible(false);
        this.zobrazeniSlovniku.setVisible(true);
        String[] seznam = new String[this.slovnik.getPocetSlovniku()];
        seznam = this.slovnik.getSeznamSlovniku();
        for (int i = 0; i < seznam.length; i++) {
            this.textAreaZobrazeniSlovniku.append("" + seznam[i] + "\n");
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        this.vytvoreniSlovniku.setVisible(false);
        this.spravaSlovicek.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        this.spravaSlovicek.setVisible(false);
        this.vytvoreniSlovniku.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void vytvorNovySlovnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vytvorNovySlovnikActionPerformed
        this.slovnik.vytvorNovySlovnik(this.nazevNovehoSlovniku.getText());
    }//GEN-LAST:event_vytvorNovySlovnikActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (this.uzivatel.testPravomoc(this.slovnik.getTvurceSlovniku(), 3)) {
            this.spravaSlovniku.setVisible(false);
            this.smazaniSlovniku.setVisible(true);
            String[] seznam = new String[this.slovnik.getPocetSlovniku()];
            seznam = this.slovnik.getSeznamSlovniku();
            for (int i = 0; i < seznam.length; i++) {
                this.textAreaSmazaniSlovniku.append("" + seznam[i] + "\n");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        this.smazaniSlovniku.setVisible(false);
        this.spravaSlovniku.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void vymazatSlovnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazatSlovnikActionPerformed
        if (this.slovnik.getPocetSlovniku() <= Integer.valueOf((String) this.cisloKeSmazani.getValue())) {
        } else {
            JOptionPane.showMessageDialog(rootPane, "Slovnik s timto cislem neexistuje!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_vymazatSlovnikActionPerformed

    private void spravaSlovnikuButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spravaSlovnikuButonActionPerformed
        this.Menu.setVisible(false);
        this.spravaSlovniku.setVisible(true);
    }//GEN-LAST:event_spravaSlovnikuButonActionPerformed

    private void ukoncitProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukoncitProgramActionPerformed
        this.slovnik.ulozSlovnik(this.uzivatel.getJmeno());
        this.slovnik.vycistiSpojovySeznam();
        System.exit(0);
    }//GEN-LAST:event_ukoncitProgramActionPerformed

    private void odhlasitSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odhlasitSeActionPerformed
        this.slovnik.ulozSlovnik(this.uzivatel.getJmeno());
        this.slovnik.vycistiSpojovySeznam();
        this.Menu.setVisible(false);
        this.Prihlaseni.setVisible(true);
    }//GEN-LAST:event_odhlasitSeActionPerformed

    private void zmenaSlovnikuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zmenaSlovnikuActionPerformed
        this.slovnik.vycistiSpojovySeznam();
        this.Menu.setVisible(false);
        this.vyberSlovnikPanel.setVisible(true);
    }//GEN-LAST:event_zmenaSlovnikuActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (this.slovnik.getPocetBunek() == 0 && this.slovnik.neaktivni.isEmpty() == true) {
            JOptionPane.showMessageDialog(rootPane, "Nejsou zadna slova k zobrazeni");
        } else if (this.slovnik.getPocetBunek() == 0 && this.slovnik.neaktivni.isEmpty() == false) {
            this.table.setModel(this.dataModelNeaktivni);
            this.jButton8.setText("Zobrazit statistiku pro aktivni slova");
            this.Menu.setVisible(false);
            this.statistiky.setVisible(true);
        } else {
            this.Menu.setVisible(false);
            this.statistiky.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void spravaSlovicekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spravaSlovicekButtonActionPerformed
        this.Menu.setVisible(false);
        this.spravaSlovicek.setBounds(0, 0, 330, 250);
        this.spravaSlovicek1.setVisible(true);
    }//GEN-LAST:event_spravaSlovicekButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.Menu.setVisible(false);
        this.nastaveniTestu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StareGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StareGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StareGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StareGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StareGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Prihlaseni;
    private javax.swing.JButton Uloz;
    private javax.swing.JButton Uloz1;
    private javax.swing.JPanel aktivaceSlovicek12;
    private javax.swing.JToggleButton aktivovaniNeaktivnichSlov;
    private javax.swing.JToggleButton aktivovaniNeaktivnichSlov1;
    private javax.swing.JButton aktivovatVse;
    private javax.swing.JButton aktivovatVybrane;
    private javax.swing.JTextField anglickyVyraz;
    private javax.swing.JTextField anglickyVyraz1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTextField ceskyVyraz;
    private javax.swing.JTextField ceskyVyraz1;
    private javax.swing.JSpinner cisloKeSmazani;
    private javax.swing.JButton cleanAktivaceSlovicek;
    private javax.swing.JSpinner coAktivovat;
    private javax.swing.JButton deaktivujDvojci;
    private javax.swing.JButton doMenuZVyhodnoceniTestu;
    private javax.swing.JPasswordField hesloNovehoUctu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jmenoUctu;
    private javax.swing.JTextField kPrekladu1;
    private javax.swing.JTextField kPrekladu2;
    private javax.swing.JButton kamPrekladat;
    private javax.swing.JPanel mazaniSlovicekPanel;
    private javax.swing.JPanel nastaveniTestu;
    private javax.swing.JTextField nazevNovehoSlovniku;
    private javax.swing.JPanel novyUcet;
    private javax.swing.JButton odhlasitSe;
    private javax.swing.JButton okTest;
    private javax.swing.JPasswordField opakovaneHesloNovehoUctu;
    private javax.swing.JSpinner pocetOtazek;
    private javax.swing.JButton potvrdSlovnik;
    private javax.swing.JButton prejitDoMenuNeaktivni;
    private javax.swing.JButton pridaniSlovicekButton;
    private javax.swing.JButton pridaniSlovicekButton1;
    private javax.swing.JPanel pridaniSlovicekPanel;
    private javax.swing.JPanel pridaniSlovicekPanel1;
    private javax.swing.JButton prihlas;
    private javax.swing.JProgressBar progresTest;
    private javax.swing.JButton smazaniSlovicekButton;
    private javax.swing.JButton smazaniSlovicekButton1;
    private javax.swing.JPanel smazaniSlovniku;
    private javax.swing.JSpinner spinnerSmazaniSlovniku;
    private javax.swing.JButton spravaHracuButton;
    private javax.swing.JPanel spravaSlovicek;
    private javax.swing.JPanel spravaSlovicek1;
    private javax.swing.JButton spravaSlovicekButton;
    private javax.swing.JPanel spravaSlovniku;
    private javax.swing.JButton spravaSlovnikuButon;
    private javax.swing.JPanel statistiky;
    private javax.swing.JButton statistikyZpet;
    private javax.swing.JTable table;
    private javax.swing.JPanel test;
    private javax.swing.JTextArea textAreaSmazaniSlovniku;
    private javax.swing.JTextArea textAreaVyhodnoceniTestu;
    private javax.swing.JTextArea textAreaZobrazeniSlovniku;
    private javax.swing.JButton ukoncitProgram;
    private javax.swing.JButton uplneVymazani;
    private javax.swing.JPasswordField vstupHesla;
    private javax.swing.JComboBox vyberSlovnik;
    private javax.swing.JPanel vyberSlovnikPanel;
    private javax.swing.JComboBox vyberUcet;
    private javax.swing.JPanel vyhodnoceniTestu;
    private javax.swing.JButton vymazatSlovnik;
    private javax.swing.JButton vytvorNovySlovnik;
    private javax.swing.JButton vytvorNovyUcet;
    private javax.swing.JButton vytvorUcetButton;
    private javax.swing.JPanel vytvoreniSlovniku;
    private javax.swing.JButton zmenaSlovniku;
    private javax.swing.JButton zobrayVseNeaktivni;
    private javax.swing.JTextArea zobrayeniNeaktivnichSlov;
    private javax.swing.JTextArea zobrayeniSlovicekText;
    private javax.swing.JButton zobrazVse;
    private javax.swing.JTextArea zobrazeniAktivaceSlovicek;
    private javax.swing.JPanel zobrazeniNeaktivnichSlovicek;
    private javax.swing.JButton zobrazeniNeaktivnichSlovicekButton;
    private javax.swing.JButton zobrazeniNeaktivnichSlovicekButton1;
    private javax.swing.JButton zobrazeniSlovicekButton;
    private javax.swing.JButton zobrazeniSlovicekButton1;
    private javax.swing.JPanel zobrazeniSlovicekPanel;
    private javax.swing.JPanel zobrazeniSlovniku;
    private javax.swing.JButton zpetDoMenuZSpravaSlovicek;
    private javax.swing.JButton zpetDoPrihlas;
    private javax.swing.JButton zpetMazaniSlovicek;
    private javax.swing.JButton zpetNeaktivni;
    private javax.swing.JButton zpetSpravaSlovicek;
    private javax.swing.JButton zpetZezobrazeniSlovnku;
    // End of variables declaration//GEN-END:variables
}
