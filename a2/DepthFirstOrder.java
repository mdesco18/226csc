// DepthFirstOrder.java
// 
// ALL METHODS ARE CONSTRUCTED UNDER THE SAME CONSTRAINTS AS Digraph.java
// 
// Methods modified from Algs4 (C) Sedgewick, Wayne
// https://algs4.cs.princeton.edu/42digraph/DepthFirstOrder.java.html
import java.util.*;
public class DepthFirstOrder {
    private boolean[] marked;          // marked[v] = has v been marked in dfs?
   	public int[] pre;                 // pre[v]    = preorder  number of v
    public int[] post;                // post[v]   = postorder number of v
    private LinkedList preorder;   // vertices in preorder
    private LinkedList postorder;  // vertices in postorder
    private int preCounter;            // counter or preorder numbering
    private int postCounter;           // counter for postorder numbering

    /**
     * Determines a depth-first order for the digraph {@code G}.
     * @param G the digraph
     */
    public DepthFirstOrder(Digraph G) {
        pre    = new int[G.V];
        post   = new int[G.V];
        postorder = new LinkedList();
        preorder  = new LinkedList();
        marked    = new boolean[G.V];
		int i;
        for (int v = 0; v < G.adj_order.length; v++){
			i = G.adj_order[v];
			if (!marked[i]) dfs(G, i);
		}
    }
	/**
	*
	* perform a dfs preorder search on Digraph G
	*
*/
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		pre[v] = preCounter++;
		preorder.addRear(v);
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		
	}
	 /**
     * Returns the preorder number of vertex {@code v}.
     * @param  v the vertex
     * @return the preorder number of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int pre(int v) {
        validateVertex(v);
        return pre[v];
    }

    /**
     * Returns the postorder number of vertex {@code v}.
     * @param  v the vertex
     * @return the postorder number of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int post(int v) {
        validateVertex(v);
        return post[v];
    }

    /**
     * Returns the vertices in postorder.
     * @return the vertices in postorder, as an iterable of vertices
     */
    public Iterable<Integer> post() {
        return postorder.values();
    }

    /**
     * Returns the vertices in preorder.
     * @return the vertices in preorder, as an iterable of vertices
     */
    public Iterable<Integer> pre() {
        return preorder.values();
    }

    /**
     * Returns the vertices in reverse postorder.
     * @return the vertices in reverse postorder, as an iterable of vertices
     
    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder)
            reverse.push(v);
        return reverse;
    }
	*/
	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}
}
