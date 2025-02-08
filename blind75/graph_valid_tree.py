from collections import defaultdict, deque
from typing import Deque, Dict, List, Set


class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        def to_graph(edges: List[List[int]]) -> Dict[int, List[int]]:
            graph: Dict[int, List[int]] = defaultdict(list)

            for node1, node2 in edges:
                graph[node1].append(node2)
                graph[node2].append(node1)

            return graph

        graph = to_graph(edges)

        stack: Deque[int] = deque()
        visited: Set[int] = set()

        for node in range(n):
            if node not in graph:
                return False

            if node in visited:
                continue

            stack.append(node)
            while len(stack) > 0:
                curr_node = stack.pop()

                if curr_node not in graph:
                    return False

                for neighbor_node in graph[curr_node]:
                    if neighbor_node in visited:
                        return False

                    stack.append(neighbor_node)

                visited.add(curr_node)

        return True
