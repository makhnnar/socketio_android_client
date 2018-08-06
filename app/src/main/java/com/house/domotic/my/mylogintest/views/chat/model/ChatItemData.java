package com.house.domotic.my.mylogintest.views.chat.model;

public class ChatItemData {
    private String id;
    private String nombre;
    private String mensaje;
    private String foto;
    private String hora;



    public ChatItemData(  String nombre, String mensaje, String foto, String hora, String id) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.foto = foto;
        this.hora = hora;
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

    public String getId() {  return id;    }

    public void setId(String id) { this.id = id;   }
}
