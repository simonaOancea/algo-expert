package graphs;

import java.util.Arrays;

public class CycleInGraph {

    // O(v + e) time | O(v) space
    // We use v space for the two auxiliary data structures
    // and the depth-first-search needs to look at all of the vertices (nodes)
    // and all of the edges.
    public boolean cycleInGraph(int[][] edges) {
        int numberOfNodes = edges.length;
        boolean[] visited = new boolean[numberOfNodes];
        boolean[] currentlyInStack = new boolean[numberOfNodes];
        Arrays.fill(visited, false);
        Arrays.fill(visited, false);

        for (int node = 0; node < numberOfNodes; node++) {
            if (visited[node]) {
                continue;
            }
            boolean containsCycle = isNodeInCycle(node, edges, visited, currentlyInStack);
            if (containsCycle) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNodeInCycle(
            int node, int[][] edges, boolean[] visited, boolean[] currentlyInStack) {
        visited[node] = true;
        currentlyInStack[node] = true;

        boolean containsCycle = false;
        int[] neighbors = edges[node];
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                containsCycle = isNodeInCycle(neighbor, edges, visited, currentlyInStack);
            }

            if (containsCycle) {
                // meaning we did find a cycle
                return true;
                // if that's not the case and the neighbor has already been visited,
                // then we check if they are currently in stack
            } else if (currentlyInStack[neighbor]) {
                // because this means we found an edge from a descendant to its ancestor
                // meaning there is a cycle in the graph
                return true;
            }
        }
        // the function call has ended
        // and the current node is no longer in the recursive stack
        currentlyInStack[node] = false;

        return false;

    }
}
