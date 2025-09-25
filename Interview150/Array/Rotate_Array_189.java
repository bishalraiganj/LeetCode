package Interview150.Array;

import java.util.Arrays;

public class Rotate_Array_189 {


	public static void main(String... args)
	{
		int[] intArr= {1,2,3,4,5,6,7};
		int[] intArr1 = {10,11,12,13,14,15,16};
		int[] intArr2 = {-1,-100,3,99};
		rotate2(intArr,3);
		System.out.println(Arrays.toString(intArr));
	}
	/*

	* Input: nums = [1,2,3,4,5,6,7], k = 3
	  Output: [5,6,7,1,2,3,4]
 */

	//Sequential rotation of each element , in-efficient for large number of elements
	public  static void rotate(int[] nums, int k) {

		//Edge Cases handled
		if(nums.length == 0 || k<=0)
		{
			return;
		}

		k = k % nums.length;
		int len  = nums.length;

		for(int i = 1 ; i <= k ; i++)
		{
			int temp = nums[len - 1];

			int j = len - 2;
			while( j >= 0)
			{
				nums[j + 1] = nums[j];
				j--;
			}

			nums[0] = temp;
		}
	}



	/*

	* Input: nums = [1,2,3,4,5,6,7], k = 3
	  Output: [5,6,7,1,2,3,4]
 */
	//-1, -100 , 3, 99 , k = 2



	// Reversal Algorithm
	public static void rotate2(int[] nums, int k)
	{

//		for(int i = 0 ; i < nums.length / 2 ; i++)
//		{
//			int temp = nums[i];
//			nums[i] = nums[nums.length - 1 - i];
//			nums[nums.length - 1 - i] = temp;
//		}

		//edge cases

		if(nums.length == 0 || k<=0)
		{
			return;
		}

		k = k % nums.length;



		reverseFunct2(nums,0,nums.length);
		reverseFunct2(nums,0,k);
		reverseFunct2(nums,k,nums.length);




	}


	public static void reverseFunct2(int[] nums,int start, int end)
	{

		end=end-1;
		while(start < end)
		{
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}



	}
	public static void reverseFunct(int[] arr, int start, int end)
	{
		int len = end - start;
		for(int i = start ; i <start + ( len / 2 ) ; i++)
		{
			int temp = arr[i];
			arr[i] = arr[end - 1 - (i - start )];
			arr[end - 1 - (i - start)] = temp;
		}
	}

}
