
package com.mycompany.sistemacontroldonraul;

public class Producto {
  private int idProducto;
    private String nombre;
    private double precio;
    private String descripcion;
    private String imagen;
    private String marca;   
    private String usuario;
    private String categoria;
    private String proveedor;

    public Producto(int idProducto, String nombre, double precio, String descripcion, String imagen, String marca, String usuario, String categoria, String proveedor) {
        this.idProducto = idProducto; 
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.marca = marca;
        this.usuario = usuario;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public Producto(String usuario) {
        this.usuario = usuario;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
   

