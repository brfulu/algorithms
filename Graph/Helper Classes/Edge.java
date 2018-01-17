package graph;

public class Edge implements Comparable<Edge> {
	private final int u;
	private final int v;
	private final int w;
	
	public Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public int u() {
		return u;
	}
	
	public int v() {
		return v;
	}
	
	public int w() {
		return w;
	}

	@Override
	public int compareTo(Edge other) {
		return Integer.compare(w, other.w);
	}

	@Override
	public String toString() {
		return String.format("[%d - %d %d]", u, v, w);
	}

}
