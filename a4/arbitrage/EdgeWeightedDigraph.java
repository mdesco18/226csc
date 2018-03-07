//EdgeWeightedDigraph.java
//Descoteaux, Marc-Andre

public class EdgeWeightedDigraph{
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public int V; //vertices
	public int E; //edges
	public DirectedEdgeList[] adj; //adjacency list for v
	public int[] degree; //degree of v
	
	public EdgeWeightedDigraph(int v){
		if(v < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		
		V = v;
		E = 0;
		degree = new int[v];
		adj = new DirectedEdgeList[v];
		for(int i = 0; i < v; i++){
			adj[i] = new DirectedEdgeList();
		}
		
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}

	public void addEdge(int u, int v, double w) {
		validateVertex(u);
		validateVertex(v);
		adj[u].addRear(u, v, w);
		degree[v]++;
		E++;
	}
	
	// broken with EdgeList, only works for sets; use new node creation
	public void addEdge(DirectedEdge e) {
		int u = e.from();
		int v = e.to();
		validateVertex(u);
		validateVertex(v);
		adj[u].addRear(e);
		degree[v]++;
		E++;
	}
	
	
	//Returns edge list of directed edges from vertex u
	public Iterable<DirectedEdge> adj(int u) {
        validateVertex(u);
        return adj[u].edges();
    }
	//Returns the number of directed edges incident from vertex
	public int outdegree(int u) {
        validateVertex(u);
        return adj[u].size();
    }
	//Returns the number of directed edges incident to vertex
	public int indegree(int u) {
        validateVertex(u);
        return degree[u];
    }
	//if V becomes private,  get it here
	public int V(){
		return V;
	}
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj(v)) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}