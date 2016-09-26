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
import conexion.OpSimposio;
import tpidsi.grupoinvestigacion.Facultad;
import tpidsi.investigador.Chair;
import tpidsi.simposio.EdicionSimposio;
import tpidsi.trabajoinvestigacion.TrabajoDeInvestigacion;

/**
 *
 * @author Genaro F
 */
public class OpGestor {
    
    private OpUniversidad opU = new OpUniversidad();
    private OpTrabajoInvestigacion opTI = new OpTrabajoInvestigacion();
    
    public Facultad[] obtenerFacultades(){
        return opU.obtenerFacultades();
    }
    
    public TrabajoDeInvestigacion obtenerTrabajoDeInvestigacion(int idTI){
        return opTI.buscarTrabajoInvestigacion(idTI);
    }
    
    public Evaluador obtenerEvaluador(int idEv){
        return opTI.obtenerEvaluador(idEv);
    }

    private Investigador obtenerInvestigador(int id) {
        Ingresar in = new Ingresar();

        Investigador e = in.getInvestigadorPorId(id);
        return e;
    }

    public Evaluador[] obtenerEvaluadores() {
        Evaluador[] arr = null;
        Conectar op = new Conectar();
        Connection conexion = op.getConection();

        String q = "SELECT * FROM evaluador";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(q);
            rs = ps.executeQuery();
            int id_inv, id_ev, contador = 0;
            Evaluador n;
            if (rs.next()) {
                arr = new Evaluador[rs.getRow()];
                id_inv = rs.getInt("id_investigador");
                id_ev = rs.getInt("id");
                n = new Evaluador(obtenerInvestigador(id_inv), id_ev);
                arr[contador] = n;
                contador++;
                while (rs.next()) {
                    id_inv = rs.getInt("id_investigador");
                    id_ev = rs.getInt("id");
                    n = new Evaluador(obtenerInvestigador(id_inv), id_ev);
                    arr[contador] = n;
                    contador++;
                }

            }

        } catch (SQLException e) {

        }

        return arr;
    }
    
    public Chair[] conocerChairs(){
        return OpSimposio.conocerChairs();
    }
    
    public EdicionSimposio buscarSimposioChair(int idChair){
        return OpSimposio.buscarSimposioChair(idChair);
    }

}
