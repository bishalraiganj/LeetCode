package Interview150.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}




public class Flatten_Binary_Tree_To_LinkedList_114 {

	public void flatten(TreeNode root) {

		//Edge Case Handling

		preOrderTraversal(root);
	}



	public TreeNode preOrderTraversal(TreeNode root)
	{
		if(root==null ) return root;
		if(root.left== null && root.right==null) return root;



		TreeNode leftTree = preOrderTraversal(root.left);
		TreeNode rightTree = preOrderTraversal(root.right);


		if(leftTree!=null)
		{
			leftTree.right = root.right;
			root.right  = root.left;
			root.left = null;
		}

		return rightTree!=null?rightTree:leftTree;
	}
}
