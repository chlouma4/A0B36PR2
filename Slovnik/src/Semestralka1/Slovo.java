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
    
        public Slovo(String aj, String cj, int pocetSpravnychOdpovedi, int pocetSpatnychOdpovedi){
        this.aj=aj;
        this.cj=cj;
        this.pocetSpatnychOdpovedi=pocetSpatnychOdpovedi;
        this.pocetSpravnychOdpovedi=pocetSpravnychOdpovedi;
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

    @Override
    public  String toString(){
        String format =getAj()+" prelozeno do cestiny "+getCj();
        return format;
    
}  
}
