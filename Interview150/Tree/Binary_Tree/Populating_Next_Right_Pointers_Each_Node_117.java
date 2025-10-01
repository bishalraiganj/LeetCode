package Interview150.Tree.Binary_Tree;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}


public class Populating_Next_Right_Pointers_Each_Node_117 {




	ArrayDeque<Node> queue = new ArrayDeque<>();
	Node head = null;
	Node tail = null;


	public Node connect(Node root) {

		if(root == null)
		{
			return head;
		}

		queue.add(root);
		levelOrder();
		return root;

	}

	public void levelOrder()
	{
		//Base Case / Breaking Condition
		if(queue.isEmpty())
		{
			return;
		}
		int size = queue.size();
		while(size>0)
		{
			Node node = queue.pollFirst();
			if(head==null)
			{
				head = node;
				tail = node;
				tail.next = null;

			}
			else
			{
				tail.next = node;
				tail = node;
			}

			if(node.left!=null)
			{
				queue.offerLast(node.left);
			}
			if(node.right!=null)
			{
				queue.offerLast(node.right);
			}
			size--;
		}
		head= null;
		tail = null;

		levelOrder();
	}
}
