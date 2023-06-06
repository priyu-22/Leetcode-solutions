package practice;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(diameterOfBinaryTree(root));
		
	}
	private static int diameter = 0;
	public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
		dfs(root);
		return diameter;
    }
	
	private static int dfs(TreeNode root) {
		if(root == null) return 0;
		int left = 0;
		int right =0;
		left = dfs(root.left);
		right = dfs(root.right);
		diameter = Math.max(diameter, left+right);
		return Math.max(left, right)+1;
	}

}
