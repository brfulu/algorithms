package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	private final int V;
	private int E;
	private List<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		E = 0;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
		E++;
	}
	
	public List<Integer> adj(int u) {
		return adj[u];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String newline = System.getProperty("line.separator");
		sb.append("Graph:" + newline);
		sb.append("V = " + V + newline);
		sb.append("E = " + E + newline);
		for (int u = 0; u < V; u++) {
			sb.append("adj[" + u + "] = ");
			for (int v : adj[u]) {
				sb.append(v + " ");
			}
		}
		return sb.toString();
	}
	
	
}
