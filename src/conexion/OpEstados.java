/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tpidsi.trabajoinvestigacion.Estado;
import tpidsi.state.*;

/**
 *
 * @author Genaro F
 */
public class OpEstados {
    
    static public Estado getEstado(int id){
        Estado est;
        switch(id){
            case 1: est= new Aceptado();break;
            case 2: est= new Anulado();break;
            case 3: est= new Cancelado();break;
            case 4: est= new EvaluacionInicial();break;
            case 5: est= new Pendiente();break;
            case 6: est= new PendienteEvaluacionChair();break;
            case 7: est= new PendientePrimeraEvaluacion();break;
            case 8: est= new Publicado();break;
            case 9: est= new Rechazado();break;
            case 10: est= new SujetoACorrecciones();break;
            default: est = null;
        }
        return est;
    }
    
    static public String getNombreEstado(int id){
        String state = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String q = "SELECT nombre FROM estado WHERE estado=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(q);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                state = rs.getString("nombre");
            }
            
        }catch(SQLException e){
            System.out.println("Error en la consulta: "+e.getMessage());
        }
        return state;
    }
    
    static public String getDescripcionEstado(int id){
        String state = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String q = "SELECT descripcion FROM estado WHERE estado=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(q);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                state = rs.getString("descripcion");
            }
            
        }catch(SQLException e){
            System.out.println("Error en la consulta: "+e.getMessage());
        }
        return state;
    }
}
