/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;

import tpidsi.grupoinvestigacion.*;
import tpidsi.investigador.Investigador;

/**
 *
 * @author Genaro F
 */
public class Autor implements Comparable{
    private Investigador investigador;
    private int id;

    public Autor(Investigador investigador, int id) {
        this.investigador = investigador;
        this.id = id;
    }
    
    

    public String getNombre() {
        return this.investigador.getNombre();
    }

    public String getApellido() {
        return this.investigador.getApellido();
    }

    public String getDatos(){
        return "Nombre: " + getNombre() + ", Apellido: " + getApellido() +"\n";
    }
    
    public Investigador getInvestigador() {
        return investigador;
    }
    
    public CentroDeInvestigacion obtenerCentroDeInvestigacion(){
        return this.investigador.obtenerCentroDeInvestigacion();
    }
    
    public Facultad obtenerFacultad(){
        return this.investigador.obtenerFacultad();
    }
    
    public GrupodeInvestigacion obtenerGrupodeInvestigacion(){
        return this.investigador.obtenerGrupodeInvestigacion();
    }
    
    public Universidad obtenerUniversidad(){
        return this.investigador.obtenerUniversidad();
    }

    @Override
    public int compareTo(Object t) {
        Autor a1 = (Autor) t;
        return this.investigador.compareTo(a1.getInvestigador());
    }
}
