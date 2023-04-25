package LoginSystem;

import java.util.Scanner;

public class register {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your Name: ");
        String name = input.nextLine();
        
        System.out.print("Enter your Height (in cm): ");
        double height = input.nextDouble();
        
        System.out.print("Enter your Weight (in kg): ");
        double weight = input.nextDouble();
        
        System.out.print("Enter your Birth-Date (DD/MM/YYYY): ");
        String birthDate = input.next();
        
        // Create a new object with the user's information
        Person person = new Person(name, height, weight, birthDate);
        
        System.out.println("Registration successful!");
        System.out.println(person.toString());
    }
}

class Person {
    private String name;
    private double height;
    private double weight;
    private String birthDate;
    
    public Person(String name, double height, double weight, String birthDate) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
    }
    
    public String getName() {
        return name;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getBirthDate() {
        return birthDate;
    }
    
    public String toString() {
        return "Name: " + name + "\nHeight: " + height + " cm\nWeight: " + weight + " kg\nBirth-Date: " + birthDate;
    }
}
