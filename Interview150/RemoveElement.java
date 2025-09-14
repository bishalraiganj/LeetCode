package Interview150;

import java.util.Arrays;

public class RemoveElement {


	public static void main(String... args)
	{

		int[] intArr = {2,3,5,3,2,5,3,2,0};

		System.out.println(removeElement(intArr,2) + " "+ Arrays.toString(intArr));



	}



	// 2 ,3,5,3,2,5,3,2,0,
		public static int removeElement(int[] nums, int val)
		{

			int counter = 0;
			for (int i = 0; i < nums.length; i++)
			{

				if(nums[i]!=val)
				{
					nums[counter++]=nums[i];
				}
			}
			return counter;
		}




}
