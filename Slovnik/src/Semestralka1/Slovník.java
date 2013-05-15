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
import java.util.LinkedList;
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
   private LinkedList neaktivni= new LinkedList();

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
                System.out.println("Vkladam na konec "+ aj+ " "+cj);
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
        String cislo="";
        int cislo1;
        String idSlova=this.getIdPoslednohoSlova();
        String slovnik=this.getTypSlovniku();
        if(idSlova==null){
            System.out.println(" RETURN nove ID");
            return slovnik+"1";
        }
        int delkaSlovnik=slovnik.length();
        int delkaIdSlova=idSlova.length();
        char [] pole =idSlova.toCharArray();
        for (int i = delkaSlovnik--; i <= delkaIdSlova--; i++) {
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
        System.out.println("Mazu "+x);
        int z = 0;
        Bunka pom = prvni;
        while (pom != null) {
            z = z + 1;
            if (z == x && x == 1) { // pro smazani prvniho
                System.out.println("Pomoci prvniho");
                prvni = prvni.dalsi;
                break;
            }
            if (z == x - 1 && x != pocetDvojic()) {
                System.out.println("Pomoci prostredniho");
                pom.dalsi = pom.dalsi.dalsi;
                break;
            }
            if (z == x - 1 && x == pocetDvojic()) { // mazani posledniho 
                System.out.println("Pomoci posledniho");
                pom.dalsi = null;
                volna.dalsi = pom;
                volna = volna.dalsi;
                break;
            }
            pom = pom.dalsi;

        }
    }
 public void vycistiSpojovySeznam(){
       this.prvni=null;
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
     * 2-vrátí anglický výraz 3- vrátí pocet spravnych odpovedi 4- vrátí pocet
     * spatnzch dpovedi 5- vrati IdSlova 6- vrati aktivitu slova
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
          try{
               this.setTvurceSlovniku(scanSlovnik.next());
          }catch(Exception e){
        System.out.println("Ze souboru nebylo mozne nacist data.Soubor je pravdepodobne pozkozen.");
          }
        while (true) {
            test = scanSlovnik.hasNext();
            if (test == true) {
                try {
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
         this.setIdPoslednihoSlova(this.getTypSlovniku()+this.pocetDvojic());
         System.out.println("posledni ma id "+this.getIdPoslednohoSlova());
     /*   for (int j = 1; j <= this.pocetDvojic(); j++) {
             System.out.println(getObsahBunky(j, 1) + " " + getObsahBunky(j, 2) + " " + getObsahBunky(j, 3) + " " + getObsahBunky(j, 4)+" "+ getObsahBunky(j, 5)+" " +getObsahBunky(j, 6));
        }
*/
    }

    public void ulozSlovnik(String jmenoHrace) {  // Meotda ktera ulozi typSlovniku do souboru 
        FileWriter outSlovnik = null;
         FileWriter outHrac = null;
        try {
            outSlovnik = new FileWriter(getTypSlovniku()+ ".txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
            outHrac = new FileWriter(jmenoHrace+ ".txt");
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                outSlovnik.write(this.getTvurceSlovniku()+System.lineSeparator());
                if(!this.neaktivni.isEmpty()){
                    System.out.println("pocet Dvojic"+this.pocetDvojic());
                    for (int i = 0; i < this.neaktivni.size(); i++) {
                        System.out.println("pridavam");
                         Slovo slovo= (Slovo)this.neaktivni.get(i);
                          this.vlozNaKonec(slovo.getAj(),slovo.getCj(), slovo.getPocetSpravnychOdpovedi(),slovo.getPocetSpatnychOdpovedi()
                                  , slovo.getIDSlova(), slovo.getAktivita()); 
                    }
                }
         System.out.println("pocet Dvojic"+this.pocetDvojic());
        for (int i = 1; i <=this.pocetDvojic(); i++) {
                outSlovnik.write(getObsahBunky(i, 1) + " " + getObsahBunky(i, 2) + " " + getObsahBunky(i, 5) + " " + getObsahBunky(i, 6) + System.lineSeparator());
                 outHrac.write(getObsahBunky(i, 5) + " " + getObsahBunky(i, 3) + " " + getObsahBunky(i, 4) + System.lineSeparator());
        }
        } catch (IOException ex) {
                Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        try {
            outSlovnik.close();
            outHrac.close();
        } catch (IOException ex) {
            Logger.getLogger(Slovník.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*Tato metoda presune neaktivni slova do Linked listu tridy neaktivni.
     * 
     * 
     */
    public void presunNeaktivni(){
        String test;
        for (int i = 1; i <= this.pocetDvojic(); i++) {
         test=this.getObsahBunky(i, 6);
         if(test.equals(""+0)){
             System.out.println("Ukladam do neaktivni"+getObsahBunky(i, 1) + " " + getObsahBunky(i, 2) +
                     " " + getObsahBunky(i, 3) + " " + getObsahBunky(i, 4) +" " + getObsahBunky(i, 5) + " " + getObsahBunky(i, 6));
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
/**Metoda ktera aktivuje nbeo deaktivuke slovo.
 * Parametrem poradi se urcuje poradi slova ve spojovem seznamu.
 * Pokud bude porametr poradi 0 tak se operace provede pro vsechna slova.
 * Parametrem operace se voli aktivace ne deaktivace slov takto:
 * 0 - nastav na neaktivni
 * 1-nastav na aktivni
 * @param poradi
 * @param operace 
 */
    public void aktivaceDeaktivaceSlova(int poradi, int operace){
                int z = 0;
        Bunka pom = prvni;
        while (pom != null) {
            
            z = z + 1;
            if (z == poradi && poradi == 1 | poradi==0) { 
               pom.slovicka.setAktivita(operace);
                break;
            }
            if (z == poradi - 1 && poradi != pocetDvojic()| poradi==0) {
             pom.slovicka.setAktivita(operace);
                break;
            }
            if (z == poradi - 1 && poradi == pocetDvojic()| poradi==0) { 
                pom.slovicka.setAktivita(operace);
                break;
            }
            pom = pom.dalsi;

        }
        
        
    }

    public String getIdPoslednohoSlova() {
        return idPoslednihoSlova;
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
