package Interview150.Array;

public class Maximum_SubArray_53 {


	public int maxSubArray(int[] nums) {

		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for(int i = 0 ; i < nums.length ; i++)
		{
			currSum +=nums[i]; //Current Maximum sub-array
			maxSum = Math.max(currSum, maxSum); //Overall maximum sub-array
			if(currSum<0)
			{
				// if currentSub (after adding curr) array contributes negative we cannot consider this for
				//expanding to the right, so we reset from here and also ignore the current value
				//because that previous subarr sum is greater , and since this just makes the up until here
				// subarr sum smaller
				//we can safely say it is smaller so just ignore it right away
				currSum = 0;
			}
		}
		return maxSum;
	}
}
