/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;

import tpidsi.simposio.EdicionSimposio;
import tpidsi.state.Pendiente;

/**
 *
 * @author Genaro F
 */
public class TrabajoDeInvestigacion {
    private int nroOrden;
    private String resumen, titulo, palabrasClave;
    private HistorialEstado historialEstado;
    private HistorialEstado ultimoEstado;
    private AsignacionEvaluador asignacionEvaluador;
    private Autor autor;
    private EdicionSimposio edicionSimposio;
    
    
    //Aca en vez de pasar los String pasaria objetos de Evaluador y de Chair...
   
    /*
        public AsignacionEvaluador asignarEvaluador(Evaluador evaluadorAsignado, Chair chair){
        AsignacionEvaluador asignacion = null;
        if(this.ultimoEstado.getEstado() instanceof Pendiente){
            asignacion = this.ultimoEstado.getEstado().asignarEvaluador(evaluadorAsignado, chair);
        }
        return asignacion;
    }
    */
    
    
    
    public AsignacionEvaluador asignarEvaluador(String evaluadorAsignado, String chair){
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
