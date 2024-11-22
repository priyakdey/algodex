package com.priyakdey.graphs;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class AdjacencyMatrixToAdjacencyList {

    @SuppressWarnings("unchecked")
    ArrayList<Integer>[] matrixToAdjList(int n, int[][] matrix) {
        ArrayList<Integer>[] adjList = (ArrayList<Integer>[]) new ArrayList[n];

        int rows = matrix.length, cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            adjList[row] = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    adjList[row].add(col);
                }
            }
        }

        return adjList;
    }

}
