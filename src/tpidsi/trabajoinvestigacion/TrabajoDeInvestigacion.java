/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;

import conexion.OpTrabajoInvestigacion;
import java.util.ArrayList;
import java.util.Arrays;
import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
import tpidsi.simposio.EdicionSimposio;
import tpidsi.state.Pendiente;
import tpidsi.state.PendientePrimeraEvaluacion;

/**
 *
 * @author Genaro F
 */
public class TrabajoDeInvestigacion {

    private OpTrabajoInvestigacion op;
    private int id;
    private int nroOrden;
    private String resumen, titulo, palabrasClave;
    private HistorialEstado historialEstado;
    private HistorialEstado ultimoEstado;
    private AsignacionEvaluador asignacionEvaluador;
    private ArrayList<Autor> autores;
    private ArrayList<Evaluador> evaluadores;
    private EdicionSimposio edicionSimposio;

    public TrabajoDeInvestigacion(int id, String titulo, HistorialEstado ultimoEstado, EdicionSimposio edicionSimposio) {
        this.id = id;
        this.titulo = titulo;
        this.ultimoEstado = ultimoEstado;
        this.edicionSimposio = edicionSimposio;
        configurar();
    }

    private void configurar() {
        this.op = new OpTrabajoInvestigacion();
        this.autores.addAll(Arrays.asList(this.op.obtenerAutorTrabajo(this.id)));
        this.evaluadores.addAll(Arrays.asList(this.op.obtenerEvaluadorTrabajo(this.id)));
    }

    public AsignacionEvaluador asignarEvaluador(Evaluador evaluadorAsignado, Chair chair) {
        AsignacionEvaluador asignacion = new AsignacionEvaluador(evaluadorAsignado, chair);

        if(this.ultimoEstado.getEstado() instanceof Pendiente){
            asignacion = this.ultimoEstado.getEstado().asignarEvaluador(evaluadorAsignado, chair);
        }
        ultimoEstado = new HistorialEstado(new PendientePrimeraEvaluacion());
        return asignacion;
    }

    public void setUltimoEstado(Estado pendientePrimeraEvaluacion) {
        this.historialEstado = this.ultimoEstado;
        this.ultimoEstado = new HistorialEstado(pendientePrimeraEvaluacion);
    }

    public boolean buscarTIEstadoPendiente() {
        return this.ultimoEstado.getEstado() instanceof Pendiente;
    }

    public int getNroOrden() {
        return nroOrden;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<Evaluador> getEvaluadores() {
        return evaluadores;
    }

}
