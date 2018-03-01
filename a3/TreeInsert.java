import java.util.*;
import java.io.*;
//import java.lang.Comparable;
//import java.lang.Math;
//import java.lang.Number;
import java.math.BigInteger;

public class TreeInsert{
	
	static boolean debug = true;
	
	static int MOD = (int)1e9+7;
	static int n;
	static int[] ord;
	static BinTree tree;
	static int[][] lookup;
	
	public static int prod(int a, int b){
		int res = a;
		res *= b;
		if (res >= MOD) return res % MOD;
		return res; 
	}
	/*
	public static BigInteger bigProd(BigInteger a, BigInteger b){

		return a.multiply(b); 
	}
	*/
	public static BigInteger findPerms(TreeNode r){
		//if (r == null || r.size < 3) return BigInteger.valueOf(1);
		//else if (r.size == 3) return BigInteger.valueOf(2);
		if(r == null) return BigInteger.valueOf(1);
		return findPerms(r.right).multiply(findPerms(r.left)).multiply(BigInteger.valueOf(choose(r.size-1, TreeNode.getSize(r.right))));
	
	}
	public static int choose(int k, int r){
		if(k < r) return 0;
		if(k == r || r == 0) return 1;
		if(r == k-1) return k;
		if(lookup[k][r] >= 0) return lookup[k][r];
		int bico = choose(k-1, r) + choose(k-1, r-1);
		lookup[k][r] = bico;
		return bico;
	}
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		in.nextLine();
		int val, i;
		while(n > 0){
			//Build tree
			tree = new BinTree(n);
			ord = new int[n];
			
			for(i = 0; i < n; i++){
				val = in.nextInt();
				ord[i] = val;
				if(i==0){ 
					tree.root = tree.put(null, 0, val);
				}else{
					tree.put(tree.root, 0, val);
				}
			}
			lookup = new int[n][n];
			for(int[] row: lookup)
				Arrays.fill(row, -1);
			BigInteger perms = findPerms(tree.root);
			System.out.println(perms);
			
			/*
			if(debug){
				//make iterables of nodes and keys
				tree.Iterate(tree.root);
				int a;
				System.out.print("Index\t\t");
				for(a = 0; a < n; a++){
					System.out.print(a+" ");
				}
				System.out.print("\nOrder\t\t");
				for(a = 0; a < n; a++){
					System.out.print(ord[a]+" ");
				}
				tree.i = 0;
				for(a = 0; a < n; a++){
					
					if(tree.nodes[a] != null){
						System.out.println("\nNode k: "+tree.nodes[a].key+" v: "+tree.nodes[a].val);
						System.out.print("Points left to ");
						if(tree.nodes[a].left !=null) System.out.println("Node k: "+tree.nodes[a].left.key+" v: "+tree.nodes[a].left.val);
						else System.out.println("Nothing");
						System.out.print("Points right to ");
						if(tree.nodes[a].right !=null) System.out.println("Node k: "+tree.nodes[a].right.key+" v: "+tree.nodes[a].right.val);
						else System.out.println("Nothing");
					}
					//System.out.println(tree.keys[a]);
				}	
				System.out.print("\nPosition\t");
				for(a = 0; a < n; a++){
					System.out.print(tree.nodes[a].key+" ");
				}
				System.out.println("");
			}
			*/
			
			n = in.nextInt();
			in.nextLine();
		}
		
		
		
	}
	
}
	