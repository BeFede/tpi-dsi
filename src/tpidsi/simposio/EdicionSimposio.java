/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.simposio;

import conexion.OpSimposio;
import java.util.ArrayList;
import java.util.Arrays;
import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
import tpidsi.trabajoinvestigacion.Estado;
import tpidsi.trabajoinvestigacion.TrabajoDeInvestigacion;

public class EdicionSimposio {

    private ArrayList<Evaluador> evaluadores;
    private ArrayList<Chair> chairs;
    private String nombre;
    private String fecha;
    private int id;

    public EdicionSimposio(String nombre, String fecha, int id) {
        evaluadores = new ArrayList();
        chairs = new ArrayList();
        this.nombre = nombre;
        this.fecha = fecha;
        this.id = id;
        configurar();
    }

    private void configurar(){
        evaluadores.addAll(Arrays.asList(OpSimposio.conocerEvaluadores()));
        chairs.addAll(Arrays.asList(OpSimposio.conocerChairs()));
    }
    
    public ArrayList<Evaluador> obtenerDatosEvaluadores() {
        return evaluadores;
    }

    public ArrayList<Evaluador> obtenerEvaluadoresAsignados() {
        return evaluadores;
    }

    //Este metodo debe devolver la edicion simposio del chair logueado... En la semana lo implemento. No me gusta la signatura que tiene
    public ArrayList<Chair> conocerChairs() {
        return chairs;
    }

    public void agregarEvaluador(Evaluador eva) {
        evaluadores.add(eva);
        boolean guardo = OpSimposio.agregarEvaluador(this.id, eva.getId());
    }

    public void agregarChair(Chair cha) {
        chairs.add(cha);
        boolean guardo = OpSimposio.agregarChair(this.id, cha.getId());
    }

    //paso por parámetros el evaluador y el chair. Se puede implementar si las demas clases lo implementan igual
    // Ver como lo vamos a hacer
    public void asignarEvaluador(Evaluador e, Chair ch, TrabajoDeInvestigacion ti) {
        ti.asignarEvaluador(e, ch);
    }

    public String buscarDatosAutores(TrabajoDeInvestigacion ti) {
        String autores = "";
        for (int i = 0; i < ti.getAutores().size(); i++) {
            autores += ti.getAutores().get(i).getDatos() + "\n";
        }
        return autores;
    }

    public String buscarDatosEvaluadores(TrabajoDeInvestigacion ti){
        String evaluadores = "";
        for (int i = 0; i < ti.getEvaluadores().size(); i++) {
            evaluadores += ti.getEvaluadores().get(i).getDatos() + "\n";
        }
        return evaluadores;
    }
    /*
    Buscar datos de autores: Que hace? Hay que buscar tooodos los autores de cualquier trabajo que
    sea presentado en esa edición?
     */
    
    public void actualizarEstadoTI(TrabajoDeInvestigacion ti, Estado es){
        ti.setUltimoEstado(es);
    }
}
