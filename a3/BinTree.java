
//import java.lang.Math;

public class BinTree{
	
	public int size;
	public TreeNode root;
	public TreeNode[] nodes;
	public int[] keys;
	public int i;
	public static boolean debug = false;
	
	
	public BinTree(int n){
		i = 0;
		nodes = new TreeNode[n];
		keys = new int[n];
		
	}
	
	public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(TreeNode x) {
        if (x == null) return 0;
        else return x.size;
    }
	public void Iterate(TreeNode x){
		if(x == null) return;
		else {
			nodes[i] = x;
			keys[i] = x.key;
			i++;
		}
		if(i < nodes.length){
			Iterate(x.left);
			Iterate(x.right);
		}
	}
	public TreeNode put(TreeNode x, int k, int val) {
		if (x == null){
			if(debug) System.out.println("key "+ k +" val "+val);
			return new TreeNode(k, val, 1);
		}
		if (val < x.val) x.left = put(x.left, (2*k)+1, val);
		else if (val > x.val) x.right = put(x.right, (2*k)+2, val);
		else x.right = put(x.right, (2*k)+2,  val);
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}
	
    public TreeNode get(TreeNode x, int key, int val) {
        if (x == null) return null;
       
		if(val < x.val) return get(x.left, key, val);
		else if (val > x.val) return get(x.right, key, val);
		//else if (key == x.key) return x;
		//else return get(x.right, val);
        return x;
    }
}