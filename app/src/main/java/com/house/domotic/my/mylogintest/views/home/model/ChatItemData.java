package com.house.domotic.my.mylogintest.views.home.model;

public class ChatItemData {

    private String nombre;
    private String mensaje;
    private String foto;

    public ChatItemData(String nombre, String mensaje, String foto) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.foto = foto;
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
}
