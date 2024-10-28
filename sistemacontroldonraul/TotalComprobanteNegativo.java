
package com.mycompany.sistemacontroldonraul;


public class TotalComprobanteNegativo extends Exception {
    private final double totalInvalido;

    public TotalComprobanteNegativo(String mensaje, double totalInvalido) {
        super("Revisar detalle de Compra");
        this.totalInvalido = totalInvalido;
    }

    public double getTotalInvalido() {
        return totalInvalido;
    }

    @Override
    public String toString() {
        return super.getMessage() + ": " + totalInvalido;
    }
}