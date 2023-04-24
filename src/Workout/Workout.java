package Workout;
// import NutriApp.NUTRiApp;
//import static NutriApp.NUTRiApp.*;

import java.util.Scanner;

public class Workout {

    private int minutes;
    private String intensity;
    private String time;
    private String date;
    Goal.WeightGoal gw;

    public Workout(int minutes, String intensity, String time, String date) {
       this.minutes = minutes;
       this.intensity = intensity;
       this.time = time;
       this.date = date;

    }

    public void LogWorkout() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount of minutes you worked out for: ");
        minutes = input.nextInt();
        
        System.out.print("Enter the intensity level (easy, medium, hard): ");
        intensity = input.nextLine();
        
        System.out.print("Enter the date you worked out");
        date = input.nextLine();
        
        System.out.print("Enter the time you worked out: ");
        time = input.nextLine();
    }

    public void suggestWorkout() {
      if (gw == Goal.WeightGoal.MAINTAIN){
         System.out.println("Barbell bench press: 3 sets of 8-12 rep. \nBent-over rows: 3 sets of 8-12 reps.\nDumbbell shoulder press: 3 sets of 8-12 reps.\nBicep curls: 3 sets of 8-12 reps.\nTricep extensions: 3 sets of 8-12 reps");
      
      } else if (gw == Goal.WeightGoal.LOOSE){
         System.out.println("Warm up: 5-minute walk or jog.\nSquats: 3 sets of 10 reps.\nLunges: 3 sets of 10 reps.\nBench dips: 3 sets of 10 reps.\nPush-ups: 3 sets of 10 reps.\nPlank: hold for 30 seconds.\n5 minute walk or jog");
      
      } else if (gw ==  Goal.WeightGoal.GAIN){
         System.out.println("Warm up: 5-minute walk or jog. \nBarbell squats: 3 sets of 8 reps. \nBarbell bench press: 3 sets of 8 reps. \nDumbbell lunges: 3 sets of 10 reps.\nSeated cable rows: 3 sets of 10 reps.\nBarbell bicep curls: 3 sets of 10 reps.\nTricep pushdowns: 3 sets of 10 reps.\nCool down: 5-minute walk or jog.");
      
      }     

    }
}
