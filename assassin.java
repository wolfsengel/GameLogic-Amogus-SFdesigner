public class assassin extends player {
    //matar funcion
    //matar a un jugador
    public void matar(player p){
        p.alive=false;
        System.out.println("El jugador "+p.name+" ha sido asesinado");
    }

}
