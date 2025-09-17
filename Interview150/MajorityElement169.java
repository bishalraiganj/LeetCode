package Interview150;

import java.util.Arrays;
import java.util.Collections;

public class MajorityElement169 {

	public static void main(String... args)
	{

		int[] intArr = {2,2,3,3,3,3,3,2,5,6,3};

		System.out.println(majorityElement(intArr));

	}


	public static int majorityElement(int[] nums)
	{

		Arrays.sort(nums);

		int lastGreatest = nums[0];
		int lastGreatestCount = 1;
		int prev = nums[0];
		int count = 1;
		for(int i = 1 ; i < nums.length ; i++)
		{
			if(prev == nums[i])
			{
				count++;
				if(count > lastGreatestCount)
				{
					lastGreatest = nums[i];
					lastGreatestCount =count;
				}
				if(count > nums.length/2)
				{
					return prev;
				}
			}
			else
			{
				prev = nums[i];
				count = 1;
			}

		}
		return lastGreatest;
	}




}
