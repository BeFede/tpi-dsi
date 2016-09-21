/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;
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
        this.fechaAsignacion = new Date();
        this.evaluadorAsignado = evaluadorAsignado;
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
