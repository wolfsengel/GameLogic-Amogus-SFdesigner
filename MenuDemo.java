import java.util.*;

public class MenuDemo {
    public static void main(String[] args) {
        // Crea el menú principal
        Menu mainMenu = new Menu("Menú principal");

        // Crea el menú de tareas
        Menu tasksMenu = new Menu("Tareas");
        tasksMenu.addOption("Engadir tarefa");
        tasksMenu.addOption("Borrar tarefa");
        tasksMenu.addOption("Ver tarefas");
        tasksMenu.addOption("Salir");
        tasksMenu.setAction("Has seleccionado Salir del menú de Tareas.", () -> {
            System.out.println("Ejecutando acción de Salir del menú de Tareas.");
        });

        // Crea el menú de jugadores
        Menu playersMenu = new Menu("Xogadores");
        playersMenu.addOption("Engadir xogador");
        playersMenu.addOption("Borrar xogador");
        playersMenu.addOption("Ver xogadores");
        playersMenu.addOption("Salir");
        playersMenu.setAction("Has seleccionado Salir del menú de Jugadores.", () -> {
            System.out.println("Ejecutando acción de Salir del menú de Jugadores.");
        });

        // Crea el menú de configuración
        Menu configMenu = new Menu("Configuración");
        configMenu.addOption("Configurar tiempo máximo de resposta");
        configMenu.addOption("Salir");

        // Agrega los menús al menú principal
        mainMenu.addSubMenu(tasksMenu);
        mainMenu.addSubMenu(playersMenu);
        mainMenu.addSubMenu(configMenu);
        mainMenu.addOption("Xogar");
        mainMenu.addOption("Salir");

        // Ejecuta el bucle principal del menú
        mainMenu.run();
    }

    // Clase que representa una opción de menú con una acción a ejecutar
    private static class ActionOption extends Option {
        private Runnable action;

        public ActionOption(String name, Runnable action) {
            super(name);
            this.action = action;
        }

        @Override
        public void execute() {
            action.run();
        }
    }

    // Clase que representa un menú
    private static class Menu extends Option {
        private List<Option> options = new ArrayList<>();
        private List<Menu> subMenus = new ArrayList<>();
        private Runnable action;
        private String exitMessage;

        public Menu(String name) {
            super(name);
        }

        public void addOption(String name, Runnable action) {
            options.add(new ActionOption(name, action));
        }

        public void addSubMenu(Menu menu) {
            subMenus.add(menu);
            options.add(menu);
        }

        public void setAction(String exitMessage, Runnable action) {
            this.exitMessage = exitMessage;
            this.action = action;
        }

        @Override
        public void execute() {
            // El menú no tiene ninguna acción
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);

            Menu currentMenu = this;

            while (true) {
                // Muestra las opciones del menú actual
                System.out.println(currentMenu.getName());
               
                for (int i = 0; i < currentMenu.options.size(); i++) {
                    System.out.printf("%d. %s\n", i, currentMenu.options.get(i).getName());
                }
    
                // Pide al usuario que seleccione una opción
                System.out.print("Selecciona una opción: ");
                int selection = scanner.nextInt();
    
                if (selection < 0 || selection >= currentMenu.options.size()) {
                    System.out.println("Opción no válida.");
                    continue;
                }
    
                Option selectedOption = currentMenu.options.get(selection);
    
                if (selectedOption instanceof Menu) {
                    // El usuario seleccionó un submenú
                    currentMenu = (Menu) selectedOption;
                } else {
                    // El usuario seleccionó una opción
                    selectedOption.execute();
    
                    if (selectedOption == currentMenu.options.get(currentMenu.options.size() - 1)) {
                        // El usuario seleccionó la opción de "Salir"
                        if (currentMenu.exitMessage != null) {
                            System.out.println(currentMenu.exitMessage);
                            currentMenu.action.run();
                        }
    
                        if (currentMenu == this) {
                            // Si estamos en el menú principal y el usuario seleccionó la opción de "Salir",
                            // terminamos el bucle y salimos del programa
                            break;
                        } else {
                            // Si estamos en un submenú y el usuario seleccionó la opción de "Salir",
                            // volvemos al menú anterior
                            currentMenu = currentMenu.getParentMenu();
                        }
                    }
                }
            }
    
            scanner.close();
        }
    
        public void addOption(String name) {
            options.add(new Option(name));
        }
    
        public Menu getParentMenu() {
            return parentMenu;
        }
    }
    
    // Clase que representa una opción de menú
    private static class Option {
        private String name;
        protected Menu parentMenu;
    
        public Option(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    
        public void execute() {
            // La opción no tiene ninguna acción
        }
    
        public void setParentMenu(Menu parentMenu) {
            this.parentMenu = parentMenu;
        }
    }
}    