package classes;


import java.sql.Date;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author delbiaggionicolas
 */
public class Employe {
    private int noEmpl;
    private String nomEmp;
    private String prenomEmp;
    private Fonction fonction;
    private Date dateEmpl;
    private int noChef;
    private Departement departement;
    
    //Getteur
    public int getNoEmpl(){return this.noEmpl;}
    public String getNomEmp(){return this.nomEmp;}
    public String getPrenomEmp(){return this.prenomEmp;}
    public Fonction getFonction(){return this.fonction;}
    public Date getDateEmpl(){return this.dateEmpl;}
    public Departement getDepartement(){return this.departement;}
    
    public Employe(int noEmpl, String nomEmp, String prenomEmp, Fonction fonction, Date dateEmpl, int noChef,Departement departement){
        this.noEmpl = noEmpl;
        this.nomEmp = nomEmp;
        this.prenomEmp = prenomEmp;
        this.fonction = fonction;
        this.dateEmpl = dateEmpl;
        this.noChef = noChef;
        this.departement = departement;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof Employe)) {return false;}
        return this.getNoEmpl() == ((Employe)obj).getNoEmpl();
    }
        
    public int compareTo(Object obj){
        Employe emp = (Employe)obj;
        if (this.nomEmp.compareTo(emp.getNomEmp())<0) {
            return -1;
        }else if (this.nomEmp.compareTo(emp.getNomEmp())>0) {
            return 1;
        }else if (this.prenomEmp.compareTo(emp.getPrenomEmp())<0) {
            return -1;
        }else if (this.prenomEmp.compareTo(emp.getPrenomEmp())<0) {
            return 1;
        }else if (this.equals(emp)){
            return 0;
        }else if (this.getNoEmpl()>=emp.getNoEmpl()) {
            return 1;
        }else{
            return -1;
        }
    }
    
    //retourne un arrayList avec les attributs suivants dans l'ordre: nom,prenom,date,nom fonction, nom departement, nom lieu
    public ArrayList getAttributeVisible(){
        ArrayList lstAttribut = new ArrayList();
        lstAttribut.add(this.nomEmp);
        lstAttribut.add(this.prenomEmp);
        lstAttribut.add(this.dateEmpl);
        lstAttribut.add(this.fonction.getNom());
        lstAttribut.add(this.departement.getNom());
        lstAttribut.add(this.departement.getLieu());
        return lstAttribut;
    }
    
    public String toString(){
        return this. nomEmp + " " + this.prenomEmp;
    }
}
