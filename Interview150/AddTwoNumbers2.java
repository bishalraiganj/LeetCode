package Interview150;

import java.util.List;

class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val)
	  { this.val = val; }
      ListNode(int val, ListNode next)
	  { this.val = val; this.next = next; }
  }


public class AddTwoNumbers2 {


	 ListNode firstNode = new ListNode(0);
	 ListNode  previousNode = firstNode;
	 int carry = 0;


	public static void main(String... args)
	{

		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(9);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(6);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(2);
		ListNode l8 = new ListNode(5);
		ListNode l9 = new ListNode(3);
		ListNode l10 = new ListNode(5);
		ListNode l11 = new ListNode(3);
		ListNode l12 = new ListNode(1);

		l1.next= l2;
		l2.next = l3;

//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//
//		l7.next = l8;
//		l8.next = l9;
//		l9.next = l10;
//		l10.next = l11;
//		l11.next = l12;


		//9,9,1
		//1
		// = 0,0,2
//		System.out.println(addTwoNumbers(l1,l4).val);

		System.out.println("-".repeat(50));

		print(new AddTwoNumbers2().addTwoNumbers(l1,l12));








	}


	public static void print(ListNode head)
	{
		while(head!=null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}

	public  ListNode  addTwoNumbers(ListNode l1, ListNode l2)
	{


		recursiveSum(l1,l2);
//    	while(firstNode.next != null)
//		{
//			System.out.println(firstNode.next.val);
//			firstNode = firstNode.next;
//		}

		return firstNode.next;

	}



	public    void recursiveSum(ListNode l1,  ListNode l2)
	{

		if(l1!=null || l2!=null)
		{
			if(l1==null )
			{
				int val = carry==0?l2.val:l2.val + 1;
				carry = 0;
				if(val>=10)
				{
					val = val%10;
					carry = 1;
				}
				ListNode n  = new ListNode(val);
				previousNode.next = n;
				previousNode = n;
				l2 = l2.next;
				while(l2 !=null)
				{
					int val1= carry == 0 ? l2.val : l2.val +1;
					carry = 0;
					if(val1>=10)
					{
						val1 = val1%10;
						carry= 1;
					}
					l2 = l2.next;
					ListNode n1 = new ListNode(val1);
					previousNode.next= n1;
					previousNode = n1;
				}
				if(carry==1)
				{
					previousNode.next = new ListNode(1);
				}

			}
			else if(l2==null)
			{
				int val = carry==0?l1.val:l1.val + 1;
				carry=0;
				if(val>=10)
				{
					val = val%10;
					carry = 1;
				}
				ListNode n  = new ListNode(val);
				previousNode.next = n;
				previousNode =n ;
				l1 = l1.next;
				while(l1 != null)
				{
					int val1= carry == 0 ? l1.val : l1.val +1;
					carry=0;
					if(val1>=10)
					{
						val1 = val1%10;
						carry= 1;
					}
					l1 = l1.next;
					ListNode n1 = new ListNode(val1);
					previousNode.next = n1;
					previousNode = n1;
				}
				if(carry==1)
				{
					previousNode.next = new ListNode(1);
				}

			}
			else
			{
				int r = carry==0? l1.val + l2.val:l1.val + l2.val +1;
				carry=0;
				if (r >= 10)
				{
					r = r % 10;
					carry = 1;
				}
				ListNode n = new ListNode( r );
				previousNode.next = n;
				previousNode = n;
				recursiveSum(l1.next,l2.next);
			}
		}
		else
		{
			if(carry==1)
			{
				previousNode.next = new ListNode(1);
			}
		}


	}


}
