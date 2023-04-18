package Workout;


public class Goal {

    public enum WeightGoal {
        MAINTAIN,
        LOOSE,
        GAIN
    }

    private double targetWeight;
    private WeightGoal goalType;

    public Goal(double targetWeight, WeightGoal goalType) {
        targetWeight = this.targetWeight;
        goalType = this.goalType;
    }

    public void setTargetWeight(double newTargetWeight) {
        this.targetWeight = newTargetWeight;
    }

    public void setGoalType(WeightGoal newGoalType) {
        this.goalType = newGoalType;
    }

}
