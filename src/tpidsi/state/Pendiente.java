/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.state;

import conexion.OpEstados;
import tpidsi.trabajoinvestigacion.Estado;

/**
 *
 * @author Genaro F
 */
public class Pendiente extends Estado{
    public Pendiente(){
         super();
        super.setId(5);
        super.setNombre(OpEstados.getNombreEstado(super.getId()));
        super.setAmbito("Trabajo de Investigacion");
        super.setDescripcion(OpEstados.getDescripcionEstado(super.getId()));
    }
    
    /*
    public AsignacionEvaluador asignarEvaluador(Evaluador evaluadorAsignado, Chair chair){
        AsignacionEvaluador ev = new AsignacionEvaluador(evaluadorAsignado, chair);
        return ev;
    }
    */
    
}
