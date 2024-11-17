
package com.mycompany.sistemacontroldonraul;

public class Comprobante {
    private int idComprobante;
    private double totalCompra;
    private String detalle;
    private String fecha;

    public Comprobante(int idComprobante, double totalCompra, String detalle, String fecha) {
        this.idComprobante = idComprobante;
        this.totalCompra = totalCompra;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

