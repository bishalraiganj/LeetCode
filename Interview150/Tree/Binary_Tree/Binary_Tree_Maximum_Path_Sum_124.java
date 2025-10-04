package Interview150.Tree.Binary_Tree;

public class Binary_Tree_Maximum_Path_Sum_124 {

	// Global tracker for the highest path sum found in the tree
	private int globalMax = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		// Run DFS traversal to compute maximum path sum
		dfs(root);
		// After traversal, globalMax holds the final answer
		return globalMax;
	}

	/**
	 * Recursive DFS function:
	 * Returns the maximum path gain that can be extended upward to the parent.
	 * Also updates the global maximum path sum during traversal.
	 */
	private int dfs(TreeNode node) {
		if (node == null) {
			// A null node contributes 0 to any path
			return 0;
		}

		// 1️⃣ Recursively compute the best downward gain from left and right children
		// Ignore any negative contributions using Math.max(0, …)
		int leftGain = Math.max(0, dfs(node.left));
		int rightGain = Math.max(0, dfs(node.right));

		// 2️⃣ Compute the best path sum passing through this node
		// This could include both left and right gains (forming a "V" connection)
		int localPathSum = node.val + leftGain + rightGain;

		// 3️⃣ Update the global maximum if this path is better than any previously found
		globalMax = Math.max(globalMax, localPathSum);

		// 4️⃣ Return to parent the best single-branch path sum that can be extended upward
		// (A parent can only choose one child path)
		return node.val + Math.max(leftGain, rightGain);
	}


}
