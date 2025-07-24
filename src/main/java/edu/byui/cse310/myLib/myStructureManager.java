package edu.byui.cse310.myLib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import edu.byui.cse310.myLib.Task_t;

public class myStructureManager {

  // initialize a vector with all tasks
  private ArrayList<Task_t> allTasks = new ArrayList<>();

  private String filename;

  public myStructureManager(final String filename_) {
    filename = filename_;

    System.out.println("constructor of ManagerStructureClass\\n");

    try (BufferedReader file = new BufferedReader(new FileReader(filename))) {
      String line;

      // run over a file, from begin to the end file.
      while ((line = file.readLine()) != null) {
        // sepate a content of string
        String[] substrings = line.split("\\|");

        // check if there are 3 elements
        if (substrings.length >= 3) {
          int id = Integer.parseInt(substrings[0].trim());
          boolean completed = Integer.parseInt(substrings[1].trim()) == 1 ? true : false;
          String description = substrings[2].trim();

          if (add(id, completed, description)) {
            System.out.println("Loaded ID: " + id);
          }
        }
      }
    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }
  }

  // add new task to buffer
  public boolean add(String description) {

    int id = 0;
    // looking for a last ID
    for (int a = 0; a < allTasks.size(); a++) {
      // if in task id is greater than my current ID
      int tmp_id = allTasks.get(a).getId();
      if (tmp_id > id) {
        id = tmp_id;
      }
    }
    id++;

    Task_t myNewElement = new Task_t();
    myNewElement.setId(id);
    myNewElement.setCompleted(false);
    myNewElement.setDescription(description);

    allTasks.add(myNewElement);

    return true;
  }

  // add new task to buffer
  boolean add(int id, boolean completed, String description) {

    Task_t myNewElement = new Task_t();
    myNewElement.setId(id);
    myNewElement.setCompleted(completed);
    myNewElement.setDescription(description);

    allTasks.add(myNewElement);

    return true;
  }


public boolean complete(int myID)
{

  // if is invalid pointer, return false
  if (allTasks == null)
    return false;

  int id = 0;
  // looking for a last ID
  for (int a = 0; a < allTasks.size(); a++)
  {
    // if in task id is equal my current ID
    if (allTasks.get(a).getId() == myID)
    {
       // change status of my task
       allTasks.get(a).setCompleted(true);
        //(*allTasks)[a].completed = true;
      break;
    }
  }

  return true;
}


  // list all tasks
  public void list() {

    System.out.println("****** Start Elements in Task buffer *******");

    System.out.println(" ID | Completed |  Description of task");
    System.out.println("--------------------------------------");
    for (int a = 0; a < allTasks.size(); a++) {

      System.out.printf("%4d| %-10s| %s%n",
          allTasks.get(a).getId(),
          (allTasks.get(a).getCompleted() ? "Yes" : "No"),
          allTasks.get(a).getDescription());

    }
    System.out.println("--------------------------------------");
    System.out.println("****** End   Elements in Task buffer *******");

  }

  // destructor
  public void destructor() {
    // saveToFile
    // check if a pointer is initailized and free memory
    if (allTasks != null) {

      try (FileWriter file = new FileWriter(filename)) {
        for (int a = 0; a < allTasks.size(); a++) {
          Task_t task = allTasks.get(a);
          file.write(task.getId() + "|" + (task.getCompleted() ? "1" : "0") + "|" + task.getDescription() + "\n");
        }
        // System.out.println("El archivo se creo correctamente.");
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        // No es necesario cerrar el archivo explícitamente ya que se usa
        // try-with-resources
      }
      allTasks.clear();

    }

  }

}
