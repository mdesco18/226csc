// Graph.java 
// Descoteaux, Marc-Andre


import java.util.*;

public class Graph {
    
	private static boolean debug = false;
    public final int V;           // number of vertices in this Graph
    public int E;                 // number of edges in this Graph
    public EdgeList[] adj;		// adj[v] = adjacency list for vertex v
    public int[] indegree;        // indegree[v] = indegree of vertex v
	public int[] adj_order;			// top to bottom order of adjacency list for dfs
    
/***********************************************************
				CONTSTRUCTORS
***********************************************************/
/*

Regular Constructor

Arguments: 
@v is the number of vertices of the graph

*/

	 public Graph(int v) {
		
        this.V = v;
        this.E = 0;
        indegree = new int[V];
        this.adj = new EdgeList[v];
		  for (int i = 0; i < V; i++) {
            adj[i] = new EdgeList();
			indegree[i] = 0;
        }
		
    }
/*

Constructor when adjacency list is given

Arguments: 
@V is the number of vertices in the graph
@E is the number of edges in the graph
@list is the adjacency lists
@ao is the order in which the adjacency lists were given

*/
    public Graph(int V, int E, EdgeList[] list, int[] ao) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Graph must be nonnegative");
        this.V = V;
        this.E = E;
        indegree = new int[V];
        this.adj = list;
		adj_order = ao;
		for(int i = 0; i < V; i++){
			indegree[i] = list[i].size();
		}
    }
	
/***************************************************************
					MODIFIERS
****************************************************************/
/*

Adds a new edge to the graph

Arguments:
@u @v  are the vertices of the edge

*/
	public void addEdge(int u, int v) {
		validateVertex(u);
		validateVertex(v);
        adj[u].addRear(u, v);
		indegree[u]++;
        E++;
    }
/*

Adds an existing edge to the graph

Arguments:
@e is the edge to be added

*/
	public void addEdge(Edge e) {
		if(debug) System.out.println(e);
		int u = e.u;
		validateVertex(u);
        adj[u].addRear(e);
		indegree[u]++;
        E++;
    }

/*********************************************
				GETTERS
*********************************************/

//returns degree of given vertex
	public int degree(int v) {
        validateVertex(v);
        return indegree[v];
    }

//returns size of the graph
	public int size(){
		return V;
	}
	
	
/********************************************************************
						UTILITY FUNCTIONS
*********************************************************************/
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges \n");
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
			/*
			Iterable<Integer> vals = adj[adj_order[v]].edges();
            for (int w :vals) {
                s.append(String.format("%d ", w));
            }
			*/
			for (Edge e: adj(v)) {
                s.append(String.format("%d ", e.other(v)));
            }
            s.append("\n");
        }
        return s.toString();
    }
	
	public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v].edges();
    }
	
	private void validateVertex(int v) {
		    if (v < 0 || v > V)
		        throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}
	
}
