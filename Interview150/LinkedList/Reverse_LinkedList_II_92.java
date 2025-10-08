package Interview150.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Reverse_LinkedList_II_92 {

	class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

	//Input: head = [1,2,3,4,5], left = 2, right = 4
	//Output: [1,4,3,2,5]
	public static void main(String... args)
	{
		Reverse_LinkedList_II_92 obj = new Reverse_LinkedList_II_92();

		ListNode head = obj.new ListNode(1);
		ListNode n2 = obj.new ListNode(2);
		ListNode n3 = obj.new ListNode(3);
		ListNode n4 = obj.new ListNode(4);
		ListNode n5 = obj.new ListNode(5);

		head.next = n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;

		ListNode h2 = obj.reverseBetween(head,2,4);
		obj.printList(h2);
	}


	public ListNode reverseBetween(ListNode head, int left, int right) {

		int currPosition =1;
		ListNode currNode = head;
		ListNode next = null; // except first node of the reverse range , it represents current nodes next
		ListNode startNode = null;
		ListNode prevNode = null;
		//Input: head = [1,2,3,4,5], left = 2, right = 4
		//Output: [1,4,3,2,5]
		while( currPosition<right)
		{
			if(currPosition==left)
			{
				startNode= currNode; //will be used to set to the end node;
				next= currNode.next.next;
				currNode.next.next=currNode;

				ListNode currNext =currNode.next;
				currNode.next = null;
				currNode = currNext;
			}
			else if(currPosition>left)
			{
				ListNode currNext = next;
				next=next.next;
				currNext.next=currNode;
				currNode=currNext;
			}
			else
			{
				prevNode = currNode;
				currNode=currNode.next;

			}
			currPosition++;
		}
		if(startNode!=null) {
			startNode.next = next;

		}

		if(prevNode==null)
		{
			return currNode;
		}
		prevNode.next = currNode;
		return head;

	}


	public void printList(ListNode head)
	{
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head=head.next;
		}


	}
}
