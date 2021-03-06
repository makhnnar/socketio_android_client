package com.house.domotic.my.mylogintest.views.home.listaamigos.model;

public class ListaAmigosItemData {

    private String nombre;
    private String estado;
    private String foto;
    private String id;

    public ListaAmigosItemData(String nombre, String estado, String foto, String id) {
        this.nombre = nombre;
        this.estado = estado;
        this.foto = foto;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {  return id;  }

    public void setId(String id) {   this.id = id;  }
}
