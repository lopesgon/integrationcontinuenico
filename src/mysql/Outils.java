package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Outils {

  /** Retourne une connexion avec une base de données MySQL. */
  public static Connection connect (String nomBase) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver"); //Charge le driver
    Properties props = new Properties();
    props.put("user", "root"); props.put("password", ""); props.put("charSet", "UTF-8");// Défini les paramètres de connexions
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomBase, props);// Etabli une connexion à la bas MySQL
    //3306
  } // connect

} // Outils