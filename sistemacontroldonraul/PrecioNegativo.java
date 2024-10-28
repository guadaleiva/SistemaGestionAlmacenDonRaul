
package com.mycompany.sistemacontroldonraul;

public class PrecioNegativo extends Exception {
    private final double precioInvalido;

    public PrecioNegativo(String mensaje, double precioInvalido) {
        super("Precio Invalido");
        this.precioInvalido = precioInvalido;
    }

    public double getPrecioInvalido() {
        return precioInvalido;
    }


    @Override
    public String toString() {
        return super.getMessage() + ": " + precioInvalido;
    }
}
    
    
