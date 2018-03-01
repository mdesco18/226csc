/* Arbitrage.java
V00847029 Descoteaux, Marc-Andre
CSC226 Assignment 4 
*/

import java.util.*;

public class Arbitrage{
	
	static boolean debug = true;
	
	public static boolean arbitrate(Map x){
		
		
		
		
	}
	
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		
		int C = input.nextInt();
		input.nextLine(); //feed line
		int R = 0;
		
		while(C > 0){
			
			String[] codes = new String[C];
			Map<String, Map<String, Double>> xchange = new HashMap<String, Map<String, Double>>();
			for(int i = 0; i < C; i++){
				codes[i] = input.next();
				
				/*if(debug){
					System.out.println(codes[i]);
				}*/
			}
			R = input.nextInt();
			input.nextLine();
			
			for(int i = 0; i < R; i++){
				String first = input.next();
				String second = input.next();
				String[] r = input.nextLine().split(":");
				double a = Double.valueOf(r[0]);
				double b = Double.valueOf(r[1]);
				double x = b/a;
				
				/*if(debug){
					System.out.println("First: "+first+" Second: "+second+" Rate: "+x);
				}*/
				if(xchange.containsKey(first)){
					Map<String, Double> rate = xchange.get(first);
					rate.put(second, x);
					xchange.replace(first, rate);
				}else{
					Map<String, Double> rate = new HashMap<String, Double>();
					rate.put(second, x);
					xchange.put(first, rate);
				}
				
			}
				if(debug){
					xchange.forEach((f, map) -> {
						map.forEach((s, ra) -> {
					System.out.println(f+" "+s+" "+ra);
						}
						);
					} );
					System.out.println();
				}
				
				if(arbitrate(xchange)) System.out.println("Arbitrage");
				else System.out.println("Ok");
				
				
			C = input.nextInt();
			
		}
		
		
		
	}
	
}