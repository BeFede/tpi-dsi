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


public class Anulado extends Estado{
    
    public Anulado(){
        super();
        super.setNombre("Anulado");
        super.setAmbito("Trabajo de Investigacion");
        super.setDescripcion("");
    }
}
