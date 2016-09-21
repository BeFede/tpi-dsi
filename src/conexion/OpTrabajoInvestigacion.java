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
import tpidsi.simposio.EdicionSimposio;
import tpidsi.trabajoinvestigacion.Estado;
import tpidsi.trabajoinvestigacion.HistorialEstado;
import tpidsi.trabajoinvestigacion.TrabajoDeInvestigacion;

/**
 *
 * @author Genaro F
 */
public class OpTrabajoInvestigacion {

    public TrabajoDeInvestigacion buscarTrabajoInvestigacion(int idtrabajo) {
        TrabajoDeInvestigacion trb = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT * FROM trabajoinvestigacion WHERE id=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, idtrabajo);
            rs = ps.executeQuery();

            if (rs.next()) {
                Estado es = OpEstados.getEstado(rs.getInt("estado"));
                HistorialEstado he = new HistorialEstado();
                he.setUltimoEstado(es);
                EdicionSimposio eds = OpSimposio.buscarSimposio(rs.getInt("edicionsimposio"));
                trb = new TrabajoDeInvestigacion(idtrabajo, rs.getString("nombre"), he, eds);
            }

        } catch (SQLException e) {

        }
        return trb;
    }

}
