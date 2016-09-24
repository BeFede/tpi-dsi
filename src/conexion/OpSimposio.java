/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tpidsi.simposio.EdicionSimposio;

/**
 *
 * @author Genaro F
 */
public class OpSimposio {
    static public EdicionSimposio buscarSimposio(int id){
        EdicionSimposio eds=null;
        Conectar conectar = new Conectar();
        Connection conexion = conectar.getConection();
        PreparedStatement ps;
        ResultSet rs;
        String q = "SELECT * FROM edicionsimposio WHERE id=?";
        try {
            ps = conexion.prepareStatement(q);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                eds= new EdicionSimposio(rs.getString("nombre"),rs.getString("fecha"), id);
            }
            
        } catch (SQLException e) {
        }
        
        
        return eds;
    }
    
    static public boolean agregarChair(int id_simposio, int id_chair){
        boolean guardo = true;

        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "INSER INTO chairxedicionsimposio (simposio, chair)"
                + " VALUES simposio=? AND chair=? ";
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, id_simposio);
            ps.setInt(2, id_chair);
            ps.executeUpdate();
            conexion.commit();

            conexion.close();
        } catch (SQLException e) {
            guardo = false;
        }
        return guardo;
    }
    
    static public boolean agregarEvaluador(int id_simposio, int id_evaluador){
        boolean guardo = true;

        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "INSER INTO evaluadorxedicionsimposio (simposio, evaluador)"
                + " VALUES simposio=? AND evaluador=? ";
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, id_simposio);
            ps.setInt(2, id_evaluador);
            ps.executeUpdate();
            conexion.commit();

            conexion.close();
        } catch (SQLException e) {
            guardo = false;
        }
        return guardo;
    }
        
}
