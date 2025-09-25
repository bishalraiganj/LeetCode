package Interview150.LinkedList;




public class LinkedList_Cycle_141 {


	public static void main(String... args)
	{
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);

		head.next = n1;

		System.out.println(hasCycle(head));

	}

	//Floyd's Cycle detection algorithm (Tortoise and Hare)

	public static boolean hasCycle(ListNode head) {
		if (head == null)
		{
			return false;
		}
		else if(head.next == null)
		{
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;


		//2,3,4,->repeat->2
		//1,2->null (no cycle)
		while(fast!= null && fast.next != null && fast!=slow)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		if(slow == fast)
		{
			return true;
		}
		return false;

	}
}
