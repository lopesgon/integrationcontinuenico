/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Button;
import java.util.Observable;
import java.util.Observer;
import modele.Action;
import modele.Modele;

/**
 *
 * @author delbiaggionicolas
 */
public class ButtonObservable implements Observer{

    private Button btn;
    
    public ButtonObservable(Button btn){
        this.btn = btn;
    }
    
    public void update(Observable o, Object arg) {
        Action act = (Action)arg;
        switch(act.getAction()){
            case Action.ADJONCTION: btn.setEnabled(true);
                                    break;
            case Action.SUPPRESSION:btn.setEnabled(false);
                                    break;
            case Action.SELECTION:  btn.setEnabled(true);
           
                                    break;
            case Action.DESELECTED: btn.setEnabled(false);
                                    break;
        }
    }   
}
