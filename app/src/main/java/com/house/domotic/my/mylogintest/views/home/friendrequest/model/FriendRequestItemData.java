package com.house.domotic.my.mylogintest.views.home.friendrequest.model;

public class FriendRequestItemData {

    private String nombre;
    private String mensaje;
    private String foto;
    private String hora;


    public FriendRequestItemData(String nombre, String mensaje, String foto, String hora) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.foto = foto;
        this.hora = hora;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
