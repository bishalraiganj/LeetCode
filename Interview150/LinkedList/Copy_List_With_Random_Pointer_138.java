package Interview150.LinkedList;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}




public class Copy_List_With_Random_Pointer_138 {



	//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
	//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
	public Node copyRandomList(Node head) {

		if(head==null)
		{
			return null;
		}

		Map<Node,Node> map = new HashMap<>();

		Node temp = head;
		int counter=0;
		while(temp!=null)
		{
			Node newNode = new Node(temp.val);
			map.put(temp,newNode);
			temp = temp.next;
		}

		Node copyHead  = null;
		while(head!=null)
		{
			if(copyHead==null)
			{
				copyHead=map.get(head);
			}
			map.get(head).random=map.get(head.random==null?null:head.random);
			map.get(head).next=map.get(head.next==null?null:head.next);
			head=head.next;
		}
		return copyHead;
	}

}
