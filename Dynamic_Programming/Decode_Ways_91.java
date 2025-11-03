package Dynamic_Programming;

public class Decode_Ways_91 {
}



class Solution34 {
	public int numDecodings(String s) {

		int len = s.length();
		int[] dp = new int[len];
		for(int i = 0  ;  i < len ; i++)
		{
			dp[i] = -1;
		}


		return memoize(s.length()-1,s,dp);
	}




	//Memoization(Recursive Top-Down DP)
	public int memoize(int idx,String s, int[] dp)
	{
		if(idx >=0 &&  dp[idx]!=-1 ) return dp[idx];
		if(idx<0) return 1;
		if(s.charAt(0) == '0') return 0;
		if(idx == 0  )
		{
			int num = s.charAt(0) - '0';
			if(num >= 1 && num <= 9) {
				dp[0] = 1;
				return 1;
			}
		}


		int netWays = 0;
		int curr = s.charAt(idx)-'0';

		if(curr >=1 && curr<= 9)
		{
			if(idx-1>=0)
				netWays+= memoize(idx-1 ,s,dp);
		}



		if(idx-1 >=0 && s.charAt(idx-1) != '0')
		{
			int appendedPrev = ((s.charAt(idx-1)-'0') * 10) +  (s.charAt(idx)-'0');
			if(appendedPrev >= 10 && appendedPrev <=26)
			{
				netWays+= memoize(idx-2,s,dp);
			}
		}


		dp[idx] = netWays;
		return netWays;
	}




}