/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import Interfaces.PantallaAsignarEvaluadoresTI;
import Interfaces.PantallaGestionTIChair;
import conexion.OpGestor;
import java.time.Instant;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import tpidsi.grupoinvestigacion.Facultad;
import tpidsi.investigador.Chair;
import tpidsi.investigador.Evaluador;
import tpidsi.investigador.Investigador;
import tpidsi.investigador.Sesion;
import tpidsi.investigador.Usuario;
import tpidsi.simposio.EdicionSimposio;
import tpidsi.trabajoinvestigacion.Autor;
import tpidsi.trabajoinvestigacion.TrabajoDeInvestigacion;

/**
 *
 * @author fedeb
 */
public class GestorAsignarEvaluadores {

    private PantallaAsignarEvaluadoresTI pantalla;
    private HashMap<Integer, ArrayList<Evaluador>> clasificadosEvaluadores;
    private OpGestor op;
    private Sesion sesion;
    private Chair chairLogueado;
    private EdicionSimposio edicionSimposioChair;
    private ArrayList<TrabajoDeInvestigacion> trabajosInvestigacionPendientes;
    private ArrayList<Autor> autores;
    private ArrayList<Evaluador> evaluadores;
    private int[][] evaluadoresSeleccionadosPorTrabajo; //es una matriz con el id del trabajo y el id de los evaluadores 
    //asignados. De la forma [idTrabajo][idEvaluador]. De esta manera
    //es posible asociar un trabajo a varios evaluadores.

    public GestorAsignarEvaluadores(Sesion s, PantallaAsignarEvaluadoresTI pantalla) {
        this.sesion = s;
        this.pantalla = pantalla;
        this.op = new OpGestor();
        asignarEvaluadoresATI();
    }

    //Los retornos los pongo todos en void porque no se bien como se va a tratar con la comunicacion con la pantalla
    //Los comentario están hecho en base a lo que pude deducir del diagrama de comunicaciones del CU
    //Invoca al método asignarEvaluador del EdicionSimposio pasando el Chair el evaluador y el TI. 
    //Despues de ejecutar esto, debería haberse creado un AsignacionEvaluador y TI debe estar con el nuevo estado
    //este metodo seria el que lleve la secuencia si hace falta.
    public void asignarEvaluadoresATI() {
        String nom = "";
        chairLogueado = buscarChairLogueado(sesion);
        if (this.chairLogueado != null) {
            nom = this.chairLogueado.getInvestigador().getApellido() + ", " + this.chairLogueado.getInvestigador().getNombre();
        }
        this.pantalla.mostrarNomYApeChair(nom, buscarEdicionSimposioChair().getNombre());
    }

    public void asignarEvaluadoresATrabajo(Evaluador ev, Chair ch, TrabajoDeInvestigacion ti) {
        edicionSimposioChair.asignarEvaluador(ev, ch, ti);
    }

    public Evaluador[] ordenAscendente() {
        Evaluador[] au = op.obtenerEvaluadores();
        return ordenarEvaluadoresPorCategoria(au);
    } //retorna un array de evaluadores ordenados ascendentemente (es el metodo "tomarOrden" renombrado)

    public void tomarTrabajosInvestigacion(TrabajoDeInvestigacion[] tiA) {
        trabajosInvestigacionPendientes.addAll(Arrays.asList(tiA));
    } // toma los TI seleccionados en la pantalla e inicializa trabajosInvestigacionPendientes

    public void tomarEvaluadores(Evaluador[] evA) {
        evaluadores.addAll(Arrays.asList(evA));
    } //toma los evaluadores seleccionados e inicializa this.evaluadores

    /**
     * Recibe un HashMap donde por cada Trabajo de Investigacion se almacena un
     * array de Evaluador. Por cada TI realiza las validaciónes correspondientes
     * a cantidad y categorias de evaluadores, en caso de que algun TI no pase
     * la validaccion, la funcion se interrumpe y retorna false. Si todo termina
     * sin problemas, retorna true.
     *
     * @param mapaEvaluadoresPorTI HashMap<TrabajoDeInvestigacion, Evaluador[]>
     * @return En caso de que algun TI no pase la validaccion, la funcion se
     * interrumpe y retorna false. Si todo termina sin problemas, retorna true.
     */
    public boolean tomarConfirmacion(HashMap<TrabajoDeInvestigacion, Evaluador[]> mapaEvaluadoresPorTI) {
        boolean bien = true;
        for (TrabajoDeInvestigacion trS : this.trabajosInvestigacionPendientes) {
            if (mapaEvaluadoresPorTI.containsKey(trS)) {

                Evaluador[] tmpEv = mapaEvaluadoresPorTI.get(trS);
                if (validarCantYCategoriaEvaluadorPorTI(tmpEv)) {
                    obtenerFechaYHoraActual();

                    for (Evaluador ev : tmpEv) {
                        asignarEvaluadoresATrabajo(ev, chairLogueado, trS);
                    }
                    /*
                    Estado pendiente = buscarEstadoPendientePrimeraEvaluacion();
                    actualizarEstadoTI(trS, pendiente);
                     */ // lo hace el patron 
                } else {
                    bien = false;
                    break;
                }

            }
        }
        return bien;
    }//Se toma a confirmacion y se invoca a los métodos que siguen haciendo cumplir la secuencia

    public Chair buscarChairLogueado(Sesion s) {
        return s.buscarChair();
    } //invoca al "buscarChair" en sesión

    public EdicionSimposio buscarEdicionSimposioChair() {
        if(this.chairLogueado == null){
            this.chairLogueado = buscarChairLogueado(this.sesion);
        }
        EdicionSimposio simp = op.buscarSimposioChair(this.chairLogueado.getId());
        this.edicionSimposioChair = simp;
        return this.edicionSimposioChair;
    } //Invoca al ConocerChairs de edicion simposio, y va a devolver la edicion simposio del chair logueado y asignarla a edicionSimposioChair

    public String[] buscarDatosAutores() {
        String[] aut = new String[this.trabajosInvestigacionPendientes.size()];
        int contador = 0;
        for (TrabajoDeInvestigacion e : this.trabajosInvestigacionPendientes) {
            aut[contador] = this.edicionSimposioChair.buscarDatosAutores(e);
            contador++;
        }
        return aut;
    } //invoca al método buscarDatosAutores de EdicionSimposio y le pasas los mismos  a la pantalla

    public Evaluador[] buscarEvaluadoresAsignados() {
        ArrayList arr = this.edicionSimposioChair.obtenerEvaluadoresAsignados();
        return (Evaluador[]) arr.toArray();
    } //Invoca al método obtenerEvaluadoresAsignados de la EdicionSimposio

    public String[] buscarDatosEvaluadores() {
        String[] aut = new String[this.trabajosInvestigacionPendientes.size()];
        int contador = 0;
        for (TrabajoDeInvestigacion e : this.trabajosInvestigacionPendientes) {
            aut[contador] = this.edicionSimposioChair.buscarDatosEvaluadores(e);
            contador++;
        }
        return aut;
    } //Invoca al buscarDatosEvaluadores de EdicionSimposio

    public Evaluador[] ordenarEvaluadoresPorCategoria(Evaluador[] au) {
        Arrays.sort(au);
        return au;
    } //Ordena a los evaluadores por ategoria y los devuelve para la pantalla

    public void clasificarEvaluadoresPorFacultad() {
        HashMap<Integer, ArrayList<Evaluador>> evaluadoresClasificados = new HashMap<>();
        Evaluador[] evaluadores = this.op.obtenerEvaluadores();
        Facultad[] facultades = this.op.obtenerFacultades();
        ArrayList[] evxf;
        evxf = new ArrayList[facultades.length];
        for (Evaluador ev : evaluadores) {
            if (evxf[ev.obtenerFacultad().getId()] == null) {
                ArrayList<Evaluador> s = new ArrayList<>();
                s.add(ev);
                evxf[ev.obtenerFacultad().getId()] = s;
            } else {
                evxf[ev.obtenerFacultad().getId()].add(ev);
            }
        }

        for (int i = 0; i < evxf.length; i++) {
            evaluadoresClasificados.put(i, evxf[i]);
        }
        this.clasificadosEvaluadores = evaluadoresClasificados;
    } //Clasifica los evaluadores por facultad y los devuelve a la pantalla 

    public void calcularCantTIPorEvaluador() {
    } //Muestra la cantidad de trabajos que tiene asignado cada evaluador seleccionado

    //valida que para cada TI se hayan seleccionado tres evaluadores y al menos uno que sea de la categoria 1 o 2
    /**
     * Consulta la lista de Trabajos de Investigacion y valida que cada uno
     * cumpla con tener 3 evaluadores y al menos uno sea de categoria 1 o 2. Si
     * no hay error, retorna null. En caso de que existan TI que no cumplan, los
     * retorna en un array.
     *
     * @return Si no hay error, retorna null. En caso de que existan TI que no
     * cumplan, los retorna en un array.
     */
    public boolean validarCantYCategoriaEvaluadorPorTI(Evaluador[] seleccionados) {
        boolean es1o2 = false;

        if (seleccionados.length > 2) {
            for (Evaluador ev : seleccionados) {
                if (ev.obtenerCategoria().getId() < 3) {
                    es1o2 = true;
                    break;
                }
            }
        }
        return es1o2;
    }

    public Date obtenerFechaYHoraActual() {
        return Date.from(Instant.now());
    } //No se que hace xD

    public void finCU() {
    } //

    public void buscarTIEstadoPendiente() {

    }//que busca todo los ti en estado pendiente para esa edicion d esimposio

    public Evaluador[] evaluadoresFacultadDistinta(Evaluador cuarentena) {
        Facultad[] facultades = this.op.obtenerFacultades();
        int facultadCuarentena = cuarentena.obtenerFacultad().getId();

        ArrayList<Evaluador> listaE = new ArrayList<>();
        if (this.clasificadosEvaluadores == null) {
            clasificarEvaluadoresPorFacultad();
        }

        for (int i = 0; i < facultades.length; i++) {
            if (i == facultadCuarentena) {
                continue;
            }
            ArrayList<Evaluador> tmp = this.clasificadosEvaluadores.get(facultades[i].getId());
            for (Evaluador e : tmp) {
                listaE.add(e);
            }
        }
        return (Evaluador[]) listaE.toArray();
    }

}
