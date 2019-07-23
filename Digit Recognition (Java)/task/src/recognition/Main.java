package recognition;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        // corresponding weights for each number
        int[][] weights =   {
                            {+1, +1, +1, +1, -1, +1, +1, -1, +1, +1, -1, +1, +1, +1, +1},//0
                            {-1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1},//1
                            {+1, +1, +1, -1, -1, +1, +1, +1, +1, +1, -1, -1, +1, +1, +1},//2
                            {+1, +1, +1, -1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//3
                            {+1, -1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, -1, -1, +1},//4
                            {+1, +1, +1, +1, -1, -1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//5
                            {+1, +1, +1, +1, -1, -1, +1, +1, +1, +1, -1, +1, +1, +1, +1},//6
                            {+1, +1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1},//7
                            {+1, +1, +1, +1, -1, +1, +1, +1, +1, +1, -1, +1, +1, +1, +1},//8
                            {+1, +1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1}//9
                            };

        // BIASES
        // initialize output neurons with their biases. Add the two vector products
        // of input * weights later
        int[]outputNeurons = {-1, 6, 0, 0, 0, 0, -1, 4, -2, -1};

        Scanner sc = new Scanner(System.in);

        char[][] number = new char[5][3];
        int[] inputVector = new int[15];

        // read input into a 2D array as chars for printing later
        // and also read into a 1D inputVector as ints for doing the calculations
        int vecPosition = 0;
        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 3; j++) {
                number[i][j] = line.charAt(j);
                if (line.charAt(j) == 'X') {
                    inputVector[vecPosition] = 1;
                } else {
                    inputVector[vecPosition] = -1;
                }
                vecPosition++;
            }
        }


        // add the multiplication of weights times the input vector to the biases
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                outputNeurons[i] += weights[i][j] * inputVector[j];
            }
        }


        // find the index of the max value of the outputNeurons. This is our number
        int indexOfMax = 0;
        int maxValue = outputNeurons[0];
        for (int i = 0; i < 10; i++) {
            if (outputNeurons[i] > maxValue) {
                indexOfMax = i;
                maxValue = outputNeurons[i];
            }
        }

        //print input grid
        System.out.println("Input grid:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(number[i][j]);
            }
            System.out.println("");
        }

        // print result
        System.out.println("This number is "+indexOfMax);

    }
}
