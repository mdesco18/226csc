// Kattis problem "Tree Insertion" 3.3
// Type: Binary search tree, binomial coefficients, big integers
// Comment: Has similarities with problem "Ceiling".  On 226 HW#3.

import java.util.*;
import java.math.*;

class Node {
   int val;  // key
   int desc; // number of descendants
   Node L,R;
   Node( int v ) { val=v; }
}

class TreeInsertion {

   static BigInteger[][] C = new BigInteger[101][101];
   
   static void initC() {
      for (int n=0; n<=100; ++n ) {
         C[n][0] = C[n][n] = BigInteger.ONE;
         for (int k=1; k<n; ++k ) 
            C[n][k] = C[n-1][k].add( C[n-1][k-1] );
      }
   }

   static Node insert( Node t, int v ) {
      if (t==null) return new Node( v ); 
      if (v < t.val) t.L = insert( t.L, v );
      else t.R = insert( t.R, v );
      return( t );
   }
   
   static BigInteger count ( Node t ) {
       if (t==null) return( BigInteger.ONE );
       if (t.L==null && t.R==null) { t.desc = 1; return( BigInteger.ONE ); }
       BigInteger cL = count( t.L );
       BigInteger cR = count( t.R );
       int dL = t.L==null?0:t.L.desc;
       int dR = t.R==null?0:t.R.desc;
       t.desc = 1+dL+dR;
       return( cL.multiply(cR).multiply(C[dL+dR][dL]) );
   }
   
   public static void main ( String[] args ) {
      initC();
      Scanner in = new Scanner( System.in );
      int N = in.nextInt(); // 1 <= N <= 100
      while (N > 0) {
         Node T = new Node( in.nextInt() ); // the root
         for (int n=1; n<N; ++n) insert( T, in.nextInt() );
         System.out.println( count( T ) );
         N = in.nextInt();
      }
   }
}
