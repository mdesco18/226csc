// Kattis problem "Weak Vertices" 1.8
// Type: Graphs, brute-force.
// Comment: Used in CSC 226 Midterm #1, Spring 2018.
//    This version uses a labelled break.

import java.util.*;

class WeakVerticesA {

    public static void main( String[] args ) {
       char[][] adj = new char[32][32];  // adjacency matrix
       Scanner in = new Scanner( System.in );
       while (true) {
          int N = in.nextInt();
          if (N==-1) return;  in.nextLine(); 
          for (int r=0; r<N; ++r) 
             adj[r] = in.nextLine().replaceAll(" ","").toCharArray();
          for (int i=0; i<N; ++i) {
             boolean weak = true;
             next_vertex:
             for (int j=0; j<N; ++j) 
                for (int k=0; k<N; ++k)
                   if (adj[i][j]=='1' && adj[j][k]=='1' && adj[k][i]=='1') {
                      weak = false;
                      break next_vertex;
                   }
             if (weak) System.out.print( i+" " );
          }
          System.out.println(); 
       }
   }
}
