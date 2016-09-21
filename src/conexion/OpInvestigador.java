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
import tpidsi.grupoinvestigacion.*;

/**
 *
 * @author Genaro F
 */
public class OpInvestigador {
    
    private Universidad buscarUniversidad(int uni){
        Universidad univ = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT nombre FROM universidad WHERE id=?";
        PreparedStatement ps4;
        ResultSet rs4;
        try {
            ps4 = conexion.prepareStatement(qcat);
            ps4.setInt(1, uni);
            rs4 = ps4.executeQuery();

            if (rs4.next()) {
                String nombre = rs4.getString("nombre");
                univ = new Universidad(nombre);

            }
        } catch (SQLException e) {

        }
        return univ;
    }
    
    private Facultad buscarFacultad(int facu){
        Facultad facul = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT nombre, universidad FROM facultad WHERE id=?";
        PreparedStatement ps3;
        ResultSet rs3;
        try {
            ps3 = conexion.prepareStatement(qcat);
            ps3.setInt(1, facu);
            rs3 = ps3.executeQuery();

            if (rs3.next()) {
                String nombre = rs3.getString("nombre");
                int idf= rs3.getInt("universidad");
                facul = new Facultad(nombre, buscarUniversidad(idf));

            }
        } catch (SQLException e) {

        }
        return facul;
        
    }

    private CentroDeInvestigacion buscarCentro(int centro) {
        CentroDeInvestigacion cent = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT nombre, facultad FROM centroinvestigacion WHERE id=?";
        PreparedStatement ps2;
        ResultSet rs2;
        try {
            ps2 = conexion.prepareStatement(qcat);
            ps2.setInt(1, centro);
            rs2 = ps2.executeQuery();

            if (rs2.next()) {
                String nombre = rs2.getString("nombre");
                int idf= rs2.getInt("facultad");
                cent = new CentroDeInvestigacion(nombre, buscarFacultad(idf));

            }
        } catch (SQLException e) {

        }
        return cent;
    }

    private GrupodeInvestigacion buscarGrupo(int idgrupo) {
        GrupodeInvestigacion gdi1 = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT nombre, centroinvestigacion FROM grupoinvestigacion WHERE id=?";
        PreparedStatement ps1;
        ResultSet rs1;
        try {
            ps1 = conexion.prepareStatement(qcat);
            ps1.setInt(1, idgrupo);
            rs1 = ps1.executeQuery();

            if (rs1.next()) {
                String nombre = rs1.getString("nombre");
                int idcen = rs1.getInt("grupoinvestigacion");
                gdi1 = new GrupodeInvestigacion(nombre, buscarCentro(idcen));
            }
        } catch (SQLException e) {

        }
        return gdi1;

    }

    public GrupodeInvestigacion getGrupoInvestigacion(int idinvestigador) {
        GrupodeInvestigacion gdi = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT grupoinvestigacion FROM investigador WHERE id=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, idinvestigador);
            rs = ps.executeQuery();

            if (rs.next()) {
                int idgr = rs.getInt("grupoinvestigacion");

            }
        } catch (SQLException e) {

        }
        return gdi;
    }

}
