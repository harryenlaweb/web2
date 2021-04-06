/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion{
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://190.220.170.30:3306/electiva3?autoReconnect=true&useSSL=false","universidad","grupo1");
            System.out.println("Conexion exitosa...");
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }        
    }
    public Connection getConnection(){
        return con;
    }
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
        
    }
}


  

//public class Conexion {
//    
//    private String USERNAME = "root";
//    private String PASSWORD = "AFfw@9544";
//    private String HOST = "localhost";
//    private String PORT = "3306";
//    private String DATABASE = "registro";
//    private String CLASSNAME = "com.mysql.jdbc.Driver"; // Driver de MYSQL
//    private String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?user=" + USERNAME + "&password=" + PASSWORD + "&useSSL=false";
//    Connection con; //libreria de java para conectarse
//    
//
//    public Conexion() {
//        try {
//            Class.forName(CLASSNAME);
//            con = DriverManager.getConnection(url, USERNAME, PASSWORD);
//            System.out.println("Conexión exitosa..");
//        } catch (ClassNotFoundException e) {
//            System.err.println("ERROR ClassNAME" + e);
//        } catch (SQLException e) {
//            System.err.println("ERROR SQL" + e);
//        }
//    }
//
//    public Connection getConnection() {
//        return con;
//    }
//
//    public static void main(String[] args) {
//        Conexion con = new Conexion();
//    }
//}
