package Interview150.Tree.Binary_Tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class Lowest_Common_Ancestor_Of_Binary_Tree_236 {


	//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
	//Output: 3
	//Explanation: The LCA of nodes 5 and 1 is 3.
	public static void main(String... args)
	{
		TreeNode n3 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);
		TreeNode n6 = new TreeNode(6);
		TreeNode n2 = new TreeNode(2);
		TreeNode n0 = new TreeNode(0);
		TreeNode n8 = new TreeNode(8);
		TreeNode n7 = new TreeNode(7);
		TreeNode n4 = new TreeNode(4);

		n3.left= n5;
		n3.right=n1;
		n5.left=n6;
		n5.right=n2;
		n1.left= n0;
		n1.right=n8;
		n2.left=n7;
		n2.right=n4;

		System.out.println(lowestCommonAncestor(n3,n5,n1).val);




	}

	static ArrayDeque<Integer> stackA = new ArrayDeque<>();
	 static HashSet<Integer> setB = new HashSet<>();
	  static int a, b;
	  static boolean c,d;
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		a=p.val;
		b=q.val;
		preOrderDFS(root,new ArrayDeque<>());
		return new TreeNode(findCommonAncestor(stackA,setB));
	}


	public static void preOrderDFS(TreeNode root, ArrayDeque<Integer> currStack) {

		if(root==null)
		{
			return;
		}

		currStack.addLast(root.val);
		if (root.val == a) {
			c=true;
			stackA.addAll(currStack);
			if(d==true)
			{
				return;
			}
		}
		if (root.val == b) {
			d=true;
			setB.addAll(currStack);
			if(c==true)
			{
				return;
			}
		}


		if (root.left == null && root.right == null) {
			return;
		}

		if (root.left != null) {
			preOrderDFS(root.left, currStack);
			currStack.removeLast();
		}

		if (root.right != null) {
			preOrderDFS(root.right, currStack);
			currStack.removeLast();
		}

	}

	public static int findCommonAncestor(ArrayDeque<Integer> stackA,HashSet<Integer> setB)
	{
		int res;
		stackA.stream().forEach((e)->System.out.print(e+" "));
		System.out.println(" ");
		setB.stream().forEach((e)->System.out.print(e+" "));
		while(!stackA.isEmpty())
		{
			int popVal = stackA.removeLast();
			if(setB.contains(popVal))
			{
				return popVal;
			}
		}
		return -999999;
	}

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
	{
		if(root== null || root==p || root==q) return root;
		TreeNode left = lowestCommonAncestor1(root.left,p,q);
		TreeNode right = lowestCommonAncestor1(root.right,p,q);
		if(left!=null && right!=null) return root;
		return left!=null?left:right;
	}
}
