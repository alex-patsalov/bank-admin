package hw3;

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
        for (; ; ) {
            System.out.print("Pick a day: ");
            String userInput = sc.nextLine().trim();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.print("Bye!");
                break;
            } else if (userInput.contains("change")) {
                for (int i = 0; i < schedule.length; i++) {
                    if (!userInput.toLowerCase().contains(schedule[i][0].toLowerCase()) && i == schedule.length - 1) {
                        System.out.print("the day doesn't exist or you forgot to include it \n");
                    } else if (userInput.toLowerCase().contains(schedule[i][0].toLowerCase())) {
                        System.out.print("Print new task: ");
                        String newTask = sc.nextLine().trim();
                        schedule[i][1] = newTask;
                        break;
                    }
                }
                continue;
            }

            for (int i = 0; i < schedule.length; i++) {
                if (userInput.equalsIgnoreCase(schedule[i][0])) {
                    System.out.printf("Your task for %s is %s \n", schedule[i][0], schedule[i][1]);
                    break;
                } else if (!userInput.equalsIgnoreCase(schedule[i][0]) && i == schedule.length - 1) {
                    System.out.print("I do not understand you try again \n");
                }
            }

        }
    }
}

