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
import java.sql.Statement;
import tpidsi.grupoinvestigacion.Facultad;

/**
 *
 * @author Genaro F
 */
public class OpUniversidad {

    private OpInvestigador op = new OpInvestigador();

    public Facultad[] obtenerFacultades() {
        Facultad[] facultades = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT id FROM facultad"; //nombre, universidad 
        PreparedStatement ps3;
        ResultSet rs3;
        int contador = 0, id_f;
        try {
            ps3 = conexion.prepareStatement(qcat);
            rs3 = ps3.executeQuery();
            Conectar cd = new Conectar();
            Statement s = cd.getConection().createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM facultad");
            r.next();
            int size = r.getInt("rowcount");
            r.close();
            if (rs3.next()) {
                facultades = new Facultad[size];
                id_f = rs3.getInt("id");
                facultades[contador] = this.op.buscarFacultad(id_f);

            }
        } catch (SQLException e) {

        }
        return facultades;
    }

}
