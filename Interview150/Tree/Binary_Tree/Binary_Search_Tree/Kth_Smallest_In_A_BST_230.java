package Interview150.Tree.Binary_Tree.Binary_Search_Tree;

// * Definition for a binary tree node.
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





public class Kth_Smallest_In_A_BST_230 {

	 int counter=0;
	 int value=0;
	 int targetIndex;

	public int kthSmallest(TreeNode root, int k) {

		if(root != null)
		{

			targetIndex = k;
			inOrderLevel(root, k);
		}

		return value;
	}


	//In-Order Traversal , cause  the left most one is the smallest one then it's parent and then
	//the left most one from the right sub tree of the left most (first left most)one's parent ,
	//so ,we will recursively keep visiting smallest one's in order ,(ascending)
	// and on each last node on the stack frame we track the counter (1-indexed ) and when the target matches ,
	//we just simply assign the root.val to value and return in the kthSmallest method
	public void inOrderLevel(TreeNode root, int level)
	{
		if(root == null)
		{
			return ;
		}

		if( root.left != null)
		{
			inOrderLevel(root.left, level  + 1);
		}

		counter++;
		if(counter == targetIndex)
		{
			value =root.val;
		}

		if(root.right != null)
		{
			inOrderLevel(root.right, level + 1);
		}
	}
}
