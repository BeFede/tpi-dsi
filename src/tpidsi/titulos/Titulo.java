/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.titulos;

/**
 *
 * @author filardo
 */
public class Titulo {
    
    private String nombre;
    private TipoTitulo tipoTitulo;

    
    public Titulo(String nombre, TipoTitulo tipoTitulo) {
        this.nombre = nombre;
        this.tipoTitulo = tipoTitulo;
    }

    public TipoTitulo getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(TipoTitulo tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }
    
    
    
}
