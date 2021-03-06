package presentation;

import classes.ActionOnEmploye;
import classes.Bases;
import classes.Departement;
import classes.Employe;
import classes.Fonction;
import java.awt.Color;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * 634.1 Programmation - TP P01
 * 
 * Fenêtre de saisie d'un nouvel employé:
 * - Singleton
 * 
 * @author Delbiaggio Nicolas
 * @version 1.0
 */
public class FrmNouveau extends java.awt.Frame {
  
  private static FrmNouveau currentInstance = null;
  private FrmMain parent;  
  
  private static final String format = "dd-MM-yyyy";
  
  /* Constructeur */
  private FrmNouveau (FrmMain parent) {
    initComponents();
    this.parent = parent;
    loadDep();
    loadFunc();
    this.validate();    
  } // Constructeur
  
  public static FrmNouveau getInstance(FrmMain parent){
      if (currentInstance == null) {
          currentInstance = new FrmNouveau(parent);
      }
      return currentInstance;
  }
  
  public void loadDep(){      
      chDepartements.removeAll();      
      ArrayList listeDep = this.parent.getListeDepartement();
      for (int i = 0; i < listeDep.size(); i++) {
         chDepartements.addItem(listeDep.get(i).toString());
      }
  }
  
  public void loadFunc(){
      chFonctions.removeAll();
      ArrayList listeFunc = this.parent.getListeFonction();
      for (int i = 0; i < listeFunc.size(); i++) {
         chFonctions.addItem(listeFunc.get(i).toString());
      }
  }
  
  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        java.awt.Label label1 = new java.awt.Label();
        tfNom = new java.awt.TextField();
        java.awt.Label label2 = new java.awt.Label();
        tfPrenom = new java.awt.TextField();
        lblDateEngagement = new java.awt.Label();
        tfDateEngagement = new java.awt.TextField();
        java.awt.Label label4 = new java.awt.Label();
        chFonctions = new java.awt.Choice();
        java.awt.Label label5 = new java.awt.Label();
        chDepartements = new java.awt.Choice();
        btnEnregistrer = new java.awt.Button();

        setResizable(false);
        setTitle("Saisie d'un employé");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        label1.setText("Nom");

        tfNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKeyReleased(evt);
            }
        });

        label2.setText("Prénom");

        tfPrenom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKeyReleased(evt);
            }
        });

        lblDateEngagement.setText("Date d'engagement");

        tfDateEngagement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKeyReleased(evt);
            }
        });

        label4.setText("Fonction");

        label5.setText("Département");

        btnEnregistrer.setEnabled(false);
        btnEnregistrer.setLabel("Enregistrer");
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNom, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(tfPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateEngagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDateEngagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chFonctions, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(chDepartements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDateEngagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDateEngagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chFonctions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chDepartements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btnEnregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed
        String nom = tfNom.getText().trim();
        String prenom = tfPrenom.getText().trim();
        SimpleDateFormat simpDF = new SimpleDateFormat(format);
        java.sql.Date d;
        try{
            d = new Date(simpDF.parse(tfDateEngagement.getText().trim()).getTime());
            Departement depNo = (Departement)this.parent.getListeDepartement().get(chDepartements.getSelectedIndex());
            Fonction fonc = (Fonction)this.parent.getListeFonction().get(chFonctions.getSelectedIndex());
            Employe emp = new Employe(ActionOnEmploye.getNextEmpNo(Bases.connect(Bases.MYSQL)), nom, prenom, fonc, d,-1, depNo);
            //Ajout du nouvel employe
            this.parent.getModel().addEmploye(emp);
            setInitialState();
            btnEnregistrer.setEnabled(false);
        }catch (ParseException e){System.out.println("Problème de parse");}
        catch(Exception e){System.out.println("Problèem d'exception");}
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    private void tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKeyReleased
        if(tfDateEngagement.getText().isEmpty()){
            btnEnregistrer.setEnabled(false);
        }else if(!isDateValid(tfDateEngagement.getText().trim(),this.format)){
            tfDateEngagement.setForeground(Color.RED);
            btnEnregistrer.setEnabled(false);
        }else if(tfNom.getText().trim().isEmpty() || tfPrenom.getText().trim().isEmpty()){
            btnEnregistrer.setEnabled(false);
        }else{
            btnEnregistrer.setEnabled(true);
            tfDateEngagement.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_tfKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private boolean isDateValid(String date,String format){
        if (date.length()>10) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try{
            dateFormat.parse(date); 
            SimpleDateFormat simpDF = new SimpleDateFormat(format);
            java.sql.Date d = new Date(simpDF.parse(tfDateEngagement.getText().trim()).getTime());
            if (d.before(new java.sql.Date(new java.util.Date().getTime()) )) {
                return true;
            }
            return false;
        }catch(ParseException e){
            return false;
        }
    }
    
    private void setInitialState(){
        tfDateEngagement.setText(" ");tfDateEngagement.setText("");
        tfNom.setText(" ");tfNom.setText("");
        tfPrenom.setText(" ");tfPrenom.setText("");
        chDepartements.select(0);
        chFonctions.select(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnEnregistrer;
    private java.awt.Choice chDepartements;
    private java.awt.Choice chFonctions;
    private java.awt.Label lblDateEngagement;
    private java.awt.TextField tfDateEngagement;
    private java.awt.TextField tfNom;
    private java.awt.TextField tfPrenom;
    // End of variables declaration//GEN-END:variables

} // FrmNouveau
