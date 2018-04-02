//Coloring.java
//Descoteaux, Marc-Andre V00847029

import java.util.*;

public class Coloring{
	
	private static boolean debug = false;
	private static int[] colors;
	private static int N;
	static int[][] G ;
	
	//time: O(N)
	public static boolean isSame(int[][] G, int v, int c){
		
		for(int i = 0; i < N; i++){ 
			if(G[v][i] == 1 && c == colors[i]) return true;
		}
		return false;
	}
	
	
	static boolean btColoring(int[][] G, int v, int m){
		
		if(v == N) return true;
		
		//try assigning color c
		for(int c = 1; c <= m; c++){
			
			//check if color c is not assigned to any of v's neighbours
			if(!isSame(G, v, c)){
				colors[v] = c;
				
				//after checking all neighbours, get solution 
				//or continue on to next vertex
				
				if(btColoring(G, v+1, m)) return true;
				
				//if a solution wasn't found then reset the color
				colors[v] = 0;
			
			}	
		}
		
		return false;
	
	}
	
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		in.nextLine();
		
		G = new int[N][N];
		colors = new int[N];
		//Arrays.fill(colors, 0);
		//colors[0] = 0;
		
		//time: O(N+E)
		for(int n = 0; n < N; n++){
			Scanner line = new Scanner(in.nextLine());
			while(line.hasNext()){
				G[n][line.nextInt()] = 1;
			}
				
		}
		
		int m = 0;
		//time: O(N)
		for(m = 2; m <= N; m++){
			if(btColoring(G, 0, m))
				break;
		}
		if(debug){
			for(int i = 0; i < N; i++)
				System.out.println(colors[i]);
		} 
		System.out.println(m);	
		
	}
	
	
}