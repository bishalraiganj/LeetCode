package Dynamic_Programming;

public class Minimum_Cost_Climbing_Trees_746 {


		public int minCostClimbingStairs(int[] cost) {
			int[] dp  = new int[cost.length];
			for(int i = 0 ; i < cost.length ; i++)      dp[i]=-1;
			dp[0] = cost[0];
			dp[1] = cost[1];
			return Math.min(memoize(cost.length-1,dp,cost),memoize(cost.length-2,dp,cost));
		}

		public int memoize(int step ,int[] dp, int[] cost)
		{
			if(step<=1) return cost[step];
			if(dp[step]!=-1) return dp[step];

			int one = memoize(step-1,dp,cost);
			int two = memoize(step-2,dp,cost);
			return dp[step] = Math.min(one,two) + cost[step];
		}


}
