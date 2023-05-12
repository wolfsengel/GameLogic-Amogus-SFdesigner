import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
String nombre;
ArrayList<Menu> submenus= new ArrayList<Menu>();
//get nombre
public String getNombre() {
    return nombre;
}
// Constructor
    private Menu(String nombre){
        this.nombre = nombre;
    }
    private void addSubmenu(Menu menu) {
        this.submenus.add(menu);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu Principal = new Menu("Principal");
        Menu conf=new Menu("Configuracion");
        Menu jug=new Menu("Jugar");
        Menu sal=new Menu("Salir");
        Principal.addSubmenu(conf);
        Principal.addSubmenu(jug);
        Principal.addSubmenu(sal);
        Menu tar=new Menu("Tareas");
        Menu Jugadores=new Menu("Jugadores");
        Menu tiempo=new Menu("Tiempo Maximo de Respuesta");
        Menu sal2=new Menu("Salir");
        conf.addSubmenu(tar);
        conf.addSubmenu(Jugadores);
        conf.addSubmenu(tiempo);
        conf.addSubmenu(sal2);
        Menu engtar=new Menu("Añadir tarea");
        Menu elitar=new Menu("Eliminar tarea");
        Menu vertar=new Menu("Ver tareas");
        Menu sal3=new Menu("Salir");
        tar.addSubmenu(engtar);
        tar.addSubmenu(elitar);
        tar.addSubmenu(vertar);
        tar.addSubmenu(sal3);
        Menu engjug=new Menu("Añadir jugador");
        Menu elijug=new Menu("Eliminar jugador");
        Menu verjug=new Menu("Ver jugadores");
        Menu sal4=new Menu("Salir");
        Jugadores.addSubmenu(engjug);
        Jugadores.addSubmenu(elijug);
        Jugadores.addSubmenu(verjug);
        Jugadores.addSubmenu(sal4);

        //mostar menu
        Menu auxMenu = Principal;
        App juego = new App();
        while(true){
            System.out.println("Menu: "+auxMenu.getNombre());
            for(int i=0;i<auxMenu.submenus.size();i++){
                System.out.println(i+" "+auxMenu.submenus.get(i).getNombre());
            }
            System.out.println("Ingrese el numero de la opcion que desea");
            int opcion = Integer.parseInt(sc.nextLine());
            if(opcion<auxMenu.submenus.size()){
                //si la opcion no tiene submenus, ejecuta una funcion independiente de cada opcion
                if(auxMenu.submenus.get(opcion).submenus.size()==0){
                    //ejecutar funcion jugar
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Jugar")){
                        juego.jugar();
                    }
                    //ejecutar funcion configurar tiempo
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Tiempo Maximo de Respuesta")){
                        System.out.println("Configurando tiempo");
                    }
                    //ejecutar funcion añaadir tarea
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Añadir tarea")){
                        System.out.println("Añadiendo tarea");
                    }
                    //ejecutar funcion eliminar tarea
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Eliminar tarea")){
                        System.out.println("Eliminando tarea");
                    }
                    //ejecutar funcion ver tareas
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Ver tareas")){
                        System.out.println("Viendo tareas");
                    }
                    //ejecutar funcion añadir jugador
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Añadir jugador")){
                        System.out.println("Añadiendo jugador");
                    }
                    //ejecutar funcion eliminar jugador
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Eliminar jugador")){
                        System.out.println("Eliminando jugador");
                    }
                    //ejecutar funcion ver jugadores
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Ver jugadores")){
                        System.out.println("Viendo jugadores");
                    }
                    //ejecutar funcion salir
                    if(auxMenu.submenus.get(opcion).getNombre().equals("Salir")){
                        System.out.println("Saliendo del programa");
                        System.exit(0);
                    }
                }
                
                auxMenu = auxMenu.submenus.get(opcion);
            }else{
                System.out.println("Opcion no valida");
            }
        }
        
    }
    
}   