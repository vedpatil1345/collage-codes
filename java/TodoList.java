import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    private static final String FILE_NAME = "todo_list.txt";

    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        loadTodoList(todoList);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Todo List Menu:");
            System.out.println("1. View Todo List");
            System.out.println("2. Add Todo");
            System.out.println("3. Remove Todo");
            System.out.println("4. Save and Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewTodoList(todoList);
                    break;
                case 2:
                    addTodoItem(todoList, scanner);
                    break;
                case 3:
                    removeTodoItem(todoList, scanner);
                    break;
                case 4:
                    saveAndQuit(todoList);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void loadTodoList(ArrayList<String> todoList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                todoList.add(line);
            }
        } catch (IOException e) {
            // File doesn't exist or other IO error, ignore
        }
    }

    private static void viewTodoList(ArrayList<String> todoList) {
        if (todoList.isEmpty()) {
            System.out.println("Todo list is empty.");
        } else {
            System.out.println("Todo List:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    private static void addTodoItem(ArrayList<String> todoList, Scanner scanner) {
        System.out.print("Enter new todo item: ");
        String newItem = scanner.nextLine();
        todoList.add(newItem);
        System.out.println("Todo item added.");
    }

    private static void removeTodoItem(ArrayList<String> todoList, Scanner scanner) {
        if (todoList.isEmpty()) {
            System.out.println("Todo list is already empty.");
            return;
        }

        viewTodoList(todoList);
        System.out.print("Enter the number of the item to remove: ");
        int indexToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (indexToRemove >= 1 && indexToRemove <= todoList.size()) {
            todoList.remove(indexToRemove - 1);
            System.out.println("Todo item removed.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    private static void saveAndQuit(ArrayList<String> todoList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String item : todoList) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("Todo list saved. Exiting program.");
        } catch (IOException e) {
            System.out.println("Error saving todo list: " + e.getMessage());
        }
    }
}