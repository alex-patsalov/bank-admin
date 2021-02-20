package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class PlannerApp {

    public static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static String[] tasks = {
            "Go to classes", "Go to work", "Go shopping", "Go home", "Do hometask", "Relax", "Work like hell"
    };
    public static Scanner sc = new Scanner(System.in);

    public static String[][] fillArray(String[] days, String[] tasks) {
        String[][] schedule = new String[days.length][2];
        for (int i = 0; i < days.length; i++) {
            schedule[i] = new String[]{days[i], tasks[i]};
        }
        return schedule;
    }

    public static void main(String[] args) {
        String[][] schedule = fillArray(days, tasks);
        for (; ;) {
            System.out.print("Pick a day: ");
            String userInput = sc.nextLine().trim();
            for (String[] el : schedule) {
                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.print("Bye!");
                    break;
                } else if (userInput.equalsIgnoreCase(el[0])) {
                    System.out.printf("Your task for %s is %s \n", el[0], el[1]);
                    break;
                }
                if (!userInput.equalsIgnoreCase(el[0])) {
                    System.out.print("I do not understand you try again \n");
                    break;
                }
            }
        }
    }
}

