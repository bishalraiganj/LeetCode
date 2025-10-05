package Interview150.Tree.Binary_Tree.Binary_Search_Tree;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Binary_Search_Tree_Iterator_173 {


	public static void main(String... args)
	{
		TreeNode n7 = new TreeNode(7);
		TreeNode n3 = new TreeNode(3);
		TreeNode n15 = new TreeNode(15);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);

		n7.right = n15;
		n7.left = n3;
		n15.right = n20;
		n15.left = n9;

		BSTIterator iterator = new BSTIterator(n7);

		while(iterator.hasNext())
		{
//			System.out.println(iterator.counter + " " + iterator.pointerIndex);
			System.out.println(iterator.next());
		}

	}

}


//Input
//["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
//[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
//Output
//[null, 3, 7, true, 9, true, 15, true, 20, false]

class BSTIterator {

	TreeNode pointer = new TreeNode(Integer.MIN_VALUE);
	int[] inOrderArr =  new int[300];
	int counter = 0;
	int pointerIndex=0;

	public BSTIterator(TreeNode root) {

		if(root!=null)
		{
			inOrder(root);
		}
	}

	public int next() {
			if(pointerIndex < counter)
			{
				return inOrderArr[pointerIndex++];
			}
			return -1;
	}

	public boolean hasNext() {
		return pointerIndex<counter;
	}

	public void inOrder(TreeNode root)
	{
		if(root==null)
		{
			return;
		}

		//Base Case( when leaf node reached)
		if(root.left== null && root.right==null)
		{
			inOrderArr[counter++] = root.val;
			return;
		}

		if(root.left!=null)
		{
			inOrder(root.left);
		}

		inOrderArr[counter++] = root.val;

		if(root.right!=null)
		{
			inOrder(root.right);
		}
	}
}



class BSTIterator2{

	ArrayDeque<TreeNode> stack = new ArrayDeque<>();
	public BSTIterator2(TreeNode root)
	{
		if(root==null)
		{
			return;
		}
		pushLeft(root);
	}

	public int next()
	{
		TreeNode node =  stack.pop();
		pushLeft(node.right);
		return node.val;
	}

	public boolean hasNext()
	{
		return !stack.isEmpty();
	}

	public void pushLeft(TreeNode root)
	{
		if(root!=null)
		{
			stack.push(root);
			while(root.left!=null)
			{
				stack.push(root.left);
				root = root.left;
			}
		}

	}
}