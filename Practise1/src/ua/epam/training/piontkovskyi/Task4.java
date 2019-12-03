package ua.epam.training.piontkovskyi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
    private static void fillMatrix(int[][] matrix){
        Random rnd = new Random();
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix.length; ++j){
                matrix[i][j] = rnd.nextInt();
            }
        }
    }
    private static void printMatrix(int[][] matrix){
        for(int[] array:matrix) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println();
    }
    private static int [][] getRotatedMatrix(int [][] sourceMatrix) {
        int dimension = sourceMatrix[0].length;
        int [][] rotatedMatrix = new int[dimension][dimension];
        int rotatedPosI = 0;
        int rotatedPosJ = sourceMatrix.length - 1;
        for (int [] sourceI : sourceMatrix){
            for (int sourceIJ : sourceI) {
                rotatedMatrix[rotatedPosI++][rotatedPosJ] = sourceIJ;
            }
            rotatedPosI = 0;
            rotatedPosJ--;
        }
        return rotatedMatrix;
    }

    public static void main(String[] args) {
        System.out.println("Enter the dimension of the matrix:");
        Scanner input = new Scanner(System.in);
        int dimension = input.nextInt();
        if(dimension < 1){
            System.err.println("Dimension shoud be greater then 1");
        }else {
            int[][] matrix = new int[dimension][dimension];
            fillMatrix(matrix);
            printMatrix(matrix);
            int[][] rotatedMatrix = getRotatedMatrix(matrix);
            printMatrix(rotatedMatrix);
        }
    }
}
