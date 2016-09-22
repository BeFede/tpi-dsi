/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.grupoinvestigacion;

import java.util.ArrayList;

/**
 *
 * @author Genaro F
 */
public class Universidad {
    private String nombre;
    private ArrayList<Facultad> facultades;
    
    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<Facultad> getFacultades()
    {
        return facultades;
    }
    
    public void addFacultad(Facultad f)
    {
        facultades.add(f);
    }
            
    
}
