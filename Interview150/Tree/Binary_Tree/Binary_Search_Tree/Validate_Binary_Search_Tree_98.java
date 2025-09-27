package Interview150.Tree.Binary_Tree.Binary_Search_Tree;

public class Validate_Binary_Search_Tree_98 {

	public boolean isValidBST(TreeNode root)
	{
		if(root==null)
		{
			return true;
		}
		return inOrderTraversal(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}


	public boolean inOrderTraversal(TreeNode root,long min, long max)
	{

		if(root.val<=min || root.val>=max)
		{
			return false;
		}
		boolean leftStatus = true;
		boolean rightStatus = true;

		// It the root has a left child check the left child with it's leftRange
		// leftRange( parent's min,current node's val)
		//rightRange(currentNode's val , parent's max)
		//min,max values of the range are exclusive , according to the leetcode questions instructions
		if(root.left != null)
		{
			if(    root.left.val>min && root.left.val<root.val)
			{
				leftStatus= inOrderTraversal(root.left,min,root.val);
			}
			else leftStatus = false;
		}

		// It the root has a right child check the righ child with it's rightRange
		//min,max values of the range are exclusive , according to the leetcode questions instructions
		if(root.right != null)
		{
			if(root.right.val>root.val && root.right.val<max)
			{
				rightStatus= inOrderTraversal(root.right,root.val,max);
			}
			else
			{
				rightStatus = false;
			}
		}
		return leftStatus && rightStatus;
	}

}
