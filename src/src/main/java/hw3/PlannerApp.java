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
        System.out.println(Arrays.deepToString(schedule));
        System.out.print("Pick a day: ");
        String userInput = sc.nextLine().trim();
        boolean found = true;
        for (String[] element : schedule) {
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.print("Bye!");
                break;
            }
            if (userInput.equalsIgnoreCase(element[0]) && found) {
                System.out.printf("Your task for %s is %s \n", element[0], element[1]);
                continue;
            }
            if (!userInput.equalsIgnoreCase(element[0])) {
                continue;
//                System.out.print("I do not understand, try again later \n");
            }
        }
    }
}

