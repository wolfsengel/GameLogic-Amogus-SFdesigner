import java.util.ArrayList;
import java.util.Random;

public class App {
    ArrayList<player> jugadores = playersnammes.getPlayers();
    ArrayList<String> tareas =task.getTareas() ;
    int tiemporespuesta;
    int puntacion;

    public void jugar() {
        System.out.println("¡COMIENZA LA PARTTIDA!");
        int asesinos= jugadores.size()>4 ? jugadores.size()/4 : 1;
        System.out.println("Sois "+jugadores.size()+" jugadores, pero hay "+asesinos+" asesinos");

        //distribucion de los roles aleatoriamente
        Random r = new Random();
        for (int i = 0; i < asesinos; i++) {
            int random = r.nextInt(jugadores.size());
            if(jugadores.get(random) instanceof student){
                player playero = new assassin(jugadores.get(random));
                jugadores.set(random, playero); 
            }            
        }

        //comienza el juego
        while(true){
            //mostrar vivos
            System.out.println("Vivos:");
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i).alive){
                    System.out.println(jugadores.get(i).name);
                }
            }
            
            //distribuir por las habitaciones aleatoriamente
            for (int i = 0; i < jugadores.size(); i++) {
                int random = r.nextInt(Rooms.values().length);
                jugadores.get(i).room=Rooms.values()[random].name();
            }

            //distruibuir 4 tareas aleatoriamente a cada jugador estudiante
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i) instanceof student){
                    for (int j = 0; j < 4; j++) {
                        int random = r.nextInt(tareas.size());
                        jugadores.get(i).tasks.add(tareas.get(random));
                    }
                }
            }
            
        }
        



    }

    //--------------------------------------------------------------------------------------------------------------
    //ver tareas
    public void vertareas() {
        System.out.println("Tareas:");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println(tareas.get(i));
        }
    }
    //configurar tiempo
    public void configurarTiempo(int tiempo) {
        this.tiemporespuesta=tiempo;
    }
    //añadir tarea
    public void añadirtarea(String tarea) {
        this.tareas.add(tarea);
    }
    //eliminar tarea
    public void eliminartarea(String tarea) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).equals(tarea)) {
                this.tareas.remove(i);
            }
        }
    }
    //añadir jugador
    public void añadirjugador(String jugador) {
        player playero=new student(jugador);
        this.jugadores.add(playero);
    }
    //eliminar jugador
    public void eliminarjugador(String jugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).name.equals(jugador)) {
                this.jugadores.remove(i);
            }
        }
    }
    //ver jugadores
    public void verjugadores() {
        System.out.println("Jugadores:");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println(jugadores.get(i).name);
        }
    }

}
