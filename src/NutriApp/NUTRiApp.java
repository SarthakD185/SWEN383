package NutriApp;

import PersonalInfo.*;
import Workout.*;
// import Registration.*;

import java.util.Scanner;

import static NutriApp.MenuActions.*;

public class NUTRiApp {

    /**
     * Prompts the user to register if they are a new user and
     * save their account, logging them in
     */
    public static void register(Scanner reader, Account user) {
        // TODO: make any PTUI changes you want

        System.out.println("\n\n -- Register --");
        System.out.println("Welcome to NutriApp, lets get you acount set up\nI'm going to start by asking you some personal details");

        // defining variables we need to get
        String name;
        int age;
        String height;
        double weight;
        String birthdate;
        double targetWeight;
        Goal.WeightGoal goalType;

        //get data from user
        System.out.println("\n - What is your name? ");
        name = reader.next();
        age = getIntResponse(reader, " - What is your age? ");
        System.out.println(" - What is your height? ");
        height = reader.next();
        weight = getDoubleResponse(reader," - What is your weight? (decimal is ok) ");
        System.out.println(" - What is your birthdate? (mm-dd-yyyy)");
        birthdate = reader.next();
        targetWeight = getDoubleResponse(reader, " - What is your target weight? ");

        if (targetWeight == weight) {
            goalType = Goal.WeightGoal.MAINTAIN;
        } else if (targetWeight > weight) {
            goalType = Goal.WeightGoal.GAIN;
        } else {
            goalType = Goal.WeightGoal.LOOSE;
        }
        System.out.println("Perfect, your weight goal is " + goalType + ". If this \n" +
                        "is not correct, you can change it later in the menu.");

        // create new user
        System.out.println("Creating account...");
        user = new Account(name, age, height, weight, birthdate, targetWeight, goalType);
        // TODO: make PTUI work with back end

        System.out.println("\nCongratulations! Your account has been created.");
        menuOfActions(reader, user);
    }

    /**
     * Prompts the user to log in to their acount and logs them in
     */
    public static void login(Scanner reader, Account user) {
        // TODO: make any PTUI changes you want

        System.out.println("\n\n -- Login --");

        String username;
        String password;

        System.out.println("Enter your username: ");
        username = reader.next();
        System.out.println("Enter your password: ");
        password = reader.next();

        System.out.println("Logging you in...");
        // TODO: make PTUI work with back end
        // TODO: instantiate user with their data

        System.out.println("Successfully Logged In!");

        System.out.println("Has your weight changed since your last login?");
        updateWeight(reader, user);
        menuOfActions(reader, user);
    }

    /**
     * Allows the user to choose between the actions the app offers
     */
    public static void menuOfActions(Scanner reader, Account user) {
        // start the while loop for options
        boolean exit = false;
        while (!exit) {

            // print out the options
            System.out.println("\n\n -- Menu --");
            System.out.println("Enter an Option: \n");
            System.out.println("1. Log Workout ");
            System.out.println("2. Add new Food ");
            System.out.println("3. View Shopping List ");
            System.out.println("4. Update weight ");
            System.out.println("5. Change weight goal ");
            System.out.println("6. Eat Food ");
            System.out.println("7. Exit and Logout ");

            int selection = getIntResponse(reader, "\nSelection: ");

            switch (selection) {
                case 1:
                    // Log Workout
                    logWorkout(reader, user);
                    break;

                case 2:
                    // Add New Food
                    addNewFood(reader);
                    break;

                case 3:
                    // View Shopping List
                    viewShoppingList(reader, user);
                    break;

                case 4:
                    // Update weight
                    updateWeight(reader, user);
                    break;

                case 5:
                    //change weight goal
                    changeWeightGoal(reader, user);
                    break;

                case 6:
                    // eat food
                    eatFood(reader);
                    break;

                case 7:
                    //exit
                    exit = true;
                    System.out.println("\nLogging out...");
                    System.out.println("Exiting Program :) \nSee you later");
                    System.exit(0);
                    break;

            }


        }
    }

    /**
     * Gets a double response from the user and handles if they try to use non numbers in their answer
     * @param reader - scanner object for user info
     * @return - the double answer
     */
    public static double getDoubleResponse(Scanner reader, String question) {
        double response = 0;

        while(true) {
            System.out.println(question);
            try {
                response = Double.parseDouble(reader.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Use only whole numbers in your answer. Ex: 23 ");
            }
        }

        return response;
    }

    /**
     * Gets a int response from the user and handles if they try to use non numbers or decimals in their answer
     * @param reader - scanner object for user info
     * @return - the int answer
     */
    public static int getIntResponse(Scanner reader, String question) {
        int response = 0;

        while(true) {
            System.out.println(question);
            try {
                response = Integer.parseInt(reader.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Use only numbers in your answer. Ex: 23.34 ");
            }
        }

        return response;
    }

    public static void main(String args[]) {
        System.out.println("Welcome To NutriApp");

        // set up a user Account, it will be filled in login or register
        Account user = null;

        Scanner reader = new Scanner(System.in);
        String answer = "";

        // sends user to login or register
        System.out.println("Are you a new user? (y or n) ");
        answer = reader.next();
        if (answer.equalsIgnoreCase("y")) {
            register(reader, user);
        } else {
            login(reader, user);
        }

    }

}
