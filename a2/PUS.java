// V00847029 Descoteaux, Marc-Andre
/* PUS.java
Author: Marc Descoteaux
Student: V00847029
Date: 2018-01-26
Project: CSC226 A2 P1 

// This exercise does not make use of vertex '0' therefore the classes it uses are modified as such
*/

import java.util.*;
import java.io.*;

public class PUS{
	
	public static boolean debug = false;

	public static void failed(){
		System.out.println("IMPOSSIBLE");
		System.exit(1);
	}
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		// get number of sticks and lines
		int n = in.nextInt();
		int m = in.nextInt();

		int a, b, i, j, firstex;
		int[] ao = new int[n]; //adjacency list input order
		// create adjacency node list for sticks
		LinkedList[] adj = new LinkedList[n+1];
		Node curr;
		firstex = in.nextInt();
		a = firstex;
		b =  in.nextInt();
		j = 0;
		for(i = 0; i < m; i++){
			if( a == b ){
				failed();
			}
			if(debug){
				System.out.println("A is: "+a+" B is: "+b);
			}
			if(adj[a] == null){
				adj[a] = new LinkedList();
				ao[j] = a;
				j++;
			}
			adj[a].addRear(b);
			if(in.hasNext()){
				a = in.nextInt();
				b = in.nextInt();
			}
			
		}
		
		for(i = 0; i <= n; i++){
			if(adj[i] != null){
				adj[i].checkList();
				if(!adj[i].unique(n)){
					failed();
				}
			}else adj[i] = new LinkedList();
		}
		
		if(debug){
			for(i = 0; i <= n; i++){
				System.out.println("List for stick: "+i);
				if(adj[i] != null){
					adj[i].printList();
				}else{
					System.out.println("Empty");
				}				
			}
		}
		
		Digraph G = new Digraph(n, m, adj, ao);
		
		if(debug){
			System.out.println("Before DFS");
			System.out.println(G);
		}
		
		G.topologicalSort();
	
	}
	
}
