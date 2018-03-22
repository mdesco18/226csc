// Solution to the Kattis problem "Big Truck" 3.9
// Type: Shortest paths in a graph
// Solution: Lazy Dijkstra, encoded the items in the distances using shifting.

import java.util.*;

class Node { // used both for adj lists and for pq
   int v, d;
   Node link;
   Node ( int vv, int dd, Node ll ) { v=vv; d=dd; link=ll; }
}

class BigTruckB {

public static void main ( String[] args ) {
   PriorityQueue<Node> pq = new PriorityQueue<Node>( 100, (x,y)->x.d-y.d );
   Scanner in = new Scanner( System.in );
   int n = in.nextInt(); // can assume 2 <= n <= 100
   int[] items = new int[n+1];  // number of items at a node
   int[] dist = new int[n+1];   // shortest "distances"
   Node[] adj = new Node[n+1];  // adjacency lists
   for (int i=1; i<=n; ++i) items[i] = in.nextInt(); // <= 100
   for (int i=in.nextInt(); i>0; --i) {
      int v = in.nextInt(), w = in.nextInt(), d = in.nextInt();
      adj[v] = new Node( w, (d<<16)-items[w], adj[v] );  
      adj[w] = new Node( v, (d<<16)-items[v], adj[w] );  
   }
   // Dijkstra's algorithm, lazy version
   Arrays.fill( dist, Integer.MAX_VALUE/2 );
   dist[1] = (1<<15)-items[1];  
   boolean[] inTree = new boolean[n+1];
   pq.add( new Node( 1, (1<<15)-items[1], null ));
   while (!pq.isEmpty()) {
      int v = pq.poll().v;
      if (inTree[v]) continue;
      inTree[v] = true;
      for (Node e = adj[v]; e != null; e = e.link) {
         int w = e.v;
	     if (!inTree[w] && (dist[w] > dist[v] + e.d )) {
            dist[w] = e.d + dist[v];
	        pq.add( new Node( w, dist[w], null ) ); 
	     }
      }
   }
   if (dist[n] == Integer.MAX_VALUE/2) System.out.println( "impossible" );
   else System.out.println( (dist[n]>>16)+" "+((1<<15)-dist[n]&0x0000FFFF) );
}

}
