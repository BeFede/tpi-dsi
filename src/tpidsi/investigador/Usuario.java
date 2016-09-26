/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;

import conexion.OpInvestigador;

/**
 *
 * @author filardo
 */
public class Usuario {
    
    private int idinvestigador;
    private Investigador inv;
    
    public Usuario(int id) {
        this.idinvestigador = id;
    }

    public int getId() {
        return idinvestigador;
    }

    public void setId(int id) {
        this.idinvestigador = id;
    }

    public Investigador getInv() {
        return inv;
    }

    public void setInv(Investigador inv) {
        this.inv = inv;
    }
    
    public Chair buscarChair(){
        Chair rtn = null;
        OpInvestigador op = new OpInvestigador();
        if(op.esChair(idinvestigador)){
            rtn = op.obtenerChair(idinvestigador);
        }
        return rtn;
    }
    
    
}
