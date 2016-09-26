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
    
    public boolean esChairLogueado(){
        return investigador.getUsuario().buscarChair()!= null;
    }
    
    public Investigador getInvestigador(){
        return this.investigador;
    }

    public int getId() {
        return id;
    }

}
