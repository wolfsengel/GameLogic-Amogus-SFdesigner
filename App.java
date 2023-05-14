import java.util.ArrayList;
import java.util.Random;

public class App {
    ArrayList<player> jugadores = playersnames.getPlayers();
    ArrayList<String> tareas =task.getTareas() ;
    int tiemporespuesta=10;
    int puntuacion=0;

    public void jugar(){
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
            //si no quedan viivos se pierde
            int vivos=0;
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i).alive){
                    vivos++;
                }
            }
            if(vivos==0){
                System.out.println("¡No quedan supervivientes!"
                +"\n¡Has perdido!");
                return;
            }

            //distribuir por las habitaciones aleatoriamente
            for (int i = 0; i < jugadores.size(); i++) {
                int random = r.nextInt(Rooms.values().length);
                jugadores.get(i).room=Rooms.values()[random].name();
            }
            //cada ronda cada estudiante hace una tarea y se suma a puntuacion un punto por estudiante vivo
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i) instanceof student && jugadores.get(i).alive){
                    puntuacion++;
                }
            }
            //comprobar si la puntuacion equivale a la suma de todos los estudiantes
            int estudiantes=0;
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i) instanceof student){
                    estudiantes++;
                }
            }
            if(puntuacion==estudiantes*4){
                System.out.println("¡Has completado todas las tareas!"
                +"\n¡Has ganado!");
                return;
            }

             //----Ronda de la muerte--------------------------------------
            //comprobar si hay asesinos en la misma habitacion que un estudiante, cada asesino mata una vez por ronda
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i) instanceof assassin){
                    for (int j = 0; j < jugadores.size(); j++) {
                        if(jugadores.get(i).room.equals(jugadores.get(j).room) && jugadores.get(j) instanceof student){
                            jugadores.get(j).alive=false;
                            System.out.println(" Han matado a "+jugadores.get(j).name+" en la habitacion "+jugadores.get(j).room);
                            break;
                        }
                    }
                }
            }
            //mostrar estado de los jugadores
            System.out.println("Estado de los jugadores:");
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println(jugadores.get(i).name+" esta en la habitacion "+jugadores.get(i).room+" y esta "+(jugadores.get(i).alive ? "vivo" : "muerto"));
            }
            //el ususario decide a quien mata para intentar acertar a un asesino
            System.out.println("¿A quien quieres matar?");
            String matar=System.console().readLine();
            //si se pasa de tiempo no se mata a nadie
            try {
                Thread.sleep(tiemporespuesta*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //comprobar si el jugador existe y matarlo
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i).name.equals(matar)){
                    jugadores.get(i).alive=false;
                    System.out.println("Has matado a "+jugadores.get(i).name);
                    System.out.println(jugadores.get(i).name+" era un "+jugadores.get(i).getClass().getSimpleName());
                    break;
                }
            }

            //comprobar cuantos asesinos quedan vivos
            int asesinosvivos=0;
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i) instanceof assassin && jugadores.get(i).alive){
                    asesinosvivos++;
                }
            }
            //si no queda ninguno se gana
            if(asesinosvivos==0){
                System.out.println("¡Has matado a todos los asesinos!"
                +"\n¡Has ganado!");
                return;
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
