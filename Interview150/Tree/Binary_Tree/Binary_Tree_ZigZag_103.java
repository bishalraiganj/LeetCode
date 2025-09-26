package Interview150.Tree.Binary_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Binary_Tree_ZigZag_103 {

	// Queue (double-ended) to support flexible removals
	// - leftToRight traversal uses removeFirst (normal BFS order)
	// - rightToLeft traversal uses removeLast (reverse direction)
	Deque<TreeNode> queue = new ArrayDeque<>();

	// Final result list where each inner list represents one level
	List<List<Integer>> levelsList = new ArrayList<>();
	boolean leftToRightFlag = true;



	/**
	 * Main function to perform ZigZag (spiral) level order traversal
	 *
	 * @param root - root node of the binary tree
	 * @return nested list where each level alternates between left→right and right→left order
	 *
	 * Intuition:
	 * - Start BFS traversal from the root
	 * - First level goes left→right
	 * - Second level goes right→left
	 * - Alternate the traversal direction at each level
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return levelsList; // Edge case: empty tree
		}

		queue.addLast(root); // Add root as the first node in BFS
		leftToRight();       // Start traversal from left→right for level 0
		return levelsList;
	}


	/**
	 * Process the current level in Left-to-Right order
	 * - Remove nodes from the FRONT of the queue (normal BFS)
	 * - Add children left→right into the queue
	 * - Collect current level values and store in result
	 * - When done, delegate to rightToLeft() for next level
	 */
	public void leftToRight() {
		if (!queue.isEmpty()) {
			List<Integer> currLevelList = new ArrayList<>();
			int size = queue.size(); // Process exactly one level

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.removeFirst(); // Standard BFS order
				if (node.left != null) {
					queue.addLast(node.left);
				}
				if (node.right != null) {
					queue.addLast(node.right);
				}
				currLevelList.add(node.val);
			}
			levelsList.add(currLevelList); // Add this level to final result
		}

		// If nodes remain, process the next level in opposite order
		if (!queue.isEmpty()) {
			rightToLeft();
		}
	}


	/**
	 * Process the current level in Right-to-Left order
	 * - Remove nodes from the BACK of the queue
	 * - Add children in reverse order (right first, then left) to preserve zigzag structure
	 * - Collect current level values and store in result
	 * - When done, delegate to leftToRight() for next level
	 */
	public void rightToLeft() {
		if (!queue.isEmpty()) {
			List<Integer> currLevelList = new ArrayList<>();
			int size = queue.size(); // Process exactly one level

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.removeLast(); // Reverse BFS order

				// Add children in reverse order for next level
				if (node.right != null) {
					queue.addFirst(node.right);
				}
				if (node.left != null) {
					queue.addFirst(node.left);
				}
				currLevelList.add(node.val);
			}
			levelsList.add(currLevelList); // Add this level to final result

			// If nodes remain, switch back to leftToRight
			if (!queue.isEmpty()) {
				leftToRight();
			}
		}
	}





	//Simpler , involves traversing twice because of the new ArrayList<>(level) at the end

	public List<List<Integer>> zigzagLevelOrder1(TreeNode root)
	{

		if(root == null)
		{
			return levelsList;
		}

		queue.offer(root);
		levelOrderTraversal();
		return levelsList;

	}

	public void  levelOrderTraversal()
	{
		while(!queue.isEmpty())
		{
			Deque<Integer> levelQueue = new ArrayDeque<>();
			int size = queue.size();
			for(int i = 0 ; i < size ; i++)
			{
				TreeNode node = queue.poll();
				if(leftToRightFlag)
				{
					levelQueue.addLast(node.val);
				}
				else
				{
					levelQueue.addFirst(node.val);
				}

				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null)
				{
					queue.offer(node.right);
				}
			}

			levelsList.add(new ArrayList<>(levelQueue));
			leftToRightFlag = !leftToRightFlag;


		}


	}



}
