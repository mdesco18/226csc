//Midterm Q4
//V00847029 Descoteaux, Marc-Andre

import java.util.*;

public class MidtermD{
	
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.nextLine();
		
		int[] sol = new int[n];
		
		for(int i = 0; i < n; i++){
			int row = in.nextInt();
			int col = in.nextInt();
			sol[col] = row;
			in.nextLine();
		}
		
		ValidQueens vq = new ValidQueens(n, sol);
		
		boolean correct = vq.checkValid();
		
		if(correct) System.out.println("CORRECT");
		else System.out.println("INCORRECT");
		
	}
	
}