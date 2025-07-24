package edu.byui.cse310.myLib;

import java.util.Scanner;

public class myMenu {

  public void clearConsole() {
    // Código ANSI para limpiar pantalla y mover cursor al inicio
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  // list of items menu
  public void showMyMenu() {

    // clear console
    clearConsole();

    System.out.println("Main Sprint 2 Amauri Siqueira");

    System.out.println("1 | Create a new task");
    System.out.println("2 | Complete a task");
    System.out.println("3 | Delete a task");
    System.out.println("4 | List all tasks");
    System.out.println("5 | Exit of program");
    System.out.print("\n\nPlease choice a option between 1 and 5: ");
  }

  public int getMenuOption() {
    Scanner scanner = new Scanner(System.in);
    int optionSelected = 0;

    do {

      showMyMenu();

      if (scanner.hasNextInt()) {
        optionSelected = scanner.nextInt();
      } else {
        System.out.println("Invalid number. Please try again!");
        scanner.next(); // clear input buffer
        continue; // skip secuence
      }

      if (optionSelected < 1 || optionSelected > 5) {
        System.out.println("Invalid option! . try  entre a number between 1 and 5.");
      }

    } while (optionSelected < 1 || optionSelected > 5);

    return optionSelected;
  }

}
