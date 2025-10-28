package Dynamic_Programming;

public class Jump_Game_55 {
}



class Solution {
	public boolean canJump(int[] nums) {
		Boolean[] dp = new Boolean[nums.length];
		dp[0] = Boolean.valueOf(true);
		return memoize(nums.length-1,dp,nums);
	}


	public boolean memoize(int idx ,Boolean[] dp , int[] nums)
	{
		if(dp[idx]!= null && dp[idx].booleanValue() ) return true;
		if(idx == 0) return true;


		boolean reachableFlag = false;


		for(int  i  = idx-1 ; i >= 0 ; i--)
		{

			if(idx-i <= nums[i] )
			{
				if(dp[i]!= null && dp[i].booleanValue())
				{

					reachableFlag= true;
					break;
				}else if(dp[i] == null)
				{
					reachableFlag = memoize(i,dp,nums);
				}

				if(reachableFlag)
				{
					dp[idx] =Boolean.valueOf(true);
					return true;
				}
			}

		}
		dp[idx] =Boolean.valueOf(reachableFlag);
		return reachableFlag;

	}

}