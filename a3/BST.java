//BST.java taken from algs4
import java.lang.Comparable;

public class BST{

	public int[] pos;
	public int size;
	public TreeNode root;
	
	public BST(){
		
	}
	
	public int size() {
        return size(root);
    }

    // return number of key-val pairs in BST rooted at x
    private int size(TreeNode x) {
        if (x == null) return 0;
        else return x.size;
    }
	
	public void put(String key, int val) {
        if (key == null || val == 0) return;
        root = put(root, key, val);
    }
	public TreeNode put(TreeNode x, String key, int val) {
		if (x == null) return new TreeNode(key, val, 1);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = put(x.left,  key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else              x.val   = val;
		//x.size = 1 + size(x.left) + size(x.right);
		return x;
	}
	public int get(String key) {
        return get(root, key);
    }

    private int get(TreeNode x, String key) {
        //if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
	
}