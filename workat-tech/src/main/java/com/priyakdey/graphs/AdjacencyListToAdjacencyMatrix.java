package com.priyakdey.graphs;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class AdjacencyListToAdjacencyMatrix {

    int[][] adjListToMatrix(int n, ArrayList<Integer>[] adjList) {
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                int node1 = i;
                int node2 = adjList[i].get(j);
                adjMatrix[node1][node2] = 1;
                adjMatrix[node2][node1] = 1;
            }
        }

        return adjMatrix;
    }

}
