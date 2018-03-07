// Kattis problem "Bacon, Eggs and Spam" 1.8
// Type: Easy, but uses StringTokenizer, TreeMap, and TreeSet.
// Comment: Nice problem.  Better to use split instead of the Tokenizer?  

import java.util.*;

class BaconEggsSpamB {

   public static void main ( String[] args ) {
      Scanner in = new Scanner( System.in );
      while (true) {
         int N = in.nextInt();
         if (N==0) return;
         in.nextLine(); // advance past N
         TreeMap<String,TreeSet<String>> tm = new TreeMap<String,TreeSet<String>>();
         for (int n=0; n<N; ++n) {
            StringTokenizer st = new StringTokenizer( in.nextLine() );
            String name = st.nextToken();
            while (st.hasMoreTokens()) {
               String item = st.nextToken(); 
               if (tm.containsKey(item)) {
                  TreeSet<String> v = tm.get(item);
                  v.add( name );
               } else {
                  TreeSet<String> v = new TreeSet<String>( );
                  v.add( name );
                  tm.put( item, v );
               }
            }
         }
         
         tm.forEach( (item,names) -> {
            System.out.print( item+" " );
            for ( String name : names ) System.out.print( name+" " );
            System.out.println();
         } );
           
         System.out.println();
      }
   }

}
