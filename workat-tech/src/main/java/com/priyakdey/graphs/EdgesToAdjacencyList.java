package com.priyakdey.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class EdgesToAdjacencyList {

    @SuppressWarnings("unchecked")
    ArrayList<Integer>[] edgesToAdjList(int n, int[][] edges) {
        ArrayList<Integer>[] adjList = (ArrayList<Integer>[]) new ArrayList[n];
        Arrays.fill(adjList, new ArrayList<Integer>());

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adjList[node1].add(node2);

            if (node1 != node2) {
                adjList[node2].add(node1);
            }
        }

        return adjList;
    }

}
