package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimMST {
	private WeightedGraph G;
	private int weight;
	private List<Edge> edges;
	private boolean[] visited;
	private PriorityQueue<Edge> pq;
	
	public PrimMST(WeightedGraph G) {
		this.G = G;
	}
	
	public void calculateMST() {
		reset();
		relax(0);
		while (!pq.isEmpty()) {
			Edge e = pq.remove();
			int u = e.u(), v = e.v();
			if (visited[u] && visited[v]) continue;
			weight += e.w();
			edges.add(e);
			if (!visited[u]) relax(u);
			if (!visited[v]) relax(v);
		}
	}
	
	public void relax(int u) {
		visited[u] = true;
		for (Edge e : G.adj(u)) {
			if (!visited[e.v()]) 
				pq.add(e);
		}
	}
	
	private void reset() {
		weight = 0;
		edges = new ArrayList<>();
		visited = new boolean[G.V()];
		pq = new PriorityQueue<>();
	}
	
	public int weight() {
		return weight;
	}
	
	public List<Edge> edges() {
		return edges;
	}
	
	public static void main(String[] args) {
		WeightedGraph G = new WeightedGraph(5);
		G.addEdge(new Edge(0, 1, 2));
		G.addEdge(new Edge(2, 1, 3));
		G.addEdge(new Edge(4, 1, 5));
		G.addEdge(new Edge(2, 4, 7));
		G.addEdge(new Edge(3, 4, 9));
		G.addEdge(new Edge(3, 1, 8));
		G.addEdge(new Edge(3, 0, 6));
		
		PrimMST mst = new PrimMST(G);
		mst.calculateMST();
		System.out.println("MST = " + mst.weight());
		System.out.println("Edges:");
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
	}
}
