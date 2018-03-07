//LinkedList class

import java.util.*;
import java.io.*;

public class LinkedList{

	static boolean debug= false;

	public int n;
	public Node start;
	public Node rear;
	
/**
	*
	* linked list constructor
	* first with no variables for initializing
	* second with choice variables
	*
*/
	public LinkedList(){
		n= 0;
		start= null;
		rear= null;
	}
	public LinkedList(int n, Node start, Node rear){
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
	* insert a new node into a linked list keeping values sorted
	*
*/
	public void insertList(int value){
		Node current;
		Node previous;
		current= start;
		previous=start;
		
//check if list is empty
		if(current == null){
			current = new Node(value,rear);
		   start = current;
		   rear = current;
//check if insertion will be at beginning of list
		}else if(start.data > value){
		
		   current = new Node(value, start);
		   start = current;
		   
		}else{
//iterate through list to place insertion
			while (current.data < value && current != rear){
				previous = current;
			   current= current.next;
			}
//check if insertion is to be appended
			if(current == rear){
				Node end = new Node(value, null);
				current.next = end;
				rear = end;
//insert new value
			}else{
				 
				current= new Node(value,current);
				previous.next = current;
			}
		}
		n++;
	}

/**
	*
	* adds a Node to the rear of the LinkedList
	*
*/
	public void addRear(int val){
		Node curr;
		curr = new Node(val, null);
		if(start == null){
			
			start = curr;
			rear = curr;
		}else{
			rear.next = curr;
			rear = curr;
		}
		n++;
	}
			
/**
	* 
	* reverse the nodes in the LinkedList recursively 
	*
*/	
	public void reverse(int level){
//base case: if list is size 1 then it can't be reversed
		if(n == 1){
			return;
		}
	
		Node current;
		current = start;
		int i, size2;
	
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
	//go to middle of the list
		current = start;
		for(i = 1; i < n/2; i++){
			current = current.next;
		}
	//divide list in half
		list1.start = start;
		list2.start = current.next;
		list2.rear = rear;
		list1.rear = current;
		list1.rear.next = null;
		size2 = n - n/2;
	
		if(debug){
			System.out.println("size2 (n-n/2) is currently: "+size2);
		}
	
		list1.n = n/2;
		list2.n = size2;
	
		if(debug){
			list1.printList();
			list2.printList();
			System.out.println("level before list1 recursion is: "+level);
		}
	
	//reverse first half of list recursively
		list1.reverse(level+1);
	
		if(debug){
			System.out.println("the value of k after list1 recursion is: "+level);
			System.out.println("the value of k before list2 recursion is: "+level);
		}
	
	//reverse second half of list recursively
		list2.reverse(level+1);
	
		if(debug){
			System.out.println("level after list2 recursion is: "+level);
		}
	
	//marry reversed lists: list2->list1
		start = list2.start;
		list2.rear.next = list1.start;
		rear = list1.rear;
	
		if(debug){
			System.out.println("start is: "+start.data+" rear is: "+rear.data);
			list1.printList();
			list2.printList();
		}
	
	}
/**
	*
	* get an iterable of all the data values in the linked list in order
	*
*/
	public Iterable<Integer> values(){

		Integer[] list = new Integer[n];
		int i = 0;
		for(Node curr = start; curr != null; curr = curr.next){
			list[i] = curr.data;
			i++;
		}
		Iterable<Integer> iterable = Arrays.asList(list);
		return iterable;
	}
/**
	*
	* check the uniqueness of the list
	* works with adjacency lists, v is the number of vertices, assumes all data in the linked list <= v
	*
*/
	public boolean unique(int v){
		boolean[] marked = new boolean[v+1];
		int val;
		for(Node curr = start; curr != null; curr = curr.next){
			val = curr.data;
			if(!marked[val]){
				marked[val] = true;
			}else{
				return false;
			}
		}
		return true;
	}
/**
	*
	* read an int from the given scanner
	*
*/
	 public static int readInteger(Scanner in){
		int n;

		try{
		   n= in.nextInt();
		   if (n >=0) return(n);
		   else return(-1);
		}
		catch(Exception e)
		{
		//        We are assuming legal integer input values are >= zero.
		  return(-1);
		}
	}
/**
	*
	* create a LinkedList of values from input stream
	*
*/
	public static LinkedList readList(Scanner in){
	
		int num_item;
		num_item= readInteger(in);
		if (num_item <= 0) return(null);
	
		LinkedList newList; 
		
		int value;
		int i;

		newList= new LinkedList();

		
		

		for (i=0; i < num_item; i++){
			value= readInteger(in);
			if (i==0){
				newList.start= new Node(value, null);
				newList.rear= newList.start;
				newList.n=1;
			}else{
				newList.rear.next= new Node(value, null);
				newList.rear= newList.rear.next;
				newList.n++;
			}
			if (debug){
				System.out.println("After reading in " + (i+1) + " items: ");
				newList.printList();
			}
		}
		return(newList);
	}
/**
	*
	* print to output the number of items in the list and the contents of the list iteratively
	*
*/
	public void printList(){
		
		Node current;

		int count=0;

		System.out.println("The list has " + n + " items: ");

		current= start;
		while (current != null){
			count++;

			System.out.print(current.data + " ");
			current= current.next;
		}
		System.out.println();
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		for(Node curr = start; curr!=null; curr=curr.next){
			s.append(String.format("%d\n", curr.data));
		}
		return s.toString();
	}

/**
	*
	* check if any operations have invalidated the integrity of the list
	*
*/
	public void checkList(){
	//check if list is null
		if(this != null){
	//check if list has valid n
			if(n > 0){
				Node current, prev;
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
