//Midterm Q1
//V00847029 Descoteaux, Marc-Andre

import java.util.*;

public class MidtermA{
	
	
	
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int[] dist = new int[4];
		
		for(int i = 0; i < 4; i++){
			dist[i] = in.nextInt();
		}
		Arrays.sort(dist);
		int area = dist[0] * dist[2];
		
		System.out.println(area);
		
		
	}
	
}