from collections import deque
from typing import Dict, Optional


class Node:
    """Definition for a Node."""

    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: Optional["Node"]) -> Optional["Node"]:

        def clone_node(node: Optional["Node"]) -> Optional["Node"]:
            nonlocal cloned_graph

            if node is None:
                return None

            if node in cloned_graph:
                return cloned_graph[node]

            cloned_graph[node] = Node(node.val)

            for neighbor in node.neighbors:
                cloned_neighbor = clone_node(neighbor)
                cloned_graph[node].neighbors.append(cloned_neighbor)

            return cloned_graph[node]

        if node is None:
            return None

        cloned_graph: Dict[Node, Node] = {}
        clone_node(node)
        return cloned_graph[node]
