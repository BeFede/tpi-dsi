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
public class TituloObtenido {

    private Titulo titulo;

    public TituloObtenido(Titulo titulo) {
        this.titulo = titulo;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    // hace falta? Está en Titulo ya
    public TipoTitulo getTipoTitulo() {
        return titulo.getTipoTitulo();
    }

}
