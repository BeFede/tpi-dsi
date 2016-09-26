/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;
import java.time.Instant;
import java.util.Date;
import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
/**
 *
 * @author Genaro F
 */
public class AsignacionEvaluador {
    private Date fechaAsignacion;
    private Evaluador evaluadorAsignado;
    private Chair chair;
    
    
    /*
    
    private Evaluador evaluadorAsignado;
    private Chair chair;
     
    public AsignacionEvaluador(Evaluador evaluadorAsignado, Chair chair){
        this.fechaAsignacion = new Date();
        this.evaluadorAsignado = evaluadorAsignado;
        this.chair = chair;
    }
    
    */
    
    
    public AsignacionEvaluador(Evaluador evaluadorAsignado, Chair chair){
        setFechaAsignacion();
        setEvaluadorAsignado(evaluadorAsignado);
        setChair(chair);
    }

    public void setFechaAsignacion() {
        this.fechaAsignacion = Date.from(Instant.now());
    }

    public void setEvaluadorAsignado(Evaluador evaluadorAsignado) {
        this.evaluadorAsignado = evaluadorAsignado;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public Evaluador getEvaluadorAsignado() {
        return evaluadorAsignado;
    }

    public Chair getChair() {
        return chair;
    }
    
    
}
