package hw1;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static Boolean isInt (String s){
        try {
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.print("Let the game begin!! \n");
        System.out.print("Print your name: ");
        Scanner name = new Scanner(System.in);
        String userName = name.nextLine();
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        Scanner number = new Scanner(System.in);
        System.out.print("Guess a number? \n");
        for (; ;){
            int userNumber = number.nextInt();
            if (userNumber < randomNumber){
                System.out.print("It is too small, try again: \n");
            } else if (userNumber > randomNumber){
                System.out.print("It is too big, try again: \n");
            } else {
                System.out.printf("Ta-da correct! Well done, %s", userName);
                break;
            }
        }
    }
}
