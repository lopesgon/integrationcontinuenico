package classes;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modele.Action;
import modele.Modele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author delbiaggionicolas
 */
public class ActionOnEmploye implements Observer{
    
    private static String QUERY_LastEmpNO = "select max(NoEmpl)  from Employe;";
    private static String QUERY_READEMPLOYE = "select * from Employe;";
    private static String QUERY_READFONCTION = "select * from fonction;";
    private static String QUERY_READDEPARTEMENT = "select * from departement;";
    private static String QUERY_READLIEU = "select * from lieu;";
    
    Statement sta;
    
    public ActionOnEmploye(){}
    
    public void update(Observable o, Object arg) {
        Action a  = (Action)arg;
        Modele m = (Modele)o; 
        switch(a.getAction()){
            case Action.SUPPRESSION: 
                removeEmploye(m.getEmploye(a.getPos()));  
                break;
            case Action.ADJONCTION:
                insertEmploye(m.getEmploye(a.getPos()));  
                break;
        }
        Bases.closeConnection(Bases.MYSQL);
    }
    
    private void insertEmploye(Employe emp){
        try{
            PreparedStatement p = Bases.connect(Bases.MYSQL).prepareStatement("insert into employe values (?,?,?,?,?,null,?);");
            p.setInt(1, emp.getNoEmpl());
            p.setString(2, emp.getNomEmp());
            p.setString(3, emp.getPrenomEmp());
            p.setInt(4, emp.getFonction().getNo());
            p.setDate(5, emp.getDateEmpl());
            p.setInt(6, emp.getDepartement().getNo());
            p.executeUpdate();
            p.close();
           }catch(SQLException e){
               System.out.println("Requête incorrecte!");
           }catch(Exception e){
               System.out.println("Il y a un problème de type exception");
           }
    }

    private void removeEmploye(Employe emp){
        String query = "delete from Employe where NoEmpl = "+ emp.getNoEmpl() + ";";
        try{        
         sta = Bases.connect(Bases.MYSQL).createStatement(); 
         sta.executeUpdate(query);
         sta.close();
        }
        catch(SQLException e){
            System.out.println("Erreur SQL");
        }catch(Exception e){
            System.out.println("Il y a eu un problème");
        }
    }
    
    public static int getNextEmpNo(Connection con){
      try{
        PreparedStatement p = con.prepareStatement(QUERY_LastEmpNO);
        ResultSet result = p.executeQuery();
        int number = -1;  
        if (result.next()) {
            number = result.getInt(1);
        }
        p.close();
        con.close();          
        return number+1;
      }catch (Exception e){
          System.out.println("Attention il y a une erreur -1 est retourné");
        return -1;
      }
    }
    
    public static ArrayList readEmploye(Connection con,ArrayList lstFonction, ArrayList lstDepartement){
        ArrayList lstEmploye = new ArrayList();
        try{        
            Statement statement = con.createStatement(); 
            ResultSet result = statement.executeQuery(QUERY_READEMPLOYE);
            while(result.next()){
                //Employe
                int empNo = result.getInt("NoEmpl");
                String nomEmpl = result.getString("NomEmpl");
                String prenomEmpl = result.getString("PrenomEmpl");
                int noFonc = result.getInt("NoFonc");
                Date dateEmpl = result.getDate("DateEmpl");
                int noDept = result.getInt("NoDept");
                int noChef = result.getInt("NoChef");
                //Fonction
                Fonction fonc = (Fonction)lstFonction.get(lstFonction.indexOf(new Fonction(noFonc)));                          
                //Departement
                Departement dep = (Departement)lstDepartement.get(lstDepartement.indexOf(new Departement(noDept)));
                //Création de l'employé
                Employe emp = new Employe(empNo, nomEmpl, prenomEmpl, fonc, dateEmpl,noChef, dep);
                lstEmploye.add(emp);   
            }    
            //Ferme la connexion à la base et du statement
            statement.close();
            Bases.closeConnection(Bases.MYSQL);
            return lstEmploye;
        } 
        catch(SQLException e){System.out.println("Requête SQL incorrecte: "+ e.getMessage());} 
        catch(Exception e){System.out.println("Exception: " + e.getMessage() +" problème : " + e.toString());}
        System.out.println("Attention null retourné");
        return null;
    }
    
    public static ArrayList readFonction(Connection con){
        ArrayList lstFonction = new ArrayList();
        try{        
          Statement statement = con.createStatement(); 
          ResultSet result = statement.executeQuery(QUERY_READFONCTION);
          while(result.next()){
              Fonction fonc = new Fonction(result.getInt("NoFonc"),result.getString("NomFonc"));
              lstFonction.add(fonc);
          }
          return lstFonction;
        }catch(SQLException e){
            System.out.println("Problème SQL");
        }
        System.out.println("Attention null est retourné");
        return null;
    }
    
    public static ArrayList readDepartement(Connection con,ArrayList lstLieu){
        ArrayList lstDepartement = new ArrayList();
        try{        
          Statement statement = con.createStatement(); 
          ResultSet result = statement.executeQuery(QUERY_READDEPARTEMENT);
          while(result.next()){
              Lieu lieu = (Lieu)lstLieu.get(lstLieu.indexOf(new Lieu(result.getInt("NoLieu"))));
              Departement dep = new Departement(result.getInt("NoDept"),result.getString("NomDept"),lieu);
              lstDepartement.add(dep);
          }
          return lstDepartement;
        }catch(SQLException e){
            System.out.println("Problème SQL");
        }
        System.out.println("Attention null est retourné");
        return null;       
    }
    
    public static ArrayList readLieu(Connection con){
        ArrayList lstLieu = new ArrayList();
        try{        
          Statement statement = con.createStatement(); 
          ResultSet result = statement.executeQuery(QUERY_READLIEU);
          while(result.next()){
              Lieu lieu = new Lieu(result.getInt("NoLieu"),result.getString("NomLieu"));
              lstLieu.add(lieu);
          }
          return lstLieu;
        }catch(SQLException e){
            System.out.println("Problème SQL");
        }
        System.out.println("Attention null est retourné");
        return null;         
    }
}
