package Interview150;








public class SameTree100 {


	public boolean isSameTree(TreeNode p, TreeNode q) {




	}



	//p =
	//[1,2,3,null,null,4,5]
	//q =
	//[1,2,3]

	public static boolean checkTwoTreeStructure(TreeNode p ,TreeNode q)
	{
		if(p.val == q.val)
		{
			boolean left  = true;
			boolean right = true;
			if ( p.left != null && q.left != null) {
				left = checkTwoTreeStructure(p.left, q.left);
			}
			else if(p.left == null && q.left !=null)
			{
				left= false;
			}
			else if(p.left != null && q.left == null)
			{
				left= false;
			}


			if (p.right != null && q.right != null) {
				right= checkTwoTreeStructure(p.right, q.right);
			}
			else if(p.right ==null && q.right != null)
			{
				right = false;
			}
			else if(p.right != null && q.right == null)
			{
				right= false;
			}
			return left && right;
		}
		else
		{
			return false;
		}

	}

}
