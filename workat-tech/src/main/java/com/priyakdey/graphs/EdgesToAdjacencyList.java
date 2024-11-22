package com.priyakdey.graphs;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class EdgesToAdjacencyList {

    @SuppressWarnings("unchecked")
    ArrayList<Integer>[] edgesToAdjList(int n, int[][] edges) {
        ArrayList<Integer>[] adjList = (ArrayList<Integer>[]) new ArrayList[n];

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (adjList[node1] == null) adjList[node1] = new ArrayList<>();
            adjList[node1].add(node2);

            if (node1 == node2) continue;

            if (adjList[node2] == null) adjList[node2] = new ArrayList<>();
            adjList[node2].add(node1);
        }

        return adjList;
    }

}
