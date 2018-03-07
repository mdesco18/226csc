//Truck.java
//V00847029 Descoteaux, Marc-Andre
//CSC226 Assignment 4

import java.util.*;

public class Truck{
	
	public static boolean debug = true;
	
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] items = new int[n+1];
		for(int i = 1; i <= n; i++){
			items[i] = in.nextInt();
		}
		int m = in.nextInt();
		EdgeWeightedGraph G = new EdgeWeightedGraph(n);
		for(int i = 0; i < m; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			double d = (double) in.nextInt();
			
			G.addEdge(a, b, d);
		}
		
		if(debug) System.out.println(G);
		
		DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(G, 1);
		if(!dsp.hasPathTo(n)) System.out.println("Impossible");
		else{
			int sp = (int) dsp.distTo(n);
			if(debug) System.out.println(sp);
			int grabbed = 0;
			for(Edge e: dsp.pathTo(n)){
				if(debug) System.out.println(e);
				grabbed += items[e.either()];
				if(debug) System.out.println(grabbed);
			}
		}
		// to try seperate paths: 
		// Map <sp, grabbed>
		// remove pathTo(n)[0] 
		// dsp again
		// compare if sp1 == sp2, use max{grabbed1, grabbed2}
		
	}
}