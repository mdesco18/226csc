// Kattis problem "Natjecanje" 2.2
// Type: Easy, greedy
// Comment: Nice problem.  

import java.util.*;

class Natjecanje {

public static void main ( String[] args ) {
   Scanner in = new Scanner( System.in );
   int N = in.nextInt(), S = in.nextInt(), R = in.nextInt();
   int[] K = new int[16];
   Arrays.fill( K, 1 );   // Give each team 1 kayak.
   for (int n=0; n<S; ++n) K[in.nextInt()] = 0;
   for (int n=0; n<R; ++n) {
      int x = in.nextInt();
      K[x] = K[x]==0 ? 1 : 2;  // Need this!
   }
   int count=0;
   for (int n=1; n<=N; ++n) {
      if (K[n]==0) { // look left, then right
         if (K[n-1]==2) K[n-1]=K[n]=1; else
         if (K[n+1]==2) K[n+1]=K[n]=1; else
         ++count;
      }
   }
   System.out.println( count );
}

}
