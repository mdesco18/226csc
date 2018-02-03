// Kattis problem "No Duplicates"
// Type: Easy, strings
// Comment: Used on CSC 226 Midterm #1, 2018.

import java.util.*;

class NoDuplicates {
   public static void main ( String[] args ) {
      Scanner in = new Scanner( System.in );
      String[] S = in.nextLine().split(" ");
      HashSet<String> hash = new HashSet<String>();
      for (int i=0; i<S.length; ++i) {
         if (hash.contains( S[i] )) {
            System.out.println( "no" );
            return;
         } else hash.add( S[i] );
      }
      System.out.println( "yes" );
   }
}
