package Interview150.Tree.Binary_Tree;

public class Symmetric_Tree_101 {

	public boolean isSymmetric(TreeNode root) {

		if(root== null || (root.left==null && root.right==null))
		{
			return true;
		}

		return inOrderSymmetry(root.left,root.right);

	}

	public boolean inOrderSymmetry(TreeNode root1, TreeNode root2)
	{
		if(root1.val == root2.val)
		{
			boolean left = true;
			boolean right = true;

			if(root1.left!=null && root2.right!=null)
			{
				left  = inOrderSymmetry(root1.left,root2.right);
			}
			else if(!(root1.left==null && root2.right==null))
			{
				return false;
			}

			if(root1.right!=null && root2.left!=null)
			{
				right = inOrderSymmetry(root1.right,root2.left);
			}
			else if(!(root1.right==null&&root2.left==null))
			{
				return false;
			}

			return left && right;
		}
		else {

			return false;
		}

	}

}
