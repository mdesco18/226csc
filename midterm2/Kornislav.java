// Kattis problem "Kornislav" 1.3
// Type: Easy
// Comment: Nice problem.  

import java.util.*;

class Kornislav {
    public static void main( String[] args ) {
       Scanner in = new Scanner( System.in );
       int[] X = { in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt() };
       Arrays.sort( X );
       System.out.println( X[0]*X[2] );
    }
}
