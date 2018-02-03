//V00847029 Descoteaux, Marc-Andre
//Midterm 1 CSC 226 Question 1 no duplicates

import java.util.*;
import java.io.*;

public class MidtermA{
	static boolean debug = false;
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		String[] words = new String[40];
		boolean nodups = true;
		int i = 0;
		String one, two;
		while(in.hasNext()){
			words[i] = in.next();
			if(debug) System.out.println(words[i]);
			i++;
		}
		for(i = 0; i < words.length; i++ ){
			if(words[i] != null){
				one = words[i];
				for(int j = i+1; j < words.length; j++){
					if(words[j] != null){
						two = words[j];
						if(debug) System.out.println(one + " " + two);
						if(one.equals(two)){
							if(debug) System.out.println("Equal");
							System.out.print("no");
							nodups = false;
							System.exit(0);
						} 
					}
				}
			}
		}
		if(nodups) System.out.print("yes");
		
		
		
	}
	
	
}