package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearchSecond {

    static class Graph {
        private int V;

        //Array of lists of adjacency list representation
        private LinkedList<Integer> adj[];

        //constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            //Add w to v's list
            adj[v].add(w);
        }

        // A function used by DFS
        void DFSUtil(int v, boolean visited[]) {
            // Mark the current node as visited
            visited[v] = true;
            System.out.print(v + " ");

            // Recur for all the vertices adjacent vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }

        // The function to do DFS traversal.
        // It uses recursive DFSUtil()
        void DFS(int v) {
            // Mark all the vertices as not visited
            boolean visited[] = new boolean[V];

            // Call the recursive helper function to print DFS traversal
            DFSUtil(v, visited);
        }

        public static void main(String[] args) {
            Graph g = new Graph(4);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println(
                    "Following is Depth First Traversal "
                            + "(starting from vertex 2)");

            // Function call
            g.DFS(2);
        }

    }
}
