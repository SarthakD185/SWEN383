import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoginSystem {

    private static final String FILE_NAME = "details.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Login System!");

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("1. Create an account");
            System.out.println("2. Log in");
            System.out.print("Please choose an option (1 or 2): ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    loggedIn = login(scanner);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        System.out.println("You are now logged in.");
    }

    private static boolean login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens[0].equals(username) && tokens[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user details file.");
        }

        System.out.println("Incorrect username or password. Please try again.");
        return false;
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(username + "," + password + "\n");
        } catch (IOException e) {
            System.err.println("Error writing user details file.");
        }

        System.out.println("Account created successfully.");
    }
}
