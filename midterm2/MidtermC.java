//Midterm Q3
//V00847029 Descoteaux, Marc-Andre


import java.util.*;

public class MidtermC{
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		
		while(n > 0 || m > 0){
			
			EdgeWeightedGraph G = new EdgeWeightedGraph(n);
			
			for(int i = 0; i < m; i++){
				G.addEdge(in.nextInt(), in.nextInt(), -1 * in.nextDouble());
				in.nextLine();
			}
			
			DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(G, 0);
			double size = 1.000;
			if(dsp.hasPathTo(n-1)){
				for(Edge e: dsp.pathTo(n-1))
					size = size * (-1 * e.weight());
				
				System.out.printf("%.4f\n", size);
			}
			
			n = in.nextInt();
			m = in.nextInt();
			in.nextLine();
		
		}
		
	}
	
}