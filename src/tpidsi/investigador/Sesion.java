/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpidsi.investigador;

import conexion.Ingresar;

/**
 *
 * @author filardo
 */
public class Sesion {

    /**
     * Comprueba que exista el usuario y la contraseña sea correcta en la 
     * base de datos. Si es logueado con exito, retorna el objeto Investigador,
     * de lo contrario retorna null.
     * @param user
     * @param password
     * @return Referencia a un Investigador logueado
     */
    public Investigador ingresar(String user, String password) {
        //Investigador1:p4ssw0rd
        Investigador inv;
        Ingresar op = new Ingresar();

        inv = op.ingresar(user, password);
        return inv;
    }

    /*public static void main(String[] args) {
        Investigador inv = null;
        String usr = "Investigador1", password="p4ssw0rd";
        Ingresar op = new Ingresar();
        
        inv = op.ingresar(usr, password);
        if(inv == null) System.out.println("Error de usuario o contraseña");
        else{
            System.out.println("Usuario "+inv.getNombre()+" logueado con exito!");
        }
    }*/
}
