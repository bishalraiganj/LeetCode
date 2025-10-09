package prefix_sum;

import java.util.Arrays;
import java.util.HashMap;

public class SubArray_Sum_Equals_K_560 {

	public static void main(String... args)
	{
		int[] intArr = {1,2,3};
		int[] intArr2 = {1,1,1};
		int[] intArr3 = {1,2,3,5};
		System.out.println(subarraySum(intArr3,0));


	}

	//nums = [1, 2, 3], k = 3
	// i num sum map (sum→count) count
	// 0 1 1 {0:1, 1:1} 0
	// 1 2 3 {0:1, 1:1, 3:1} 1 (sum-k=0)
	// 2 3 6 {0:1,1:1,3:1,6:1} 2 (sum-k=3)
	public static int subarraySum(int[] nums, int k)
	{
		int count = 0;
		int sum = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0,1); // Must put this , in case the current prefixSum is equal to target k
		//when target k == current prefix sum, the (0,1) mapping accounts for the current prefix sum
		//otherwise , the current prefix sum is ignored because it is put later
		for(int i = 0 ; i < nums.length ; i++)
		{
			sum+=nums[i];
			count+=map.getOrDefault(sum-k,0);
			map.put(sum,map.getOrDefault(sum,0)+1);
		}
		return count;
	}

}
