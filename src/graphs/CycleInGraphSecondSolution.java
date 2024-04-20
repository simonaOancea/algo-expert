package graphs;

import java.util.Arrays;

public class CycleInGraphSecondSolution {
    public static int WHITE = 0; // unvisited node
    public static int GREY = 1; // node that is currently in the recursion stack
    public static int BLACK = 2; // finished

    // O(v + e) time | O(v) space
    public static boolean cycleInGraph(int[][] edges) {
        int numberOfNodes = edges.length;
        int[] colors = new int[numberOfNodes];
        Arrays.fill(colors, WHITE);

        for (int node = 0; node < numberOfNodes; node++) {
            // if it's not equal to white, means the node has not been visited yet
            if (colors[node] != WHITE) {
                continue;
            }

            boolean containsCycle = traverseAndColorNodes(node, edges, colors);
            if (containsCycle) {
                return true;
            }
        }

        return false;
    }

    public static boolean traverseAndColorNodes(int node, int[][] edges, int[] colors) {
        // in the recursive stack
        colors[node] = GREY;

        int[] neighbors = edges[node];
        for (int neighbor : neighbors) {
            int neighborColor = colors[neighbor];

            // if the color is grey, then it means we found a back edge (a cycle)
            if (neighborColor == GREY) {
                return true;
            }
            // we can skip looking at this neighbor
            if (neighbor == BLACK) {
                continue;
            }

            boolean containsCycle = traverseAndColorNodes(neighbor, edges, colors);
            if (containsCycle) {
                return true;
            }
        }
        // out of the recursive stack
        colors[node] = BLACK;
        return false;
    }
}
