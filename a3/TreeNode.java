//TreeNode.java

public class TreeNode{
	
	public int key; //position in tree
	public int val;
	public int size; //size of subtrees
	public TreeNode right;
	public TreeNode left;
	
	public TreeNode(int k, int v, int s){
		key = k;
		val = v;
		size = s;
	}
	
	public static int getSize(TreeNode r){
		if (r != null) return r.size;
		else return 0;
	}
	
}