// Kattis problem "Verify This, Your Majesty" (queens) 3.3
// Type: Easy, similar to Kattis Eight Queens problem
// Comment: Good to know the "classic" solution to n-queens.

import java.util.*;

class VerifyQueen {

public static void main ( String[] args ) {

  // relying on Java initializing these to false.
  boolean[] a = new boolean[6000];  // Queen in - row
  boolean[] b = new boolean[12000]; // Queen in / diagonal
  boolean[] c = new boolean[12000]; // Queen in \ diagonal
  boolean[] x = new boolean[6000];  // Queen in column

  Scanner in = new Scanner( System.in );
  int N = in.nextInt();
  boolean invalid = false;
  for (int n=0; n<N; ++n) {
     int row = in.nextInt(), col = in.nextInt();
     if (a[row])       { invalid = true; break; }  else a[row]       = true;
     if (b[row+col])   { invalid = true; break; }  else b[row+col]   = true;
     if (c[row-col+N]) { invalid = true; break; }  else c[row-col+N] = true;
     if (x[col])       { invalid = true; break; }  else x[col]       = true;
  }
  System.out.println( invalid?"INCORRECT":"CORRECT" );
}

}
