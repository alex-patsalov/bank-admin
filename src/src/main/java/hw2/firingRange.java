package hw2;

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class firingRange {

    public static int randomNumber(){
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    public static String arrayToString (String[] arr){
        StringJoiner joiner = new StringJoiner(" | ");
        for (String a : arr){
            joiner.add(String.format("%s", a));
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        int[] target = {randomNumber(), randomNumber()};
        int rows = 6;
        int cols = 6;
        boolean endOfGame = false;
        Scanner sc = new Scanner(System.in);
        String [][] array = new String[rows][cols];
        for (; ;) {
            System.out.print("Type row: ");
            int userRow = sc.nextInt();
            System.out.print("Type col: ");
            int userCol = sc.nextInt();
            System.out.println();
            if (userRow == target[0] && userCol == target[1]){
                array[target[0]][target[1]] = "X";
                endOfGame = true;
            } else {
                array[userRow][userCol] = "o";
                System.out.print("Try again \n");
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    array[0][j] = "" + j;
                    array[i][0] = "" + i;
                    if (array[i][j] == null) {
                        array[i][j] = "-";
                    }
                }
                System.out.println(arrayToString(array[i]));
            }
            if(endOfGame) {
                System.out.print("You win! \n");
                break;
            }
        }
    }
}
