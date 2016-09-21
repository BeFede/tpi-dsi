/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;

import conexion.OpHistorialEstados;
import java.util.Date;

/**
 *
 * @author Genaro F
 */
public class HistorialEstado {

    private Date fecha;
    private Estado estado;

    public void setUltimoEstado(Estado pendientePrimeraEvaluacion) {
        this.estado = pendientePrimeraEvaluacion;
        this.fecha = new Date();
    }

    public boolean guardarHistorial(int idtrabajo){
        OpHistorialEstados ohe = new OpHistorialEstados();
        boolean guardo = ohe.guardarHistorial(this,idtrabajo);
        return guardo;
    }
    public Date getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }

}
