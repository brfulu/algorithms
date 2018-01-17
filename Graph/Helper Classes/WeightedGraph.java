package graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final int V;
	private int E;
	private List<Edge>[] adj;
	
	public WeightedGraph(int V) {
		this.V = V;
		E = 0;
		adj = (ArrayList<Edge>[]) new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(Edge e) {
		int u = e.u();
		int v = e.v();
		adj[u].add(e);
		adj[v].add(e);
		E++;
	}
	
	public List<Edge> adj(int u) {
		return adj[u];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public int degree(int u) {
		return adj[u].size();
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
			for (Edge e : adj[u]) {
				sb.append(e + " ");
			}
		}
		return sb.toString();
	}
	
}
