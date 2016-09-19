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
class Conexiones {

    private final String archivo = "src/conexion/tpidsi.db";
    private Connection conexion = null;
    private Statement consulta = null;
    private static Conexiones instancia;
    
    public static Conexiones getConexion(){
       if(instancia == null){
            instancia = new Conexiones();
        }
        return instancia;
    }

    public Statement conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            if(conexion != null && !conexion.isClosed()){cerrar();}
            conexion = DriverManager.getConnection("jdbc:sqlite:" + this.archivo);
            conexion.setAutoCommit(false);
            consulta = conexion.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC no encontrado");
        } catch (SQLException e) {
            System.out.println("Error al abrir la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return consulta;
    }

    public void cerrar() {
        try {
            consulta.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }

}
