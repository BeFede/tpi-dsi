/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;

import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
import tpidsi.simposio.EdicionSimposio;
import tpidsi.state.Pendiente;

/**
 *
 * @author Genaro F
 */
public class TrabajoDeInvestigacion {
    private int id;
    private int nroOrden;
    private String resumen, titulo, palabrasClave;
    private HistorialEstado historialEstado;
    private HistorialEstado ultimoEstado;
    private AsignacionEvaluador asignacionEvaluador;
    private Autor autor;
    private EdicionSimposio edicionSimposio;
    
    
  

    public TrabajoDeInvestigacion(int id, String titulo, HistorialEstado ultimoEstado, EdicionSimposio edicionSimposio) {
        this.id = id;
        this.titulo = titulo;
        this.ultimoEstado = ultimoEstado;
        this.edicionSimposio = edicionSimposio;
    }
    
    
    
    
    public AsignacionEvaluador asignarEvaluador(Evaluador evaluadorAsignado, Chair chair){
        AsignacionEvaluador asignacion = null;
        if(this.ultimoEstado.getEstado() instanceof Pendiente){
            asignacion = this.ultimoEstado.getEstado().asignarEvaluador(evaluadorAsignado, chair);
        }
        return asignacion;
    }
    
    public void setUltimoEstado(Estado pendientePrimeraEvaluacion){
        this.historialEstado = this.ultimoEstado;
        this.ultimoEstado = new HistorialEstado();
        this.ultimoEstado.setUltimoEstado(pendientePrimeraEvaluacion);
    }
        
    public boolean buscarTIEstadoPendiente(){
        return this.ultimoEstado.getEstado() instanceof Pendiente;
    }

    public int getNroOrden() {
        return nroOrden;
    }

    public Autor getAutor() {
        return autor;
    }
    
    
}
