//StringList class

import java.util.*;
import java.io.*;

public class StringList{

	static boolean debug= false;

	public int n;
	public NodeS start;
	public NodeS rear;
	
/**
	*
	* linked list constructor
	* first with no variables for initializing
	* second with choice variables
	*
*/
	public StringList(){
		n= 0;
		start= null;
		rear= null;
	}
	public StringList(int n, NodeS start, NodeS rear){
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
	* adds a NodeS to the rear of the StringList
	*
*/
	public void addRear(String val){
		NodeS curr;
		curr = new NodeS(val, null);
		if(start == null){
			
			start = curr;
			rear = curr;
		}else{
			rear.next = curr;
			rear = curr;
		}
		n++;
	}
	public void addFront(String val){
		NodeS curr, prev;
		curr = new NodeS(val, null);
		if(start == null){
			
			start = curr;
			rear = curr;
		}else{
			prev = start;
			start = curr;
			curr.next = prev;
		}
		n++;
	}


	public String toString(){
		StringBuilder s = new StringBuilder();
		for(NodeS curr = start; curr!=null; curr=curr.next){
			s.append(String.format("%d\n", curr.data));
		}
		return s.toString();
	}

/**
	*
	* check if all operations have not invalidated the integrity of the list
	*
*/
	public void checkList(){
	//check if list is null
		if(this != null){
	//check if list has valid n
			if(n > 0){
				NodeS current, prev;
				current = null; prev = null;
	//check if start pointer points to first NodeS
				if(start != null){
					current = start;
	//check if rear pointer points to null
					if(rear.next == null){
						int i = 0;
	//count how many NodeSs are in the list
						while(current != null && i < n){
							i++;
							prev = current;
							current = current.next;
						}
	//check if the number of NodeSs counted is equal to the number of NodeSs set in the list
						if( i != n ){
							System.err.println("StringList not properly set - wrong number of n or list has null NodeSs");
							System.exit(0);
						}
	//check if rear pointer points to last NodeS
						if(rear != prev){
							System.err.println("StringList not properly set - rear doesn't point to last NodeS");
							System.exit(0);
						}
					}else{
						System.err.println("StringList not properly set - rear doesn't point to null");
						System.exit(0);
					}
				}else{
					System.err.println("StringList not properly set - start is null");
					System.exit(0);	
				}
			}else{
				System.err.println("StringList not properly set - List has no NodeSs");
				System.exit(0);
			}
		}else{
			System.err.println("StringList not properly set - List is null");
			System.exit(0);
		}
	}
	
}
