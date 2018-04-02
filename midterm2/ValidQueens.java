//ValidQueens.java
//Descoteaux, Marc-Andre

import java.util.*;

public class ValidQueens{
	
	private  boolean debug = false;

	private  int n; //size of board
	private  int[] x; //solution
	private  int[] y; //solution to compare to
	private  boolean correct = false;
	private  int count = 0; //num of solutions
	private  boolean[] a; // row free?
	private  boolean[] b; // diag / free?
	private  boolean[] c; // diag \ free?	
	
	public ValidQueens(int n, int[] y){
		
		this.n = n;
		this.y = y;
		x = new int[n];
		a = new boolean[n];
		b = new boolean[n];
		c = new boolean[n];
	}
	
	private void check(){
		
		if(Arrays.equals(x, y)) correct = true;
		
	}
	
	public boolean checkValid(){
		
		gen(0);
		return correct;
		
	}
	
	public void gen(int col){
		
		for(int row = 0; row < n; ++row){
			
			if(debug) System.out.println(row+" "+col);
			
			if(a[row] && b[row+col] && c[row-col+n]){
				x[col] = row;
				a[row] = b[row+col] = c[row-col+n] = false;
				
				if(col == n - 1) check();
				else gen(col+1);
				
				a[row] = b[row+col] = c[row-col+n] = true;
			}
			
		}
		
	}


}