// DiceBet.java
// V00847029, Marc-Andre Descoteaux
// Project: CSC 226 A3
// 2018-02-15

import java.util.*;
import java.io.*;

public class DiceBet{
	
	static boolean debug = false;
	static int n, s, k;
	static double prob;
	static double[][] lookup;
	
	public static double betProbability(int r, int d, int level, boolean side){
		/*
		if(debug){
			if(side){
				System.out.println("Called from side 1, level "+(level-1));
			}else{
				System.out.println("Called from side 2, level "+(level-1));
			}
		} */
		if(lookup[r][d] > 0){
			//if(debug) System.out.println("Base memoir");
			return lookup[r][d];
		}else if(d >= k){
			//if(debug) System.out.println("Base d >= k");
			return 1;
		}else if(r == 0){
			//if(debug) System.out.println("Base r = 0");
			
			return 0;
		}else{
			/*
			if(debug){
				System.out.println("Before Call at level: "+level);
				System.out.printf("n = %d; s = %d; k = %d; r = %d; d = %d\n", n, s, k, r, d);
			}*/
			
			double b1 = ((double)d)/s;
			double b2 = ((double)s-d)/s;
			/*
			if(debug){
				System.out.println("b1 "+b1);
				System.out.println("b2 "+b2);
			}*/
			prob = b1 * betProbability(r-1, d, level+1, true) + b2 * betProbability(r-1, d+1, level+1, false);
			/*
			if(debug){
				System.out.println("After Call at level: "+level);
				System.out.printf("n = %d; s = %d; k = %d; r = %d; d = %d; prob = %f\n", n, s, k, r, d, prob);
			}
			*/
			
			lookup[r][d] = prob;
			
			/*
			if(debug){
				for(int a = 0; a <= n; n++){
					for(int b = 0; b <= k; k++){
						System.out.println(lookup[a][b]);
					}
				}
			}*/
		}
		return prob;
		
	}
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		s = in.nextInt();
		k = in.nextInt();
		lookup = new double[n+1][k+1];
		int d = 0;
		prob = betProbability(n, d, 0, true);
		//answer
		System.out.printf("%.07f", prob);
	}
}