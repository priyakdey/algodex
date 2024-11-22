package com.priyakdey.graphs;

/**
 * @author Priyak Dey
 */
public class EdgesToAdjacencyMatrix {

    int[][] edgesToMatrix(int n, int[][] edges) {
        int[][] adjMatrix = new int[n][n];

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjMatrix[node1][node2] = 1;
            adjMatrix[node2][node1] = 1;
        }

        return adjMatrix;
    }

}
