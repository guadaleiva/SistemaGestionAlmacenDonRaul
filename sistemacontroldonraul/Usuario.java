
package com.mycompany.sistemacontroldonraul;

public class Usuario {
    protected static   int idUsuario;
    private  String nombre;
    private  String tipo;
    String contrasenha; 

    public Usuario(String nombre, String tipo, int idUsuario, String contrasenha) {
        Usuario.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contrasenha = contrasenha; 
    }

    public static   int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        Usuario.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  String getContreasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha= contrasenha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
