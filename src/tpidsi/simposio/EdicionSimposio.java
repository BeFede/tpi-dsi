/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.simposio;


import java.util.ArrayList;
import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
import tpidsi.trabajoinvestigacion.TrabajoDeInvestigacion;

public class EdicionSimposio {
    
    private ArrayList<Evaluador> evaluadores;
    private ArrayList<Chair> chairs;
    private String nombre;
    private String fecha;
    
    public EdicionSimposio(String nombre, String fecha)
    {
        evaluadores = new ArrayList();
        chairs = new ArrayList();
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public ArrayList<Evaluador> obtenerDatosEvaluadores() {
        return evaluadores;
    }

    public ArrayList<Chair> conocerChairs() {
        return chairs;
    }
    
    public void agregarEvaluador (Evaluador eva)
    {
        evaluadores.add(eva);
    }
    
    public void agregarChair(Chair cha)
    {
        chairs.add(cha);
    }
    
    
    //paso por parámetros el evaluador y el chair. Se puede implementar si las demas clases lo implementan igual
    // Ver como lo vamos a hacer
    /*
    public void asignarEvaluador(Evaluador e,Chair ch, TrabajoDeInvestigacion ti)
    {
        ti.asignarEvaluador(e,ch);
    
    }
    */
    
    //Métodos que faltan... actualizarEstadoTI (Creo que no hace falta, ya que este método ha sido reemplazado por el patrón)
    //buscarDatosAutores ()
    
}
