package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
	private final WeightedGraph G;
	private int[] dist;
	
	public Dijkstra(WeightedGraph G) {
		this.G = G;
		dist = new int[G.V()];
	}
	
	private class State implements Comparable<State> {
		int u, d;
		
		public State(int u, int d) {
			this.u = u;
			this.d = d;
		}

		@Override
		public int compareTo(State other) {
			return Integer.compare(d, other.d);
		}
	}
	
	public void calculateShortestPaths(int src) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<State> pq = new PriorityQueue<>();
		dist[src] = 0;
		pq.add(new State(src, 0));
		
		while (!pq.isEmpty()) {
			State top = pq.remove();
			int u = top.u;
			int d = top.d;
			if (d > dist[u]) continue;
			for (Edge e : G.adj(u)) {
				if (dist[e.v()] > dist[u] + e.w()) {
					dist[e.v()] = dist[u] + e.w();
					pq.add(new State(e.v(), dist[e.v()]));
				}
			}
		}
	}
	
	public int getDist(int u) {
		return dist[u];
	}
	
	public static void main(String[] args) {
		WeightedGraph G = new WeightedGraph(7);
		G.addEdge(new Edge(0, 1, 7));
		G.addEdge(new Edge(2, 3, 6));
		G.addEdge(new Edge(3, 4, 11));
		G.addEdge(new Edge(0, 5, 5));
		G.addEdge(new Edge(5, 1, 3));
		G.addEdge(new Edge(4, 5, 5));
		G.addEdge(new Edge(0, 2, 1));
		G.addEdge(new Edge(3, 5, 1));
		
		Dijkstra dijkstra = new Dijkstra(G);
		dijkstra.calculateShortestPaths(0);
		for (int i = 0; i < G.V(); i++) {
			System.out.println("dist[" + i + "] = " + dijkstra.getDist(i));
		}
	}
}
