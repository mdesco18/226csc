// Kattis problem "Bishops" 2.0
// Type: Easy, mathy type of analysis
// Comment: E.g., put n bishops in leftmost column and n-2
//      in the rightmost column.

import java.util.*;

class Bishops {
    public static void main( String[] args ) {
       Scanner in = new Scanner( System.in );
       while (in.hasNext()) {
          int n = in.nextInt();
          System.out.println( n==1 ? 1 : 2*n-2 );
       }
    }
}
