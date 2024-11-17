
package com.mycompany.sistemacontroldonraul;

public class Usuario {
    protected static   int idUsuario;
    private  String nombre;
    private  int idRol;
    String contrasenha; 

    public Usuario(String nombre, int idRol, int idUsuario, String contrasenha) {
        Usuario.idUsuario = idUsuario;
        this.nombre = nombre;
        this.idRol = idRol;
        this.contrasenha = contrasenha; 
    }

    public static   int getIdUsuario() {
        return idUsuario;
    }

    Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Usuario(String nombre, String idUsuario, String idRol, String contrasenha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public  String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha= contrasenha;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int  idRol) {
        this.idRol = idRol;
    }
}
