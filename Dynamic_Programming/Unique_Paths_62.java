package Dynamic_Programming;

public class Unique_Paths_62 {
}


class Solution2 {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		int[][] dirVector = {{1,0},{0,1}};

		for(int r = 0 ; r < m  ; r++)
		{
			for(int c = 0 ; c < n ; c++)
			{
				dp[r][c] = -1;
			}
		}

		dp[m-1][n-1] = 1;
		return memoize(0,0,m,n,dirVector,dp);

	}


	//Memoization Top-down DP (recursive)
	//Transition Rule (Recurrence): sum of the ways the neighbors/childs can reach
	public int memoize(int r,int c,int m ,int n,int[][] dirVector,int[][] dp)
	{
		if(r <0 || r >=  m || c < 0 || c>= n) return 0;
		if(dp[r][c]>=0) return dp[r][c];
		if(r==m-1 && c == n-1) return 1;

		int netWays  = 0;
		for(int[] nei : dirVector)
		{
			if( r >= 0 && r < m && c >=0 && c < n)
			{
				netWays+=memoize(r+nei[0],c+nei[1],m,n,dirVector,dp);
			}
		}
		dp[r][c] = netWays;
		return netWays;

	}
}

