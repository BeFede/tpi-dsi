/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tpidsi.trabajoinvestigacion.HistorialEstado;

/**
 *
 * @author Genaro F
 */
public class OpHistorialEstados {

    public boolean guardarHistorial(HistorialEstado he, int idtrabajo) {
        boolean guardo = true;

        String fecha = he.getFecha().toString();
        int idestado = he.getEstado().getId();

        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "INSER INTO historialestado (estado, trabajoinvestigacion, fecha)"
                + " VALUES estado=? AND trabajoinvestigacion=? AND fecha=? ";
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, idestado);
            ps.setInt(2, idtrabajo);
            ps.setString(3, fecha);
            ps.executeUpdate();
            conexion.commit();

            conexion.close();
        } catch (SQLException e) {
            guardo = false;
        }
        return guardo;
    }

}
