package Interview150;




public class MinimumAbsoluteDifferenceBST530 {



	public static void main(String... args)
	{
//		TreeNode root = new TreeNode(37);
//		TreeNode l1v28 = new TreeNode(39);
//		TreeNode l1v41 = new TreeNode(37);
//		TreeNode l2v19 = new TreeNode(37);
//		TreeNode l2v29 = new TreeNode(34);
//		TreeNode l2v39 = new TreeNode(34);
//		TreeNode l2v42 = new TreeNode(36);
//		TreeNode l3v15 = new TreeNode(33);
//		TreeNode l3v20 = new TreeNode(32);
//		TreeNode l3v38 = new TreeNode(31);
//		TreeNode l3v43 = new TreeNode(30);
//		TreeNode l5v21 = new TreeNode(32);

//
//		root.left = l1v28;
//		root.right = l1v41;
//		l1v28.left =l2v19;
//		l1v28.right = l2v29;
//		l1v41.left = l2v39;
//		l1v41.right = l2v42;
//		l2v19.left = l3v15;
//		l2v19.right = l3v20;
//		l2v39.left = l3v38;
//		l2v42.right = l3v43;
//
//
//
//		System.out.println(minDiff(root));

		System.out.println("-".repeat(50));

		TreeNode root = new TreeNode(1);
		TreeNode l1v0 = new TreeNode(0);
		TreeNode l1v48 = new TreeNode(48);
		TreeNode l2v12 = new TreeNode(12);
		TreeNode l2v49 = new TreeNode(49);


		root.left = l1v0;
		root.right = l1v48;
		l1v48.left = l2v12;
		l1v48.right= l2v49;


		System.out.println(minNode(l1v48));
		System.out.println(minDiff(root));




	}

	static int minDistance = Integer.MAX_VALUE;
	public static int minDiff(TreeNode root)
	{

		inOrderTraverse(root);

		return minDistance;

	}

	public static void inOrderTraverse(TreeNode root)
	{
		int leftVal = 0;
		int rightVal = 0;
		int leftDistance;
		int rightDistance;
		if(root.left != null)
		{
			leftVal = maxNode(root.left).val;
		}
		if(root.right != null)
		{
			rightVal = minNode(root.right).val;
		}

		if(root.left !=null || root.right !=null) {
			leftDistance = Math.abs(root.val - leftVal);
			rightDistance = Math.abs(root.val - rightVal);
			if(root.left == null)
			{
				leftDistance = Integer.MAX_VALUE;
			}
			if(root.right == null)
			{
				rightDistance = Integer.MAX_VALUE;
			}
			int minimum = Math.min(leftDistance, rightDistance);
			minDistance = Math.min(minimum, minDistance);
		}

		if(root.left != null)
		{
			inOrderTraverse(root.left);
		}

		if(root.right!=null)
		{
			inOrderTraverse(root.right);
		}

	}




	public static TreeNode maxNode(TreeNode root)
	{
		if(root.right != null)
		{
			return maxNode(root.right);
		}

		return root;

	}

	public static TreeNode minNode(TreeNode root)
	{
		if(root.left != null)
		{
			return minNode(root.left);
		}
		return root;
	}


}
