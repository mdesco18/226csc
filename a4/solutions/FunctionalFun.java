// Kattis problem "Functional Fun" 2.3
// Type: Mathy, hashing.
// Comment: Use in CSC 226

import java.util.*;

class FunctionalFun {
   public static void main ( String[] args ) {
      Scanner in = new Scanner( System.in );
      while (in.hasNext()) {
         boolean injective=true, surjective=false, notfunction=false;
         int Rhit=0; // number of values in f(D)
         HashSet<String> Ds = new HashSet<String>(); // domain
         HashSet<String> Rs = new HashSet<String>(); // range
         String[] D = in.nextLine().split(" ");
         String[] R = in.nextLine().split(" ");
         int N = in.nextInt();  in.nextLine();
         for (int n=0; n<N; ++n) {
            String[] F = in.nextLine().split(" ");
            if (Ds.contains(F[0])) notfunction = true;
            else {
               Ds.add(F[0]);
               if (Rs.contains(F[2])) injective = false;
               else { Rs.add(F[2]); ++Rhit; }
            }  
         }
         if (Rhit == R.length-1) surjective = true;
         if (notfunction) System.out.println( "not a function" ); else
         if (injective && surjective) System.out.println( "bijective" ); else
         if (injective) System.out.println( "injective" ); else
         if (surjective) System.out.println( "surjective" ); else
         System.out.println( "neither injective nor surjective" );
      }
   }
}
