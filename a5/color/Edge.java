//Edge.java
//Descoteaux, Marc-Andre

public class Edge{
	
	public final int u;
	public final int v;
	public double weight;
	public Edge next; 
	
/******************************************
				CONSTRUCTORS
*******************************************/
	
	public Edge(){
		u = 0;
		v = 0;
		weight = 0.0;
		next = null;
	}
	
	public Edge(int u, int v){
		if (u < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
		this.u = u;
		this.v = v;
		weight = 0.0;
		next = null;
	}
	
	public Edge(int u, int v, double w){
		if (u < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(w)) throw new IllegalArgumentException("Weight is NaN");
		this.u = u;
		this.v = v;
		weight = w;
		next = null;
	}
	
	
	public Edge(int u, int v, double w, Edge p){
		if (u < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(w)) throw new IllegalArgumentException("Weight is NaN");
		this.u = u;
		this.v = v;
		weight = w;
		next = p;
	}
	
	//copies an edge
	public Edge(Edge e){
		if (e.u < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (e.v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(e.weight)) throw new IllegalArgumentException("Weight is NaN");
		this.u = e.u;
		this.v = e.v;
		weight = e.weight;
		next = e.next;
	}
	
/*******************************************
				GETTERS
*******************************************/

	public double weight(){
		return weight;
	}
	
	public int either(){
		return u;
	}
	//returns the endpoint of the given vertex
	public int other(int vertex) {
        if      (vertex == u) return v;
        else if (vertex == v) return u;
        else throw new IllegalArgumentException("Illegal endpoint");
    }
	
/********************************************
			UTILITY
********************************************/

	//compare two edges weights
	//@Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }
	
	public String toString(){
        return String.format("%d-%d %.3f %d", u, v, weight);
    }
	
}