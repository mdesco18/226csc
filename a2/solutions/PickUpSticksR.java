// Kattis problem "Pick Up Sticks" 6.1
// Type: Graphs, topological sort
// Comment: Basically DFS top sort algo w back edge detection.
//    Had to be careful processing 1 million inputs/outputs.

import java.util.*;

class Node {
   int vert;
   Node link;
   Node ( int v, Node e ) { vert = v; link = e; }
}

class PickUpSticksR {

static final int MAXN = 1000001;

static int N, top;
static Node[] adj = new Node[MAXN]; // The graph
static int[] stack = new int[MAXN]; // reverse of finish order.
static boolean[] beg = new boolean[MAXN]; // vertex started?
static boolean[] fin = new boolean[MAXN]; // vertex finished?
static boolean back_edge = false;

static void DFS ( int v ) { 
   beg[v] = true;
   for (Node p=adj[v]; p!=null; p=p.link ) {
      int w = p.vert; 
      if (!beg[w]) DFS( w );
      if (!fin[w]) back_edge = true;
   }
   fin[v] = true;
   stack[top++] = v;
}

public static void main ( String[] args ) {

   Scanner in = new Scanner( System.in );
   N = in.nextInt();
   
   // Build the adjacency lists
   int K = in.nextInt();
   for (int k=0; k<K; ++k) {
      int v = Integer.parseInt(in.next()), w = Integer.parseInt(in.next());
      adj[v] = new Node( w, adj[v] );
   }
   
   // Compute the answer
   for (int n=1; n<N; ++n) if (!beg[n]) DFS( n );
   if (back_edge) System.out.println( "IMPOSSIBLE" );
   else {
      StringBuilder sb = new StringBuilder();
      while (top>0) sb.append( stack[--top]+"\n" );
      System.out.print( sb );
   }
}

}
