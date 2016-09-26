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
import tpidsi.investigador.Evaluador;
import tpidsi.investigador.Investigador;
import tpidsi.simposio.EdicionSimposio;
import tpidsi.trabajoinvestigacion.Autor;
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
                HistorialEstado he = new HistorialEstado(OpEstados.getEstado(rs.getInt("estado")));
                EdicionSimposio eds = OpSimposio.buscarSimposio(rs.getInt("edicionsimposio"));
                trb = new TrabajoDeInvestigacion(idtrabajo, rs.getString("nombre"), he, eds);
            }

        } catch (SQLException e) {

        }
        return trb;
    }

    private Investigador obtenerInvestigador(int id) {
        Ingresar in = new Ingresar();

        Investigador e = in.getInvestigadorPorId(id);
        return e;
    }
    
    public Evaluador obtenerEvaluador(int id_evaluador){
        Evaluador rtn = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT id_investigador FROM evaluador WHERE id=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, id_evaluador);
            rs = ps.executeQuery();
            if (rs.next()) {
                rtn = new Evaluador(obtenerInvestigador(rs.getInt("id_investigador")),id_evaluador);
            }
        } catch (SQLException e) {

        }
        return rtn;
    }

    public Investigador obtenerInvestigadorEvaluador(int id_evaluador) {
        Investigador rtn = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT id_investigador FROM evaluador WHERE id=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, id_evaluador);
            rs = ps.executeQuery();
            if (rs.next()) {
                rtn = obtenerInvestigador(rs.getInt("id_investigador"));
            }
        } catch (SQLException e) {

        }
        return rtn;
    }

    public Evaluador[] obtenerEvaluadorTrabajo(int idTrabajo) {
        Evaluador[] rtn = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT evaluador FROM evaluadoresxtrabajo WHERE trabajodeinvestigacion=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, idTrabajo);
            rs = ps.executeQuery();
            Evaluador n;
            int contador = 0, id_evaluador;
            if (rs.next()) {
                rtn = new Evaluador[rs.getRow()];
                id_evaluador = rs.getInt("evaluador");
                n = new Evaluador(obtenerInvestigadorEvaluador(id_evaluador), id_evaluador);
                rtn[contador] = n;
                contador++;
                while (rs.next()) {
                    id_evaluador = rs.getInt("evaluador");
                    n = new Evaluador(obtenerInvestigadorEvaluador(id_evaluador), id_evaluador);
                    rtn[contador] = n;
                    contador++;
                }
            }

        } catch (SQLException e) {

        }
        return rtn;
    }
    
    public Investigador obtenerInvestigadorAutor(int id_autor){
         Investigador rtn = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT id_investigador FROM autor WHERE id=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, id_autor);
            rs = ps.executeQuery();
            if (rs.next()) {
                rtn = obtenerInvestigador(rs.getInt("id_investigador"));
            }
        } catch (SQLException e) {

        }
        return rtn;
    }
    
    public Autor[] obtenerAutorTrabajo(int idTrabajo) {
        Autor[] rtn = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT autor FROM autoresxtrabajo WHERE trabajodeinvestigacion=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(qcat);
            ps.setInt(1, idTrabajo);
            rs = ps.executeQuery();
            Autor n;
            int contador = 0, id_autor;
            if (rs.next()) {
                rtn = new Autor[rs.getRow()];
                id_autor = rs.getInt("autor");
                n = new Autor(obtenerInvestigadorAutor(id_autor), id_autor);
                rtn[contador] = n;
                contador++;
                while (rs.next()) {
                    id_autor = rs.getInt("autor");
                    n = new Autor(obtenerInvestigadorAutor(id_autor), id_autor);
                    rtn[contador] = n;
                    contador++;
                }
            }

        } catch (SQLException e) {

        }
        return rtn;
    }

}
