/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.trabajoinvestigacion;
import tpidsi.state.*;


/**
 *
 * @author Genaro F
 */
public abstract class Estado {

    private String ambito;
    private String descripcion;
    private String nombre;

    public AsignacionEvaluador asignarEvaluador(String evaluadorAsignado, String chair){return null;};

    public Cancelado cancelar() {
        Cancelado sta = new Cancelado();
        return sta;
    }

    public EvaluacionInicial evaluar() {
        EvaluacionInicial sta = new EvaluacionInicial();
        return sta;
    }

    public Publicado publicar() {
        Publicado sta = new Publicado();
        return sta;
    }

    public Rechazado rechazar() {
        Rechazado sta = new Rechazado();
        return sta;
    }

    public Aceptado aceptar() {
        Aceptado sta = new Aceptado();
        return sta;
    }

    public Anulado anular() {
        Anulado sta = new Anulado();
        return sta;
    }

    public SujetoACorrecciones solicitarCorrecciones() {
        SujetoACorrecciones sta = new SujetoACorrecciones();
        return sta;
    }

    public SujetoACorrecciones presentarCorrecciones() {
        SujetoACorrecciones sta = new SujetoACorrecciones();
        return sta;
    }

    
    
    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
