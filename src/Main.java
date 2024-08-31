/*
Short Description:  This program will accept two sets of nine integers from a user, place them into a 3x3 matrix,
                    and then compare the matrices to validate that they are equal
Author:  Brian Wiatrek
Date:  August 22, 2024
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean foundIt(int[][] searchMatrix, int searchNum){
        int matrixVal;

        for (int col=0; col<3; col++){
            for (int row=0; row<3; row++){
                matrixVal = searchMatrix[col][row];
                //System.out.printf("Found matrixVal: %d and searchNum: %d\n", matrixVal, searchNum);
                if (matrixVal == searchNum){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equals(int[][] m1, int[][] m2){
        int searchVal;
        boolean equalMatrix = true;

        for (int col=0; col<3; col++) {
            for (int row = 0; row < 3; row++) {
                searchVal = m1[col][row];
                equalMatrix = foundIt(m2, searchVal);
                if (equalMatrix == false) return equalMatrix;
                //System.out.printf("Found: %b and searchNum: %d\n", equalMatrix, searchVal);
            }
        }
        return equalMatrix;
    }

    public static int[][] buildArray(String[] allTokens){
        int[][] matrix;
        matrix = new int[3][3];
        int i = 0;
        for (int col=0; col<3; col++){
             for (int row=0; row<3; row++){
                 matrix[col][row] = Integer.parseInt(allTokens[i]);
                 i++;
             }
        }
        return matrix;
    }

    public static void printMatrix(int[][] inputMatrix){
        for (int col=0; col<3; col++){
            for (int row=0; row<3; row++){
                System.out.println(inputMatrix[col][row]);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int[][] matrix1;
        int[][] matrix2;

        System.out.println("Please enter 9 numbers for the first array delimited by one or more spaces:\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String delims = "[ ]+";
        String inputNumbers = reader.readLine();
        String[] tokens = inputNumbers.split(delims);
        matrix1 = buildArray(tokens);
        System.out.println("Please enter 9 numbers for the second array delimited by one or more spaces:\n");
        reader = new BufferedReader(new InputStreamReader(System.in));
        inputNumbers = reader.readLine();
        tokens = inputNumbers.split(delims);
        matrix2 = buildArray(tokens);
        System.out.println(equals(matrix1, matrix2));
    }
}