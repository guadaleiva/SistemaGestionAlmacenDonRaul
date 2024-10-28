
package com.mycompany.sistemacontroldonraul;

public class PrecioDuplicado extends Exception {
    private final String nombreProducto;

    public PrecioDuplicado(String mensaje, String nombreProducto) {
        super("Revisar, precio dublicado");
        this.nombreProducto = nombreProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    @Override
    public String toString() {
        return super.getMessage() + " Producto: " + nombreProducto;
    }
}