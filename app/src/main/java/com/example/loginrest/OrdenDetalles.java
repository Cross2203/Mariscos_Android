package com.example.loginrest;

public class OrdenDetalles {

    String id_orden_detalle;

    String id_orden;

    String id_alimento;

    String id_estado;

    String cantidad;

    String precio_unitario;

    String precio_total;

    public String getId_orden_detalle() {
        return id_orden_detalle;
    }

    public void setId_orden_detalle(String id_orden_detalle) {
        this.id_orden_detalle = id_orden_detalle;
    }

    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(String id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(String precio_total) {
        this.precio_total = precio_total;
    }
}
