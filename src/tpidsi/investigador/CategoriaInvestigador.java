/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;

/**
 *
 * @author fedeb
 */
public class CategoriaInvestigador implements Comparable{
    private int id;
    private String nombre;

    public CategoriaInvestigador(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Object t) {
        CategoriaInvestigador c = (CategoriaInvestigador) t;
        return this.nombre.compareTo(c.getNombre());
    }
    
    
    
    
}
