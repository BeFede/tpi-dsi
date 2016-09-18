/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.state;

import tpidsi.trabajoinvestigacion.Estado;

/**
 *
 * @author Genaro F
 */
public class PendientePrimeraEvaluacion extends Estado{
    
    public PendientePrimeraEvaluacion(){
        super();
        super.setNombre("Pendiente Primera Evaluacion");
        super.setAmbito("Trabajo de Investigacion");
        super.setDescripcion("");
    }
    
}
