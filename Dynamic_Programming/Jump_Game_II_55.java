package Dynamic_Programming;

public class Jump_Game_II_55 {
}



class SolutionBishal22 {
	public int jump(int[] nums) {

		int[] dp = new int[nums.length];

		for(int i = 0 ;  i < nums.length ; i++)
		{
			dp[i] = -1;
		}

		return memoize(nums.length-1,nums.length,dp,nums);

	}


	public int memoize(int pos, int numsLen, int[] dp, int[] nums)
	{
		if(dp[pos] !=-1) return dp[pos];
		if(pos==0)
		{
			dp[0] = 0;
			return 0;
		}


		int smallestJumpSoFar = Integer.MAX_VALUE;
		int smallestPos = -1;

		for(int i = pos-1 ;  i >=0 && i < pos  ; i--)
		{
			if(nums[i] >= pos-i)
			{
				int currJump = dp[i] ==-1 ? memoize(i,numsLen,dp,nums) :dp[i]; //Avoiding unnecessary recursive calls for pre cached results of the sub-problems
				if(currJump < smallestJumpSoFar)
				{
					smallestJumpSoFar = currJump;
					smallestPos = i;

				}
			}

		}



		if(smallestJumpSoFar != Integer.MAX_VALUE )
		{

			if(smallestPos==0 || smallestJumpSoFar != 0)
			{
				int res = ++smallestJumpSoFar;
				dp[pos] = res;
				return res;
			}
		}

		return dp[pos] = 0;

	}
}
