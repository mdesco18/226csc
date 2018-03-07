// Kattis problem "Un-bear-able Zoo" 1.6.
// Type: Sorting or TreeMap (used here).
// Comment: On 226 Midterm #1.

import java.util.*;

class BearZoo {

public static void main ( String[] args ) {
   Scanner in = new Scanner( System.in );
   int caseNum = 0; 
   while (true) {
      int N = in.nextInt();  in.nextLine();
      if (N==0) return;
      TreeMap<String,Integer> tmap = new TreeMap<String,Integer>();
      System.out.println( "List "+(++caseNum)+":" );
      for (int n=0; n<N; ++n) {
	  String[] S = in.nextLine().split(" ");
         String animal = S[S.length-1].toLowerCase();
         if (tmap.get( animal ) == null) tmap.put( animal, 1 ); // this code
         else tmap.put( animal, 1 + tmap.get( animal ) );       // seems ugly
      } 
      tmap.forEach( (animal,count) -> { System.out.println( animal+" | "+count ); } );
   }
}

}
