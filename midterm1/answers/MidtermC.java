//V00847029 Descoteaux, Marc-Andre
//Midterm 1 CSC 226 Question 3 Weak Vertices

import java.util.*;
import java.io.*;

public class MidtermC{
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		
		while(n>0){
			int[][] adjm = new int[n][n];
			boolean[] weak = new boolean[n];
			for(int i = 0; i < n; i++){
				weak[i] = true;
			}
			for (  int i = 0; i< n; i++){
				Scanner li = new Scanner(in.nextLine());
				for(int j = 0; j < n; j++){
					adjm[i][j] = li.nextInt();
				}
			}
			for( int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(adjm[i][j] == 1){
						int[] listi = new int[n];
						int[] listj = new int[n];
						for(int m = 0; m < n; m++){
							listi[m] = adjm[i][m];
							listj[m] = adjm[j][m];
						}
						for(int m = 0; m < n; m++){
							if(listi[m] == 1 && listj[m]==1){
								weak[i] = false;
								weak[j] = false;
							}
						}
					}
				}
			}
			for( int i = 0; i < n; i++){
				if(weak[i]){
					System.out.print(i+" ");
				}
			}
			System.out.println("");
			 n = in.nextInt();
			in.nextLine();
		}
		
	}
	
	
}