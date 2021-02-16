package hw2;

import java.util.Arrays;
import java.util.Random;
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
        int rows = 6;
        int cols = 6;
        String [][] array = new String[rows][cols];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    array[0][j] = "" + j;
                    array[i][0] = "" + i;
                    if (array[i][j] == null){
                        array[i][j] = "-";
                    }
                }
                System.out.println(arrayToString(array[i]));
            }
    }
}
