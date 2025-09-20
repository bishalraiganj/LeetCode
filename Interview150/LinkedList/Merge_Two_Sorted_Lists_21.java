package Interview150.LinkedList;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



public class Merge_Two_Sorted_Lists_21 {


	public static void main(String... args)
	{

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		LinkedList<ListNode> list1 = new LinkedList<>();
		LinkedList<ListNode> list2 = new LinkedList<>();


	}


	public static  ListNode mergeTwoLists(ListNode list1, ListNode list2)
	{
		if(list1 == null && list2 == null)
		{
			return null;
		}

		ListNode prevNode = null;

		ListNode  head = null ;

		//1,2,4    | 1,3,4
		while(list1 != null && list2 != null)
		{
			ListNode smallest = list1.val <= list2.val ? list1 : list2;
			if(prevNode == null)
			{
				prevNode=smallest;
				head = smallest;
			}
			else
			{
				prevNode.next=smallest;
				prevNode = smallest;
			}
			if(smallest == list1)
			{
				list1 = list1.next;
			}
			else
			{
				list2 = list2.next;
			}

		}

		if(list1 != null)
		{
			while(list1 != null)
			{
				if(prevNode == null) {
					prevNode = list1;
					head = list1;
					list1 = list1.next;
				}

				else
				{
					prevNode.next = list1;
					prevNode = list1;
					list1 = list1.next;
				}
			}
		}
		else if(list2 != null)
		{
			while(list2 != null)
			{
				if(prevNode == null)
				{
					prevNode = list2;
					head =list2;
					list2= list2.next;
				}
				else
				{
					prevNode.next = list2;
					prevNode = list2;
					list2 = list2.next;
				}
			}
		}
		return head;

	}


}
