package hw1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static Boolean isInt(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length == 0) {
            return false;
        }
        if (s.charAt(0) == '-' && length == 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static int [] sortMinToMax(int [] array){
        int buffer;
        for (int i = 0; i < array.length; i++){
            for (int j = 1; j < array.length - i; j++){
                if (array[j-1] > array[j]){
                    buffer = array[j-1];
                    array[j-1] = array[j];
                    array[j] = buffer;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.print("Let the game begin!! \n");
        System.out.print("Print your name: ");
        Scanner name = new Scanner(System.in);
        String userName = name.nextLine();
        Random random = new Random();
        int randomNumber = random.nextInt(1000) + 1;
        Scanner number = new Scanner(System.in);
        System.out.print("Guess a number? \n");
        int counter = 0;
        int[] array = new int[1000];
        for (; ;) {
            String userNumber = number.nextLine();
            if (isInt(userNumber)) {
                int input = Integer.parseInt(userNumber);
                if (input > 1000) {
                    System.out.print("The range is < 100 \nTry again: \n");
                } else if (input < randomNumber) {
                    array[counter++] = input;
                    System.out.print("It is too small, try again: \n");
                } else if (input > randomNumber) {
                    array[counter++] = input;
                    System.out.print("It is too big, try again: \n");
                } else {
                    int[] result = sortMinToMax(Arrays.copyOf(array, counter));
                    System.out.printf("Ta-da correct! Well done, %s \n", userName);
                    System.out.printf("This is what you've printed --> %s", Arrays.toString(result));
                    break;
                }
            } else {
                System.out.print("It is not an integer, try again: \n");
            }
        }
    }
}