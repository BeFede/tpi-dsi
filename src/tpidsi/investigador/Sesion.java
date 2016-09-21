/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;

import conexion.Operaciones;



/**
 *
 * @author filardo
 */
public class Sesion {
    
    /*
    Ya veo qué meter acá
    
    Esta clase deberia de tener visibilidad predeterminada para no ser accesible
    desde fuera del paquete (y no poder generar una sesion sin autenticarse).
    
    La operacion "ingresar()" de la clase Operaciones hace la comparacion, en la bd
    y retorna un objeto Investigador para setear a la sesion.
    Usuario creado en al bd:
    Investigador1:p4ssw0rd
    */
    
    public static void main(String[] args) {
        Investigador inv = null;
        String usr = "Investigador1", password="p4ssw0rd";
        Operaciones op = new Operaciones();
        
        inv = op.ingresar(usr, password);
        if(inv == null) System.out.println("Error de usuario o contraseña");
        else{
            System.out.println("Usuario "+inv.getNombre()+" logueado con exito!");
        }
    }
}
