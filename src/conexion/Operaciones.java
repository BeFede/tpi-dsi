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
public class Operaciones {

    Conexiones conexion = Conexiones.getConexion();

    public ResultSet select(String query) {
        Statement consulta = conexion.conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error al ejectutar la sentencia: "+e.getMessage());
        } finally {
            conexion.cerrar();
        }
        return resultado;
    }

    public boolean insertar(String query) {
        boolean valor = true;
        Statement consulta = conexion.conectar();
        try {
            consulta.executeUpdate(query);
        } catch (SQLException e) {
            valor = false;
            System.out.println("Error al ejectutar la sentencia: "+e.getMessage());

        } finally {
            conexion.cerrar();
        }
        return valor;
    }

}
