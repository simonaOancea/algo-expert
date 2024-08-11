package playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		BFS bfs = new BFS();
		int s = 0;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(1).add(3);
		adj.get(1).add(4);

		boolean[] visited = new boolean[adj.size()];

		bfs.bfs(s, adj, visited);
	}

	public void bfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");

			for (Integer neighbour : adj.get(s)) {
				if (!visited[neighbour]) {
					queue.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}

	}
}
