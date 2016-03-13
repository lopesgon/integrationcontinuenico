package modele;

/**
 * Action effectuée sur le modèle
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version 1.0
*/
public class Action {
  
  /* Les action possibles */
  public static final int SELECTION = 1, ADJONCTION = 2, SUPPRESSION = 3, MODIFICATION = 4, READ = 5,DESELECTED = 6;
  
  private int action; /* L'action: une des valeurs ci-dessus */
  private int pos;    /* La position concernée */
  
  public Action (int action, int pos) {this.action = action; this.pos = pos;}
  
  public int getAction () {return action;}
  public int getPos () {return pos;}

} // Action