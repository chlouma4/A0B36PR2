/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

/**
 * 
 * @author Marco
 */
public class Slovo {
   private String aj;
    private String cj;
    private  int  pocetSpravnychOdpovedi;
    private int    pocetSpatnychOdpovedi;
    private String IDSlova;
    private int aktivita;

    
        public Slovo(String aj, String cj, int pocetSpravnychOdpovedi, int pocetSpatnychOdpovedi, String IDSlova, int aktivita){
        this.aj=aj;
        this.cj=cj;
        this.pocetSpatnychOdpovedi=pocetSpatnychOdpovedi;
        this.pocetSpravnychOdpovedi=pocetSpravnychOdpovedi;
        this.IDSlova=IDSlova;
        this.aktivita=aktivita;

    }   


    public int getPocetSpravnychOdpovedi() {
        return pocetSpravnychOdpovedi;
    }

    public void setPocetSpravnychOdpovedi(int pocetSpravnychOdpovedi) {
        this.pocetSpravnychOdpovedi = pocetSpravnychOdpovedi;
    }

    public int getPocetSpatnychOdpovedi() {
        return pocetSpatnychOdpovedi;
    }

    public void setPocetSpatnychOdpovedi(int pocetSpatnychOdpovedi) {
        this.pocetSpatnychOdpovedi = pocetSpatnychOdpovedi;
    }
    

    public String getAj() {
        return aj;
    }

    public void setAj(String aj) {
        this.aj = aj;
    }

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
    }

    public String getIDSlova() {
        return IDSlova;
    }

    public void setIDSlova(String IDSlova) {
        this.IDSlova = IDSlova;
    }

    public int getAktivita() {
        return aktivita;
    }

    public void setAktivita(int aktivita) {
        this.aktivita = aktivita;
    }

    
    

    @Override
    public  String toString(){
        String format =getAj()+" přeloženo do češtiny "+getCj();
        return format;
    
}  
}
