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
public class Rechazado extends Estado{
    private int id = 9;
    public Rechazado(){
        super();
        super.setId(9);
        super.setNombre(OpEstados.getNombreEstado(super.getId()));
        super.setAmbito("Trabajo de Investigacion");
        super.setDescripcion(OpEstados.getDescripcionEstado(super.getId()));
    }
}
