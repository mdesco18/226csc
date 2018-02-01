// V00847029 Descoteaux, Marc-Andre
/* BES.java
Author: Marc Descoteaux
Student: V00847029
Date: 2018-01-22
Project: CSC226 A2 P1 
*/

import java.util.*;
import java.io.*;

public class BES{
	
	public static boolean debug = false;

	public static void main(String args[]){
		
		Scanner sysin = new Scanner(System.in);
		TreeMap<String, PriorityQueue<String>> tm = new TreeMap<String, PriorityQueue<String>>();
		int n = sysin.nextInt();
		int i = 0; int j = 0;
		String order, food;
		sysin.nextLine();
		

		while(n > 0){

			if(debug){
				System.out.println("n is: "+n);
			}
			
			String[] cust = new String[20];
			
			for(i = 0; i < n; i++){

				order = sysin.nextLine();

				if(debug){
					System.out.println("\nOrder "+(i+1)+" begin:");
					System.out.println(order);
					System.out.println("Order "+(i+1)+" end.\n");
				}

				Scanner str = new Scanner(order);
				cust[i] = str.next();
				String[] ord = new String[11];
				PriorityQueue<String> whoAte = new PriorityQueue<String>(20);
				while(str.hasNext()){
					food = str.next();
					ord[j] = food;
					j++;

				}
				for(j = 0; ord[j] != null && j < 10; j++){
					if(debug){
						System.out.println(ord[j]);
					}
					if(!tm.containsKey(ord[j])){
						whoAte = new PriorityQueue<String>();
						
					}else{
						whoAte = tm.get(ord[j]);
						tm.remove(ord[j]);
					}
					whoAte.add(cust[i]);
					tm.put(ord[j], whoAte);

					if(debug){

						System.out.println("Size of tree is: "+tm.size());
						System.out.println("Keys in the tree are: " + tm.keySet());
						System.out.println("Values in the tree are: " + tm.values());
						
					}

				} j = 0;

			}

			if(debug) System.out.println("Begin polling:");

			Iterable<String> keys = tm.keySet();

			for(String s: keys){
				System.out.print(s+" ");
				Iterable<String> ppl = tm.get(s);
				for(String r: ppl){
					System.out.print(r+" ");
				}
				System.out.println("");
			}
			System.out.println("");
				
			tm.clear();
			n = sysin.nextInt();
			if(sysin.hasNext())	sysin.nextLine();
		}
				

	}

}
