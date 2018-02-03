// Kattis problem "Cookie Selection" 5.1
// Type: Priority Queue data structure.
// Comment: Very nice problem

import java.util.*;

class CookieSelection {

public static void main ( String[] args ) {

  Scanner in = new Scanner( System.in );
  PriorityQueue<Integer> pqmin = new PriorityQueue<Integer>();
  PriorityQueue<Integer> pqmax = new PriorityQueue<Integer>(Collections.reverseOrder());
  pqmin.add( Integer.MAX_VALUE );  pqmax.add( Integer.MIN_VALUE );
  while (in.hasNext()) { 
     String s = in.next();
     if (s.equals("#")) {
        System.out.println( pqmin.poll() );
        if (pqmax.size() > pqmin.size()) pqmin.add( pqmax.poll() );
     } else {
        int d = Integer.parseInt(s);
        if (d > pqmax.peek()) {
           pqmin.add( d );
           if (pqmin.size() > 1+pqmax.size()) pqmax.add( pqmin.poll() );
        } else {
           pqmax.add( d );
           if (pqmax.size() > pqmin.size() ) pqmin.add( pqmax.poll() );
        }
     }
  }
}     
}
