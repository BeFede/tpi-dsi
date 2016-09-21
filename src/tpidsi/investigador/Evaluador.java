/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;

import java.util.ArrayList;
import tpidsi.titulos.TituloObtenido;

/**
 *
 * @author fedeb
 */
public class Evaluador {

    private Investigador investigador;

    public Evaluador(Investigador investigador) {
        this.investigador = investigador;
    }

    public String obtenerCategoria() {
        return investigador.getCategoriaInvestigador().getNombre();
    }

    //Esta implementación va a cambiar cuando el Investigador tenga mas de un titulo, es decir cuando se implemente
    //con una lista o algo asi. Por el momento la dejo asi para hacer uso de ella, pero la voy a cambiar y va a devolver
    //un aarray list con todos los tipos de titulo del investgador
    public String obtenerTiposTitulos() {
        TituloObtenido[] to = investigador.getTituloObtenido();
        for (int i = 0; i < to.length; i++) {
            //Esta retornando solo el primero o null si no existe titulo obtenido
            return to[i].getTitulo().getTipoTitulo().getNombre();
        }
        return null;

    }

}
