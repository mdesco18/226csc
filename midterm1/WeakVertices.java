// Kattis problem "Weak Vertices" 1.8
// Type: Graphs, brute-force.
// Comment: Used in CSC 226 Midterm #1, Spring 2018

import java.util.*;

class WeakVertices {

    public static void main( String[] args ) {
       char[][] adj = new char[32][32];  // adjacency matrix
       boolean[] inT = new boolean[32];  // vertex in triangle?
       Scanner in = new Scanner( System.in );
       while (true) {
          int N = in.nextInt();
          if (N==-1) return;  in.nextLine(); 
          for (int r=0; r<N; ++r) {
             adj[r] = in.nextLine().replaceAll(" ","").toCharArray();
          }
          Arrays.fill( inT, false );
          for (int i=0; i<N; ++i)
             for (int j=0; j<i; ++j)
                for (int k=0; k<j; ++k)
                   if (adj[i][j]=='1' && adj[j][k]=='1' && adj[k][i]=='1') 
                      inT[i] = inT[j] = inT[k] = true;
          for (int v=0; v<N; ++v)
             if (!inT[v]) System.out.print( v+" " );
          System.out.println();
       }
   }
}
