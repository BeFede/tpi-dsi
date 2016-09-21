/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;
import tpidsi.investigador.*;
import tpidsi.titulos.*;

/**
 *
 * @author Genaro F
 */
public class Ingresar {

    private TipoTitulo getTipoTitulo(int idtipo) {
        TipoTitulo tipt = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qtipt = "SELECT nombre FROM tipotitulo WHERE id=?";
        PreparedStatement pstipt;
        ResultSet rstipt;
        try {
            pstipt = conexion.prepareStatement(qtipt);
            pstipt.setInt(1, idtipo);
            rstipt = pstipt.executeQuery();

            if (rstipt.next()) {
                String nombre = rstipt.getString("nombre");
                tipt = new TipoTitulo(nombre);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al crear el tipo de titulo: " + e.getMessage());
        }
        return tipt;
    }

    private Titulo getTitulo(int idtitulo) {
        Titulo tit = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qtit = "SELECT nombre, tipotitulo FROM titulo WHERE id=?";
        PreparedStatement pstit;
        ResultSet rstit;
        try {
            pstit = conexion.prepareStatement(qtit);
            pstit.setInt(1, idtitulo);
            rstit = pstit.executeQuery();

            if (rstit.next()) {
                String nombre = rstit.getString("nombre");
                int idtipo = rstit.getInt("tipotitulo");

                TipoTitulo tiptmp = getTipoTitulo(idtipo);
                tit = new Titulo(nombre, tiptmp);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al crear el titulo: " + e.getMessage());
        }
        return tit;
    }

    private TituloObtenido[] getTituloObtenido(int idinvestigador) {
        TituloObtenido[] titob = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qtitob = "SELECT titulo, fechaobtencion FROM tituloxinvestigador WHERE investigador=?";
        PreparedStatement pstitob;
        ResultSet rstitob;

        int i = 0;
        try {
            pstitob = conexion.prepareStatement(qtitob);
            pstitob.setInt(1, idinvestigador);
            rstitob = pstitob.executeQuery();
            if (rstitob.next()) {
                titob = new TituloObtenido[rstitob.getRow()];
                int tit = rstitob.getInt("titulo");
                String fecha = rstitob.getString("fechaobtencion");
                TituloObtenido tmp = new TituloObtenido(getTitulo(tit), fecha);
                titob[i] = tmp;
                i++;
                while (rstitob.next()) {
                    tit = rstitob.getInt("titulo");
                    fecha = rstitob.getString("fechaobtencion");
                    tmp = new TituloObtenido(getTitulo(tit), fecha);
                    titob[i] = tmp;
                    i++;
                }

            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar array de titulos obtenidos: " + e.getMessage());
        }
        return titob;
    }

    private CategoriaInvestigador getCategoriaInvestigador(int idcat) {
        CategoriaInvestigador cate = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qcat = "SELECT nombre FROM categoriainvestigador WHERE id=?";
        PreparedStatement pscate;
        ResultSet rscate;
        try {
            pscate = conexion.prepareStatement(qcat);
            pscate.setInt(1, idcat);
            rscate = pscate.executeQuery();

            if (rscate.next()) {
                String nombre = rscate.getString("nombre");
                cate = new CategoriaInvestigador(nombre);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Erro al cargar categoria: " + e.getMessage());
        }
        return cate;
    }

    private Investigador getInvestigador(int idusuario) {
        Investigador usr = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String qgetinv = "SELECT * FROM investigador WHERE usuario=?";
        PreparedStatement psgetinv;
        ResultSet rsgetinv;
        try {
            psgetinv = conexion.prepareStatement(qgetinv);
            psgetinv.setInt(1, idusuario);
            rsgetinv = psgetinv.executeQuery();

            if (rsgetinv.next()) {
                String nombre = rsgetinv.getString("nombre");
                String apellido = rsgetinv.getString("apellido");
                int idcategoria = rsgetinv.getInt("categoriainvestigador");
                int idinvestigador = rsgetinv.getInt("id");
                Usuario nuevoU = new Usuario(idinvestigador);
                /*
                private CategoriaInvestigador categoriaInvestigador;
                private TituloObtenido[] tituloObtenido;
                 */
                CategoriaInvestigador categoriaInvestigador = getCategoriaInvestigador(idcategoria);
                TituloObtenido[] tituloObtenido = getTituloObtenido(idinvestigador);
                usr = new Investigador(nombre, apellido, nuevoU, categoriaInvestigador, tituloObtenido);
            }
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al crear investigador: " + e.getMessage());
        }
        return usr;
    }

    public Investigador ingresar(String usuario, String password) {
        Investigador usr = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();
        String pass = password + password;
        pass = SimpleSHA1.getSHA1(pass);

        String q = "SELECT id FROM usuario WHERE nombre=? AND password=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(q);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                usr = getInvestigador(id);

            }
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al ingresar: " + e.getMessage());
        }

        return usr;
    }
    
}
