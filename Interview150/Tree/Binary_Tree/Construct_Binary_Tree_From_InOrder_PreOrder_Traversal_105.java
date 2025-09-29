package Interview150.Tree.Binary_Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Construct_Binary_Tree_From_InOrder_PreOrder_Traversal_105 {

	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
			//edge case handling for safety
		if(    preorder==null || inorder==null || inorder.length==0 || preorder.length==0     || preorder.length!=inorder.length )
		{
			return null;
		}
		return constructBinaryTree(preorder,inorder);
	}




	public TreeNode constructBinaryTree(int[] preOrder, int[] inOrder)
	{
		//Base Case / Breaking Condition / edge case handling for safety
 		if(preOrder.length==0 || inOrder.length==0)
		{
			return null;
		}

		 TreeNode root = new TreeNode(preOrder[0]);
		 int[] leftInOrder = new int[0];
		 int[] rightInOrder = new int[0];
		 int[] leftPreOrder = new int[0];
		 int[] rightPreOrder = new int[0];

		 int rootIndex=-1 ;

		 for(int i = 0; i< inOrder.length ; i++)
		 {
			 if(inOrder[i]==root.val)
			 {
				 rootIndex = i;
				 break;
			 }
		 }

		 //we found a valid rootIndex
		 if(rootIndex!=-1 )
		 {
			 Set<Integer> lftSet = new HashSet<>();


			 // There's a valid leftInOrder arr possible
			 if(rootIndex!=0)
			 {


				 int[] lftArr = new int[rootIndex];
				 int[] lftPreOrder = new int[lftArr.length];
				 int[] rgtPreOrder = new int[(inOrder.length-rootIndex) - 1];
				 int lftPreOrderCounter=0;
				 int rgtPreOrderCounter = 0;


				 for(int i = 0; i< rootIndex ; i++)
				 {
					 		int val = inOrder[i];
							 lftArr[i] = val;
							 lftSet.add(val);
				 }
				 leftInOrder = lftArr;


				 for(int i = 1; i<preOrder.length; i++)
				 {
					 if(lftSet.contains(preOrder[i]))
					 {
						 lftPreOrder[lftPreOrderCounter++] = preOrder[i];
					 }
					 else
					 {
						 rgtPreOrder[rgtPreOrderCounter++] = preOrder[i];
					 }
				 }
				 leftPreOrder =lftPreOrder;
				 rightPreOrder = rgtPreOrder;

			 }


			 //There's a valid rootIndex such that there's a valid right inOrderArray possible
			 if(rootIndex < inOrder.length-1)
			 {
				 if(leftPreOrder.length==0)
				 {
					 int[] rgtPreOrder = new int[preOrder.length -1];
					 System.arraycopy(preOrder,1,rgtPreOrder,0,(inOrder.length-rootIndex-1));
					 rightPreOrder = rgtPreOrder;
				 }
				 int[] rgtArr = new int[(inOrder.length-rootIndex) - 1];
				 for(int i = rootIndex+1; i<inOrder.length; i++)
				 {
					 rgtArr[i-(rootIndex+1)] = inOrder[i];
				 }
				 rightInOrder = rgtArr;
			 }


			 if(leftInOrder.length!=0)
			 {
				 root.left = constructBinaryTree(leftPreOrder, leftInOrder);
			 }

			 if(rightInOrder.length!=0)
			 {
				 root.right= constructBinaryTree(rightPreOrder,rightInOrder);
			 }

		 }

		 return root;
	}

}




class Solution {
	private int preIndex = 0; // tracks current index in preorder
	private Map<Integer, Integer> inorderMap; // value -> index

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		return build(preorder, 0, inorder.length - 1);
	}

	private TreeNode build(int[] preorder, int inLeft, int inRight) {
		if (inLeft > inRight) return null; // base case

		// Current root
		int rootVal = preorder[preIndex++];
		TreeNode root = new TreeNode(rootVal);

		// Position of root in inorder
		int mid = inorderMap.get(rootVal);

		// Build left and right subtrees
		root.left = build(preorder, inLeft, mid - 1);
		root.right = build(preorder, mid + 1, inRight);

		return root;
	}
}


class Improved{

	Map<Integer, Integer> inorderMap;
	int preOrderRootCounter=0;

	public TreeNode buildTree(int[] preorder, int[] inorder)
	{

		if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0 || preorder.length!=inorder.length)
		{
			return null;
		}

		inorderMap = new HashMap<>();
		for(int i = 0 ; i < inorder.length ; i++)
		{
			inorderMap.put(inorder[i],i);
		}

		return levelOrder(preorder,0,preorder.length-1);
	}


	public TreeNode levelOrder(int[] preorder, int start, int end)
	{
		if( start > end) return null;

		int rootVal = preorder[preOrderRootCounter];
		int mid = inorderMap.get(preorder[preOrderRootCounter++]);

		TreeNode root = new TreeNode(rootVal);

		root.left = levelOrder(preorder,start,mid-1);
		root.right = levelOrder(preorder,mid+1,end);
		return root;

	}
}