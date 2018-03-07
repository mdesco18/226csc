// Kattis problem "Kitten on a Tree" 1.9
// Type: Easy, parent array.
// Comment: Used in CSC 226 Homework #1, Spring 2018

import java.util.*;

class KittenTree {

    public static void main( String[] args ) {
       int[] id = new int[101]; // this is the parent array
       Scanner in = new Scanner( System.in );
       int kitten = in.nextInt();  in.nextLine();
       
       // build the array
       while (true) {
          String[] S = in.nextLine().split(" ");
          int p = Integer.parseInt(S[0]);
          if (p==-1) break;
          for (int k=1; k<S.length; ++k) 
             id[Integer.parseInt(S[k])] = p;
       }
       
       // output the answer
       while (kitten>0) {
          System.out.print( kitten+" " );
          kitten = id[kitten];
       }
       System.out.println();
   }
}
