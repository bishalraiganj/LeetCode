package Interview150.Tree.Binary_Tree;

public class Sum_Root_To_Leaf_Numbers_129 {



	//Accumulated sum of all path's from root to nodes


	public int sumNumbers(TreeNode root) {

		//Edge Case handling
		if(root == null)
		{
			return 0;
		}

		return preOrderTraversal(root,0);

	}

	public int preOrderTraversal(TreeNode root, int sum)
	{
		//Base case's
		if(root==null )
		{
			return  0;
		}

		int currSum = (  sum * 10 ) + root.val;
		if(root.left == null && root.right == null )
		{
			return currSum;
		}

		return preOrderTraversal(root.left,currSum) + preOrderTraversal(root.right,currSum);
	}
}
