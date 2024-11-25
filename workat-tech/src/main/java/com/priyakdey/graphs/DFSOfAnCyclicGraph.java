package com.priyakdey.graphs;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class DFSOfAnCyclicGraph {

    ArrayList<Integer> dfs(ArrayList<Integer>[] adjList) {
        ArrayList<Integer> preorder = new ArrayList<>(adjList.length);
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            preorder.add(node);

            ArrayList<Integer> integers = adjList[node];
            for (int integersSize = integers.size(), i = integersSize - 1; i >= 0; i--) {
                int child = integers.get(i);
                if (!visited.contains(child)) {
                    stack.push(child);
                    visited.add(child);
                }

            }
        }

        return preorder;
    }

}
