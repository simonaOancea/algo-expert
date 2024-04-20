package graphs;

import java.util.LinkedList;

public class DepthFirstSearchThird {

    public static void main(String[] args) {
        DepthFirstSearchThird graph = new DepthFirstSearchThird(8);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 7);
        graph.insertEdge(4, 5);
        graph.insertEdge(5, 2);

        System.out.println("Depth First Traversal for the graph is: ");
        graph.DFS(0);
    }


    // adjacency list representation
    private LinkedList<Integer> adj[];
    private boolean[] visited;

    // Creation of the graph
    // V is the number of vertices in the graph
    public DepthFirstSearchThird(int V) {
        adj = new LinkedList[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Adding an edge to the graph
    public void insertEdge(int src, int dest) {
        adj[src].add(dest);
    }

    public void DFS(int vertex) {
        // Mark the current node as visited.
        visited[vertex] = true;
        System.out.println(vertex + "");

        for (int n : adj[vertex]) {
            if (!visited[n]) {
                DFS(n);
            }
        }
    }
}
