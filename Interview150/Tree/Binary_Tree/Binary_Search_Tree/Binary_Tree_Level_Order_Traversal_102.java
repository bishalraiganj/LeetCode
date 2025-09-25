package Interview150.Tree.Binary_Tree.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_102 {


	public static void main(String... args)

	{

		TreeNode n1 = new TreeNode(-8);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(-8);
		TreeNode n5 = new TreeNode(-1);
		TreeNode n6 = new TreeNode(8);

		n1.right = n2;
		n1.left = n3;
		n2.right = n4;
		n4.left = n5;
		n5.left = n6;


		System.out.println(levelOrder(n1));

		map.forEach((key,value)->{
			System.out.println( "Level: " + key + " value: " + value);
		});


		System.out.println("-".repeat(50));

		System.out.println(levelList);




	}



	static List<List<Integer>> levelList = new ArrayList<>();
	static HashMap<Integer,List<Integer>> map = new HashMap<>();

	public static List<List<Integer>> levelOrder(TreeNode root) {


		if (root == null)
		{
			return levelList;
		}
		levelOrderTraversal(root,0);
		return levelList;

	}


	// We visit every node in left-parent-righ fashion recursively as we have called on the same recursive method
	// on the leftchild first so left most child is visited first, but we process the node we are in  as we process it before the recursive calls
	// as we are propagating the level down the call stack by passing to every recursive call
	//it's level , we are able to track every node's level
	//and then we put a list represeting that level to the map created earlier and
	//nodes values are added to their corresponding lists in the hashmap , and on the first node of every level visited, we
	//immediately create the list and put it in the map and use it to add values for all recursive call's with the help of the
	// hashmap
	//at the end we return the final list of list's
	public static void levelOrderTraversal(TreeNode root,int level)
	{

		if(!map.containsKey(level))
		{
			List<Integer> currLevelList = new ArrayList<>();
			levelList.add(currLevelList);
			currLevelList.add(root.val);
			map.put(level, currLevelList);
		}
		else if(map.containsKey(level))
		{
			map.get(level).add(root.val);
		}

//		if(!levelList.contains(map.get(level)))
//		{
//			levelList.add(map.get(level));
//		}


		if(level==2)
		{
			System.out.println(levelList.contains(map.get(level)));
		}


		if(root.left!=null)
		{
			levelOrderTraversal(root.left,level+1);
		}

		if(root.right!=null)
		{
			levelOrderTraversal(root.right,level+1);
		}
	}



}
