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
import java.sql.Statement;
import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
import tpidsi.simposio.EdicionSimposio;

/**
 *
 * @author Genaro F
 */
public class OpSimposio {

    static public EdicionSimposio buscarSimposioChair(int id_chair) {
        EdicionSimposio eds1 = null;
        Conectar conectar = new Conectar();
        Connection conexion = conectar.getConection();
        PreparedStatement ps1;
        ResultSet rs1;
        String q1 = "SELECT simposio FROM chairxedicionsimposio WHERE chair=?";
        try {
            ps1 = conexion.prepareStatement(q1);
            ps1.setInt(1, id_chair);
            rs1 = ps1.executeQuery();

            if (rs1.next()) {
                int idS = rs1.getInt("simposio");
                eds1 = buscarSimposio(idS);
            }

        } catch (SQLException e) {
        }

        return eds1;
    }

    static public EdicionSimposio buscarSimposio(int id_simposio) {
        EdicionSimposio eds = null;
        Conectar conectar = new Conectar();
        Connection conexion = conectar.getConection();
        PreparedStatement ps;
        ResultSet rs;
        String q = "SELECT * FROM edicionsimposio WHERE id=?";
        try {
            ps = conexion.prepareStatement(q);
            ps.setInt(1, id_simposio);
            rs = ps.executeQuery();

            if (rs.next()) {
                eds = new EdicionSimposio(rs.getString("nombre"), rs.getString("fecha"), id_simposio);
            }

        } catch (SQLException e) {
        }

        return eds;
    }

    static public Chair[] conocerChairs() {
        Chair[] eds = null;
        Conectar conectar = new Conectar();
        Connection conexion = conectar.getConection();
        PreparedStatement ps;
        ResultSet rs;
        String q = "SELECT * FROM chair";
        try {
            ps = conexion.prepareStatement(q);
            rs = ps.executeQuery();
            int idChair, idInvestigador, contador = 0;
            Chair nC;
            Conectar cd = new Conectar();
            Statement s = cd.getConection().createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM chair"); 
            r.next();
            int size = r.getInt("rowcount");
            r.close();
            if (rs.next()) {
                eds = new Chair[size];
                idChair = rs.getInt("id");
                idInvestigador = rs.getInt("id_investigador");
                nC = new Chair(OpInvestigador.obtenerInvestigador(idInvestigador), idChair);
                eds[contador] = nC;
                contador++;
                while (rs.next()) {
                    idChair = rs.getInt("id");
                    idInvestigador = rs.getInt("id_investigador");
                    nC = new Chair(OpInvestigador.obtenerInvestigador(idInvestigador), idChair);
                    eds[contador] = nC;
                    contador++;
                }
            }

        } catch (SQLException e) {
        }

        return eds;
    }

    static public Evaluador[] conocerEvaluadores() {
        Evaluador[] eds = null;
        Conectar conectar = new Conectar();
        Connection conexion = conectar.getConection();
        PreparedStatement ps;
        ResultSet rs;
        String q = "SELECT * FROM evaluador";
        try {
            ps = conexion.prepareStatement(q);
            rs = ps.executeQuery();
            int idChair, idInvestigador, contador = 0;
            Evaluador nC;
            Conectar cd = new Conectar();
            Statement s = cd.getConection().createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM evaluador");
            r.next();
            int size = r.getInt("rowcount");
            r.close();
            if (rs.next()) {
                eds = new Evaluador[size];
                idChair = rs.getInt("id");
                idInvestigador = rs.getInt("id_investigador");
                nC = new Evaluador(OpInvestigador.obtenerInvestigador(idInvestigador), idChair);
                eds[contador] = nC;
                contador++;
                while (rs.next()) {
                    idChair = rs.getInt("id");
                    idInvestigador = rs.getInt("id_investigador");
                    nC = new Evaluador(OpInvestigador.obtenerInvestigador(idInvestigador), idChair);
                    eds[contador] = nC;
                    contador++;
                }
            }

        } catch (SQLException e) {
        }

        return eds;
    }

    static public boolean agregarChair(int id_simposio, int id_chair) {
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

    static public boolean agregarEvaluador(int id_simposio, int id_evaluador) {
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
