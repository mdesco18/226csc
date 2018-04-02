//Color.java
//Descoteaux, Marc-Andre V00847029

import java.util.*;

public class Color{
	
	private static boolean debug = false;
	private static int colorNum;
	private static int[] colors;
	private static boolean[] colorlist;
	private static int N;
	static int sol;
	
	public static boolean isSame(Graph G, int v, int c){
		
		for(Edge e : G.adj(v)){ 
			if(debug) System.out.println(v+"->"+e.other(v)+": "+colors[v]+" "+colors[e.other(v)]+" "+ colorNum);
			if(colors[e.other(v)] == c) return true;
		}
		return false;
	}
	
	public static void greedyColoring(Graph G){
		//assign colors to vertices 1 - N-1
		 for (int u = 1; u < N; u++){
			//iterate through a vertex adj list and find what colors are being used
			for(Edge e: G.adj(u)){
				if(colors[e.other(u)] != -1){
					if (debug) System.out.println(e.other(u)+" has color: "+ colors[e.other(u)]+"\n"+u+ " has color: "+colors[u]);
					colorlist[e.other(u)] = false;
				}
			}
 
            //find the first available color
            int cr;
            for (cr = 0; cr < N; cr++){
                if (colorlist[cr]){
					if (debug) System.out.println("first available color: "+cr);
                    break;
				}
            }
 
            colors[u] = cr; //assign the found color
			if( debug) System.out.println(u+" has color: "+colors[u]);
			
            //reset the values back to true for the next iteration
            Arrays.fill(colorlist, true);
        }
	   
    }
	
	static void getSol(){
		
		Arrays.sort(colors);
		colorNum = colors[N-1]+1;
		System.out.println(colorNum);
		
	}
	
	static boolean btColoring(Graph G, int v, int m){
		
		if(v == N) return true;
		
		//try assigning color c
		for(int c = 1; c <= m; c++){
			
			//check if color c is not assigned to any of v's neighbours
			if(!isSame(G, v, c)){
				colorNum = c;
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
		
		Graph G = new Graph(N); 
		colors = new int[N];
		colorlist = new boolean[N];
		Arrays.fill(colors, 0);
		//Arrays.fill(colorlist, true);
		colors[0] = 0;
		
		for(int n = 0; n < N; n++){
			Scanner line = new Scanner(in.nextLine());
			while(line.hasNext())
				G.addEdge(n, line.nextInt());
		}
		
		if(debug) System.out.println(G);
		int m = 0;
		for(m = 1; m <= N; m++){
			if(btColoring(G, 0, m))
				break;
		}
		if(debug){
			for(int i = 0; i < N; i++)
				System.out.println(colors[i]);
		} 
		System.out.println(m);	
		//getSol();
		
	}
	
	
}