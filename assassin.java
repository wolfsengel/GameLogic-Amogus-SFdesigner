public class assassin extends player {
    public void matar(player p){
        p.alive=false;
        System.out.println("El jugador "+p.name+" ha sido asesinado");
    }
    //constructor
    public assassin(player player){
        this.name=player.name;
        this.alive=player.alive;
    }

}
