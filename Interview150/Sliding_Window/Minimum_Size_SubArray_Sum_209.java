package Interview150.Sliding_Window;

import java.util.HashSet;

public class Minimum_Size_SubArray_Sum_209 {


	public static void main(String... args)
	{

		int[] intArr = {2,3,1,2,4,3};
		int[] intArr2 = {1,4,4};
		int[] intArr3 = {1,1,1,1,1,1,1,1};
		int[] intArr4 = {2,2,3,4,1,2,2,2,6,1,7};
		int[] intArr5 = {2,16,14,15};
		System.out.println(minSubArrayLen(11,intArr3));


	}



	public static int minSubArrayLen(int target, int[] nums)
	{
		if(nums.length == 0)
		{
			return 0;
		}

		int arrLen = nums.length;
		int minWinSize = Integer.MAX_VALUE;
		int currSum = 0;
		int left = 0;
		int right = 0;

		while(right < arrLen)
		{
			if(nums[right] >= target)
			{
				return 1;
			}
			currSum += nums[right];
			right++;

			while(currSum >= target)
			{
				minWinSize = Math.min(minWinSize,right - left);
				currSum -= nums[left++];
			}
		}
		return minWinSize == Integer.MAX_VALUE ? 0 : minWinSize;
	}



	public static int minSubArrayLenBruteForce(int target, int[] nums)
	{
		if(nums.length == 0)
		{
			return 0;
		}

		int sum = 0;
		int currLength = 0;
		int minLength = Integer.MAX_VALUE;

		for(int i = 0 ; i < nums.length; i++)
		{
			if(nums[i] >= target)
			{
				return 1;
			}
			else if(nums[i] < target)
			{
				int j = i;

				while(j < nums.length && nums[j] + sum < target)
				{
					sum += nums[j];
					currLength++;
					j++;
				}

				/*
				* When control comes here
				* 1. j is over nums index
				* 2.nums[j] + sum >= target
				* 3.nums.length == 1
				* */

				if( j < nums.length &&  nums[j] + sum >= target)
				{
					currLength++;
					minLength = Math.min(minLength, currLength);
				}
			}
			sum = 0;
			currLength = 0;
		}

		if(minLength == Integer.MAX_VALUE)
		{
			return 0;
		}
		return minLength;
	}




}
