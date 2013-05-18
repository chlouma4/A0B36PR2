/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Marco
 */
public class Slovník {
    private int pocetSlovniku;
    private Bunka prvni;
    private Bunka volna;
    private static String typSlovniku;
    private String idPoslednihoSlova;
    private String tvurceSlovniku;
    public LinkedList neaktivni = new LinkedList();
    private JRootPane pane;

    public Slovník(JRootPane pane) {
        this.pane = pane;
    }

    /**Metoda vklada na konec spojoveho seznamu to co dostane v argumentu.
     * 
     * @param aj
     * @param cj
     * @param spravneOdpovedi
     * @param spatneOdpovedi
     * @param IDSlova
     * @param aktivita 
     */
    public void vlozNaKonec(String aj, String cj, int spravneOdpovedi, int spatneOdpovedi, String IDSlova, int aktivita) {  // metoda ktera vklada vstupni promene cj aj na konec spojoveho sezamu, pokud jsou promene praydne ulozeni se neprovede
        if (cj != null && aj != null) {
            Slovo slovo = new Slovo(aj, cj, spravneOdpovedi, spatneOdpovedi, IDSlova, aktivita);
            Bunka bunka = new Bunka(slovo, null);
            if (prvni == null) {
                prvni = bunka;
                volna = prvni;

            } else {
                volna.dalsi = bunka;
                volna = volna.dalsi;
            }
        } else {
            System.out.println("Chyba!: Jedno ze slovicek nebo obe nebyla zadana.");
        }
    }
/**Metoda vrati pocet bunek spojoveho seznamu.
 * 
 * @return 
 */
    public int getPocetBunek() { 
        int x = 0;
        Bunka pom = prvni;
        while (pom != null) {
            x = x + 1;
            pom = pom.dalsi;
        }
        return x;
    }
    
    /**Metoda vytvori nove ID slova a to navrati v typu String.
     * 
     * @return 
     */
    public String vytvorNoveIdSlova() {
        String cislo = "";
        int cislo1;
        String idSlova = this.getIdPoslednohoSlova();
        String slovnik = this.getTypSlovniku();
        if (idSlova == null) {
            return slovnik + "1";
        }
        int delkaSlovnik = slovnik.length();
        int delkaIdSlova = idSlova.length();
        char[] pole = idSlova.toCharArray();
        for (int i = delkaSlovnik--; i <= delkaIdSlova--; i++) {
            cislo = cislo + pole[i];
        }
        cislo1 = Integer.valueOf(cislo);
        cislo1++;

        return slovnik + cislo1;
    }
   
    /**Tato metoda vrati vypisSpojovySeznam vsech neaktivnich slov v poli typu String.
     * 
     * @return 
     */
public String[] vypisNeaktivni(){
    String[] slova = new String[this.neaktivni.size()];
    for (int i = 0; i < this.neaktivni.size(); i++) {
           Slovo slovo = (Slovo) this.neaktivni.get(i);
        slova[i]=slovo.toString();
    }
    return slova;
}
    
/**Metoda vrati v poli typu String vypisSpojovySeznam vsech slov ve spojovem seznamu.
 * Ukazka vypisu jedne bunky v poli :
 * Hello prelozeno do cestiny Ahoj
 * 
 * @return 
 */
    public String[] vypisSpojovySeznam() {   
        int g = 1;
        Bunka pom = prvni;
        String[] slova = new String[getPocetBunek()];
        while (pom != null) {
            slova[g - 1] = "(" + g + ") " + pom.slovicka.toString();
            pom.slovicka.toString();
            g++;
            pom = pom.dalsi;
        }
        return slova;
    }
/**Metoda navrati ve Stringu vypis jedne bunky Spojoveho seznamu.
 * To ktera bunka se vypise se nastavuje parametem  x.
 * DULEZITE: Pro vypis celeho spojoveho seznamu pouzite metodu vypisSpojovySeznam
 * Ukazka vypisu jedne bunky v poli :
 * Hello prelozeno do cestiny Ahoj
 * 
 * 
 * @param x
 * @return 
 */
    public String vypisXZeSpojovehoSeznamu(int x) { 
        int z = 0;
        String slovo = null;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == x) {
                slovo = "(" + x + ") " + pom.slovicka.toString();
            }
            pom = pom.dalsi;
        }
        return slovo;
    }

    /**Metoda vymaze bunku ze spojoveho seznamu.
     * To ktera bunka ma byt vymazana se nastavuje pomoci argumentu x.
     * 
     * @param x 
     */
    public void smaz(int x) { 
        int z = 0;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == x && x == 1) { // pro smazani prvniho
                prvni = prvni.dalsi;
                break;
            }
            if (z == x - 1 && x != getPocetBunek()) {
                pom.dalsi = pom.dalsi.dalsi;
                break;
            }
            if (z == x - 1 && x == getPocetBunek()) { // mazani posledniho 
                pom.dalsi = null;
                volna.dalsi = pom;
                volna = volna.dalsi;
                break;
            }
            pom = pom.dalsi;

        }
    }

    /**Metoda smaze vsechen obsach spojoveho seznamu.
     * 
     */
    public void vycistiSpojovySeznam() {
        this.prvni = null;
    }

  
/** POYOR !!!! metoda zatim nebyla predelana pro pouyiti s GUI
 * Metoda vymaze slovnik. Parametrem  x se urcuje ktery slovnik
 * ma byt vymazan.
 * 
 */
    public void smazSlovnik(int cisloSlovniku) {
        cisloSlovniku--;
       ArrayList  seznamSlovniku= this.getSeznamSlovniku();
       String Smazat=(String)seznamSlovniku.get(cisloSlovniku);
      seznamSlovniku.remove(cisloSlovniku);
        FileWriter outSeznam = null;
         File smazat= null;
        try {
            outSeznam = new FileWriter("Seznam.txt");
            smazat= new File(Smazat+".txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i = 0; i < seznamSlovniku.size(); i++) {
                outSeznam.write(seznamSlovniku.get(i) + "" + System.lineSeparator());
            }
            outSeznam.close();
            smazat.delete();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(pane, "Systemu se nepodarilo vztvorit novy slovnik",
                    "Error!",JOptionPane.ERROR_MESSAGE );
        }
       
     
       
    }

    /**
     * Metoda vrátí jednu polozku z bunky. Proměnnou cisloBunky zvolíme ze které
     * bunky spojevého seznamu chceme vytáhnout data. Proměnnou polozka volíme
     * kterou plozku chceme z bunky vytáhnouta to tak že 1-vrátí cj výraz
     * 2-vrátí anglický výraz 3- vrátí pocet spravnych odpovedi 4- vrátí pocet
     * spatnch dpovedi 5- vrati IdSlova 6- vrati aktivitu slova
     */
    public String getObsahBunky(int cisloBunky, int polozka) {
        int citac = 0;
        String slovo = null;
        Bunka pom = prvni;
        while (pom != null) {
            citac++;
            if (citac == cisloBunky) {
                switch (polozka) {
                    case 1:
                        slovo = pom.slovicka.getCj();
                        break;
                    case 2:
                        slovo = pom.slovicka.getAj();
                        break;
                    case 3:
                        slovo = String.valueOf(pom.slovicka.getPocetSpravnychOdpovedi());
                        break;
                    case 4:
                        slovo = String.valueOf(pom.slovicka.getPocetSpatnychOdpovedi());
                        break;
                    case 5:
                        slovo = pom.slovicka.getIDSlova();
                        break;
                    case 6:
                        slovo = String.valueOf(pom.slovicka.getAktivita());
                }
            }
            pom = pom.dalsi;
        }
        return slovo;

    }

    public String getTypSlovniku() {
        return typSlovniku;
    }

    public void setTypSlovniku(String typSlovniku) {
        this.typSlovniku = typSlovniku;
    }

    /**
     * Meotda vytvori novy slovnik a ulozi jej do seznamu Slovniku.
     * 
     * @param novySlovnik 
     */
    public void vytvorNovySlovnik(String novySlovnik, String tvurce) {
        ArrayList seznam =this.getSeznamSlovniku();
        boolean test=seznam.contains(novySlovnik);
        if(test==true){
            JOptionPane.showMessageDialog(pane, "Slovnik s timto nazvem je jiz vztvoren prosim zvolte jiny nazev",
                    "Chyba!",JOptionPane.WARNING_MESSAGE );
           
        }else{
            seznam.add(novySlovnik);
        FileWriter outSeznam = null;
        FileWriter outSlovnik=null;
        try {
            outSeznam = new FileWriter("Seznam.txt");
            outSlovnik= new FileWriter(novySlovnik+".txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i = 0; i < seznam.size(); i++) {
                outSeznam.write(seznam.get(i) + "" + System.lineSeparator());
            }
            outSlovnik.write(tvurce);
            outSlovnik.close();
            outSeznam.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(pane, "Systemu se nepodarilo vztvorit novy slovnik",
                    "Error!",JOptionPane.ERROR_MESSAGE );
        }
        JOptionPane.showMessageDialog(pane, "Slovnik byl uspesne vytvoren" );
        }
    }
/**
 * Meotda vrati seznam vsech slovniku.
 * 
 * @return 
 */
    public ArrayList getSeznamSlovniku() {
        ArrayList seznam = new ArrayList();
        Scanner scan = null;
        String nazev;
        boolean test;
        try {
            scan = new Scanner(new FileReader("Seznam.txt"));
        } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(pane, "Systemu se nepodatilo najit soubor Seznam.txt",
                    "Error!",JOptionPane.ERROR_MESSAGE );
        }
        while (true) {
            test = scan.hasNext();
            if (test == true) {
                nazev = scan.next();
                seznam.add(nazev);
            } else {
                break;
            }
        }
        
        return seznam;

    }

    /**Metoda nacte slova ze slovniku do Spojoveho seznamu.
     * Parametrem slovnik se urci ktery slovnik ma nacist.
     * Parametrem jmenoUzivatele se urci ci statistiky se maji nacist.
     * 
     * @param slovnik
     * @param jmenoUzivatele 
     */
    public void nactiSlovnik(String slovnik, String jmenoUzivatele) {
        int spravneOdpovedi = 0, spatneOdpovedi = 0, hrac1, i = 0, aktivni;
        boolean test;
        this.setTypSlovniku(slovnik);
        String cj, aj, idSlova, test1;
        Scanner scanSlovnik = null;
        Scanner scanHrac = null;
        try {
            scanSlovnik = new Scanner(new FileReader(getTypSlovniku() + ".txt"));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this.pane, "System nemuze nalezt soubor " + this.getTypSlovniku() + ".txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try {
            scanHrac = new Scanner(new FileReader(jmenoUzivatele + ".txt"));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this.pane, "System nemuze nalezt soubor " + jmenoUzivatele + ".txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try {
            this.setTvurceSlovniku(scanSlovnik.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.pane, "System nemuze nacist data ze souboru" + this.getTypSlovniku() + ".txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        while (true) {
            test = scanSlovnik.hasNext();
            if (test == true) {
                try {
                    cj = scanSlovnik.next();
                    aj = scanSlovnik.next();
                    idSlova = scanSlovnik.next();
                    aktivni = scanSlovnik.nextInt();
                    while (true) {
                        try {
                            do {
                                test1 = scanHrac.next();
                                if(test1.equals(idSlova)){
                                     spravneOdpovedi = scanHrac.nextInt();   // pokud slovo najde 
                                         spatneOdpovedi = scanHrac.nextInt();
                                         break;
                                }
                            } while (true);    // tento cyklus pobezi dokud nenarazi na posledni slovo v souboru ktere je konec.
                        } catch (Exception e) {         // pokud cyklud slovo nenajde tak dojde na konec souboru kde se potom pokusi o scan prazdneho mista
                            spravneOdpovedi = 0;       // coz skonci chybou a to znamena ze statistiky pro toto slovo nejsou a jsou nastavenz tedz na nula
                            spatneOdpovedi = 0;
                        }
                        this.vlozNaKonec(aj, cj, spravneOdpovedi, spatneOdpovedi, idSlova, aktivni);
                        break;
                    }

                } catch (Exception e) {
                   JOptionPane.showMessageDialog(this.pane, "System nemuze nacist data ze souboru" + this.getTypSlovniku() + ".txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
                   System.exit(1);
                }
            } else {
                break;
            }
        }
        this.setIdPoslednihoSlova(this.getTypSlovniku() + this.getPocetBunek());

    }
/**Metoda ulozi Obsah spojoveho seznamu a obsah LinkedListu neaktivni do prislusneho souboru.
 * Parametrem jmenoUzivatele se urci kteremu hraci se maji zapsat nove statistiky.
 * 
 * @param jmenoUzivatele 
 */
    public void ulozSlovnik(String jmenoUzivatele) {  
        FileWriter outSlovnik = null;
        FileWriter outHrac = null;
        try {
            outSlovnik = new FileWriter(getTypSlovniku() + ".txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this.pane, "System nemuze ukladat data do souboru" + this.getTypSlovniku() + ".txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try {
            outHrac = new FileWriter(jmenoUzivatele + ".txt");
        } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this.pane, "System nemuze ukladat data do souboru" + jmenoUzivatele + ".txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try {
            outSlovnik.write(this.getTvurceSlovniku() + System.lineSeparator());
            if (!this.neaktivni.isEmpty()) {
                for (int i = 0; i < this.neaktivni.size(); i++) {
                    Slovo slovo = (Slovo) this.neaktivni.get(i);
                    this.vlozNaKonec(slovo.getAj(), slovo.getCj(), slovo.getPocetSpravnychOdpovedi(), slovo.getPocetSpatnychOdpovedi(), slovo.getIDSlova(), slovo.getAktivita());
                }
            }
            for (int i = 1; i <= this.getPocetBunek(); i++) {
                outSlovnik.write(getObsahBunky(i, 1) + " " + getObsahBunky(i, 2) + " " + getObsahBunky(i, 5) + " " + getObsahBunky(i, 6) + System.lineSeparator());
                outHrac.write(getObsahBunky(i, 5) + " " + getObsahBunky(i, 3) + " " + getObsahBunky(i, 4) + System.lineSeparator());
            }
        } catch (IOException ex) {
        JOptionPane.showMessageDialog(this.pane, "Pri ukladani dat do souboru doslo k chybe",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        try {
            outSlovnik.close();
            outHrac.close();
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**Tato metoda presune neaktivni slova do Linked listu tridy neaktivni.
     * 
     * 
     */

    public void presunNeaktivni() {
        String test;
        for (int i = 1; i <= this.getPocetBunek(); i++) {
            test = this.getObsahBunky(i, 6);
            if (test.equals("" + 0)) {
                this.neaktivni.add(new Slovo(this.getObsahBunky(i, 2),
                        this.getObsahBunky(i, 1),
                        Integer.valueOf(this.getObsahBunky(i, 3)),
                        Integer.valueOf(this.getObsahBunky(i, 4)),
                        this.getObsahBunky(i, 5),
                        Integer.valueOf(this.getObsahBunky(i, 6))));
                this.smaz(i);
                i--;
            }
        }
    }

    /**
     * Metoda ktera aktivuje nbeo deaktivuke slovo. Parametrem poradi se urcuje
     * poradi slova ve spojovem seznamu. Pokud bude porametr poradi 0 tak se
     * operace provede pro vsechna slova. Parametrem operace se voli aktivace nebo
     * deaktivace slov takto: 0 - nastav na neaktivni 1-nastav na aktivni
     *
     * @param poradi
     * @param operace
     */
    public void aktivaceDeaktivaceSlova(int poradi, int operace) {
        int z = 0;
        Bunka pom = prvni;
  
         if( operace==1){
             if(poradi==0){
            for (int i = 0; i < this.neaktivni.size(); i++) {
                Slovo slovo = (Slovo) this.neaktivni.get(i);
                slovo.setAktivita(operace);
                   this.vlozNaKonec(slovo.getAj(), slovo.getCj(), slovo.getPocetSpravnychOdpovedi(), slovo.getPocetSpatnychOdpovedi(), slovo.getIDSlova(), slovo.getAktivita());
                   this.neaktivni.remove(i);
                   i--;
            }
             }else{
                 poradi--;
                  Slovo slovo = (Slovo) this.neaktivni.get(poradi);
                slovo.setAktivita(operace);
                   this.vlozNaKonec(slovo.getAj(), slovo.getCj(), slovo.getPocetSpravnychOdpovedi(), slovo.getPocetSpatnychOdpovedi(), slovo.getIDSlova(), slovo.getAktivita());
                       this.neaktivni.remove(poradi);
             }
        }else{
        while (pom != null) {
            z = z + 1;
            if ((z == poradi && poradi == 1) | poradi == 0) {
                pom.slovicka.setAktivita(operace);
                break;
            }
            if ((z == poradi - 1 && poradi != getPocetBunek()) | poradi == 0) {
                pom.slovicka.setAktivita(operace);
                break;
            }
            if ((z == poradi - 1 && poradi == getPocetBunek() )| poradi == 0) {
                pom.slovicka.setAktivita(operace);
                break;
            }
            pom = pom.dalsi;
        }
        this.presunNeaktivni();
        }
    }
    
    /**Metoda vypocet uspesnost v procentech ze vstupnich parametru.
     * Pokud nelze uspesnost vypocitat metoda vrati "---".
     * @param spravneOdpovedi
     * @param spatneOdpovedi
     * @return 
     */
    public String vypoctiUspesnost(int spravneOdpovedi, int spatneOdpovedi){
        if(spravneOdpovedi==0 && spatneOdpovedi==0){
         return "---";   
        }else{
        int uspesnost=(100*spravneOdpovedi)/(spravneOdpovedi+spatneOdpovedi);
        
        return ""+uspesnost+"%";
        }
    }
    /**Tato metoda zvysi pocetSpravnyhOdpovedi nebo pocetSpatnychOdpovedi u slova.
     * Parametrem poradi se urcuje , kteremu slovu ma byt zmenena statistika.
     * Parametrem statistika se urcuje jestly ma byt zvysen pocetSpravnyhOdpovedi 
     * nebo pocetSpatnychOdpovediu slova.Takto :
     * 0- zvysi pocetSpravnyhOdpovedi
     * 1- zvysi pocetSpatnychOdpovedi
     * 
     * @param poradi
     * @param statistika 
     */
    public void upravStatistiku(int poradi,int statistika){
        int z = 0;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == poradi) {
               if(statistika==0){
                   pom.slovicka.setPocetSpravnychOdpovedi(pom.slovicka.getPocetSpravnychOdpovedi()+1);
               }else{
                   pom.slovicka.setPocetSpatnychOdpovedi(pom.slovicka.getPocetSpatnychOdpovedi()+1);
               }
            }
            pom = pom.dalsi;
        }
        
    }
    /**Metoda vrati v poli cisla slov (jejich poradi ve spojovem seznamu) 
     * s nejvyssim poctem spatnych odpovedi. Parametrem pocet se nastavuje kolik 
     * slov  s nejvyssim poctem spatnych odpovedi chceme vratit chceme vratit.
     * 
     * @param pocet
     * @return 
     */
    public ArrayList sNejvissimPocetemSpatnychOdpovedi(int pocet){
        ArrayList odpoved= new  ArrayList();
        ArrayList<Integer> spatneOdpovedi= new ArrayList<>();
        for (int i = 1; i <= this.getPocetBunek(); i++) {
            spatneOdpovedi.add((Integer.valueOf(this.getObsahBunky(i, 4))));
        }
        for (int j = 0; j < pocet; j++) {
        int max=0;
        int pozice=0;
        for (int i = 0; i < spatneOdpovedi.size(); i++) {
            int pom=(Integer.valueOf(spatneOdpovedi.get(i)));
            if(pom > max){
                max=pom;
                pozice=i;
            }
        }
        odpoved.add(max);
        spatneOdpovedi.remove(pozice);
        }
        return odpoved;
    }

    public String getIdPoslednohoSlova() {
        return idPoslednihoSlova;
    }

    public int getPocetSlovniku() {
        return pocetSlovniku;
    }

    public void setPocetSlovniku(int pocetSlovniku) {
        this.pocetSlovniku = pocetSlovniku;
    }

    public String getTvurceSlovniku() {
        return tvurceSlovniku;
    }

    public void setTvurceSlovniku(String tvurceSlovniku) {
        this.tvurceSlovniku = tvurceSlovniku;
    }

    public String getIdPoslednihoSlova() {
        return idPoslednihoSlova;
    }

    public void setIdPoslednihoSlova(String idPoslednihoSlova) {
        this.idPoslednihoSlova = idPoslednihoSlova;
    }
}
