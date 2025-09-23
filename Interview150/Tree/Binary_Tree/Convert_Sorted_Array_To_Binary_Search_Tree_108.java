package Interview150.Tree.Binary_Tree;

public class Convert_Sorted_Array_To_Binary_Search_Tree_108 {



	public TreeNode sortedArrayToBST(int[] nums) {

		return balanceTree(nums, 0, nums.length );
	}



	//[-10,-3,0,5,9]
	public static TreeNode balanceTree(int[] nums, int start, int end)
	{
		// means, left only one element the start index
		if(end - start == 1)
		{
			return new TreeNode(nums[start]);
		}
		// menas, no elements left
		else if( start >= end)
		{
			return null;
		}

		// when left with more than one element's
		//mid is set to root , and it's left is set to the returned value of the recursive call of it's left partition
		// and mid's right is set to the returned value/node of the recursive call of it's right partition
		// these recursive call's keep further balancing the partition's accordingly and each call return's the root
		//cause , root is set as left or right by it's previous call in the stack frame
		int mid = start + ( end - start) / 2;

		TreeNode root = new TreeNode(nums[mid]);

		TreeNode leftSubtree = balanceTree(nums, start, mid);
		TreeNode rightSubtree = balanceTree(nums, mid + 1 ,end);


		root.left = leftSubtree;
		root.right = rightSubtree;

		return root;


	}


}
