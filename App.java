import java.util.ArrayList;

public class App {
    ArrayList<player> jugadores = new ArrayList<player>();
    ArrayList<String> tareas =task.getTareas() ;
    int tiemporespuesta;
    int puntacion;

    public void jugar() {
        System.out.println("¡COMIENZA LA PARTTIDA!");

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
