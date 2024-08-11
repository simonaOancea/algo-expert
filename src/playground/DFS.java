package playground;

import java.util.ArrayList;

public class DFS {
	public static void main(String[] args) {
		DFS dfs = new DFS();
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

		dfs.dfs(s, adj, visited);
	}

	public void dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		visited[s] = true;
		System.out.println(s + " ");

		for (Integer neighbour : adj.get(s)) {
			if (!visited[neighbour]) {
				dfs(neighbour, adj, visited);
			}
		}
	}


}
