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
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Marco
 */
public class Uzivatel {

    private String jmeno;
    private String heslo;
    private int pokusy;
    private JRootPane pane;
    private ArrayList seznamX;
    
    public Uzivatel(JRootPane pane){
        this.pane=pane;
    }

    /**Metoda ulozUzivatele() ulozi  uzivatele do souboru.
     *Parametrem nastaveni se urcuje jak bude metoda pracovat.
     * 
     * @param nastaveni 
     *  1- metoda uklada noveho uzivatele jeho jmeno a hesllo si vezme
     * z tridnich promenich.
     * 2- metoda zmeni heslo hrace. nove heslo ziska z promene tridy.
     * 3- metoda slouzi metode smazUzivatele pro ulozeni zmen.
     */
    public void ulozUzivatele(int nastaveni) {
    String smazat="";
        ArrayList seznam = new ArrayList();
        if(nastaveni==3){
          seznam=this.seznamX;
           smazat= (String)this.seznamX.get(this.seznamX.size()-1);
          this.seznamX.remove(this.seznamX.size()-1);
        }else{
        String[] seznam1=nactiUdajeOHracich(3);
        seznam.addAll(Arrays.asList(seznam1));
        if(nastaveni==1){
        seznam.add(this.jmeno);
        seznam.add(this.heslo);
        }
        if (nastaveni==2){
          int index=seznam.indexOf(this.jmeno);
          seznam.remove(index+1);
            seznam.add(index+1,this.heslo);
        }
        }
        FileWriter out = null;
        File novy= null;
        File uzivatel=null;
        try {
            out = new FileWriter("seznamUzivatelu.txt");
            if(nastaveni==1){
           novy= new File(this.jmeno+".txt");
            }     
            if(nastaveni==3){
               uzivatel= new File(smazat+".txt");
            
            }
        } catch (IOException ex) {
              JOptionPane.showMessageDialog(this.pane, "System nemuze nalezt soubor Hraci.txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try {
            for (int i = 0; i < seznam.size(); i++) {
                out.write(seznam.get(i) + "" + System.lineSeparator());
            }
            out.close();
            if(nastaveni==1){
            novy.createNewFile();
            }
            if(nastaveni==3){
                uzivatel.delete();
            }
        } catch (Exception e) {
      JOptionPane.showMessageDialog(this.pane, "System nemuze zapsat data do souboru Hraci.txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }
/**Metoda smaze uzivatele i jeho heslo ze seznamuUzivatelu 
 * a smaze jeho soubor se statistikami. 
 * 
 * @param uzivatel - cislo uzivatele ktery bude smazan
 */
    public void smazUzivatele(int uzivatel) {
        String [] udaje=this.nactiUdajeOHracich(3);
        ArrayList seznam= new ArrayList();
        seznam.addAll(Arrays.asList(udaje));
        uzivatel=(uzivatel-1)*2;
        String jmeno=(String)seznam.get(uzivatel);
        seznam.remove(uzivatel);
        seznam.remove(uzivatel);
        seznam.add(jmeno);
        this.seznamX=seznam;
        this.ulozUzivatele(3);
        
    }

   /***Metoda navrati yvolene udaje.
    * 
    * @param udaj 
    * 1- Jmena hracu
    * 2- Hesla hracu
    * 3- Jmena i hesla hracu
    * @return ArrayList s udaji
    */
    public String [] nactiUdajeOHracich( int udaj) {
        ArrayList seznam = new ArrayList();
        String hrac;
        boolean test;
        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader("seznamUzivatelu.txt"));
        } catch (FileNotFoundException ex) {
                 JOptionPane.showMessageDialog(this.pane, "System nemuze nalezt soubor Hraci.txt",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
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
        if(udaj==1){
            for (int j = 1; j < seznam.size(); j++) {
                seznam.remove(j);
               
            }
        }else if (udaj==2){
            for (int j = 0; j < seznam.size(); j++) {
                seznam.remove(j);
        }
        }
         seznam.toString();
         String[] pole;
        pole = (String[]) seznam.toArray(new String[seznam.size()]);

        return pole;
    
        
        
    }
    
    /**
     * Metoda porovnava zadane heslo se spravnym heslem a na zaklade
     * porovnani vrati true nebo false. Zdane heslo dostane metoda parametrem
     * heslo a spravne heslo dostane od metody rozsifrujHeslo(). Pokud je
     * porovnani vzhodnoceno jako false tak metoda zavola metodu pokusy() a pote
     * vrati false.
     *
     * @param heslo0 - heslo k overeni
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
     * Metoda pocita neplatne pokusy o zadani hesla. Pokud je pocet
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
     * Metoda zasifruje retezec heslo0 ktery dostane v
     * argumentu. Vysledek zapise do tridni promenne heslo;
     *
     * @param heslo0 - retezec k zasifrovani
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
     * Metoda rozsifruje heslo ulozene v tridni promenne heslo.
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
    /**Metoda overi jestli se o prihlaseni pokousi
     * majitel uctu.
     * 
     * @param jmeno - jmeno uzivatele pod kterym je pokouseno o prihlaseni
     * @param zadane - zadane heslo
     * @param poradi - paradi uyivatele v seznamuUzivatelu
     * @return 
     */
    public boolean prihlaseni(String jmeno, String zadane, int poradi){
     this.setJmeno(jmeno);
     String []hesla = nactiUdajeOHracich(2);
     this.setHeslo(hesla[poradi]);
     boolean spravne=overHeslo(zadane);
     return spravne;     
    }
    /**Metoda kontroluje jestli jmeno ktere dostane v parametru jmeno je jiz
     * v seznamUzivatelu;
     * 
     * @param jmeno - je porovnanu s seznamUzivatelu.
     * @return 
     */
    public boolean zkontrolujJmeno(String jmeno){
        String []pole =nactiUdajeOHracich(1);
          ArrayList jmena = new ArrayList();
          for (int i = 0; i < pole.length; i++) {
            jmena.add(pole[i].toLowerCase());
        }
          boolean a = jmena.contains(jmeno.toLowerCase());
        
        return a;
        
    }
    /**Metoda vytvoří nového Uzivatele nebo zmeni heslo uyivatele.
     * Pokud se nepodari noveho uzivatele vytvorit vrati false
     * @param jmenoNeboHeslo - jmeno  noveho uzivatele nebo stare heslo uzivatele.
     * @param noveHeslo - heslo noveho Uzivatele
     * @param opakovaneHeslo - opakovane heslo noveho uzivatele
     * @param  nastaveni - 
     * 1- metoda vytvori noveho uzivatele.V tomto pripade je 2 argument jmeno uzivatele
     * 2- metoda zmeni heslo uzivatele.V tomto pripade je 2 argument stare heslo uzivatele
     * @return 
     */
    public boolean vytvorNeboZmenUzivatele(int nastaveni,String jmenoNeboHeslo,String noveHeslo,String opakovaneHeslo){
        if(jmenoNeboHeslo.equals("") || noveHeslo.equals("") || opakovaneHeslo.equals("")){
           JOptionPane.showMessageDialog(this.pane, "Některý z údajů nebyl zadán", "Chyba!", JOptionPane.WARNING_MESSAGE);
           return false;
        }
          if(noveHeslo.equals(opakovaneHeslo)== false){
          JOptionPane.showMessageDialog(this.pane, "Hesla se neshoduji", "Chyba!", JOptionPane.WARNING_MESSAGE);
        return false;
        }
        if(nastaveni ==1 && zkontrolujJmeno(jmenoNeboHeslo)== true){
     JOptionPane.showMessageDialog(this.pane, "Jmeno je jiz obsazene prosim vyberte si jine", "Chyba!", JOptionPane.WARNING_MESSAGE);
       return false;
        }
        if(nastaveni==2 && !this.overHeslo(jmenoNeboHeslo)){
             JOptionPane.showMessageDialog(this.pane, "Zadano spatne stare heslo", "Chyba!", JOptionPane.WARNING_MESSAGE);
       return false;
        }
        if(noveHeslo.length()==4 | noveHeslo.length()==6){
            if(nastaveni==1){
        this.setJmeno(jmenoNeboHeslo);
        this.zasifrujHeslo(noveHeslo);
        this.ulozUzivatele(1);
          JOptionPane.showMessageDialog(this.pane, "Ucet byl uspesne vytvoren");
            }else{
                this.zasifrujHeslo(noveHeslo);
                     this.ulozUzivatele(2);
                      JOptionPane.showMessageDialog(this.pane, "Heslo bylo uspesne zmeneno");
            }
            
        return true;
        }else{
             JOptionPane.showMessageDialog(this.pane, "Heslo nema predepsanou delku", "Chyba!", JOptionPane.WARNING_MESSAGE);
             return false;
        }
    }
 /**Metoda ktera testuje jake ma uzivatel  pravomoce.
     *  
     * 
  * 
  * @param tvurce - jmeno hrace ktery vytvoril prave spusteny slovnik.
  * @param testuj - urcuje jakz test chceme provest
  * 1- navrati true pokud prave prihlaseny uzivatel je Admin nebo tvurce.
  * 2- navrati true pokud prave prihlaseny uzivatel je tvurce.
  * 3- navrati true pokud prave prihlaseny uzivatel je  Admin.
  * @return 
  */
   public boolean testPravomoc(String tvurce,int testuj){
        switch (testuj){
            case 1:
                if(this.getJmeno().equals(tvurce) | this.getJmeno().equals("Admin")){
                    return true;
                }
                break;
            case 2:
                if(tvurce.equals(this.getJmeno()) ){
                    return true;
                }
                break;
            case 3:
                if(tvurce.equals("Admin")){
                    return true;
                }
                break;
        }
         JOptionPane.showMessageDialog(this.pane, "Na tuto akci nemate pravomoc!", "Chyba!", JOptionPane.WARNING_MESSAGE);
        return false;
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
