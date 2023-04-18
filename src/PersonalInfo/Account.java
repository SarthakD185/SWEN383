package PersonalInfo;

import Food.*;
import Workout.*;
import java.util.ArrayList;

/**
 * This account class works with other classes to be the center of user data
 */
public class Account {

    private String name;
    private ArrayList<Workout> workoutHistory;
    private ArrayList<Food> foodHistory;
    private PersonalDetails myDetails;
    private Goal mygoal;
    private ShoppingList shoppingList;

    /**
     * Constructor, runs the personal details constructor as well
     * @param name - name of the user
     * @param age - age of the user
     * @param height - height of user
     * @param weight - starting weight of user
     * @param birthdate - birthdate of user
     *
     */
    public Account(String name,int age, String height, double weight, String birthdate, double targetWeight, Goal.WeightGoal goalType) {
        this.name = name;

        workoutHistory = new ArrayList<Workout>();
        foodHistory = new ArrayList<Food>();

        myDetails = new PersonalDetails(age, height, weight, birthdate);
        mygoal = new Goal(targetWeight, goalType);
    }

    /**
     * Set a new name
     * @param name - new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * add a workout to log
     * @param workout - workout just completed
     * @return - if add was successfull
     */
    public boolean addWorkoutHistory(Workout workout) {
        return workoutHistory.add(workout);
    }

    /**
     * add a new food to the food history log
     * @param food - food just eaten
     * @return
     */
    public boolean addFoodHistory(Food food) {
        return foodHistory.add(food);
    }

    /**
     * Sets the shopping list
     * @param list - current shopping list
     */
    public void setShoppingList(ShoppingList list) {
        this.shoppingList = list;
    }

    /**
     * change the weight
     * @param newWeight - new weight
     */
    public void changeWeight(Double newWeight) {
        myDetails.setWeight(newWeight);
    }

    /**
     * change the weight goal
     * @param targetWeight - new target weight
     */
    public void changeWeightGoal(Double targetWeight) {
        mygoal.setTargetWeight(targetWeight);

        double currentWeight = myDetails.getWeight();
        if ( currentWeight < targetWeight) {
            mygoal.setGoalType(Goal.WeightGoal.GAIN);
        } else if (currentWeight == targetWeight) {
            mygoal.setGoalType(Goal.WeightGoal.MAINTAIN);
        } else {
            mygoal.setGoalType(Goal.WeightGoal.LOOSE);
        }
    }
}
