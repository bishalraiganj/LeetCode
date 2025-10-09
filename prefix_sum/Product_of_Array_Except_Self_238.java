package prefix_sum;

import java.util.Arrays;

public class Product_of_Array_Except_Self_238 {


	public static void main(String... args)
	{
		int[] intArr = {1,2,3,4};

		System.out.println(Arrays.toString(productExceptSelf(intArr)));

	}

	public static  int[] productExceptSelf(int[] nums)
	{
		//Example 1:
		//
		//Input: nums = [1,2,3,4]
		//Output: [24,12,8,6]

		int[] outputProducts = new int[nums.length];
		outputProducts[0] = 1;
		for(int i = 1 ; i < nums.length ; i++)
		{
			outputProducts[i] = nums[i-1] * outputProducts[i-1];
		}
		int suffix = 1;
		for(int i = nums.length - 1 ; i >= 0 ; i--)
		{
			outputProducts[i] = suffix;
			suffix *= nums[i];
		}
		return outputProducts;
	}


}
