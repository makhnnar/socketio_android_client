package com.house.domotic.my.mylogintest.views.home.chatactivos.model;

public class ChatActivosItemData {

    private String nombre;
    private String mensaje;
    private String foto;
    private String id;

    public ChatActivosItemData(String nombre, String mensaje, String foto, String id) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.foto = foto;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
