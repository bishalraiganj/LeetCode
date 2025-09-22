package Interview150.Tree.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Average_Of_Levels_In_A_Binary_Tree_637 {

	double[] sum  = new double[100000];
	double[] frequency = new double[100000];
	List<Double> avgList  = new ArrayList<>();
	int prevLevel = -1;

	public List<Double> averageOfLevels(TreeNode root) {

	 int maxDepth = 	maxDepthTraversal(root, 0);


		int i = 0;
		if(maxDepth != -1) {
			while (i <= maxDepth) {
				avgList.add(sum[i] / frequency[i]);
				i++;
			}

		}
		return avgList;

	}

	public  int maxDepthTraversal(TreeNode root, int level)
	{
		if(root != null)
		{
			sum[level]+= root.val;
			frequency[level]++;

			if(root.left != null && root.right != null)
			{
				return Math.max(maxDepthTraversal(root.left, level + 1) , maxDepthTraversal(root.right, level + 1));
			}
			else if(root.left != null)
			{
				return maxDepthTraversal(root.left, level + 1);
			}
			else if(root.right != null)
			{
				return maxDepthTraversal(root.right,level + 1);
			}
			else
			{
				// when root is a leaf with no childs, then it must update its average
				return level;
			}
		}


		return -1;
	}

}
