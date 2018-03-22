// Kattis problem "Arbitrage" 4.0
// Type: SSSP, negative-cycle detection
// Comment: Bellman-Ford, convert factors to sums using logs
//     Add dummy node 0 to make all vertices reachable.

import java.util.*;

class Edge {
   int v, w; // endpoints
   double d; // distance
   Edge( int vv, int ww, double dd ) { v=vv; w=ww; d=dd; }
}

class Arbitrage {

    
    public static void main( String[] args ) {
       Scanner in = new Scanner( System.in );
       while (true) {
          // Read inputs, build graph
          HashMap<String,Integer> hash = new HashMap<String,Integer>();
          int N  = in.nextInt();  // Verts 1 <=  N <= 200
          if (N==0) return;
          in.nextLine();
          String[] C = in.nextLine().split(" ");
          int M2 = in.nextInt(), M = 0;  // 1 <= Edges <= N*(N-1)/2
          Edge[] E = new Edge[M2+N];  // Edge list
          double[] dist = new double[N+1];
          for (int n=0; n<N; ++n) {
             hash.put( C[n], n+1 );
             E[M++] = new Edge( 0, n+1, 0.0 ); // dummy edges
          }
          for (int m=0; m<M2; ++m) {
             int v = hash.get( in.next() ), w = hash.get( in.next() );
             String[] R = in.next().split(":");
             double f = -Math.log( Double.parseDouble(R[1])/Double.parseDouble(R[0]) );
             E[M++] = new Edge( v, w, f );
          }
          
          // Try naive Bellman-Ford, with changed checked.
          Arrays.fill( dist, Double.MAX_VALUE );
          dist[0] = 0.0;
          boolean changed = true;
          int iter = 0;
          while (changed && iter <= N+1) {
             ++iter;
             changed = false;
             for (int i=0; i<M; ++i) 
                if (dist[E[i].v] != Double.MAX_VALUE)
                if (dist[E[i].v]+E[i].d < dist[E[i].w]) { 
                   changed = true;
                   dist[E[i].w] = dist[E[i].v]+E[i].d;
                } 
          }
          System.out.println( (iter>N+1?"Arbitrage":"Ok") );
       }
   }
}
