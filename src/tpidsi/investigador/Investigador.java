/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;

import tpidsi.grupoinvestigacion.*;
import tpidsi.titulos.*;

/**
 *
 * @author filardo
 */
public class Investigador {
    
    private String nombre;
    private String apellido;
    private Usuario usuario;
    private CategoriaInvestigador categoriaInvestigador;
    private TituloObtenido tituloObtenido;

    public Investigador() {
    }

    public Investigador(String nombre, String apellido, Usuario usuario, CategoriaInvestigador categoriaInvestigador, TituloObtenido tituloObtenido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.categoriaInvestigador = categoriaInvestigador;
        this.tituloObtenido = tituloObtenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CategoriaInvestigador getCategoriaInvestigador() {
        return categoriaInvestigador;
    }

    public void setCategoriaInvestigador(CategoriaInvestigador categoriaInvestigador) {
        this.categoriaInvestigador = categoriaInvestigador;
    }

    public TituloObtenido getTituloObtenido() {
        return tituloObtenido;
    }

    public void setTituloObtenido(TituloObtenido tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
    }
    
    public CentroDeInvestigacion obtenerCentroDeInvestigacion(){
        return null;
    }
    
    public Facultad obtenerFacultad(){
        return null;
    }
    
    public GrupodeInvestigacion obtenerGrupodeInvestigacion(){
        return null;
    }
    
    public Universidad obtenerUniversidad(){
        return null;
    }
    
}
