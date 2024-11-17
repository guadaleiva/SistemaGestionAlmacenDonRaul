
package com.mycompany.sistemacontroldonraul;

public class Producto {
  private int idProducto;
    private String nombre;
    private Float precio;
    private String descripcion;
    private String marca;   
    private String categoria;
    private String proveedor;

    public Producto(int idProducto, String nombre, float precio, String descripcion, String marca, String usuario, String categoria, String proveedor) {
        this.idProducto = idProducto; 
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    Producto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    int getId() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
   

