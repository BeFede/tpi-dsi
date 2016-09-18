/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;
import java.util.Date;
/**
 *
 * @author Genaro F
 */
public class AsignacionEvaluador {
    private Date fechaAsignacion;
    private String evaluadorAsignado;
    private String chair;
    
    public AsignacionEvaluador(String evaluadorAsignado, String chair){
        this.fechaAsignacion = new Date();
        this.evaluadorAsignado = evaluadorAsignado;
        this.chair = chair;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public String getEvaluadorAsignado() {
        return evaluadorAsignado;
    }

    public String getChair() {
        return chair;
    }
    
    
}
