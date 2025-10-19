package Dynamic_Programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Frog_Jump_403 {

	public boolean canCross(int[] stones) {
		Map<Integer,Set<Integer>> dp = new HashMap<>();
		for(int pos : stones)
		{
			dp.put(pos,new HashSet<>());
		}
		dp.get(stones[0]).add(0);
		return tabulation(stones,dp);

	}

	//Tabulation Bottom-up dp , iterative
	public boolean tabulation(int[] stones, Map<Integer, Set<Integer>> dp)
	{
		for(int pos : stones)
		{
			if(!dp.get(pos).isEmpty())
			{
				for(int posVal : dp.get(pos))
				{
					for(int step = posVal -1 ; step <= posVal + 1 ; step++)
					{
						if(step != 0 && dp.containsKey(pos+step))
						{
							dp.get(pos+step).add(step);
						}
					}
				}
			}
		}
		return !dp.get(stones[stones.length-1]).isEmpty();
	}


	//Memoization Top-down Dp , Recursive
//	public boolean memoize();
}
