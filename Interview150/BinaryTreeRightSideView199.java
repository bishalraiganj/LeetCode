package Interview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView199 {

	public static void  main(String... args)
	{
		TreeNode root = new TreeNode(1);
		TreeNode l1v0 = new TreeNode(0);
		TreeNode l1v48 = new TreeNode(48);
		TreeNode l2v12 = new TreeNode(12);
		TreeNode l2v49 = new TreeNode(49);


		root.left = l1v0;
		root.right = l1v48;
		l1v48.left = l2v12;
		l1v48.right= l2v49;

		System.out.println(rightSideView(root).toString());



	}


	public static List<Integer> rightSideView(TreeNode root) {

		Map<Integer,TreeNode> map = new HashMap<>();

		inOrderTraversal(root,1,map);

		List<Integer> list = new ArrayList<>();

		map.values().stream().forEach((node)->{
			list.add(node.val);
		});

		return list;

	}

	public static void inOrderTraversal(TreeNode root, int level, Map<Integer,TreeNode> map)
	{
		map.put(level,root);

		if(root.left != null)
		{
			inOrderTraversal(root.left,level+1,map);
		}

		if(root.right != null)
		{
			inOrderTraversal(root.right,level+1,map);
		}
	}

}
