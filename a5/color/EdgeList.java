//EdgeList.java
//Descoteaux, Marc-Andre

import java.util.*;

public class EdgeList{
	
	private boolean debug = false;
	
	public int n;
	public Edge start;
	public Edge rear;
	
	
/*****************************************
			CONSTRUCTORS
******************************************/

	public EdgeList(){
		n= 0;
		start= null;
		rear= null;
	}
	public EdgeList(int n, Edge start, Edge rear){
		this.n= n;
		this.start= start;
		this.rear= rear;
	}
	
/*******************************************
			GETTERS
*******************************************/

    public boolean isEmpty() {
        return start == null;
    }
/**
	 *
     * Returns the number of items in this list.
     *
*/
    public int size() {
        return n;
    }

/**************************************************
				MODIFIERS
***************************************************/
	
/*

insert a new or existing Edge into a linked list keeping weights sorted

*/
	public void insertList(int u, int v, double w){
		Edge current;
		Edge previous;
		current= start;
		previous= start;
		
//check if list is empty
		if(current == null){
			current = new Edge(u, v, w, rear);
		   start = current;
		   rear = current;
//check if insertion will be at beginning of list
		}else if(start.weight > w){
		
		   current = new Edge(u, v, w, start);
		   start = current;
		   
		}else{
//iterate through list to place insertion
			while (current.weight < w && current != rear){
				previous = current;
			   current= current.next;
			}
//check if insertion is to be appended
			if(current == rear){
				Edge end = new Edge(u, v, w);
				current.next = end;
				rear = end;
//insert new w
			}else{
				 
				current= new Edge(u, v, w,current);
				previous.next = current;
			}
		}
		n++;
	}
	public void insertList(Edge e){
		Edge current;
		Edge previous;
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
	* adds a Edge to the rear of the LinkedList
	*
*/
	public void addRear(int u, int v){
		if(debug) System.out.println("in addRear new");
		Edge curr;
		curr = new Edge(u, v);
		if(start == null){
			start = curr;
			rear = curr;
		}else{
			rear.next = curr;
			rear = curr;
		}
		
		n++;
		this.checkList();
	}
	public void addRear(int u, int v, double w){
		if(debug) System.out.println("in addRear new");
		Edge curr;
		curr = new Edge(u, v, w, null);
		if(start == null){
			start = curr;
			rear = curr;
		}else{
			rear.next = curr;
			rear = curr;
		}
		
		n++;
		this.checkList();
	}
	
//Copies given edge into graph

	public void addRear(Edge E){
		if(debug) System.out.println("in addRear edge");
		Edge e = new Edge(E);
		if(start == null){
			if(debug) System.out.println("Start list");
			start = e;
			rear = e;
		}else{
			rear.next = e;
			rear = e;
		}
		
		n++;
		
		this.checkList();
	}
	
/********************************************************
					UTILITY
********************************************************/
	//Returns all edges in list
	public Iterable<Edge> edges(){
		if(debug) System.out.println("in Edges");
		this.checkList();
	
		Edge[] list = new Edge[n];
		int i = 0;
		for(Edge curr = start; curr != null; curr = curr.next){
			list[i] = curr;
			i++;
			
		}
		Iterable<Edge> iterable = Arrays.asList(list);
		return iterable;
	}
	
	public void checkList(){
	//check if list is null
		if(this != null){
	//check if list has valid n
			if(n >= 0){
				Edge current, prev;
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