// Kattis problem "Pick Up Sticks" 6.1
// Type: Graphs, topological sort
// Comment: Basically Knuth/Kahn top sort algo.
//    Had to be careful reading 1million inputs/outputs.

import java.util.*;

class Node {
   int vert;
   Node link;
   Node ( int v, Node e ) { vert = v; link = e; }
}

class PickUpSticks {

static final int MAXN = 1000001;

static int N, top;
static Node[] adj = new Node[MAXN]; // The graph
static int[] pre = new int[MAXN];   // number of incoming arcs
static int[] ans = new int[MAXN];   // to record the answer
static int[] stack = new int[MAXN]; // sources

static boolean topsort() {
   for (int n=0; n<N; ++n) 
      if (pre[n]==0) stack[top++] = n;
   for (int n=0; n<N; ++n) {
      if (top==0) return( false ); // back edge
      int v = stack[--top];
      ans[n] = v;
      for (Node p=adj[v]; p!=null; p=p.link) {
         int w = p.vert;
         --pre[w];
         if (pre[w]==0) stack[top++] = w;
      }
   }
   return( true ); // all good
}

public static void main ( String[] args ) {

   Scanner in = new Scanner( System.in );
   N = in.nextInt();

   // Build the adjacency lists
   int K = in.nextInt();
   for (int k=0; k<K; ++k) {
      int v = Integer.parseInt(in.next()), w = Integer.parseInt(in.next());
      adj[v] = new Node( w, adj[v] );
      ++pre[w];
   }

   // Compute the answer
   if (!topsort()) System.out.println( "IMPOSSIBLE" );
   else {
      StringBuilder sb = new StringBuilder();
      for (int n=0; n<N; ++n) sb.append( ans[n]+"\n" );
      System.out.print( sb );
   }
}

}
