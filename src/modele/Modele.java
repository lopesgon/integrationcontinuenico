package modele;

import classes.Employe;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author delbiaggionicolas
 */
public class Modele extends Observable{
    //ArrayListe
    ArrayList listeEmploye;
    
    //Constructeur
    public Modele(){listeEmploye = new ArrayList();}
    
    public void selectEmploye(int indice){ 
        super.setChanged();
        if(indice != -1){
            notifyObservers(new Action(Action.SELECTION, indice));
        }else{
            notifyObservers(new Action(Action.DESELECTED, indice));
        }
    }
    
    public void selectEmploye(Employe emp){ 
        super.setChanged();
        int indice = listeEmploye.indexOf(emp);
        if(indice != -1){
            System.out.println("Selection");
            notifyObservers(new Action(Action.SELECTION, indice));
        }else{
            System.out.println("Deselection");
            notifyObservers(new Action(Action.DESELECTED, indice));
        }
    }
    
    //Ajouter un employe
    public void addEmploye(Employe emp){
        int indice = placeAnElement(listeEmploye, emp);
        listeEmploye.add(indice, emp);
        setChanged();
        notifyObservers(new Action(Action.ADJONCTION, indice ));
    }
    
    public void readEmploye(Employe emp){
        int indice = placeAnElement(listeEmploye, emp);
        listeEmploye.add(indice, emp);
        setChanged();
        notifyObservers(new Action(Action.READ, indice ));        
    }
    
    public void readEmploye(ArrayList lstEmploye){
        for (int i = 0; i < lstEmploye.size(); i++) {
            Employe emp = (Employe)lstEmploye.get(i);
            int indice = placeAnElement(this.listeEmploye, emp);
            this.listeEmploye.add(indice, emp);
            setChanged();
            notifyObservers(new Action(Action.READ, indice)); 
        }
    }
    
    //Retourne l'employe en fonction de l'indice reçu en paramètre
    public Employe getEmploye(int indice){return (Employe)listeEmploye.get(indice);}
    
    //Supprimer un employé
    public void removeEmploye(int indice){        
        setChanged();
        notifyObservers(new Action(Action.SUPPRESSION,indice));
        listeEmploye.remove(indice);
    }
    
    public void removeEmploye(Employe emp){
        int indice = listeEmploye.indexOf(emp);
        setChanged();
        notifyObservers(new Action(Action.SUPPRESSION,indice));        
        listeEmploye.remove(indice);
    }
    
    private int placeAnElement(ArrayList tab,Employe e){
        if (tab.isEmpty()) {
            return 0;
        }
        if (((Employe)tab.get(0)).compareTo(e)>0) {
            return 0;
        }
        else if (((Employe)tab.get(tab.size()-1)).compareTo(e)<=0) {
            return tab.size();
        }
        else{
            int g = 0;
            int d = tab.size()-1;
            while (g+1<d) { //g <= p <d
              int m = (g+d)/2;
              Employe comp = (Employe)tab.get(m);
              if (comp.compareTo(e)<=0) { 
                g = m;
              }
              else{
                d = m;
              }
            }
            return d;
        }    
    }
    
    public void showEmploye(){
        for (int i = 0; i < listeEmploye.size(); i++) {
            Employe emp = (Employe)listeEmploye.get(i);
            System.out.println(emp);
        }
    }     
}   
