import java.util.*;

public class Recipes {
    private Map<String, Recipe> recipes;
    private Map<String, Integer> stock;
    private int dailyTargetCalories;

    public Recipes() {
        this.recipes = new HashMap<>();
        this.stock = new HashMap<>();
        this.dailyTargetCalories = 2000; // set default daily target calories
    }

    public void addRecipe(Recipe recipe) {
        recipes.put(recipe.getName(), recipe);
    }

    public void setStock(Map<String, Integer> stock) {
        this.stock = stock;
    }

    public void setDailyTargetCalories(int dailyTargetCalories) {
        this.dailyTargetCalories = dailyTargetCalories;
    }

    public void prepareRecipe(String recipeName) {
        Recipe recipe = recipes.get(recipeName);
        if (recipe == null) {
            System.out.println("Recipe not found!");
            return;
        }

        Map<String, Integer> ingredients = recipe.getIngredients();
        boolean canPrepare = true;

        for (Map.Entry<String, Integer> entry : ingredients.entrySet()) {
            String ingredientName = entry.getKey();
            int requiredAmount = entry.getValue();

            if (!stock.containsKey(ingredientName) || stock.get(ingredientName) < requiredAmount) {
                System.out.println("Not enough " + ingredientName + " to prepare recipe!");
                canPrepare = false;
            }
        }

        if (!canPrepare) {
            return;
        }

        int totalCalories = recipe.getCalories();
        if (totalCalories > dailyTargetCalories) {
            System.out.println("Recipe exceeds daily target of calories!");
            return;
        }

        // deduct ingredients from stock
        for (Map.Entry<String, Integer> entry : ingredients.entrySet()) {
            String ingredientName = entry.getKey();
            int requiredAmount = entry.getValue();

            stock.put(ingredientName, stock.get(ingredientName) - requiredAmount);
        }

        // deduct calories from daily target
        dailyTargetCalories -= totalCalories;

        System.out.println("Recipe prepared successfully!");
    }

    public void printRecipes() {
        for (Recipe recipe : recipes.values()) {
            System.out.println(recipe);
        }
    }
}

class Recipe {
    private String name;
    private Map<String, Integer> ingredients;
    private int calories;

    public Recipe(String name, Map<String, Integer> ingredients, int calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name + " - " + ingredients.toString() + " - " + calories + " calories";
    }
}
