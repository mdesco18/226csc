//DirectedEdgeList.java
//Descoteaux, Marc-Andre

import java.util.*;

public class DirectedEdgeList{
	
	private boolean debug = false;
	public int n;
	public DirectedEdge start;
	public DirectedEdge rear;
	
	public DirectedEdgeList(){
		n= 0;
		start= null;
		rear= null;
	}
	public DirectedEdgeList(int n, DirectedEdge start, DirectedEdge rear){
		this.n= n;
		this.start= start;
		this.rear= rear;
	}
	
/**
	* Returns true if this queue is empty.
	*
	* @return {@code true} if this queue is empty; {@code false} otherwise
	*/
    public boolean isEmpty() {
        return start == null;
    }
/**
     * Returns the number of items in this queue.
     *
     */
    public int size() {
        return n;
    }

/** 
	*
	* insert a new DirectedEdge into a linked list keeping weights sorted
	*
*/
	public void insertList(int u, int v, double w){
		DirectedEdge current;
		DirectedEdge previous;
		current= start;
		previous= start;
		
//check if list is empty
		if(current == null){
			current = new DirectedEdge(u, v, w, rear);
		   start = current;
		   rear = current;
//check if insertion will be at beginning of list
		}else if(start.weight > w){
		
		   current = new DirectedEdge(u, v, w, start);
		   start = current;
		   
		}else{
//iterate through list to place insertion
			while (current.weight < w && current != rear){
				previous = current;
			   current= current.next;
			}
//check if insertion is to be appended
			if(current == rear){
				DirectedEdge end = new DirectedEdge(u, v, w);
				current.next = end;
				rear = end;
//insert new w
			}else{
				 
				current= new DirectedEdge(u, v, w,current);
				previous.next = current;
			}
		}
		n++;
	}
	public void insertList(DirectedEdge e){
		DirectedEdge current;
		DirectedEdge previous;
		current= start;
		previous= start;
		
//check if list is empty
		if(current == null){
		   start = e;
		   rear = e;
//check if insertion will be at beginning of list
		}else if(start.weight > e.weight){
		
		  e.next = start;
		   start = e;
		   
		   
		}else{
//iterate through list to place insertion
			while (current.weight < e.weight && current != rear){
				previous = current;
			   current= current.next;
			}
//check if insertion is to be appended
			if(current == rear){
				current.next = e;
				rear = e;
//insert new w
			}else{
				 
				e.next = current;
				previous.next = e;
			}
		}
		n++;
	}

/**
	*
	* adds a DirectedEdge to the rear of the LinkedList
	*
*/
	public void addRear(int u, int v, double w){
		DirectedEdge curr;
		curr = new DirectedEdge(u, v, w);
		if(start == null){
			start = curr;
			rear = curr;
		}else{
			rear.next = curr;
			rear = curr;
		}
		//curr.next = null;
		n++;
		if(debug){
			System.out.println(curr);
			this.checkList();
		}
	}
	
	public void addRear(DirectedEdge e){
		
		if(start == null){
			start = e;
			rear = e;
		}else{
			rear.next = e;
			rear = e;
		}
		//e.next = null;
		n++;
	}
	//Returns all directed edges in list
	public Iterable<DirectedEdge> edges(){
		if(debug) this.checkList();
		DirectedEdge[] list = new DirectedEdge[n];
		int i = 0;
		for(DirectedEdge curr = start; curr != null; curr = curr.next){
			list[i] = curr;
			i++;
		}
		Iterable<DirectedEdge> iterable = Arrays.asList(list);
		return iterable;
	}
	public void checkList(){
	//check if list is null
		if(this != null){
	//check if list has valid n
			if(n >= 0){
				DirectedEdge current, prev;
				current = null; prev = null;
	//check if start pointer points to first node
				if(start != null){
					current = start;
	//check if rear pointer points to null
					if(rear.next == null){
						int i = 0;
	//count how many nodes are in the list
						while(current != null && i < n){
							i++;
							prev = current;
							current = current.next;
						}
	//check if the number of nodes counted is equal to the number of nodes set in the list
						if( i != n ){
							System.err.println("LinkedList not properly set - wrong number of n or list has null nodes");
							System.exit(0);
						}
	//check if rear pointer points to last node
						if(rear != prev){
							System.err.println("LinkedList not properly set - rear doesn't point to last node");
							System.exit(0);
						}
					}else{
						System.err.println("LinkedList not properly set - rear doesn't point to null");
						System.exit(0);
					}
				}else{
					System.err.println("LinkedList not properly set - start is null");
					System.exit(0);	
				}
			}else{
				System.err.println("LinkedList not properly set - List has no nodes");
				System.exit(0);
			}
		}else{
			System.err.println("LinkedList not properly set - List is null");
			System.exit(0);
		}
	}
}