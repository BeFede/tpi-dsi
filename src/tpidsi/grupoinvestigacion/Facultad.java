/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.grupoinvestigacion;

/**
 *
 * @author Genaro F
 */
public class Facultad implements Comparable {
    private Integer id;
    private String nombre;
    private Universidad universidad; // ->La relacion es al revés. La verdad no se bien como implementarlo.. 
    //mañana pregunto en clases, por el momento me limito a hacerlo como está en el diagrama y pasando por parametros
    //los datos que necesito

    public Facultad(String nombre,Universidad u, int id) {
        this.nombre = nombre;
        this.universidad = u;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Universidad obtenerUniversidad() {
        return universidad;
    }

    public int getId() {
        return id;
    }
    

    @Override
    public int compareTo(Object t) {
        Facultad f = (Facultad) t;
        return this.id.compareTo(f.getId());
    }
    
    
    
}
