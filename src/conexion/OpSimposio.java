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
                eds= new EdicionSimposio(rs.getString("nombre"),rs.getString("fecha"));
            }
            
        } catch (SQLException e) {
        }
        
        
        return eds;
    }
}
