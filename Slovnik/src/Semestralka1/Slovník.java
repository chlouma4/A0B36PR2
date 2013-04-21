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
   private String idPoslednihoSlova;
   private String tvurceSlovniku;

    public Slovník() {
    }

    public void vlozNaKonec(String aj, String cj, int spravneOdpovedi, int spatneOdpovedi, String IDSlova, int aktivita) {  // metoda ktera vklada vstupni promene cj aj na konec spojoveho sezamu, pokud jsou promene praydne ulozeni se neprovede
        if (cj != null && aj != null) {
            Slovo slovo = new Slovo(aj, cj, spravneOdpovedi, spatneOdpovedi,IDSlova, aktivita);
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

    public String vytvorNoveIdSlova(){
        String cislo=null;
        int cislo1;
        String idSlova=this.getIdPoslednohoSlova();
        String slovnik=this.getTypSlovniku();
        int delkaSlovnik=slovnik.length();
        int delkaIdSlova=idSlova.length();
        char [] pole =idSlova.toCharArray();
        for (int i = delkaSlovnik++; i <= delkaIdSlova; i++) {
            cislo=cislo+pole[i];
        }
        cislo1=Integer.valueOf(cislo);
        cislo1++;
        
        return slovnik+cislo1;
    }
    
    
    
    public String[] pocetDvojicPole(){
        String [] pole= new String[pocetDvojic()];
        for (int i = 0; i < 10; i++) {
            pole[i]=""+i+1;
        }
        return pole;
    }
    public String [] vypis() {   // tato metoda vypise vsechny dvojce slov  serazene tak jak jsou razeny ve spojovem seznamu od prvni bunky do x-te bunky. 
        int g = 1;
        Bunka pom = prvni;
        String [] slova = new String[pocetDvojic()];
        while (pom != null) {
             slova[g-1]= "(" + g + ") " + pom.slovicka.toString();
            pom.slovicka.toString();
            g++;
            pom = pom.dalsi;
        }
        return slova;
    }

    public String vypisX(int x) {  // tato metoda vypise  dvojci slov v bunce  x. Ochrana na spatne vstupni metodz je v main
        int z = 0;
        String slovo=null;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == x) {
                slovo="(" + x + ") " + pom.slovicka.toString();
            }
            pom = pom.dalsi;
        }
        return slovo;
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
     //   seznam = nactiSeznam();
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
       // seznam = nactiSeznam();
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
     * spravnych odpovedi 5- vrati IdSlova 6- vrati aktivitu slova
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
                  slovo = String.valueOf(pom.slovicka.getPocetSpatnychOdpovedi());  
                        break;
                    case 4:
                    slovo = String.valueOf(pom.slovicka.getPocetSpravnychOdpovedi()); 
                        break;
                    case 5:
                        slovo=pom.slovicka.getIDSlova();
                        break;
                    case 6:
                        slovo=String.valueOf(pom.slovicka.getAktivita());
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
  //     seznam=nactiSeznam();
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
    public String [] nactiSeznam() {
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
        String[] pole;
        pole = (String[]) seznam.toArray(new String[seznam.size()]);
        return pole;

    }

    public void nactiSlovnik(String slovnik,String jmenoHrace) {
        int spravneOdpovedi, spatneOdpovedi,hrac1,i=0,aktivni;
        boolean test;
        this.setTypSlovniku(slovnik);
        String cj, aj,idSlova,test1;
        Scanner scanSlovnik = null;
          Scanner scanHrac = null;
        try {
            scanSlovnik = new Scanner(new FileReader(getTypSlovniku() + ".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
            scanHrac = new Scanner(new FileReader(jmenoHrace+".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            test = scanSlovnik.hasNext();
            if (test == true) {
                try {
                    this.setTvurceSlovniku(scanSlovnik.next());
                    cj = scanSlovnik.next();
                    aj = scanSlovnik.next();
                    idSlova= scanSlovnik.next();
                    aktivni= scanSlovnik.nextInt();
                    while(true){
                                try{
                              do{
                                  test1=scanHrac.next();      
                              }while(idSlova.equals(test1));    // tento cyklus pobezi dokud nenajde pozadovane slovo ve zvolenem slovniku.
                                spravneOdpovedi=scanHrac.nextInt();   // pokud slovo najde 
                                 spatneOdpovedi=scanHrac.nextInt();    // naskenuje tyto hodnoty.
                                }catch(Exception e){         // pokud cyklud slovo nenajde tak dojde na konec souboru kde se potom pokusi o scan prazdneho mista
                                    spravneOdpovedi=0;       // coz skonci chybou a to znamena ze statistiky pro toto slovo nejsou a jsou nastavenz tedz na nula
                                     spatneOdpovedi=0;
                                }
                               this.vlozNaKonec(aj, cj, spravneOdpovedi, spatneOdpovedi, idSlova,aktivni);
                                break;
                    }
               
                } catch (Exception e) {
                    System.out.println("Ze souboru nebylo mozne nacist data.Soubor je pravdepodobne pozkozen.");
                }
            } else {
                break;
            }
        }
         this.setIdPoslednohoSlova(this.getObsahBunky(this.pocetDvojic(), 5));

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
    
    public void vymazNeaktivni(){
        String test;
        for (int i = 1; i < this.pocetDvojic(); i++) {
         test=this.getObsahBunky(i, 6);
         if(test.equals("0")){
             this.smaz(i);
         }
        }
    }

    public String getIdPoslednohoSlova() {
        return idPoslednihoSlova;
    }

    public void setIdPoslednohoSlova(String idSlovniku) {
        this.idPoslednihoSlova = idSlovniku;
    }

    public String getTvurceSlovniku() {
        return tvurceSlovniku;
    }

    public void setTvurceSlovniku(String tvurceSlovniku) {
        this.tvurceSlovniku = tvurceSlovniku;
    }
    
    
   
    
}
