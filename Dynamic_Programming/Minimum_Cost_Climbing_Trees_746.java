package Dynamic_Programming;

public class Minimum_Cost_Climbing_Trees_746 {


		public int minCostClimbingStairs(int[] cost) {
			int[] dp  = new int[cost.length];
			for(int i = 0 ; i < cost.length ; i++)      dp[i]=-1;
			dp[0] = cost[0];
			dp[1] = cost[1];
//			return Math.min(memoize(cost.length-1,dp,cost),memoize(cost.length-2,dp,cost));
//			return tabulation(cost.length-1,dp,cost);
			return spaceOptimized(cost.length-1,cost);
		}


		//Memoization (Top-down DP , Recursive)
		public int memoize(int step ,int[] dp, int[] cost)
		{
			if(step<=1) return cost[step];
			if(dp[step]!=-1) return dp[step];

			int one = memoize(step-1,dp,cost);
			int two = memoize(step-2,dp,cost);
			return dp[step] = Math.min(one,two) + cost[step];

		}

		//Tabulation ( Bottom-up DP , Iterative)
		public int tabulation(int step,int[] dp, int[] cost)
		{
			for(int i = 2 ; i < cost.length ; i++) dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
			return Math.min(dp[step],dp[step-1]);
		}

//		//Space optimized only keeping the last two results required
		public int spaceOptimized(int step,int[] cost)
		{
			int minusOne = cost[1] ,minusTwo=cost[0];
			for(int i = 2; i < cost.length ; i++)
			{
				int curr  = cost[i] + Math.min(minusOne,minusTwo);
				minusTwo = minusOne;
				minusOne = curr;
			}
			return Math.min(minusOne,minusTwo);
		}


}
