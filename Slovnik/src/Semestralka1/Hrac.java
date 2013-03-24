/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Hrac {
    private String nick;
   
    
    public void  vytvorHrace(String nick,String heslo){
       throw new UnsupportedOperationException("Not supported yet.");  
    }
    public void smazHrace(){
        throw new UnsupportedOperationException("Not supported yet.");  
    }
    /**
     * Metoda nactiHrace vráti seznam hráčů i s jejich hesly v ArrayListu.
     * 
     * @return 
     */
    public ArrayList nactiHrace(){
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
        return seznam;
    }
    public void vyberHrace(){
        ArrayList hraci = new ArrayList();
        hraci=this.nactiHrace();
        System.out.println("Vyberte prosim svuj ucet");
        for (int i = 0; i < hraci.size(); i++) {
        System.out.println((i + 1) + ". " + hraci.get(i));
        }
        System.out.println("Pokud chete vztvo5it novy ucet zvolte 0.");
    }
    public void nastavHeslo(){
        throw new UnsupportedOperationException("Not supported yet.");  
    }
    public void overHeslo(){
        throw new UnsupportedOperationException("Not supported yet.");   
    }
    public void zmenHeslo(){
        throw new UnsupportedOperationException("Not supported yet.");   
    }
    public void zasifrujHeslo(){
         throw new UnsupportedOperationException("Not supported yet.");  
    }
    public void rozsifrujHeslo(){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    
}
