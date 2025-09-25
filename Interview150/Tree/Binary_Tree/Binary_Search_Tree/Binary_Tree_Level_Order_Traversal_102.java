package Interview150.Tree.Binary_Tree.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_102 {


	public static void main(String... args)
	{



	}



	static List<List<Integer>> levelList = new ArrayList<>();

	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<Integer> rootList = new ArrayList<>();
		if (root == null)
		{
			return levelList;
		}
		levelOrderTraversal(root,rootList);
		return levelList;

	}

	public static void levelOrderTraversal(TreeNode root,List<Integer> list)
	{
		if(!levelList.contains(list)) {
			levelList.add(list);
		}
		list.add(root.val);
		List<Integer> childLevelList = new ArrayList<>();

		if(root.left!=null)
		{
			levelOrderTraversal(root.left,childLevelList);
		}

		if(root.right!=null)
		{
			levelOrderTraversal(root.right,childLevelList);
		}
	}
}
