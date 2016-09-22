/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;

import java.util.ArrayList;
import tpidsi.grupoinvestigacion.CentroDeInvestigacion;
import tpidsi.grupoinvestigacion.Facultad;
import tpidsi.grupoinvestigacion.GrupodeInvestigacion;
import tpidsi.grupoinvestigacion.Universidad;
import tpidsi.titulos.TipoTitulo;
import tpidsi.titulos.TituloObtenido;

/**
 *
 * @author fedeb
 */
public class Evaluador {

    private Investigador investigador;

    public Evaluador(Investigador investigador) {
        this.investigador = investigador;
    }

    public CategoriaInvestigador obtenerCategoria() {
        return investigador.getCategoriaInvestigador();
    }

    public String obtenerNombre()
    {
        return investigador.getNombre();
    }
    
    public String obtenerApellido()
    {
        return investigador.getApellido();
    }
    
    public GrupodeInvestigacion obtenerGrupodeInvestigacion()
    {
        return investigador.obtenerGrupodeInvestigacion();
    }
    
    public CentroDeInvestigacion obtenerCentroDeInvestigacion()
    {
        return investigador.obtenerCentroDeInvestigacion();
    }
    
    public Facultad obtenerFacultad()
    {
        return investigador.obtenerFacultad();
    }
    
    
    public Universidad obtenerUniversidad()
    {
        return investigador.obtenerUniversidad();
    }
    
    
  
    public TipoTitulo[] obtenerTiposTitulos() {
        return investigador.obtenerTipoTitulos();
    }
    
    public String getDatos()
    {
        return investigador.toString();
    }

}
