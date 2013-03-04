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
    
    public Slovo(String aj, String cj){
        this.aj=aj;
        this.cj=cj;
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
