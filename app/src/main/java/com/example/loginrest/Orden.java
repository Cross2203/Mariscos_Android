package com.example.loginrest;

public class Orden {
    String id_orden;

    String id_cliente;

    String id_estado;

    String fecha;

    String direccion_entrega;

    String total;

    String estado;


    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
