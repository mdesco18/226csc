//FuncFun.java
//V00847029 Descoteaux, Marc-Andre 
//CSC226 Assignment 4 

import java.util.*;

public class FuncFun{
	
	private static boolean debug = true;
	
	private static void validateN(int n){
		
		if(n < 0 || n > 40)
			throw new IllegalArgumentException("number of mappings " + n + " is not between 0 and 40");
		
	}
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		boolean isSur = false;
		boolean isIn = true;
		boolean isBi = false;
		boolean isFunc = true;
		
		while(in.hasNext()){
			
			
			String[] domain = in.nextLine().split(" ");
			if(debug) System.out.println(domain[0]);
			
			String[] codomain = in.nextLine().split(" ");
			if(debug) System.out.println(codomain[0]);
			Set<String> set = new HashSet<String>();
			int n = in.nextInt();
			if(debug) System.out.println("n is "+n);
			in.nextLine(); //line feed
			validateN(n);
			Map<String, String> maps = new HashMap<String, String>();
			for(int i = 0; i < n; i++){
				String[] map = in.nextLine().split(" -> ");
				if(maps.containsValue(map[1])){
					isIn = false;
				}else{
					set.add(map[1]);
				}
				if(maps.containsKey(map[0])){
					isFunc = false;
				}
				maps.put(map[0], map[1]);
				if(debug) System.out.println(maps);

			}
			
			
			String[] codom = Arrays.copyOfRange(codomain, 1, codomain.length);
			Arrays.sort(codom);
			if(debug){
				for(int i = 0; i < codom.length; i++){
					System.out.print(codom[i] + " ");
				}
				System.out.println("");
			}
			
			String[] vals = set.toArray(new String[0]);
			Arrays.sort(vals);
			if(debug){
				for(int i = 0; i < vals.length; i++){
					System.out.print(vals[i]+" ");
				}
				System.out.println("");
			}
			
			if(Arrays.equals(vals, codom)){
				isSur = true;
			}
			
			if(isSur && isIn) isBi = true;
			if(!isFunc) System.out.println("not a function");
			else if(isBi) System.out.println("bijective");
			else if(isIn) System.out.println("injective");
			else if(isSur) System.out.println("surjective");
			else System.out.println("neither injective nor surjective");
		
		}
		
		
		
	}
	
	
	
}