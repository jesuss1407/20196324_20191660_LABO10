package com.example.laboratorio10_grupo3.Beans;

public class ViajesBean {

    private int idviajes;
    private String fecha_reserva;
    private String fecha_viaje;
    private String ciudad_origen;
    private String ciudad_destino;
    private String seguro;
    private int cantidadcompra;
    private int costo_total;
    private int  estudiantes_idcodigo;
    private int  idcompraviajes;

    public int getIdcompraviajes() {
        return idcompraviajes;
    }

    public void setIdcompraviajes(int idcompraviajes) {
        this.idcompraviajes = idcompraviajes;
    }

    public int getEstudiantes_idcodigo() {
        return estudiantes_idcodigo;
    }

    public void setEstudiantes_idcodigo(int estudiantes_idcodigo) {
        this.estudiantes_idcodigo = estudiantes_idcodigo;
    }

    public int getIdviajes() {
        return idviajes;
    }

    public void setIdviajes(int idviajes) {
        this.idviajes = idviajes;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getFecha_viaje() {
        return fecha_viaje;
    }

    public void setFecha_viaje(String fecha_viaje) {
        this.fecha_viaje = fecha_viaje;
    }

    public String getCiudad_origen() {
        return ciudad_origen;
    }

    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }

    public String getCiudad_destino() {
        return ciudad_destino;
    }

    public void setCiudad_destino(String ciudad_destino) {
        this.ciudad_destino = ciudad_destino;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public int getCantidadcompra() {
        return cantidadcompra;
    }

    public void setCantidadcompra(int cantidadcompra) {
        this.cantidadcompra = cantidadcompra;
    }

    public int getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(int costo_total) {
        this.costo_total = costo_total;
    }
}
