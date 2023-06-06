package practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RangeSumBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		//root.right.left = new TreeNode();
		root.right.right = new TreeNode(18);
		int low =7;
		int high = 15;
		//int res = rangeSumBST(root, low, high);
		int res = iterativeDFS(root, low, high);
		System.out.println(res);
	}

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.add(root.val);
        while(!st.isEmpty()) {
        	System.out.println("root is "+root.val);
        	if(root.left != null) {
        		st.add(root.left.val);
        		root = root.left;
        		System.out.println("root is "+root.val);
        	}else if(root.right != null) {
        		st.add(root.right.val);
        		root = root.right;
        		System.out.println("root is "+root.val);
        	}
        	int val = st.pop();
        	if(low <= val && val <= high) {
        		res += val;
        	}
        }
        
    	return res;
    }
    
    private static int iterativeDFS(TreeNode root, int low, int high) {
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	int res = 0;
    	st.push(root);
    	while(!st.isEmpty()) {
    		TreeNode val =st.pop();
    		if(val !=null) {
    			System.out.println(val.val);
    			root = val;
    			if(low <= val.val && val.val <= high) {
    				res += val.val;
            	}
    			st.push(root.right);
    			st.push(root.left);
    		}
    	}
    	return res;
    }
    
    //using iterative bfs : queue and linkedList
    public static int rangeSumBST1(TreeNode root, int low, int high) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int sum =0;
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			int n = curr.val;
			if(curr.left!=null) q.add(curr.left);
			if(curr.right != null) q.add(curr.right);
			if(n>=low && n<=high) {
				sum+=n;
			}
		}
		return sum;
	}
    
  //using iterative bfs : deque and ArrayQueue
    public static int rangeSumBST2(TreeNode root, int low, int high) {
		Deque<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		int sum =0;
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			int n = curr.val;
			if(curr.left!=null) q.add(curr.left);
			if(curr.right != null) q.add(curr.right);
			if(n>=low && n<=high) {
				sum+=n;
			}
		}
		return sum;
	}
    
    //using recurssion dfs
    public static int rangeSumBST3(TreeNode root, int low, int high) {
    	return recurssiveDfs(root, 0, low, high);
    }
    private static int recurssiveDfs(TreeNode root, int sum, int low, int high) {
    	if(root==null) return 0;
    	int n = root.val;
    	if(n < high && n > low) {
    		sum+= n;
    	}
    	if(root.left != null) {
    		sum += recurssiveDfs(root.left, sum, low, high);
    	}
    	if(root.right != null) {
    		sum += recurssiveDfs(root.right, sum, low, high);
    	}
    	return sum;
    }
    //beats 100%
    private static int recurssiveDfs2(TreeNode root, int sum, int low, int high) {
    	if(root==null) return 0;
    	int n = root.val;
    	if(n <= high && n >= low) {
    		sum+= n;
    	}
    	if(n<high) {
    		sum = recurssiveDfs(root.right, sum, low, high);
    	}
    	if(n>low) {
    		sum = recurssiveDfs(root.left, sum, low, high);
    	}
    	return sum;
    }
}
