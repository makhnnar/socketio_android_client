package com.house.domotic.my.mylogintest.views.chat.model;

public class ChatItemData {
    private String mensaje;
    private String nombre;
    private String foto;
    private String hora;



    public ChatItemData( String mensaje, String nombre, String foto, String hora) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.foto = foto;
        this.hora = hora;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
