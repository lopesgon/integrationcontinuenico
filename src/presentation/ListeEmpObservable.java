/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.Observable;
import java.util.Observer;
import modele.Action;
import modele.Modele;

/**
 *
 * @author delbiaggionicolas
 */
public class ListeEmpObservable implements Observer{

    private java.awt.List liste;
    
    public ListeEmpObservable(java.awt.List liste){
        this.liste = liste;
    }
    
    public void update(Observable o, Object arg) {
        Action act = (Action)arg;
        Modele mod = (Modele)o;
        switch(act.getAction()){
            case Action.ADJONCTION: liste.add(mod.getEmploye(act.getPos()).toString(), act.getPos());
                                    liste.select(act.getPos());            
                                    break;
            case Action.READ:       liste.add(mod.getEmploye(act.getPos()).toString(), act.getPos());
                                    break;
            case Action.SUPPRESSION:liste.remove(act.getPos());
                                    break;
            case Action.SELECTION:  liste.select(act.getPos());            
                                    break;
            case Action.DESELECTED: liste.select(act.getPos());
                                    break;
        }
    }
    



    
}
