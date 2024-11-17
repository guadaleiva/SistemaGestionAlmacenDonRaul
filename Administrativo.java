package com.mycompany.sistemacontroldonraul;

public class Administrativo extends Usuario {
    public Administrativo(String nombre, int idRol, int idUsuario, String contrasenha) {
        super(nombre, idRol, idUsuario, contrasenha);  
    }

    public void modificarPrecio(String producto, double nuevoPrecio) {
        System.out.println("El precio de " + producto + " ha sido modificado a: " + nuevoPrecio);
        
    }
}
