import java.util.ArrayList;

public class App {
    int numerojugadores;
    String[] jugadores = new String[numerojugadores];
    ArrayList<String> tareas =task.getTareas() ;
    int tiemporespuesta;
    int puntacion;

    public void jugar() {
        System.out.println("Jugando");
        




    }
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
        this.jugadores[this.jugadores.length+1]=jugador;
    }
    //eliminar jugador
    public void eliminarjugador(String jugador) {
        for (int i = 0; i < this.jugadores.length; i++) {
            if (jugadores[i].equals(jugador)) {
                this.jugadores[i]="";
            }
        }
    }
    //ver jugadores
    public void verjugadores() {
        for (int i = 0; i < this.jugadores.length; i++) {
          System.out.println(jugadores[i]);
        }
    }

}
