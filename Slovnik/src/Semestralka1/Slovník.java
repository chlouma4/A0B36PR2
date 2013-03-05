/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public String aj(int x) { // Metoda ktera vrati anglicke slovicko z bunky x.
        int z = 0;
        String a = null;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == x) {
                a = pom.slovicka.getAj();
            }
            pom = pom.dalsi;
        }
        return a;
    }

    public String cj(int x) { // Metoda ktera vrati ceske slovicko z bunky x.
        int z = 0;
        String a = null;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == x) {
                a = pom.slovicka.getCj();
            }
            pom = pom.dalsi;
        }
        return a;
    }

    public Slovník nacti() { // Metoda ktera nacte slovnik ze souboru
        int B[] = new int[1];
        Slovník A = new Slovník();
        try {
            FileInputStream po = new FileInputStream("pocet.bin"); // nacteme se souboru pole ktere je vždy o vekosti 1
            try {
                ObjectInputStream po1 = new ObjectInputStream(po); // toto pole nám řekne kolik dvojic sloviček je v soubouru                                                                            
                try {
                    B[0] = (int) po1.readObject();
                    po.close();
                } catch (ClassNotFoundException e) {
                    System.out.println("Program nenalezl tridu.");
                }
            } catch (IOException e) {
                System.out.println("Program nemuze nacist informace ze souboru pocet.bin .");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor pocet.bin nebyl nalezen. Prosim zkontrolujte umisteni souboru.");
        }
        String PD[][] = new String[B[0]][2];                          // vytvoření pole do ktereho se načtou uložene informace
        try {
            FileInputStream sl = new FileInputStream("slovicka.bin");
            try {
                ObjectInputStream so = new ObjectInputStream(sl);
                try {
                    for (int i = 1; i < PD.length; i++) {
                        for (int j = 0; j < PD[i].length; j++) {
                            PD[i][j] = (String) so.readObject();
                        }
                    }
                    sl.close();
                } catch (ClassNotFoundException e) {
                    System.out.println("Program nenalezl tridu.");
                }
            } catch (IOException e) {
                System.out.println("Program nemuze nacist informace ze souboru slovicka.bin .");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor slovicka.bin nebyl nalezen. Prosim zkontrolujte umisteni souboru.");
        }
        for (int i = 1; i < PD.length; i++) {                    // prevedeme pole na spojovy seznam a ten vratime
            A.vlozNaKonec(PD[i][0], PD[i][1]);

        }
        return A;
    }

    public void uloz(Slovník A)   {  // Meotda ktera ulozi slovnik do souboru i s daty potrebnymi pro jeho budouci nacteni.
       FileWriter out=null;
        try {
            out = new FileWriter("slovnik.txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 1; i <=pocetDvojic() ; i++) {
            try {
                out.write(cj(i)+","+aj(i)+System.lineSeparator());
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
 
