package com.example.loginrest;

public class Comida {
    private String nombre;

    private String id_alimento;

    private String descripcion;

    private Float precio;

    private String tipo;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(String id_alimento) {
        this.id_alimento = id_alimento;
    }
}
