package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

public class ListaAmigosManager implements IOSocketGameListener,IOSocketGameSender{

    private GameListener listener;
    private GameSocketManager manager;

    private ArrayList<Player> players;
    private ArrayList<Proyectil> attacks;
    private ArrayList<Mob> mobs;
    private Player player;

    public GameManager(GameListener listener,ArrayList<Player> players,ArrayList<Proyectil> attacks,ArrayList<Mob> mobs){
        this.listener = listener;
        manager = new GameSocketManager(this,Valores.URL_NUCLEO);
        this.players = players;
        this.attacks = attacks;
        this.mobs = mobs;
    }

    //TODO: remover esto. es un parche. acomodar la arquitectura
    public void setPlayer(Player player){
        this.player = player;
    }

    @Override
    public void recieveAttacks(ArrayList<Proyectil> attacks) {
        //revisar los atacks (status en general)
        listener.onAttacksChange(attacks);
    }

    @Override
    public void recievePlayers(ArrayList<Player> players) {
        //revisar los players (status en general)
        this.players = players;
        System.out.println("RECIBIMOS UN TOTAL DE "+players.size()+" PLAYERS ONLINE");
        listener.onPlayersChange(players);
    }

    @Override
    public void recieveEffects() {


    }

    @Override
    public void recieveMobs(ArrayList<Mob> mobs) {
        //revisar los mobs (status en general)
        listener.onMobsChange(mobs);
    }

    @Override
    public void sendAttack(Proyectil attack) {


    }

    @Override
    public void sendEffect() {


    }

    @Override
    public void sendPosition(int id_player, int area, int x, int y) {
        manager.sendPosition(id_player, area, x, y);

    }

    @Override
    public void sendHealStats(int hp, int mp) {


    }

    @Override
    public void enterWorld(JSONObject player) {
        manager.enterWorld(player);
    }

    @Override
    public void recievePlayersMovement(JSONObject movement) {
        //procesamos el moviento recibido
        if(player!=null){
            if(movement.getInt("id_player")!=player.getId_player()){
                for(int i=0;i<players.size();i++){
                    if(movement.getInt("id_player")==players.get(i).getId_player()){
                        System.out.println("CAMBIANDO LA POSICION DEL JUGADOR "+players.get(i).getNickname());
                        players.get(i).setPosAMover(
                                new Point(
                                        movement.getJSONObject("pos").getInt("x")*Valores.TAM_ANCHO_CUADRO,
                                        movement.getJSONObject("pos").getInt("y")*Valores.TAM_ALTO_CUADRO
                                )
                        );
                    }
                }
                listener.onPlayersChange(players);
                //al finalizar el for deberi amos refrescar los players(probar)
            }
        }
    }

    @Override
    public void sendDisconection(int id_player, int area) {
        manager.sendDisconection(id_player, area);
    }

    @Override
    public void recieveNewPlayer(Player player) {
        if(player.getId_player()!=this.player.getId_player()){
            System.out.println("AGREGADO EL RECIEN LLEGADO");
            players.add(player);
            listener.onPlayersChange(players);
        }
    }

}
