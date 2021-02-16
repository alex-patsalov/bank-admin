package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class PlannerApp {

    public static String[][] fillArray(String[] days, String[] tasks){
        String[][] schedule = new String[days.length][2];
        for (int i = 0; i < days.length; i++){
            schedule[i] = new String[]{days[i], tasks[i]};
        }
        return schedule;
    }

    public static void main(String[] args) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] tasks = {
                "Go to classes", "Go to work", "Go shopping", "Go home", "Do hometask", "Relax", "Work like hell"
        };
        String[][] schedule = fillArray(days, tasks);
        Scanner sc = new Scanner(System.in);
        System.out.print("Pick a day: ");
        String userInput = sc.nextLine();
        for (String[] element : schedule) {
//            for (int j = 0; j < 2; j++){
            if (userInput.equalsIgnoreCase(element[0])) {
                System.out.printf("Your task for %s is %s \n", element[0], element[1]);
            } else if (userInput.equalsIgnoreCase("exit")) {
                System.out.print("Bye!");
                break;
            } else {
                System.out.print("I do not understand, try again later \n");
            }
//            }
        }
    }
}
