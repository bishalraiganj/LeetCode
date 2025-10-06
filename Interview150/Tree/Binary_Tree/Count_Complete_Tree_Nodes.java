package Interview150.Tree.Binary_Tree;

public class Count_Complete_Tree_Nodes {



	public static void main(String... args)
	{
		TreeNode n2 = new TreeNode();
		TreeNode n5 = new TreeNode();
		TreeNode n4= new TreeNode();
		TreeNode n1 = new TreeNode();
		TreeNode n3 = new TreeNode();
		TreeNode n6 = new TreeNode();


		n2.left = n5;
		n2.right = n4;
		n1.right = n3;
		n3.left = n6;
		n1.left = n2;



		Count_Complete_Tree_Nodes obj = new Count_Complete_Tree_Nodes();
		System.out.println(obj.leftLevel(n1,1));

		System.out.println(obj.countNodes(n1));

	}

	public int countNodes(TreeNode root) {
		return recursiveCount(root);
	}


	public int recursiveCount(TreeNode root)
	{
		//Base Case
		if(root==null)
		{
			return 0;
		}
		if(root.left == null && root.right == null)
		{
			return 1;
		}

		int leftNodeCount = leftLevel(root.left,2);
		int rightNodeCount = rightLevel(root.right,2);
		if(leftNodeCount==rightNodeCount) return (int) Math.pow(2,leftNodeCount) - 1;

		return 1 +  ( recursiveCount(root.left) + recursiveCount(root.right) );

	}



	public int leftLevel(TreeNode root, int level)
	{
		if(root==null) return 0;
		if(root.left!=null) return leftLevel(root.left,level+1);
		return level;
	}

	public int rightLevel(TreeNode root, int level)
	{
		if(root==null) return 0;
		if(root.right!=null) return rightLevel(root.right, level+1);
		return level;
	}

}
