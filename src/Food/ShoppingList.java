package Food;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingList {
    Scanner input = new Scanner(System.in);
    Map<String, List<String>> list = new HashMap<String, List<String>>();
    List<String> foodList;

    public Boolean validateList(String name) {
        if (!list.containsKey(name)) {
            System.out.println(name + " doesn't exist!");
            return false;
        }
        return true;
    }
    
    public void createList(String name) {
        if (validateList(name) == true) {
            foodList = new ArrayList<String>();

            while(true) {
                System.out.print("Add a food to the list (When done, type save): ");
                foodList.add(input.nextLine());

                if (input.nextLine() == "save") {
                    list.put(name, foodList);
                    break;
                }
            }
            System.out.println(name + " list created!");
        }
    }

    public void displayList(String name) {
        if (validateList(name) == true) {
            for (Map.Entry<String, List<String>> entry: list.entrySet()) {
                System.out.println("List name: " + entry.getKey() + " -----");
                System.out.println(entry.getValue());
            }
        }
    }

    public void editList(String name) {
        int selectedItem;
        String modifyFoodName;

        if (validateList(name) == true) {
            while(true) {
                System.out.println("Select food to modify (Format: 'list number, food name'. When done, type save)");
                System.out.print("Select a item of " + name + ": ");
                selectedItem = input.nextInt();

                System.out.print(selectedItem + " is selected. Modify food name (To remove this item, type delete): ");
                modifyFoodName = input.nextLine();

                if (modifyFoodName == "delete") {
                    foodList.remove(selectedItem);
                    System.out.print(selectedItem + " is removed from " + name + "!");
                }
                else {
                    foodList.set(selectedItem, modifyFoodName);
                }

                if (input.nextLine() == "save") {
                    list.put(name, foodList);
                    break;
                }
            }
            System.out.print(name + " list updated!");
        }
    }

    public void deleteList(String name) {
        if (validateList(name) == true) {
            list.remove(name);
            System.out.println(name + " list is deleted!");
        }
    }
}
