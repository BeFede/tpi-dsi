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
public class Evaluador implements Comparable{

    private Investigador investigador;
    private int id;

    public Evaluador(Investigador investigador, int id_evaluador) {
        this.investigador = investigador;
        this.id = id_evaluador;
    }

    public Evaluador(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public CategoriaInvestigador obtenerCategoria() {
        return investigador.obtenerCategoria();
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

    @Override
    public int compareTo(Object t) {
        Evaluador e = (Evaluador) t;
        return this.investigador.obtenerCategoria().compareTo(e.investigador.obtenerCategoria());
    }

}
