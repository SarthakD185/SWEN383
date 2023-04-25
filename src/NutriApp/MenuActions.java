package NutriApp;

import Food.ShoppingList;

import Food.Food;
import Workout.Workout;
import PersonalInfo.*;
import static NutriApp.NUTRiApp.*;
import java.util.Scanner;

public class MenuActions {

    // 1. Log Workout
    public static void logWorkout(Scanner reader, Account user) {
        System.out.println("\n\n-- Log Workout --");

        int minutes;
        String intensity;
        String time;
        String date;
       

        minutes = getIntResponse(reader,"How many minutes was your workout? (decimal answer) ");
        System.out.println("What was the intensity? ");
        intensity = reader.next();
        System.out.println("What was the time? ");
        time = reader.next();
        System.out.println("What was the date? ");
        date = reader.next();

        Workout workout = new Workout(minutes, intensity, time, date);
        user.addWorkoutHistory(workout);
    }

    // 2. add new food
    public static void addNewFood(Scanner reader) {
        System.out.println("\n\n -- Add new food --");

        String name;
        int caloriesPerUnit;
        int fatPerUnit;
        int proteinPerUnit;
        int fiberPerUnit;
        int carbohydratesPerUnit;

        System.out.println("What is the food's name: ");
        name = reader.next();
        caloriesPerUnit = getIntResponse(reader, "How many calories per unit? ");
        fatPerUnit = getIntResponse(reader, "How much fat per unit? ");
        proteinPerUnit = getIntResponse(reader, "How much protein per unit? ");
        fiberPerUnit = getIntResponse(reader, "How much fiber per unit? ");
        carbohydratesPerUnit = getIntResponse(reader, "How many carbohydrates per unit? ");

        Food food = new Food(name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, carbohydratesPerUnit);

    }

    // 3. view shoppingList
    public static void viewShoppingList(Scanner reader, Account user) {
        reader = new Scanner(System.in);
        ShoppingList sl = new ShoppingList();
        
        while (true) {
            System.out.println("\n=== Shopping List Manager ===");
            System.out.println("1. Create a new shopping list");
            System.out.println("2. Add an item to a shopping list");
            System.out.println("3. Display a shopping list");
            System.out.println("4. Display all shopping lists");
            System.out.println("5. Delete a shopping list");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");
            
            int choice = reader.nextInt();
            reader.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the new shopping list: ");
                    String listName = reader.nextLine();
                    sl.createShoppingList(listName);
                    break;
                    
                case 2:
                    System.out.print("Enter the name of the shopping list: ");
                    listName = reader.nextLine();
                    System.out.print("Enter the name of the item to add: ");
                    String itemName = reader.nextLine();
                    sl.addItemToShoppingList(listName, itemName);
                    break;
                    
                case 3:
                    System.out.print("Enter the name of the shopping list to display: ");
                    listName = reader.nextLine();
                    sl.displayShoppingList(listName);
                    break;
                    
                case 4:
                    sl.displayAllShoppingLists();
                    break;
                    
                case 5:
                    System.out.print("Enter the name of the shopping list to delete: ");
                    listName = reader.nextLine();
                    sl.deleteShoppingList(listName);
                    break;
                    
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    
        
        // TODO: create the shopping list
        // TODO: view shopping list
    

    // 4. update weight
    public static void updateWeight(Scanner reader, Account user) {
        System.out.println("\n\n -- Update Weight --");

        Double weight = getDoubleResponse(reader, "What is your current weight? ");
        user.changeWeight(weight);
        System.out.println("Weight has been changed.");

    }

    // 5. change weight goal
    public static void changeWeightGoal(Scanner reader, Account user) {
        System.out.println("\n\n -- Change Weight Goal --");

        Double weight = getDoubleResponse(reader, "What is your target weight goal? ");
        user.changeWeight(weight);
        System.out.println("Target Weight has been changed.");
    }

    // 6. eat food
    public static void eatFood(Scanner reader) {
        System.out.println("\n\n -- Eat Food --");
        // TODO finish this
    }



}
