//V00847029 Descoteaux, Marc-Andre
//Midterm 1 CSC 226 Question 2 Un-Bear-able zoo

import java.util.*;
import java.io.*;

public class MidtermB{
	static boolean debug = true;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n; int list = 1;
		n = in.nextInt();
		in.nextLine();
		
		while(n > 0){
			
			LinkedString[] animals = new LinkedString[n];
			String[] nameani = new String[n];
			for( int i = 0; i < n; i++){
				Scanner line = new Scanner(in.nextLine());
				
				while(line.hasNext()){
					animals[i].addFront(line.next());
				}
				
			}
			for(int i = 0; i < n; i++){
				nameani[i] = animals[i].start.data;
			}
			if(debug){
				for(int d = 0; d < n; d++){
					System.out.println(nameani[d]);
				}
			}
			n = in.nextInt();
			in.nextLine();
		}
	}
	
}