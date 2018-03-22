// Kattis problem "Maximizing Winnings" 3.7
// Type: Matrix multiplication, DP, binary powering (squaring)
// Comment: Nice problem, combine MIN & MAX somehow?

import java.util.*;
import java.io.*;

class MaximizingWinningsA {

// computes T = A*B, all are n x n matrices
static int[][] multMIN ( int n, int[][] A, int[][] B ) {
   int[][] T = new int[n][n];
   for (int r=0; r<n; ++r)
      for (int c=0; c<n; ++c) {
         T[r][c] = Integer.MAX_VALUE;
         for (int i=0; i<n; ++i) {
            T[r][c] = Math.min(  T[r][c], A[r][i]+B[i][c] );
         }
      }
   return T;
}

// computes A^(e+1) using lg(n) matrix multiplications
static int[][] powerMIN( int e, int n, int[][] A ) {
   int [][] R = A.clone(); 
   while (true) {
       if ((e&1)==1) R = multMIN( n, R, A );
       if ((e>>=1)==0) break;
       A = multMIN( n, A, A );
   }
   return R;
}

// computes T = A*B, all are n x n matrices
static int[][] multMAX ( int n, int[][] A, int[][] B ) {
   int[][] T = new int[n][n];
   for (int r=0; r<n; ++r)
      for (int c=0; c<n; ++c) {
         T[r][c] = 0;
         for (int i=0; i<n; ++i) {
            T[r][c] = Math.max(  T[r][c], A[r][i]+B[i][c] );
         }
      }
   return T;
}

// computes A^(e+1) using lg(n) matrix multiplications
static int[][] powerMAX( int e, int n, int[][] A ) {
   int [][] R = A.clone(); 
   while (true) {
       if ((e&1)==1) R = multMAX( n, R, A );
       if ((e>>=1)==0) break;
       A = multMAX( n, A, A );
   }
   return R;
}

public static void main ( String[] args ) {
  Scanner in = new Scanner( new BufferedInputStream(System.in) );
  while (true) {
     int N = in.nextInt();  // 1 <= N <= 250
     if (N==0) return;
     int[][] A = new int[N][N];
     for (int n=0; n<N; ++n) 
        for (int m=0; m<N; ++m) 
           A[n][m] = in.nextInt();
     int iter = in.nextInt();
     int[][] P = powerMAX( iter-1, N, A );
     int[][] Q = powerMIN( iter-1, N, A );
     int max = 0, min = Integer.MAX_VALUE;      
     for (int n=0; n<N; ++n) {
        if (P[0][n] > max) max = P[0][n];
        if (Q[0][n] < min) min = Q[0][n];
     }
     System.out.println( max+" "+min );
  }
}

}
