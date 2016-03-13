package classes;

import java.sql.Connection;

public class Bases {
    
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    
    public static Connection connect(int noBase)throws Exception{
        switch(noBase){
            case MYSQL: return mysql.Outils.connect("EmplDept");
            case ORACLE: System.out.println("La connexion n'est pas disponible pour le moment!");
                         break;
        }
        System.out.println("Attention un pointeur null est retourné car aucune base ne correspond");
        return null;
    }
    
    public static void closeConnection(int noBase){
        try{
            Bases.connect(noBase).close();
        }catch(Exception e){
            System.out.println("Problème d'exception");
        }
    }   
}
