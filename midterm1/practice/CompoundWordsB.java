// Kattis problem "Compound Words" 1.7
// Type: Easy, strings.
// Comment: List all pairs, input specification lacks details

import java.util.*;

class CompoundWordsB {

public static void main ( String[] args ) {
   ArrayList<String> W = new ArrayList<String>(); // The words
   TreeSet<String> P = new TreeSet<String>();     // The pairs
   Scanner in = new Scanner( System.in );

   // read the inputs, store in W
   while (in.hasNext()) W.add(in.next());

   // process pairs from W
   for (int i=0; i<W.size(); ++i) 
   for (int j=0; j<W.size(); ++j) 
      if (i != j) // don't self-concatenate
         P.add( W.get(i)+W.get(j) );
   
   // output answer
   for (String s : P) System.out.println( s );
} 
}
