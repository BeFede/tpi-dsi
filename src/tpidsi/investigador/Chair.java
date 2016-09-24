/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;


public class Chair {
    private Investigador investigador;
    private int id;
    
    public Chair(Investigador i, int idChair)
    {
        this.investigador = i;
        this.id = idChair;
    }
    
    
    //Tengo que ver como hacer este método
    //Pero creo que viene mas o menos asi la mano
    public boolean esChairLogueado(){
        
        //if (investigador.getUsuario().buscarChair()!= null) return true;
        /*
        Que hace?
        */
        
        return false;
    }

    public int getId() {
        return id;
    }

}
