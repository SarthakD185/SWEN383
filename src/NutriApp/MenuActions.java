package NutriApp;
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
        System.out.println("\n\n -- View Shopping List --");
        // TODO: create the shopping list
        // TODO: view shopping list
    }

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
