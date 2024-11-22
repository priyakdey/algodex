package com.priyakdey.graphs;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class DFSOfAnAcyclicGraph {

    ArrayList<Integer> dfs(ArrayList<Integer>[] adjList) {
        ArrayList<Integer> preorder = new ArrayList<>(adjList.length);
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(0);
        visited.add(0);
        preorder.add(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int child : adjList[node]) {
                if (!visited.contains(child)) {
                    stack.offer(child);
                    visited.add(child);
                    preorder.add(child);
                }

            }
        }

        return preorder;
    }

}
