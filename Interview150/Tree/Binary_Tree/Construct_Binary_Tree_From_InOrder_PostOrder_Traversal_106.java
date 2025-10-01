package Interview150.Tree.Binary_Tree;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_From_InOrder_PostOrder_Traversal_106 {


	Map<Integer,Integer>  map ;
	int postOrderCounter;
	int[] postorder = new int[0];

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0 || inorder.length!=postorder.length)
		{
			return null;
		}

		map=new HashMap<>(inorder.length);
		for(int i = 0 ; i < inorder.length ; i++)
		{
			map.put(inorder[i],i);
		}

		postOrderCounter=postorder.length-1;
		this.postorder=postorder;

		TreeNode root = recursiveBuild(0,inorder.length-1);
		return root;

	}


	//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
	//Output: [3,9,20,null,null,15,7]

	//uses inOrder array and postOrder array to build the Binary Tree
	public TreeNode recursiveBuild(int start , int end)
	{       // for both start and end inclusive bounds ,,(but for start inclusive , end exclusive it has to be start>=end
			if(start > end)
			{
				return null;
			}

			int rootVal  = postorder[postOrderCounter--];
			TreeNode root = new TreeNode(rootVal);
			int mid = map.get(rootVal);

			root.right = recursiveBuild(mid+1,end);
			root.left = recursiveBuild(start,mid-1);
			return root;
	}

}
