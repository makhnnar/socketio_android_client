package com.house.domotic.my.mylogintest.views.home.profile.model;

public class ProfileItemData {
    private String nombre;
    private String estado;
    private String foto;
    private String conexion;
    private String telefono;
    private String id;


    public ProfileItemData(String nombre, String estado, String foto, String conexion, String telefono) {
        this.nombre = nombre;
        this.estado = estado;
        this.foto = foto;
        this.conexion = conexion;
        this.telefono = telefono;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) { this.conexion = conexion; }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId() {  return id;    }

    public void setId(String id) {  this.id = id;    }
}
