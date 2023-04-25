package Food;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingList {
    
    private HashMap<String, ArrayList<String>> shoppingLists;
    
    public ShoppingList() {
        shoppingLists = new HashMap<String, ArrayList<String>>();
    }
    
   public void createShoppingList(String listName) {
       Scanner scanner = new Scanner(System.in);
       ArrayList<String> itemList = new ArrayList<>();
       
       System.out.println("Creating a new shopping list: " + listName);
       while (true) {
           System.out.print("Enter an item to add (or type 'done' to finish): ");
           String item = scanner.nextLine();
   
           if (item.equalsIgnoreCase("done")) {
               break;
           }
   
           itemList.add(item);
       }
   
       shoppingLists.put(listName, itemList);
       System.out.println("Shopping list created successfully!");
   }

   

    
    public void deleteShoppingList(String listName) {
        shoppingLists.remove(listName);
        System.out.println("Deleted shopping list: " + listName);
    }
    
    public void addItemToShoppingList(String listName, String itemName) {
        if (shoppingLists.containsKey(listName)) {
            ArrayList<String> itemList = shoppingLists.get(listName);
            itemList.add(itemName);
            System.out.println("Added " + itemName + " to " + listName + ".");
        } else {
            System.out.println("Shopping list " + listName + " does not exist.");
        }
    }
    
    public void displayAllShoppingLists() {
        System.out.println("Shopping Lists:");
        for (String listName : shoppingLists.keySet()) {
            System.out.println("- " + listName);
        }
    }
    
    public void displayShoppingList(String listName) {
        if (shoppingLists.containsKey(listName)) {
            ArrayList<String> itemList = shoppingLists.get(listName);
            System.out.println(listName + ":");
            for (String item : itemList) {
                System.out.println("- " + item);
            }
        } else {
            System.out.println("Shopping list " + listName + " does not exist.");
        }
    }
}
