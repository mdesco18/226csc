//Queens.java
//Descoteaux, Marc-Andre

import java.util.*;

public class Queens{
	
	private static boolean debug = false;

	private static int n; //size of board
	private static int m; //number of holes
	private static int[] x = new int[12]; //solution
	private static int count; //num of solutions
	private static boolean[] a = new boolean[12]; // row free?
	private static boolean[] b = new boolean[24]; // diag / free?
	private static boolean[] c = new boolean[24]; // diag \ free?
	private static boolean[][] hole = new boolean[12][12]; //true if no hole is on the space
	
	
	
	static void gen(int col){
		
		for(int row = 0; row < n; ++row){
			
			if(debug) System.out.println(row+" "+col);
			
			if(a[row] && b[row+col] && c[row-col+n]){
				x[col] = row;
				a[row] = b[row+col] = c[row-col+n] = false;
				
				if(col == n - 1) count++;
				else gen(col+1);
				
				a[row] = b[row+col] = c[row-col+n] = true;
			}
			
		}
		
	}

	public static void main(String args[]){
	
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		
		while (n != 0){
			
			if(debug) System.out.println(n+" "+m);
			count = 0;
			for (boolean[] u: hole)
				Arrays.fill(u, true);
			Arrays.fill(a, true);
			Arrays.fill(b, true);
			Arrays.fill(c, true);
			
			for(int i = 0; i < m; i++){
				
				int x = in.nextInt();
				int y = in.nextInt();
				in.nextLine();
				hole[x][y] = false;
			}
			
			gen(0);
			System.out.println(count);
			
			
			
			n = in.nextInt();
			m = in.nextInt();
			in.nextLine();
		}
	
	
	
	
	}




}