/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modele.Action;
import modele.Modele;

/**
 *
 * @author delbiaggionicolas
 */
public class TFObeservable implements Observer{

    private ArrayList lstTf;
    
    public TFObeservable(ArrayList lstTF){
        this.lstTf = lstTF;           
    }
    
    public void update(Observable o, Object arg) {    
        Action act = (Action)arg;
        Modele mod = (Modele)o;
        switch(act.getAction()){
            case Action.ADJONCTION: employeSelected(act.getPos(), mod.getEmploye(act.getPos()));
                                    break;
            case Action.SUPPRESSION:employeDeselected();
                                    break;
            case Action.SELECTION:  employeSelected(act.getPos(),mod.getEmploye(act.getPos()));           
                                    break;
            case Action.DESELECTED: employeDeselected();
                                    break;
        }
    }
    
    public void employeSelected(int indice, Employe emp){
        ArrayList lstAttribut = emp.getAttributeVisible();
        for (int i = 0; i < lstTf.size(); i++) {
            TextField tf = (TextField)lstTf.get(i);
            tf.setText(lstAttribut.get(i)+"");
        }
    }
    
    public void employeDeselected(){
        for (int i = 0; i < lstTf.size(); i++) {
            TextField tf = (TextField)lstTf.get(i);
            tf.setText(" ");tf.setText("");
        }    
    }
    
}
