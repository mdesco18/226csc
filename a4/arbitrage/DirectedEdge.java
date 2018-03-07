//DirectedEdge.java
//Descoteaux, Marc-Andre

public class DirectedEdge{
	
	public int u;
	public int v;
	public double weight;
	public DirectedEdge next;
	
	public DirectedEdge(int u, int v, double weight){
        if (u < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.u = u;
        this.v = v;
        this.weight = weight;
		next = null;
    }
	public DirectedEdge(int u, int v, double weight, DirectedEdge nxt){
        if (u < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.u = u;
        this.v = v;
        this.weight = weight;
		next = nxt;
    }
	public int from(){
		return u;
	}
	
	public int to(){
		return v;
	}
	
	public String toString() {
        return u + "->" + v + " " + String.format("%5.2f", weight);
    }
}