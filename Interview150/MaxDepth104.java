package Interview150;



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode{


	int val;
	TreeNode left;
	TreeNode right;
	TreeNode()
	{

	}
	TreeNode(int val)
	{
		this.val = val;
	}
	TreeNode(int val,TreeNode left,TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}



}
public class MaxDepth104 {


	public int maxDepth(TreeNode root)
	{



	}


	public static int traverse(TreeNode root,int level)
	{


		int left = 0 ;
		int right  = 0 ;
		if(root.left != null)
		{
			left =	traverse(root.left, level+1);
		}
		if(root.right != null)
		{
			right = traverse(root.right,level+1);
		}

		if(root.left == null && root.right == null)
		{
			return level;
		}
		else if( root.right != null && root.left == null)
		{
			return right;
		}
		else if(root.left != null  && root.right == null)
		{
			return left;
		}
		else
		{
			return Math.max(left,right);
		}

	}



}
