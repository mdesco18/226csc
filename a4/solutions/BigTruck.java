// Solution to the Kattis problem "Big Truck" 3.9
// Type: Shortest paths in a graph
// Solution: Naive Bellman-Ford, checking for "changed".

import java.util.Scanner;

class BigTruck {

public static void main ( String[] args ) {
   Scanner in = new Scanner( System.in );
   int n = in.nextInt(); // can assume 2 <= n <= 100
   int[] items = new int[n+1];  // number of items at a node
   int[] dist = new int[n+1];   // shortest distances
   int[] itto = new int[n+1];   // max items, given shortest distance
   for (int i=1; i<=n; ++i) items[i] = in.nextInt();
   int m = in.nextInt();
   int[] f = new int[2*m+2];
   int[] t = new int[2*m+2];
   int[] d = new int[2*m+2];
   for (int i=1; i<=m; ++i) {
      f[i] = in.nextInt();
      t[i] = in.nextInt();
      d[i] = in.nextInt();
      f[i+m] = t[i];
      t[i+m] = f[i];
      d[i+m] = d[i];
   }
   for (int i=2; i<=n; ++i) dist[i] = Integer.MAX_VALUE;
   dist[1] = 0;  itto[1] = items[1];
   boolean changed = true;
   while (changed) {
      changed = false;
      for (int i=1; i<=2*m; ++i) 
         if (dist[f[i]] != Integer.MAX_VALUE)
         if (dist[f[i]]+d[i] <  dist[t[i]]) { 
            changed = true;
            dist[t[i]] = dist[f[i]]+d[i];
            itto[t[i]] = itto[f[i]]+items[t[i]];
         } else
         if (dist[f[i]]+d[i] == dist[t[i]] && itto[f[i]]+items[t[i]] > itto[t[i]]) {
            changed = true;
            itto[t[i]] = itto[f[i]]+items[t[i]];
         }
   }
   if (dist[n] == Integer.MAX_VALUE) System.out.println( "impossible" );
   else System.out.println( dist[n]+" "+itto[n] );
}

}
