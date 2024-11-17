
package com.mycompany.sistemacontroldonraul;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int idCarrito;
    private String usuario;
    private String comprobante;
    private final List<Producto> productos;
    private final List<Integer> cantidades; 

    public Carrito(int idCarrito, String usuario, String comprobante) {
        this.idCarrito = idCarrito;
        this.usuario = usuario;
        this.comprobante = comprobante;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
        System.out.println("Producto agregado al carrito: " + producto.getNombre() + ", Cantidad: " + cantidad);
    }

    public void verProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("--- Productos en el carrito ---");
            for (int i = 0; i < productos.size(); i++) {
                Producto p = productos.get(i);
                int cantidad = cantidades.get(i);
                System.out.println("Producto: " + p.getNombre() + ", ID: " + p.getId() + ", Cantidad: " + cantidad);
            }
        }
    }

    public int getIdCarrito() { return idCarrito; }
    public void setIdCarrito(int idCarrito) { this.idCarrito = idCarrito; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getComprobante() { return comprobante; }
    public void setComprobante(String comprobante) { this.comprobante = comprobante; }
}
   
