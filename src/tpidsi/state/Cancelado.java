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
public class Cancelado extends Estado{
    public Cancelado(){
        super();
        super.setNombre("Cancelado");
        super.setAmbito("Trabajo de Investigacion");
        super.setDescripcion("");
    }
}
