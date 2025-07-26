#  Requirements Report – Java Task Manager

## Basic Requirements

- **Variables**  
  Variables like `int id`, `boolean completed`, `String description`, and objects such as `ArrayList<Task_t>` are used throughout the program.

- **Expressions**  
  Arithmetic and logical expressions are used for validating menu input, looping through tasks, and checking conditions (`==`, `!=`, `>`, etc.).

- **Conditionals**  
  Multiple `if` and `switch` statements are used to control logic in the menu and task operations.

- **Loops**  
  `for` loops are used to iterate over the task list, load from file, and write to file.

- **Functions (Methods)**  
  The program is fully modular and uses custom methods such as:
  - `menuAddTask()`
  - `menuCompleteTask()`
  - `menuDeleteTask()`
  - `menuListTask()`
  - `add()`, `complete()`, `del()`, `list()`, `destructor()` within the `myStructureManager` class.

- **Classes**  
  The project defines and uses several custom classes:
  - `App` (main program logic)
  - `myMenu` (user interface)
  - `myStructureManager` (task management and persistence)
  - `Task_t` (task data structure)

- **Java Collections Framework**  
  The program uses `ArrayList<Task_t>` from the Java Collection Framework to manage the list of tasks dynamically.

---

## Additional Requirement Chosen

- **Read and write to a file**  
  The program uses `BufferedReader` and `FileWriter` to read from and write to `my_task.txt`. This allows tasks to be persisted between program executions.

---

## How the Program Works

- The user interacts through a console-based menu.
- The user can:
  - Add a new task
  - Complete an existing task
  - Delete a task
  - View all tasks
- Tasks are stored in a file, each line containing the task ID, status (completed or not), and description.
- All logic is encapsulated in modular classes following good object-oriented design.

---
