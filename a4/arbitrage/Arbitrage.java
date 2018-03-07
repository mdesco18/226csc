/* Arbitrage.java
V00847029 Descoteaux, Marc-Andre
CSC226 Assignment 4 
*/

import java.util.*;

public class Arbitrage{
	
	static boolean debug = false;
	
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		
		int C = input.nextInt();
		input.nextLine(); //feed line
		int R = 0;
		
		while(C > 0){
			
			Map<String, Integer> codes = new HashMap<String, Integer>(); //mappings for currency code to vertex
			EdgeWeightedDigraph G = new EdgeWeightedDigraph(C);
			//get currency codes
			for(int i = 0; i < C; i++){
				codes.put(input.next(), i);
			}
			R = input.nextInt();
			input.nextLine();
			
			//build digraph
			for(int i = 0; i < R; i++){
				String first = input.next();
				String second = input.next();
				String[] r = input.nextLine().split(":");
				double a = Double.valueOf(r[0]);
				double b = Double.valueOf(r[1]);
				double x = b/a;
				//DirectedEdge e = new DirectedEdge(codes.get(first), codes.get(second), -Math.log(x));
				G.addEdge(codes.get(first), codes.get(second), -Math.log(x));
			
			}
			
				if(debug){
					System.out.println(G);
				}
				if(debug){
					
					codes.forEach((f, i) -> {
						System.out.println("Code "+f+" at vertex "+i);
					}) ;
					System.out.println();
				}
				
				BellmanFord spt = new BellmanFord(G, 0);
				if (spt.hasNegativeCycle()) System.out.println("Arbitrage");
				else System.out.println("Ok");
				
				
			C = input.nextInt();
			
		}
		
		
		
	}
	
}