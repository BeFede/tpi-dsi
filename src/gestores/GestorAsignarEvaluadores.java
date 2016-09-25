/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.util.ArrayList;
import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
import tpidsi.simposio.EdicionSimposio;
import tpidsi.trabajoinvestigacion.Autor;
import tpidsi.trabajoinvestigacion.TrabajoDeInvestigacion;

/**
 *
 * @author fedeb
 */
public class GestorAsignarEvaluadores {
    
  
    private Chair chairLogueado;
    private EdicionSimposio edicionSimposioChair;
    private ArrayList<TrabajoDeInvestigacion> trabajosInvestigacionPendientes;
    private ArrayList<Autor> autores;
    private ArrayList<Evaluador> evaluadores;
    private int [][] evaluadoresSeleccionadosPorTrabajo; //es una matriz con el id del trabajo y el id de los evaluadores 
                                                        //asignados. De la forma [idTrabajo][idEvaluador]. De esta manera
                                                        //es posible asociar un trabajo a varios evaluadores.
    
    
    
    //Los retornos los pongo todos en void porque no se bien como se va a tratar con la comunicacion con la pantalla
    
    
    //Los comentario están hecho en base a lo que pude deducir del diagrama de comunicaciones del CU
    
    //Invoca al método asignarEvaluador del EdicionSimposio pasando el Chair el evaluador y el TI. 
    //Despues de ejecutar esto, debería haberse creado un AsignacionEvaluador y TI debe estar con el nuevo estado
    public void asignarEvaluadoresATrabajo(){} 
    
    public void ordenAscendente(){} //retorna un array de autores ordenados ascendentemente
    
    public void tomarTrabajosInvestigacion(){} // toma los TI seleccionados en la pantalla e inicializa trabajosInvestigacionPendientes
    
    public void tomarEvaluadores(){} //toma los evaluadores seleccionados e inicializa this.evaluadores
    
    public void tomarConfirmacion(){} //Se toma a confirmacion y se invoca a los métodos que siguen haciendo cumplir la secuencia
    
    public void buscarChairLogueado(){} //invoca al "buscarChair" en sesión
    
    public void buscarEdicionSimposioChair(){} //Invoca al ConocerChairs de edicion simposio, y va a devolver la edicion simposio del chair logueado y asignarla a edicionSimposioChair
    
    public void buscarDatosAutores(){} //invoca al método buscarDatosAutores de EdicionSimposio y le pasas los mismos  a la pantalla
    
    public void buscarEvaluadoresAsignados(){} //Invoca al método obtenerEvaluadoresAsignados de la EdicionSimposio
    
    public void buscarDatosEvaluadores(){} //Invoca al buscarDatosEvaluadores de EdicionSimposio
    
    public void ordenarEvaluadoresPorCategoria(){} //Ordena a los evaluadores por ategoria y los devuelve para la pantalla
    
    public void clasificarEvaluadoresPorFacultad(){} //Clasifica los evaluadores por facultad y los devuelve a la pantalla 
    
    public void calcularCantTIPorEvaluador(){} //Muestra la cantidad de trabajos que tiene asignado cada evaluador seleccionado

    //Valida que esté todo bien. Que concuerde la categoria y la cantidad de trabajos de un evaluador sea correcta 
    //(creo que tiene un máximo. Fijarse en el trazo fino)
    public void validarCantYCategoriaEvaluadorPorTI(){} 
    
    public void obtenerFechaYHoraActual(){} //No se que hace xD
    
   public void finCU(){} //
    
    
    
}
