/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;

import conexion.OpHistorialEstados;
import java.time.Instant;
import java.util.Date;
import tpidsi.state.PendientePrimeraEvaluacion;

/**
 *
 * @author Genaro F
 */
public class HistorialEstado {

    private Date fecha;
    private Estado estado;

    public HistorialEstado(Estado s) {
        this.fecha = Date.from(Instant.now());
        this.estado = s;
    }

    public void setUltimoEstado(Estado e) {
        this.estado = e;
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
