package Interview150.Tree.Binary_Tree;

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Sort_List_148 {

	public ListNode sortList(ListNode head)
	{

		return mergeSort(head);

	}


	public static ListNode mergeSort(ListNode node)
	{


		if( node == null  || node.next == null)
		{
			return node;
		}

		ListNode head1 = node;
		ListNode slow = head1;
		ListNode fast = head1.next;


		// 1 , 2 , 5 ,  6 , 7
		while( fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}


		ListNode head2 = slow.next;
		slow.next = null;

		ListNode leftSubList = mergeSort(head1);
		ListNode rightSubList = mergeSort(head2);

		return merge(leftSubList,rightSubList);
	}




	public static ListNode merge(ListNode head1 , ListNode head2)
	{
		ListNode dummyHead = new ListNode(0);
		ListNode currNode = dummyHead;

		while( head1 != null && head2 != null)
		{
				if( head1.val <= head2.val)
				{
					currNode.next = head1;
					currNode = head1;
					head1 = head1.next;
				}
				else
				{
					currNode.next = head2;
					currNode = head2;
					head2 = head2.next;
				}
		}


		currNode.next = head1 != null ? head1 : head2;
//
//		if(head1 != null)
//		{
//			while(head1 != null) {
//				currNode.next = head1;
//				currNode = head1;
//				head1 = head1.next;
//			}
//		}
//		else if( head2 != null)
//		{
//			while(head2 != null)
//			{
//				currNode.next = head2;
//				currNode = head2;
//				head2 = head2.next;
//			}
//		}

		return dummyHead.next;


	}


}
