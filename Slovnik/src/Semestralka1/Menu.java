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
import java.util.Scanner;
import java.util.Set;

/* pridat vybet jestly ma nove vztvorenz slovnik vzdet jenom sam utivatel nebo i ostatni.
 * Problem s ukladanim ... Kazdy slovnik ma svuj soubor kde jsou ve sloupci ulozeny slova
 * v dalsim sloupci jsou statistiky techto slov pro kazdeho hrace vlastni. Kdyz nactu do
 * spojoveho seznamu slova s jejich statistikami pro prislusneho hrace a pote ulozim tak
 * ztratim statistiky ostatnich hracu
 */

/**
 *
 * @author Marco
 */
public class Menu {

    
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

    public static void main(String[] args)  {
        String aj, cj, kon = null, preklad;
        double procenta;
        boolean kontrola = false;
        Slovník slovnik = new Slovník();
        int ukon, velikostSlovniku, z = 0, e, pom;
        ArrayList spatneOdpovedi = new ArrayList();
        
      Prihlaseni pri= new Prihlaseni();
      pri.setVisible(true);
      pri.pack();
        Scanner sc = new Scanner(System.in);
//        slovnik=slovnik.nactiSlovnik();
        velikostSlovniku = slovnik.pocetDvojic();
        System.out.println("Upozorneni: Pokud nebude program radne ukoncen tak provedene zmeny nebudou ulozeny.");
        while (true) {
            while (true) {
                System.out.println("Zadanim cisla vyberete ukon: 1-Zkouseni 2-Pridani slovicek 3-Smazani slovicek 4-Zobrazeni slovicek 5-Ukoncit Program."); // hlavní nabídka
                try {
                    ukon = sc.nextInt();
                    if (ukon > 0 && ukon < 6) {
                        break;
                    } else {
                        System.out.println("Chyba! Zadano spatne cislo. Opakujte prosim zadani.");
                    }
                } catch (Exception f) {
                    System.out.println("Chyba! Zadan spatny znak. Opakujte prosim zadani.");
                    sc.next();
                }
            }
            switch (ukon) {
                case 1: {
                    System.out.println("Bylo zadano cislo 1-Zkouseni.");
                    while (true) {
                        System.out.println("Zadejte cislo 1 pokud chcete prekladat z cestiny do anglictiny.");
                        System.out.println("Zadejte cislo 2 pokud chcete prekladat z anglictiny do cestiny.");
                        try {
                            z = sc.nextInt();
                            if (z == 1 | z == 2) {
                                break;
                            } else {
                                System.out.println("Chyba! Zadano spatne cislo. Opakujte prosim zadani.");
                            }
                        } catch (Exception f) {
                            System.out.println("Chyba! Zadan spatny znak. Opakujte prosim zadani.");
                            sc.next();
                        }
                    }
                    while (true) {
                        System.out.println("Cislici napiste z kolika slov chcete byt zkouseni.Maximalni pocet je " + velikostSlovniku);
                        try {
                            e = sc.nextInt();
                            if (e > 0 && e <= velikostSlovniku) {
                                break;
                            } else if (e == 0) {
                                System.out.println("Chyba! Test o 0 otazkach neni test. Opakujte prosim zadani.");
                            } else if (e < 0) {
                                System.out.println("Chyba! Bylo zadano zaporne cislo. Opakujte prosim zadani.");
                            } else {
                                System.out.println("Chyba! Program nezna tolik slovicek aby vas mohl z pozadovaneho poctu vzykouset aniz by se slovicka opakovala. Opakujte prosim zadani.");
                            }
                        } catch (Exception f) {
                            System.out.println("Chyba! Zadan spatny znak. Opakujte prosim zadani.");
                            sc.next();
                        }
                    }
                    Integer pom1[] = new Integer[e];
                    pom1 = generatorNahodnychCisel(e, slovnik.pocetDvojic(), spatneOdpovedi);
                    spatneOdpovedi.clear();
                    for (int i = 0; i < pom1.length; i++) {
                        if (z == 1) {
                            System.out.print("(" + (pom1[i]) + ") " + slovnik.getObsahBunky(pom1[i],1) + " prelozte slovicko do anglictiny ");
                        }
                        if (z == 2) {
                            System.out.print("(" + (pom1[i]) + ") " + slovnik.getObsahBunky(pom1[i], 2) + " prelozte slovicko do cestiny ");
                        }
                        if (i == 0) {
                            preklad = sc.nextLine();
                            preklad = sc.nextLine();
                        } else {
                            preklad = sc.nextLine();
                        }
                        preklad = preklad.toLowerCase();
                        if (z == 1) {
                            kontrola = preklad.equals(slovnik.getObsahBunky(pom1[i],2).toLowerCase());
                        }
                        if (z == 2) {
                            kontrola = preklad.equals(slovnik.getObsahBunky(pom1[i],1).toLowerCase());
                        }
                        if (kontrola == false) {
                            spatneOdpovedi.add(pom1[i]);  // pokud bude odpoved spatna zapiseme ji 
                        }
                    }
                    System.out.println("");
                    System.out.println("---Vyhodnoceni testu---");
                    System.out.println("Byl/a jste vzykousen/a ze " + e + " slovicek z nichz jste na " + spatneOdpovedi.size() + ""
                            + " odpovedel/a spatne.");
                    procenta = (100 * (e - spatneOdpovedi.size())) / e;
                    System.out.printf("Vase uspesnost je %.2f", procenta);
                    System.out.print("%");
                    System.out.println("");
                    Integer[] D = (Integer[]) spatneOdpovedi.toArray(new Integer[spatneOdpovedi.size()]); //prevod dynamickeho pole do pole 
                    if (D.length == 0) {
                        System.out.println("Gratuluji! - Congratulations!");
                        break;
                    }
                    System.out.println("Slovicka na ktera jste zodpovedel/a spatne ve spravnem prekladu.");
                    for (int k = 0; k < D.length; k++) {
                        slovnik.vypisX(D[k]);
                    }
                    break;

                }

                case 2: {
                    System.out.println("Bylo zadano cislo 2-Pridani slovicek");
                    System.out.println("Zadejte anglicky vyraz");
                    aj = sc.nextLine();     // proc to tu musi bzt dvakrat abz to chodilo ?
                    aj = sc.nextLine();
                    System.out.println("Zadejte jeho cesky preklad");
                    cj = sc.nextLine();
               //     slovnik.vlozNaKonec(aj, cj,0,0);
                    if (velikostSlovniku != slovnik.pocetDvojic()) {
                        velikostSlovniku++;
                        System.out.println("Pamatujte pri pristim spusteni se tato zmena projevy jen pokud bude program radne ukoncen.");
                    } else {
                    }
                    break;

                }
                case 3: {
                    System.out.println("Bylo zadano cislo 3-Smazani slovicek");
                    while (true) {
                        if (slovnik.pocetDvojic() == 1) {
                            System.out.println("Zadejte cislo jedna pokud chcete smazat posledni dvojci slovicek.");

                        } else if (slovnik.pocetDvojic() == 0) {
                            System.out.println("Program nezna zadnou dvojci slovicek a proto nemuze zadnou smazat.");
                            break;
                        } else {
                            System.out.println("Zadejte cislo od jedne do " + velikostSlovniku + " a dana dvojce slovicek se smaze.");
                        }
                        try {
                            z = sc.nextInt();
                            if (z > 0 && z <= velikostSlovniku) {
                                break;
                            } else {
                                System.out.println("Chyba! Takovou dvojci program nezna a proto ji nemuze smazat. Prosim opakujte zadani.");
                            }
                        } catch (Exception f) {
                            System.out.println("Zadan spatny znak! Opakujte prosim zadani.");
                            sc.next();
                        }
                    }
                    if (slovnik.pocetDvojic() == 0) {
                        break;
                    }
                    e = z; // prepsani z od pomocne promene e , jinka by radek 256 nefungoval spravne -mayalo bz jse vydz prvni dvojce
                    while (true) {
                        System.out.println("Chcete opravdu smazat? 1-ANO 2-NE");
                        slovnik.vypisX(z);
                        try {
                            pom = sc.nextInt();
                            if (pom == 1 | pom == 2) {
                                break;
                            } else {
                                System.out.println("Chyba! Zadano spatne cislo. Opakujte prosim zadani");
                            }
                        } catch (Exception f) {
                            System.out.println("Zadan spatny znak! Opakujte prosim zadani");
                            sc.next();
                        }
                    }
                    if (pom == 2) {
                        break;
                    }
                    if (pom == 1) {
                        slovnik.smaz(e);
                        velikostSlovniku = slovnik.pocetDvojic();
                        System.out.println("Pamatujte pri pristim spusteni se tato zmena projevy jen pokud bude program radne ukoncen.");
                        break;
                    }

                }
                case 4: {
                    System.out.println("Bylo zadano cislo 4-Zobrazeni slovicek");
                    while (true) {
                        System.out.println("Zadanim cisla od 1 do " + velikostSlovniku + " zobrazit jednu dvojci slovicek ,nebo zadanim cisla " + (velikostSlovniku + 1) + " zobrazit vsechny dvojce");
                        System.out.println("Zadanim cisla " + (velikostSlovniku + 2) + " se vratite do predchozy nabidky");
                        try {
                            z = sc.nextInt();
                            if (z > 0 && z < (velikostSlovniku + 3)) {
                                break;
                            } else {
                                System.out.println("Chyba! Zadano spatne cislo. Opakujte prosim zadani.");
                            }
                        } catch (Exception f) {
                            System.out.println("Chyba! Zadan spatny znak.Opakujte prosim zadani.");
                            sc.next();
                        }
                    }
                    if (z == velikostSlovniku + 2) { // navrat do hlavni nabidky
                        break;
                    }
                    while (true) {
                        e = z; // prepsani promene z do pomocne promene e - jinak bz spravne nefungoval radek  291
                        if (z == velikostSlovniku + 1) {
                            slovnik.vypis();
                        } else {
                            slovnik.vypisX(e);
                        }
                        while (true) {
                            System.out.println("Chcete pokracovat v zobrazovani slovicek? 1-ANO 2-NE");
                            try {
                                z = sc.nextInt();
                                if (z == 1 | z == 2) {
                                    break;
                                } else {
                                    System.out.println("Chyba! Zadano spatne cislo. Opakujte prosim zadani");
                                }
                            } catch (Exception f) {
                                System.out.println("Chyba! Zadan spatny znak.");
                                sc.next();
                            }
                        }
                        if (z == 2) {
                            break;
                        }
                        if (z == 1) {
                            while (true) {
                                System.out.println("Zadanim cisla od 1 do " + velikostSlovniku + " zobrazit jednu dvojci slovicek ,nebo zadanim cisla " + (velikostSlovniku + 1) + " zobrazit vsechny dvojce");
                                System.out.println("Zadanim cisla " + (velikostSlovniku + 2) + " se vratite do predchozy nabidky");
                                try {
                                    z = sc.nextInt();
                                    if (z > 0 && z < (velikostSlovniku + 1)) {
                                        break;
                                    } else {
                                        System.out.println("Chyba! Zadano spatne cislo. Opakujte prosim zadani");
                                    }
                                } catch (Exception f) {
                                    System.out.println("Chyba! Zadan spatny znak.");
                                    sc.next();
                                }
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    slovnik.ulozSlovnik(); // ulozeni seznamu
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Zadano spatne cislo! Opakujte Zadani");
                    sc.next();
                }
            }
        }
    }
}
