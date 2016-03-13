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
public class Lieu {
    private int noLieu;
    private String nomLieu;
    
    //Constructeur
    public Lieu(int noLieu, String nomLieu){
        this.noLieu = noLieu;
        this.nomLieu = nomLieu;
    }
    
    public Lieu(int noLieu){
        this.noLieu = noLieu;
    }
    
    public int getNo(){return this.noLieu;}
    public String getNom(){return this.nomLieu;}
    
    public boolean equals(Object o){
        if (!(o instanceof Lieu)) {
            return false;
        }
        if (this.getNo() == ((Lieu)o).getNo()) {
            return true;
        }
        return false;        
    }
    
    public String toString(){
        return this.nomLieu;
    }
}
