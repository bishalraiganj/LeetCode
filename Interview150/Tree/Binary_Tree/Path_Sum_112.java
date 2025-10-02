package Interview150.Tree.Binary_Tree;

public class Path_Sum_112 {

	int currTotal = 0;
	int targetSum =0;
	int subArrayDecreaseSum = 0;
	public boolean hasPathSum(TreeNode root, int targetSum) {

		//Edge Cases Handling
		if(root==null || (root.left==null && root.right==null && root.val!=targetSum))
		{
			return false;
		}

		this.targetSum = targetSum;
		return inOrder(root);
	}

	public boolean preOrder(TreeNode root)
	{
		if(root.left==null && root.right==null)
		{
			currTotal += root.val;
			return currTotal==targetSum;
		}

		currTotal+=root.val;
		boolean leftFlag = false, rightFlag = false;

		if(root.left!= null)  leftFlag = inOrder(root.left);
		if(leftFlag)
		{
			return true;
		}
		else {
			currTotal-=root.left!=null?root.left.val:0;
			if (root.right != null) rightFlag = inOrder(root.right);
			if(rightFlag)
			{
				return true;
			}
			else
			{
				currTotal-=root.right!=null?root.right.val:0;
				return false;
			}
		}

	}


	public boolean hasPathSum2(TreeNode root, int targetSum)
	{
		if(root==null) return false;

		if(root.left==null && root.right==null) return root.val == targetSum;

		return (hasPathSum2(root.left,targetSum-root.val) || hasPathSum2(root.right,targetSum-root.val));

	}

}
