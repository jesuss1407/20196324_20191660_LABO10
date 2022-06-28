package com.example.laboratorio10_grupo3.Beans;

public class EstudianteBean {

    private int idcodigo;
    private String nombre;
    private String apellido;
    private int edad;
    private String especialidad;
    private String status;
    private String correo;
    private String contasena_hashed;

    public String getContasena_hashed() {
        return contasena_hashed;
    }

    public void setContasena_hashed(String contasena_hashed) {
        this.contasena_hashed = contasena_hashed;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdcodigo() {
        return idcodigo;
    }

    public void setIdcodigo(int idcodigo) {
        this.idcodigo = idcodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
