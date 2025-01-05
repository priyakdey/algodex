package com.priyakdey.algoexpert.arrays;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class TransposeMatrix {

    // map matrix[row][col] = new_matrix[col][row]

    public int[][] transposeMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            throw new IllegalArgumentException("invalid input");
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transposedMatrix[col][row] = matrix[row][col];
            }
        }

        return transposedMatrix;
    }

}
