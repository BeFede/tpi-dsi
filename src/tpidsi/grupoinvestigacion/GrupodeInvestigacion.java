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
public class GrupodeInvestigacion {
    private String nombre;
    private CentroDeInvestigacion centroDeInvestigacion;

    public GrupodeInvestigacion(String nombre, CentroDeInvestigacion centrodeinvestigacion) {
        this.nombre = nombre;
        this.centroDeInvestigacion = centrodeinvestigacion;
    }

    public String getNombre() {
        return nombre;
    }

    public CentroDeInvestigacion obtenerCentrodeinvestigacion() {
        return centroDeInvestigacion;
    }
    
    public Facultad obtenerFacultad()
    {
        return centroDeInvestigacion.obtenerFacultad();
    }
    
    public Universidad obtenerUniversidad()
    {
        return centroDeInvestigacion.obtenerUniversidad();
    }
    
    
    
}
