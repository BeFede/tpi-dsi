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
public class CentroDeInvestigacion {
    
    private String nombre;
    private Facultad facultad;

    public CentroDeInvestigacion(String nombre, Facultad facultad) {
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public String getNombre() {
        return nombre;
    }

    public Facultad obtenerFacultad() {
        return facultad;
    }
    
    public Universidad obtenerUniversidad()
    {
        return facultad.obtenerUniversidad();
    }
    
    
}
