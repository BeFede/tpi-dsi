/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;

/**
 *
 * @author filardo
 */
public class Usuario {
    
    private int idinvestigador;

    public Usuario(int id) {
        this.idinvestigador = id;
    }

    public int getId() {
        return idinvestigador;
    }

    public void setId(int id) {
        this.idinvestigador = id;
    }
    
    
}
