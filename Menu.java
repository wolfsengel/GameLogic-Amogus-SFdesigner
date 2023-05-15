import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Componente base del patrón Composite
interface MenuComponent {
    void agregar(MenuComponent menuComponent);
    void remover(MenuComponent menuComponent);
    void mostrar();
    void ejecutar();
}

// Clase para representar los menús
class MenuComposite implements MenuComponent {
    private String nombre;
    private List<MenuComponent> submenus;

    public MenuComposite(String nombre) {
        this.nombre = nombre;
        this.submenus = new ArrayList<>();
    }

    public void agregar(MenuComponent menuComponent) {
        submenus.add(menuComponent);
    }

    public void remover(MenuComponent menuComponent) {
        submenus.remove(menuComponent);
    }

    @Override
    public void mostrar() {
        System.out.println(nombre);
        System.out.println("-----------");

        for (int i = 0; i < submenus.size(); i++) {
            System.out.println((i + 1) + ". " + submenus.get(i).toString());
        }
    }

    @Override
    public void ejecutar() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;

            do {
                mostrar();
                System.out.println("Seleccione una opción (0 para salir):");
                opcion = scanner.nextInt();

                if (opcion > 0 && opcion <= submenus.size()) {
                    MenuComponent submenu = submenus.get(opcion - 1);
                    submenu.ejecutar();
                }
            } while (opcion != 0);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}

// Clase para representar las opciones de menú
class Opcion implements MenuComponent {
    private String nombre;
    private Runnable accion;

    public Opcion(String nombre, Runnable accion) {
        this.nombre = nombre;
        this.accion = accion;
    }

    @Override
    public void agregar(MenuComponent menuComponent) {
        // No se puede agregar submenús u opciones a una opción
        throw new UnsupportedOperationException();
    }

    @Override
    public void remover(MenuComponent menuComponent) {
        // No se puede remover submenús u opciones de una opción
        throw new UnsupportedOperationException();
    }

    @Override
    public void mostrar() {
        System.out.println(nombre);
    }

    @Override
    public void ejecutar() {
        accion.run();
    }

    @Override
    public String toString() {
        return nombre;
    }
}




public class Menu {
    Scanner sc = new Scanner(System.in);
     //INICIAR APP
    App app = new App();
    //funcion que llame a app.añadirtarea
    public void añadirtarea() {
        //pide la tarea al usuario
        System.out.println("Introduce la tarea que quieres añadir");
        String tarea = sc.nextLine();
        //añade la tarea
        app.añadirtarea(tarea);
        System.out.println("Tarea añadida");
    }
    //funcion que llame a app.eliminartarea
    public void eliminartarea() {
        //pide la tarea al usuario
        System.out.println("Introduce la tarea que quieres eliminar");
        String tarea = sc.nextLine();
        //elimina la tarea
        app.eliminartarea(tarea);
        System.out.println("Tarea eliminada");
    }
    //funcion que llame a app.vertareas
    public void vertareas() {
        app.vertareas();
    }
    //funcion que llame a app.añadirjugador
    public void añadirjugador() {
        //pide el nombre al usuario
        System.out.println("Introduce el nombre del jugador que quieres añadir");
        String jugador = sc.nextLine();
        //añade el jugador
        app.añadirjugador(jugador);
        System.out.println("Jugador añadido");
    }
    //funcion que llame a app.eliminarjugador
    public void eliminarjugador() {
        //pide el nombre al usuario
        System.out.println("Introduce el nombre del jugador que quieres eliminar");
        String jugador = sc.nextLine();
        //elimina el jugador
        app.eliminarjugador(jugador);
        System.out.println("Jugador eliminado");
    }
    //funcion que llame a app.verjugadores
    public void verjugadores() {
        app.verjugadores();
    }
    //funcion que llame a app.configurarTiempo
    public void configurarTiempo() {
        //pide el tiempo al usuario
        System.out.println("Introduce el tiempo que quieres configurar");
        int tiempo = sc.nextInt();
        //configura el tiempo
        app.configurarTiempo(tiempo);
        System.out.println("Tiempo configurado");
    }
    //funcion que llame a app.jugar
    public void jugar() {
        app.jugar();
    }
    
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        // Crear el menú principal
        MenuComponent menuPrincipal = new MenuComposite("Menú Principal");

        // Crear los submenús y opciones de menú (se omiten para mayor claridad)
        MenuComponent submenuConfiguracion = new MenuComposite("Configuración");
        
        // Crear las opciones de menú
        MenuComponent opcionJugar = new Opcion("Jugar", menu::jugar);

        // Agregar los submenús al menú principal
        menuPrincipal.agregar(submenuConfiguracion);
        menuPrincipal.agregar(opcionJugar);

        // Crear los submenús de configuración
        MenuComponent submenuTareas = new MenuComposite("Tareas");
        MenuComponent submenuJugadores = new MenuComposite("Jugadores");
        MenuComponent submenuTiempoMaximo = new MenuComposite("Tiempo Máximo de Respuesta");



        // Agregar los submenús de configuración
        submenuConfiguracion.agregar(submenuTareas);
        submenuConfiguracion.agregar(submenuJugadores);
        submenuConfiguracion.agregar(submenuTiempoMaximo);

        // Crear las opciones de menú de tareas
        MenuComponent opcionAnadirTarea = new Opcion("Añadir Tarea", menu::añadirtarea);
        MenuComponent opcionEliminarTarea = new Opcion("Eliminar Tarea", menu::eliminartarea);
        MenuComponent opcionVerTareas = new Opcion("Ver Tareas", menu::vertareas);

        // Agregar las opciones de menú a tareas
        submenuTareas.agregar(opcionAnadirTarea);
        submenuTareas.agregar(opcionEliminarTarea);
        submenuTareas.agregar(opcionVerTareas);

        // Crear las opciones de menú de jugadores
        MenuComponent opcionAnadirJugador = new Opcion("Añadir Jugador", menu::añadirjugador);
        MenuComponent opcionEliminarJugador = new Opcion("Eliminar Jugador", menu::eliminarjugador);
        MenuComponent opcionVerJugadores = new Opcion("Ver Jugadores", menu::verjugadores);

    // Agregar las opciones de menú a jugadores
    submenuJugadores.agregar(opcionAnadirJugador);
    submenuJugadores.agregar(opcionEliminarJugador);
    submenuJugadores.agregar(opcionVerJugadores);

    // Mostrar el menú principal
    menuPrincipal.ejecutar();
       
    }
}