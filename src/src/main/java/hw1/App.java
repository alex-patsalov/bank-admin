package hw1;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Let the game begin!! \n");
        System.out.print("Print your name: ");
        Scanner name = new Scanner(System.in);
        String userName = name.nextLine();
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        for (; ;){
            Scanner number = new Scanner(System.in);
            System.out.print("Guess a number? \n");
            int userNumber = 0;
            while (!number.hasNextInt()){
                System.out.print("Input correct value: ");
                userNumber = number.nextInt();
            }
//            if (number.hasNextInt()){
//                userNumber = number.nextInt();
//            } else {
//                System.out.println("wrong number");
//                break;
//            }
            if (userNumber < randomNumber){
                System.out.print("It is too small \n");
            } else if (userNumber > randomNumber){
                System.out.print("It is too big \n");
            } else {
                System.out.printf("Ta-da correct! Well done, %s", userName);
                break;
            }
        }
    }
}
