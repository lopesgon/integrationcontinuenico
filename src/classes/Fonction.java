package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author delbiaggionicolas
 */
public class Fonction {
    private int noFonc;
    private String nomFonc;
    
    public Fonction(int noFonc, String nomFonc){
        this.noFonc = noFonc;
        this.nomFonc = nomFonc;
    }
    
    public Fonction(int noFonc){
        this.noFonc = noFonc;
    }
    
    public int getNo(){return this.noFonc;}
    public String getNom(){return this.nomFonc;}
    
    public boolean equals(Object o){
        if (!(o instanceof Fonction)) {
            return false;
        }
        if (this.getNo() == ((Fonction)o).getNo()) {
            return true;
        }
        return false;        
    }
    
    public String toString(){
        return this.nomFonc;
    }
}
