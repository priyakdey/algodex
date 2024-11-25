package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class MatrixRotation {

    int[][] rotateMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] rotatedMatrix = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rotatedMatrix[col][row] = matrix[row][col];
            }
        }

        for (int row = 0; row < cols; row++) {
            int left = 0, right = rows - 1;
            while (left < right) {
                int temp = rotatedMatrix[row][left];
                rotatedMatrix[row][left] = rotatedMatrix[row][right];
                rotatedMatrix[row][right] = temp;
                left++;
                right--;
            }
        }

        return rotatedMatrix;
    }

}
