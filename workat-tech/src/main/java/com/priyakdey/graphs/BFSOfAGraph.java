package com.priyakdey.graphs;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class BFSOfAGraph {

    ArrayList<Integer> bfs(ArrayList<Integer>[] adjList) {
        ArrayList<Integer> nodes = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            nodes.add(node);

            ArrayList<Integer> neighbours = adjList[node];
            for (int neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return nodes;
    }

}
