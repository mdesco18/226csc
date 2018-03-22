//Truck.java
//V00847029 Descoteaux, Marc-Andre
//CSC226 Assignment 4

import java.util.*;

public class Truck{
	
	public static boolean debug = true;
	
	static void fail(){
		System.out.println("Impossible");
		System.exit(1);
	}
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		if(n < 2)
			fail();
		
		int[] items = new int[n+1];
		for(int i = 1; i <= n; i++){
			items[i] = in.nextInt();
		}
		int m = in.nextInt();
		if(m < 1) fail();
		EdgeWeightedGraph G = new EdgeWeightedGraph(n);
		for(int i = 0; i < m; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			double d = (double) in.nextInt();
			
			G.addEdge(a, b, d, items[a], items[b]);
		}
		
		if(debug) System.out.println(G);
		
		DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(G, 1);
		if(!dsp.hasPathTo(n)) fail();
		else{
			int sp = (int) dsp.distTo(n);
			int itemGet = (int) dsp.itemGet(n);
			if(debug) System.out.println(sp);
			if(debug) System.out.println(itemGet);
			int grabbed = 0;
			Edge la = null;
			for(Edge e: dsp.pathTo(n)){
				if(debug) System.out.println(e);
				grabbed += items[e.either()];
				if(debug) System.out.println(grabbed);
				la = e;
			}
			grabbed += items[n];
			System.out.println(sp+" "+grabbed);
		}
	}
}