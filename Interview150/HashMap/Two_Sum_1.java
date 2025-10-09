package Interview150.HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum_1 {


	public static void main(String... args)
	{

		int[] intArr  = {2,7,11,15};
		int[] intArr2 = {3,2,4};
		System.out.println(Arrays.toString(twoSum2(intArr2,6)));

	}

	public static int[] twoSum(int[] nums, int target) {

		int len = nums.length;
//		int[] preffixArr = new int[len];
//		preffixArr[0] = nums[0];
//
//		//Pre-processing
//		for (int i = 1; i < len; i++)
//		{
//			preffixArr[i] = preffixArr[i-1] + nums[i];
//		}
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0 ; i < len ; i++)
		{
			map.putIfAbsent(nums[i],i);
		}

		map.forEach((k,v)->System.out.println(k + " " + v));

		for(int i = 0 ; i < len ; i++)
		{
			if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i)
			{

				return new int[]{i,map.get(target-nums[i])};
			}
		}
		return new int[0];
	}


	//Better optimized version because , it does the look up in the same pass as populating the map , because
	//Invariant (the value we are looking for must be found before the current, before reaching the end of traversal )
	//otherwise there exists no pairs that sum up to target
	//This is because, by the time we reach the end of traversal(first pass) we will have the pair in the map populated
	//say target 6 , [1,2,3,4] by the time we reach 2 , 4 does not exist but when we reach 4 , 2 does exist
	//this optimization helps because if we already have got the other value of the currents pair , we stop the pass immediately
	//and no need of the second pass
	public static int[] twoSum2(int[] nums, int target)
	{

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i < nums.length ; i++)
		{
			if(map.containsKey(target-nums[i]))
			{
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
		}

		return new int[0];
	}

}
