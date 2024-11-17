
package com.mycompany.sistemacontroldonraul;

public class AtencionAlPublico extends Usuario {
    public AtencionAlPublico(String nombre, int idRol, int idUsuario, String contrasenha) {
        super(nombre, idRol, idUsuario, contrasenha);
    }

    public void modificarPrecio(String producto, double nuevoPrecio) {
        System.out.println("Acción denegada. Los usuarios de atención al público no pueden modificar precios.");
    }
}
