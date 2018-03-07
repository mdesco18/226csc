// A Huffman's algorithm problem: "tapemerge"
// Created and solution programmed by Frank Ruskey, January 2018
// Comment: On UVic midterm #1

import java.util.*;

class Node {
   static long sum; // a bit kludgy 
   int w;
   Node left, riht;
   Node ( int ww ) { left = riht = null; w = ww; }
   Node ( Node ll, Node rr ) {
      w = ll.w + rr.w;
      sum += w;
      left = ll; riht = rr;
   }
}

class Huffy {
   public static void main ( String[] args ) {
      Scanner in = new Scanner( System.in );
      while (true) {
         int N = in.nextInt();   if (N==0) return;
         Node.sum = 0;
         PriorityQueue<Node> pq = new PriorityQueue<Node>( 2*N-1, (a,b) -> a.w-b.w );
         for (int n=0; n<N; ++n) pq.add( new Node( in.nextInt() ));  // leaves
         for (int n=1; n<N; ++n) pq.add( new Node( pq.poll(), pq.poll() ) );
         System.out.println( Node.sum-N+1 );
      }
   }
}
