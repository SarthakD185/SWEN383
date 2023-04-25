package Food;
import java.util.Scanner;

public class Food {

    private String name;
    private int caloriesPerUnit;
    private int fatPerUnit;
    private int proteinPerUnit;
    private int fiberPerUnit;
    private int carbohydratesPerUnit;

    public Food(String name, int caloriesPerUnit, int fatPerUnit, int proteinPerUnit, int fiberPerUnit, int carbohydratesPerUnit) {
        this.name = name;
        this. caloriesPerUnit = caloriesPerUnit;
        this.fatPerUnit = fatPerUnit;
        this.proteinPerUnit = proteinPerUnit;
        this.fiberPerUnit = fiberPerUnit;
        this.carbohydratesPerUnit = carbohydratesPerUnit;
    }

    // TODO: Replace "name != name" with a variable that is stored somewhere else to ensure there's no duplicate food
    // Like so; "name != foodDB.name"
    public void eat() {
        Scanner input = new Scanner(System.in);
        System.out.print("Select existing food: ");
        name = input.nextLine();

        if (name != name) {
            System.out.println(name + " doesn't exist!");
        }
        else {
            System.out.print("Update " + name + "'s calories per unit: ");
            caloriesPerUnit = input.nextInt();

            System.out.print("Update " + name + "'s fat per unit: ");
            fatPerUnit = input.nextInt();

            System.out.print("Update " + name + "'s protein per unit: ");
            proteinPerUnit = input.nextInt();

            System.out.print("Update " + name + "'s fiber per unit: ");
            fiberPerUnit = input.nextInt();

            System.out.print("Update " + name + " carbohydrates per unit: ");
            carbohydratesPerUnit = input.nextInt();

            System.out.println("You ate " + name + "!");
        }
    }

    public void delete() {
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Select existing food (Or type exit to quit this option): ");
            name = input.nextLine();

            if (name != name) {
                System.out.println("This food you're trying to delete doesn't exist. Please try again later.");
            }
            else if (name == "quit") {
                break;
            }
            else {
                System.out.println(name + " is deleted!");
                break;
            }
        }
    }

    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name of food: ");
        name = input.nextLine();

        if (name != name) {
            System.out.print("Enter " + name + "'s calories per unit: ");
            caloriesPerUnit = input.nextInt();

            System.out.print("Enter " + name + "'s fat per unit: ");
            fatPerUnit = input.nextInt();

            System.out.print("Enter " + name + "'s protein per unit: ");
            proteinPerUnit = input.nextInt();

            System.out.print("Enter " + name + "'s fiber per unit: ");
            fiberPerUnit = input.nextInt();

            System.out.print("Enter " + name + " carbohydrates per unit: ");
            carbohydratesPerUnit = input.nextInt();

            System.out.println("New food added!");
        }
        else {
            System.out.println(name + " already exist!");
        }
    }
}
