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
public class Hrac {

    private String jmeno;
    private String heslo;
    private int pokusy;

    /**
     * Metoda ulozNovehoHrace() ulozi noveho hrace do souboru. Jmeno hrace a jeho
     * heslo zaska z tridnich promenich.
     *
     */
    public void ulozNovehoHrace() {
        ArrayList seznam = new ArrayList();
        String[] seznam1=nactiHrace(3);
      
        for (int i = 0; i < seznam1.length; i++) {
            seznam.add(seznam1[i]);
        }
        seznam.add(this.jmeno);
        seznam.add(this.heslo);
        FileWriter out = null;
        try {
            out = new FileWriter("Hraci.txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i = 0; i < seznam.size(); i++) {
                out.write(seznam.get(i) + "" + System.lineSeparator());
            }
            out.close();
        } catch (Exception e) {
            System.out.println("Chyba: Nebylo mozne provest yapis do souboru Hraci.txt");
        }

    }

    public void smazHrace() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metoda nactiHrace vráti seznam hráčů i s jejich hesly v ArrayListu.
     *parametr urcuje co cheme nacist 1- Jmena hracu 2-hesla hracu 3 - nacte vse
     * @return
     */
    public String [] nactiHrace( int i) {
        ArrayList seznam = new ArrayList();
        String hrac;
        boolean test;
        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader("Hraci.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            test = scan.hasNext();
            if (test == true) {
                hrac = scan.next();
                seznam.add(hrac);
            } else {
                break;
            }

        }
        
        if(i==1){
            for (int j = 1; j < seznam.size(); j++) {
                seznam.remove(j);
               
            }
        }else if (i==2){
            for (int j = 0; j < seznam.size(); j=j+2) {
                seznam.remove(j);
        }
        }
         String[] pole;
        pole = (String[]) seznam.toArray(new String[seznam.size()]);

        return pole;
    
        
        
    }
    
    /**Metoda vyberHrace() vybere hrace ,ktery chce hrat nebo vztvori novy ucet.
     * Pomoci return vrati poradi hrace aby se mohly ye souboru nacist spravne metody.
     * 
     * @return 
     */

    public int vyberHrace() {
        Scanner scan = new Scanner(System.in);
        String heslo0;
        int volba;
        ArrayList hraci = new ArrayList();
      //  hraci = this.nactiHrace();
        System.out.println("Vyberte prosim svuj ucet");
        for (int i = 0; i <= (hraci.size() / 2); i = i + 2) {
            System.out.println((i / 2 + 1) + ". " + hraci.get(i));
        }
        System.out.println("Pokud chete vztvo5it novy ucet zvolte 0.");
        volba = scan.nextInt();
        if (volba == 0) {
            System.out.println("Zadejte sve jmeno.");
            this.jmeno = scan.next();
            nastavHeslo(0);
            ulozNovehoHrace();
            System.out.println("Ucet vytvoren");
            return (hraci.size()/2)+1;
        } else {
            this.jmeno = "" + hraci.get((volba - 1) * 2);
            this.heslo = "" + hraci.get((volba - 1) * 2 + 1);
            while (true) {
                System.out.println("Zadejte sve heslo");
                heslo0 = scan.next();
                if (overHeslo(heslo0) == false) {
                    System.out.println("Spatne heslo! Prosim opakujte zadani"
                            + " Pocet zbyvajicich pokusu" + (3 - this.pokusy));
                } else {
                    break;
                }
            }
        }
        return volba;
        
    }

    /**
     * Metoda nastavHeslo slouzi k nastaveni hesla , ktere je 4 nebo 6 ynaku
     * dlouhe. Promenna prepinac slouzi pro rozliseni kdo chce nastavit nebo
     * zmenit heslo. Pokud bude prepinac=0 tak se nastavy heslo pro noveho
     * uzivatele. Pokud bude preponac=1 tak se nastavy nove heslo stavajiciho
     * uzivatele pote co spravne zada sve doposud platne heslo.
     *
     * @param prepinac
     */
    public void nastavHeslo(int prepinac) {
        Scanner scan = new Scanner(System.in);
        boolean a;
        String nove;
        String nove1;
        String stare;
        if (prepinac == 1) {
            while (true) {
                System.out.println("Zadejte sve heslo");
                stare = scan.next();
                a = this.overHeslo(stare);
                if (a == false) {
                    System.out.println("Heslo neni spravne. Pocet zbyvajicich pokusu" + (3 - this.pokusy));
                } else {
                    break;
                }
            }
        }
        while (true) {
            System.out.println("Zadejte nove heslo. Musi byt 4 nebo 6 znaku dlouhe");
            nove = scan.next();
            System.out.println("Zadejte nove heslo znovu");
            nove1 = scan.next();
            if (nove.equals(nove1) && nove.length() == 4 | nove.length() == 6) {
                zasifrujHeslo(nove);
                System.out.println(" Heslo zmeneno.");
                break;
            } else {
                System.out.println("Zadana hesla se neshoduji. Prosim opakujte zadani");
            }
        }
    }

    /**
     * Metoda overHeslo porovnava zadane heslo se spravnym heslem a na zaklade
     * porovnani vrati true nebo false. Zdane heslo dostane metoda parametrem
     * heslo a spravne heslo dostane od metody rozsifrujHeslo(). Pokud je
     * porovnani vzhodnoceno jako false tak metoda zavola metodu pokusy() a pote
     * vrati false.
     *
     * @param heslo0
     * @return
     */
    public boolean overHeslo(String heslo0) {
        String spravneHeslo;
        spravneHeslo = rozsifrujHeslo();
        if (spravneHeslo.equals(heslo0)) {
            return true;
        } else {
            this.pokusy();
            return false;
        }
    }

    /**
     * Metoda pokusy() pocita neplatne pokusy o zadani hesla. Pokud je pocet
     * roven 3 tak ukonci okamzite program.
     *
     */
    public void pokusy() {
        this.pokusy++;
        if (this.pokusy == 3) {
            System.exit(0);
        }
    }

    /**
     * Metoda zasifrujHeslo() zasifruje retezec heslo0 ktery dostane v
     * argumentu. Vysledek zapise do tridni promenne heslo;
     *
     * @param heslo0
     */
    public void zasifrujHeslo(String heslo0) {
        String a, b, c;
        a = heslo0.substring(0, 2);
        b = heslo0.substring(2, 4);
        System.out.println(""+a+b);
        if (heslo0.length() == 4) {
            this.heslo = "" + b + a + "";
        } else {
            c = heslo0.substring(4, 6);
            this.heslo = "" + c + a + b + "";
        }

    }

    /**
     * Metoda rozsifrujHeslo() rozsifruje heslo ulozene v tridni promenne heslo.
     * Pravadi opak metody zasifrujHeslo();
     *
     * @return
     */
    public String rozsifrujHeslo() {
        String heslo0, a, b, c;
        heslo0 = this.heslo;
        a = heslo0.substring(0, 2);
        b = heslo0.substring(2, 4);
        if (heslo0.length() == 4) {
            return b + a;
        } else {
            c = heslo0.substring(4, 6);
            return b + c + a;
        }
    }
    
    public boolean prihlaseni(String jmeno, String heslo1, int poradi){
      //  System.out.println(jmeno +poradi);
        //System.out.println(heslo1);
     this.setJmeno(jmeno);
     String []pole = nactiHrace(2);
     this.setHeslo(pole[poradi]);
     boolean spravne=overHeslo(heslo1);
     return spravne;     
    }
    
    public boolean zkontrolujJmeno(String jmeno){
        String []pole =nactiHrace(1);
          ArrayList jmena = new ArrayList();
          for (int i = 0; i < pole.length; i++) {
            jmena.add(pole[i]);
        }
          boolean a = jmena.contains(jmeno);
        
        return a;
        
    }
    
    public int vytvorHrace(String jmeno,String heslo,String heslo1){
        if(zkontrolujJmeno(jmeno)== true){
            return 1;
        }
        if(heslo.equals(heslo1)== false){
            return 2;
        }
        if(heslo.length()==4 | heslo.length()==6){
            this.setJmeno(jmeno);
        this.zasifrujHeslo(heslo);
        this.ulozNovehoHrace();
        return 0;
        }
    return 3;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public int getPokusy() {
        return pokusy;
    }

    public void setPokusy(int pokusy) {
        this.pokusy = pokusy;
    }
 
  
    
}
