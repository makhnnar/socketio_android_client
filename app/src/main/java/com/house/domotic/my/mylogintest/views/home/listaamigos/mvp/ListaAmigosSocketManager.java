package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

import java.net.Socket;

public class ListaAmigosSocketManager implements IOSocketGameSender{

    private static Socket socket;
    private IOSocketGameListener listener;
    private String url;
    private AttacksInteractor attackInteractor;


    public GameSocketManager(IOSocketGameListener listener){
        new GameSocketManager(listener,"http://localhost:4000");
    }

    public GameSocketManager(IOSocketGameListener listener,String url){
        this.listener = listener;
        this.url = url;
        try {
            this.attackInteractor = new AttacksInteractor(this.listener);
            IO.Options opts = new IO.Options();
            opts.forceNew = true;
            opts.reconnection = true;
            socket = IO.socket(this.url,opts);
            socket.connect();
            socket.on(Valores.GAME_SOCKET_EVENTS.ATTACKS,this.attackInteractor);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void sendAttack(Proyectil attack) {

    }

    @Override
    public void sendEffect() {

    }

    @Override
    public void sendPosition(int id_player,int area,int x,int y) {
        JSONObject enviar = new JSONObject();
        JSONObject pos = new JSONObject();
        System.out.println("ID_PLAYER ---> "+id_player);
        try{
            pos.put("x",x);
            pos.put("y",y);
            pos.put("area",area);
            enviar.put("pos",pos);
            enviar.put("id_player",id_player);
            System.out.println("ENVIANDO ---> MOVE : "+enviar.toString());
            this.emit(Valores.GAME_SOCKET_EVENTS.MOVE,enviar);
        }catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void sendHealStats(int hp, int mp) {

    }

    @Override
    public void enterWorld(JSONObject player) {
        this.emit(Valores.GAME_SOCKET_EVENTS.ENTER,player);
    }

    private void emit(String evento,JSONObject msg){
        try {
            socket.emit(evento, msg);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("EXCEPCION: "+e.getMessage());
        }
    }

    @Override
    public void sendDisconection(int id_player, int area) {
        JSONObject enviar = new JSONObject();
        System.out.println("ID_PLAYER ---> "+id_player);
        try{
            enviar.put("area",area);
            enviar.put("id_player",id_player);
            System.out.println("ENVIANDO ---> MOVE : "+enviar.toString());
            this.emit(Valores.GAME_SOCKET_EVENTS.DISCONECT,enviar);
        }catch(JSONException e){
            e.printStackTrace();
        }
    }



}
