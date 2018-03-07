//EdgeWeightedGraph.java
//Descoteaux, Marc-Andre

//NOTE: THIS CLASS USES THE ASSUMPTION THAT VERTICES ARE BE NUMBERED 1 - V INSTEAD OF 0 - (V-1)

public class EdgeWeightedGraph{
	
	private boolean debug = false;
	
	public int V; //number of vertices
	public int E; //number of edges
	public EdgeList[] adj; //adjacency matrix for vertices
	
	public EdgeWeightedGraph(int V) {
        if (V <= 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = new EdgeList[V+1];
        for (int v = 1; v <= V; v++) {
            adj[v] = new EdgeList();
        }
    } 
	
	private void validateVertex(int v) {
		if (v <= 0 || v > V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V));
	}
	
	public void addEdge(int u, int v, double w) {
		validateVertex(u);
		validateVertex(v);
        adj[u].addRear(u, v, w);
        adj[v].addRear(u, v, w);
        E++;
    }
	/*
	public void addEdge(Edge e) {
		if(debug) System.out.println(e);
        int u = e.u;
        int v = e.v;
		validateVertex(u);
		validateVertex(v);
        adj[u].addRear(e);
        adj[v].addRear(e);
        E++;
    }
	*/
	public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

	public int V(){
		//fuck this method too
		return V;
	}
	
	public Iterable<Edge> adj(int v) {
		validateVertex(v);
        return adj[v].edges();
    }
	
	public Iterable<Edge> edges() {
        EdgeList list = new EdgeList();
        for (int v = 1; v <= V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.addRear(e.u, e.v, e.weight);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.addRear(e.u, e.v, e.weight);
                    selfLoops++;
                }
            }
        }
        return list.edges();
    }
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
		if(debug) System.out.println("V: "+V+" E: "+E);
        for (int v = 1; v <= V; v++) {
            s.append(v + ": ");
			if(debug) System.out.println(v);
            for (Edge e : adj(v)) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }

	
}