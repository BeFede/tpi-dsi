/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;

/**
 *
 * @author Genaro F
 */
 class Conectar {
     
     private String file = "src/conexion/tpidb.db";
     private Connection conexion = null;
     
     public Connection getConection(){
         try {
             Class.forName("org.sqlite.JDBC");
             
             if(conexion != null && !conexion.isClosed()) conexion.close();             
             conexion = DriverManager.getConnection("jdbc:sqlite:"+file);
             conexion.setAutoCommit(false);
         } catch (SQLException e) {
             System.out.println("Error con sql");
         } catch(ClassNotFoundException e){
             System.out.println("Error al cargar la clase");
         }
         return conexion;
     }
     
     public void close(){
         try {
             conexion.close();
         } catch (Exception e) {
             
         }
     }
    
}
