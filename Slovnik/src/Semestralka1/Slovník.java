/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Slovník {

    private Bunka prvni;
    private Bunka volna;
   private  static String typSlovniku;

    public Slovník() {
    }

    public void vlozNaKonec(String aj, String cj, int spravneOdpovedi, int spatneOdpovedi) {  // metoda ktera vklada vstupni promene cj aj na konec spojoveho sezamu, pokud jsou promene praydne ulozeni se neprovede
        if (cj != null && aj != null) {
            Slovo slovo = new Slovo(aj, cj, spravneOdpovedi, spatneOdpovedi);
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

    public int pocetDvojic() {  // metoda ktera pocita kolik bunek( dvojic slov) je uloyeno ve spojovem seznamu
        int x = 0;
        Bunka pom = prvni;
        while (pom != null) {
            x = x + 1;
            pom = pom.dalsi;
        }
        return x;
    }

    public void vypis() {   // tato metoda vypise vsechny dvojce slov  serazene tak jak jsou razeny ve spojovem seznamu od prvni bunky do x-te bunky. 
        int g = 1;
        Bunka pom = prvni;
        while (pom != null) {
            System.out.println("(" + g + ") " + pom.slovicka.toString());
            pom.slovicka.toString();
            g++;
            pom = pom.dalsi;
        }
    }

    public void vypisX(int x) {  // tato metoda vypise  dvojci slov v bunce  x. Ochrana na spatne vstupni metodz je v main
        int z = 0;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == x) {
                System.out.println("(" + x + ") " + pom.slovicka.toString());
            }
            pom = pom.dalsi;
        }
    }

    public void smaz(int x) { // tato metoda maze jednotlive bunky na pozici x.Ochrana na spatne vstupni metodz je v main
        int z = 0;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == x && x == 1) { // pro smazani prvniho
                prvni = prvni.dalsi;
                break;
            }
            if (z == x - 1 && x != pocetDvojic()) {
                pom.dalsi = pom.dalsi.dalsi;
                break;
            }
            if (z == x - 1 && x == pocetDvojic()) { // mazani posledniho 
                pom.dalsi = null;
                break;
            }
            pom = pom.dalsi;

        }
        System.out.println("Dana dvojce byla smazana");
    }

    public void vyberSlovnik() {
        int volba;
        ArrayList seznam = new ArrayList();
        Scanner scan = new Scanner(System.in);
        seznam = nactiSeznam();
        while (true) {
            System.out.println("Prosim vzberte slovnik s kterym chcete pracovat");
            for (int i = 0; i < seznam.size(); i++) {
                System.out.println((i + 1) + ". " + seznam.get(i));
            }
            System.out.println("Nebo zadejte 0. Pokud chcete vztvo5it nový slovník");
            try {
                volba = scan.nextInt();
                if (volba >= 0 && volba < seznam.size() + 1) {
                    break;
                } else {
                    System.out.println("Chyba! Zadano spatne cislo. Opakujte prosim zadani.");
                }
            } catch (Exception f) {
                System.out.println("Chyba! Zadan spatny znak. Opakujte prosim zadani.");
                scan.next();
            }
        }
        if (volba == 0) {
            String nazev;
            boolean test;
            while (true) {
                try {
                    System.out.println("Prosim zadejte jmeno slovniku.");
                    nazev = scan.next();
                    test = seznam.contains(nazev);
                    if (test == false) {
                        break;
                    } else {
                        System.out.println("Slovnik s timto nayvem jiy existuje. Prosim yvolte jiny nazev.");
                    }
                } catch (Exception e) {
                    System.out.println("Byl yadan nepovoleny znak. Prosim opakujte yadani.");
                    scan.next();
                }
            }
            vytvorSlovnik(nazev);
        } else {
            volba--;
             setTypSlovniku((String) seznam.get(volba));
        }
    }

    public void vytvorSlovnik(String nazev) {
        FileWriter out = null;
        try {
            out = new FileWriter(nazev + ".txt");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTypSlovniku(nazev);
        ulozSeznam(nazev);
    }
    
    public void smazSlovnik(){
         int volba;
        ArrayList seznam = new ArrayList();
        Scanner scan = new Scanner(System.in);
        seznam = nactiSeznam();
        while (true) {
            System.out.println("Prosim vzberte slovnik s kterym chcete pracovat");
            for (int i = 0; i < seznam.size(); i++) {
                System.out.println((i + 1) + ". " + seznam.get(i));
            }
            System.out.println("Nebo zadejte 0. Pokud chcete vztvo5it nový slovník");
            try {
                volba = scan.nextInt();
                if (volba > 0 && volba < seznam.size() + 1) {
                    break;
                } else {
                    System.out.println("Chyba! Zadano spatne cislo. Opakujte prosim zadani.");
                }
            } catch (Exception f) {
                System.out.println("Chyba! Zadan spatny znak. Opakujte prosim zadani.");
                scan.next();
            }
        }
        seznam.remove(volba);
        // musi se zacit predelavat menu
    }

    /**
     * Metoda vrátí jednu polozku z bunky. Proměnnou cisloBunky zvolíme ze které
     * bunky spojevého seznamu chceme vytáhnout data. Proměnnou polozka volíme
     * kterou plozku chceme z bunky vytáhnouta to tak že 1-vrátí cj výraz
     * 2-vrátí anglický výraz 3- vrátí pocet spatnych odpovedi 4- vrátí pocet
     * spravnych odpovedi.
     */
    public String getObsahBunky(int cisloBunky, int polozka) {
        int citac = 0;
        String slovo = null;
        Bunka pom = prvni;
        while (pom != null) {
            citac++;
            if (citac == cisloBunky) {
                if (polozka == 1) {
                    slovo = pom.slovicka.getCj();
                    break;
                } else if (polozka == 2) {
                    slovo = pom.slovicka.getAj();
                    break;
                } else if (polozka == 3) {
                    slovo = String.valueOf(pom.slovicka.getPocetSpatnychOdpovedi());
                } else {
                    slovo = String.valueOf(pom.slovicka.getPocetSpravnychOdpovedi());
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

    public void  ulozSeznam( String novySlovnik){
        ArrayList seznam = new ArrayList();
        seznam=nactiSeznam();
        seznam.add(novySlovnik);
        FileWriter out = null;
        try {
            out = new FileWriter("Seznam.txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
        for (int i = 0; i < seznam.size(); i++) {
            out.write(seznam.get(i) +""+System.lineSeparator());
        }
        out.close();
        }catch(Exception e){
            System.out.println("Chyba: Nebylo mozne provest yapis do souboru Seznam.txt");
        }
        
    }
    public ArrayList nactiSeznam() {
        ArrayList seznam = new ArrayList();
        Scanner scan = null;
        String nazev;
        boolean test;
        try {
            scan = new Scanner(new FileReader("Seznam.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
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

    public Slovník nactiSlovnik() {
        Slovník slovnik = new Slovník();
        int spravneOdpovedi, spatneOdpovedi,hrac,i=0;
        boolean test;
        String cj, aj;
        Scanner scan = null;
            Hrac a=new Hrac();
            hrac=a.vyberHrace();
        vyberSlovnik();
        try {
            scan = new Scanner(new FileReader(getTypSlovniku() + ".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            test = scan.hasNext();
            if (test == true) {
                try {
                    cj = scan.next();
                    aj = scan.next();
                    do{
                    spravneOdpovedi = scan.nextInt();
                    spatneOdpovedi = scan.nextInt();
                    i++;
                    }while(i==hrac);
                    slovnik.vlozNaKonec(aj, cj, spravneOdpovedi, spatneOdpovedi);
                } catch (Exception e) {
                    System.out.println("Ze souboru nebylo mozne nacit data.Soubor je pravdepodobne pozkozen.");
                }
            } else {
                break;
            }
        }


        return slovnik;
    }

    public void ulozSlovnik() {  // Meotda ktera ulozi typSlovniku do souboru 
        FileWriter out = null;
        try {
            out = new FileWriter(getTypSlovniku()+ ".txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 1; i <= pocetDvojic(); i++) {
            try {
                out.write(getObsahBunky(i, 1) + " " + getObsahBunky(i, 2) + " " + getObsahBunky(i, 3) + " " + getObsahBunky(i, 4) + System.lineSeparator());
            } catch (IOException ex) {
                Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ulozeno");
    }
}
