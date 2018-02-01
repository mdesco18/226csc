// Digraph.java 
//
// ALL METHODS ARE PERFORMED UNDER THE ASSUMPTION THAT THERE IS NO VERTEX '0'
// THEREFORE ARRAYS ARE ALLOCATED WITH AN EXTRA ELEMENT TO ALLOW INDEXING TO BEGIN AT 1
// AND SO THAT THE INDEX CORRESPONDS TO THE VERTEX. ITERATION REFLECTS THIS AS WELL.
//
// FOR CREATING GRAPHS THAT HAVE A VERTEX '0', 
// PLEASE PARSE METHODS TO SEE IF V MUST BE CHANGED.
// 
// Methods altered from Digraph found in Algs4
// https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
// (C) Sedgewick, Wayne

import java.util.*;

public class Digraph {
    
    public final int V;           // number of vertices in this digraph
    public int E;                 // number of edges in this digraph
    public LinkedList[] adj;		// adj[v] = adjacency list for vertex v
    public int[] indegree;        // indegree[v] = indegree of vertex v
	public int[] adj_order;			// top to bottom order of adjacency list
    
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(int V, int E, LinkedList[] list, int[] ao) {
		V++;
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = E;
        indegree = new int[V];
        this.adj = list;
		adj_order = ao;
		for(int i = 0; i < V; i++){
			indegree[i] = list[i].n;
		}
    }
	public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v].values();
    }/*
	public Iterable<Integer> order() {

		Iterable<Integer> iterable = Arrays.asList(adj_order);

        return iterable;
    }*/
	private void validateVertex(int v) {
		    if (v < 0 || v >= V)
		        throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}
	
	public LinkedList stackToList(Stack stack){

		LinkedList list = new LinkedList();
		int data;
		while(!stack.empty()){
			data = (int)stack.pop();
			list.addRear(data);
		}
		list.checkList();
		return list;
	}
		
// Topological Sorting from GeeksforGeeks.org
    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[],
                             Stack stack)
    {	
        // Mark the current node as visited.
        visited[v] = true;
 		if(v!=0){
		    // Recur for all the vertices adjacent to this
		    // vertex
		   
		    for (int i : adj[v].values()){
		        if (!visited[i])
		            topologicalSortUtil(i, visited, stack);
		    }
	 
		    // Push current vertex to stack which stores result
		    stack.push(new Integer(v));
		}
    }
 	
    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    public void topologicalSort()
    {
        Stack stack = new Stack();
 		int i;
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
         for (int v = 0; v < adj_order.length; v++){
			i = adj_order[v];
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
		}
		
		LinkedList stacked = stackToList(stack);
		if(!stacked.unique(V)) PUS.failed();
		System.out.print(stacked);
		
    }
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V-1 + " vertices, " + E + " edges \n");
        for (int v = 0; v < V-1; v++) {
            s.append(String.format("%d: ", adj_order[v]));
			Iterable<Integer> vals = adj[adj_order[v]].values();
            for (int w :vals) {
                s.append(String.format("%d ", w));
            }
            s.append("\n");
        }
        return s.toString();
    }
	
}
