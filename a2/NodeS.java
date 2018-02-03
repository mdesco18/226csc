//Node class

public class NodeS{

	public String data;
	public Node next;
	
	public NodeS(){
		data = null;
		next = null;
	}
	
	public NodeS(String x, NodeS ptr){
		data= x;
		next= ptr;
	}
	

}