package edu.byui.cse310;

import java.util.Scanner;

import edu.byui.cse310.myLib.myMenu;
import edu.byui.cse310.myLib.myStructureManager;

/**
 * main program
 */
public final class App {
    // global variable, name of file log
    final static String FILENAME_TASK = "my_task.txt";

    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        boolean active = true;
        do {
            myMenu menu = new myMenu();

            int selected = menu.getMenuOption();
            System.out.println("Seleccionaste: " + selected);
            switch (selected) {
                case 1:
                    menuAddTask();
                    break;

                case 2:
                    break;

                case 3:
                    break;
                case 4:
                    menuListTask();
                    break;
                case 5:
                    active = false;
                    break;
            }

        } while (active);
    }

    public static void menuAddTask() {
        String description;
        // clear screen
        System.out.print("\033[H\033[2J");
        System.out.println("New task");
        System.out.println("----------------------------");
        System.out.print("Description: ");

        // read keyboard
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n"); // Ignore buffer
        description = scanner.next().trim();

        if (description.length() > 1) {
            // Nueva instancia de la clase TaskManager
            myStructureManager myStructure = new myStructureManager(FILENAME_TASK);
            if (myStructure != null) {
                // Método para agregar una nueva tarea
                myStructure.add(description);
                myStructure.destructor();
            }
        }
    }

      public static void menuCompleteTask() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n"); // Ignore buffer
        System.out.println("Complete a task ID");
        System.out.println("----------------------------");
        System.out.print("ID to Complete: ");
        
        String myID = scanner.nextLine().trim();  // leer línea y eliminar espacios al inicio/final
        
        int id = 0;
        try {
            id = Integer.parseInt(myID);
        } catch (NumberFormatException e) {
            // id inválido, no hacer nada o mostrar error si quieres
        }
        
        if (id > 0) {
            myStructureManager myAllTasks = new myStructureManager(FILENAME_TASK);
            myAllTasks.complete(id);
            // call manually the destructor 
            myStructure.destructor();
        }
    }

    // procedure list all task in file
    public static void menuListTask() {
        myStructureManager myStructure = new myStructureManager(FILENAME_TASK);
        myStructure.list();
    }

}
