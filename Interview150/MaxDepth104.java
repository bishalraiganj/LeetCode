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

	@Override
	public String toString()
	{
		return "TreeNode val:"+val+"\n"+"left:"+left+"| Right:"+ right;
	}


}
public class MaxDepth104 {




	public static void main(String... args)
	{
		TreeNode root = new TreeNode(45);
		TreeNode l1v39 = new TreeNode(39);
		TreeNode l1v37 = new TreeNode(37);
		TreeNode l2v37 = new TreeNode(37);
		TreeNode l2v34 = new TreeNode(34);
		TreeNode l2v34n2 = new TreeNode(34);
		TreeNode l2v36 = new TreeNode(36);
		TreeNode l3v33 = new TreeNode(33);
		TreeNode l3v32 = new TreeNode(32);
		TreeNode l3v31 = new TreeNode(31);
		TreeNode l3v30 = new TreeNode(30);
		TreeNode l3v32n2 = new TreeNode(32);
		TreeNode l3v33n2 = new TreeNode(33);
		TreeNode l4v35 = new TreeNode(35);

		root.left = l1v39;
		root.right = l1v37;
		l1v39.left =l2v37;
		l1v39.right = l2v34;
		l1v37.left = l2v34n2;
		l1v37.right = l2v36;
		l2v37.left = l3v33;
		l2v37.right = l3v32;
		l2v34.left = l3v31;
		l2v34.right = l3v30;
		l2v34n2.left = l3v32n2;
		l2v34n2.right = l3v33n2;
		l3v33n2.right = l4v35;



		System.out.println(maxDepth(root));




	}

	public static int maxDepth(TreeNode root)
	{


		return traverse(root,0);

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
//		else if( root.right != null && root.left == null)
//		{
//			return right;
//		}
//		else if(root.left != null  && root.right == null)
//		{
//			return left;
//		}
		else
		{
			return Math.max(left,right);
		}

	}



}
