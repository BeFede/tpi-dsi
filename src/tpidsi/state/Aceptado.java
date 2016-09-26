/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.state;

import conexion.OpEstados;
import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
import tpidsi.trabajoinvestigacion.AsignacionEvaluador;
import tpidsi.trabajoinvestigacion.Estado;

/**
 *
 * @author Genaro F
 */
public class Aceptado extends Estado{
    
    
    public Aceptado(){
        super();
        super.setId(1);
        super.setNombre(OpEstados.getNombreEstado(super.getId()));
        super.setAmbito("Trabajo de Investigacion");
        super.setDescripcion(OpEstados.getDescripcionEstado(super.getId()));
    }
    
}
