/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.state;

import tpidsi.trabajoinvestigacion.AsignacionEvaluador;
import tpidsi.trabajoinvestigacion.Estado;

/**
 *
 * @author Genaro F
 */
public class Pendiente extends Estado{
    public Pendiente(){
        super();
        super.setNombre("Pendiente");
        super.setAmbito("Trabajo de Investigacion");
        super.setDescripcion("");
    }
    
    @Override
    public AsignacionEvaluador asignarEvaluador(String evaluadorAsignado, String chair){
        AsignacionEvaluador ev = new AsignacionEvaluador(evaluadorAsignado, chair);
        return ev;
    }
    
    
}
