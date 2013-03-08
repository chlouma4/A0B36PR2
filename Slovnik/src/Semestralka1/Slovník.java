/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Slovník {

    Bunka prvni;
    Bunka volna;

    public Slovník() {
    }

    public void vlozNaKonec(String aj, String cj) {  // metoda ktera vklada vstupni promene cj aj na konec spojoveho sezamu, pokud jsou promene praydne ulozeni se neprovede
        if (cj != null && aj != null) {
            Slovo slova = new Slovo(aj, cj);
            Bunka bunka = new Bunka(slova, null);
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

    public String getObsahBunky(int cisloBunky, int cj1Aj2) { // metoda ktera vrati z bunky cj nebo aj slovo 
        int citac = 0;
        String slovo = null;
        Bunka pom = prvni;
        while (pom != null) {
            citac++;
            if (citac == cisloBunky) {
                if (cj1Aj2 == 1) {
                    slovo = pom.slovicka.getCj();
                    break;
                } else {
                    slovo = pom.slovicka.getAj();
                    break;
                }
            }
        }
        return slovo;

    }

    public Slovník nacti() { 
        Slovník slovnik = new Slovník();
       boolean a;
        String cj, aj;
        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader("slovnik.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
         while(true){
             a=scan.hasNext();
             if(a == true){
                 cj=scan.next();
                 aj=scan.next();
                 aj=scan.next();
                 slovnik.vlozNaKonec(aj, cj);
             }else{
                 break;
             }
         }
        
            
       return slovnik;
    }

    public void uloz() {  // Meotda ktera ulozi slovnik do souboru 
        FileWriter out = null;
        try {
            out = new FileWriter("slovnik.txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 1; i <= pocetDvojic(); i++) {
            try {
                out.write(getObsahBunky(i, 1) + "," + getObsahBunky(i, 2) + System.lineSeparator());
            } catch (IOException ex) {
                Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            out.write("End.");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ulozeno");
    }
}
