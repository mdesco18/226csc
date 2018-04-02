//Midterm Q2
//V00847029 Descoteaux, Marc-Andre


import java.util.*;

public class MidtermB{
	
	static int N;
	static int R;
	static int S;
	static boolean[] damag;
	static boolean[] reser;
	static int[] dam;
	static int[] res;
	
	
	static int hasRes(int d){
		
		if(reser[d]) return 0;
		
		if(d == N){
	
			if(reser[d-1]) return -1;
			
		}else if(d == 0){
			
			if(reser[d+1]) return 1;
			
		}else{
			
			if(reser[d-1]) return -1;
			if(reser[d+1]) return 1;
			
			
		}
		
		return -2;
		
	}
	
	static void borrow(){
		
		for(int d = 0; d < S; d++){
			int dt = dam[d];
			if(damag[dt]){
				int hr = hasRes(dt);
				damag[dt] = false;
				if(hr == 0){
					reser[dt] = false;
				}else if(hr == 1){
					reser[dt+1] = false;
				}else if(hr == -1){
					reser[dt-1] = false;
				}else{
					damag[dt] = true;
				}
				
			}
		}
	}
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		S = in.nextInt();
		R = in.nextInt();
		in.nextLine();
		
		damag = new boolean[N+1];
		reser = new boolean[N+1];
		
		Arrays.fill(damag, false);
		Arrays.fill(reser, false);
		
		dam = new int[S];
		res = new int[R];
		
		for(int i = 0; i < S; i++){
			dam[i] = in.nextInt();
			damag[dam[i]] = true;
		}
		in.nextLine();
		for(int i = 0; i < R; i++){
			res[i] = in.nextInt();
			reser[res[i]] = true;
		}
		in.nextLine();
		
		borrow();
		int j = 0;
		for(int i = 1; i <= N; i++ ){
			if(damag[i])
				j++;
		}
		System.out.println(j);
	}
	
}