package graph;

import java.util.Arrays;

public class DepthFirstSearch {
	private Graph G;
	private boolean[] visited;
	
	public DepthFirstSearch(Graph G) {
		this.G = G;
		visited = new boolean[G.V()];
		Arrays.fill(visited, false);
	}
	
	public void dfs(int u) {
		visited[u] = true;
		for (int v : G.adj(u)) {
			if (!visited[v])
				dfs(v);
		}
	}
	
	public void reset() {
		Arrays.fill(visited, false);
	}
	
	public int getComponentCount() {
		int compCount = 0;
		reset();
		for (int u = 0; u < G.V(); u++) {
			if (!visited[u]) {
				compCount++;
				dfs(u);
			}
		}
		return compCount;
	}
	
	public static void main(String[] args) {
		Graph G = new Graph(7);
		G.addEdge(0, 1);
		G.addEdge(2, 3);
		G.addEdge(3, 4);
		G.addEdge(0, 5);
		G.addEdge(5, 1);
		
		DepthFirstSearch dfs = new DepthFirstSearch(G);
		System.out.println(dfs.getComponentCount());
	}
}
