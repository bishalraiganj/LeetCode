package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class Find_The_Town_Judge_997 {



}



class SolutionBishal{
	public int findJudge(int n, int[][] trust) {



		boolean[] hasNei = new boolean[n+1];
		HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
		for(int i = 1 ; i <= n ; i++)
		{
			adj.put(i,new HashSet<>());
		}

		for(int[] edge : trust)
		{
			adj.get(edge[1]).add(edge[0]);
			hasNei[edge[0]] =true;
		}


		for(int i = 1 ; i<= n ; i++)
		{


			if(checkAllNodesConnect(i,n,adj) && !hasNei[i]) return i;

		}

		return -1;
	}


	public boolean checkAllNodesConnect(int node ,int n, HashMap<Integer,HashSet<Integer>> adj)
	{
		boolean flag  = true;

		for(int i = 1 ; i <= n ; i++)
		{
			if(i==node) continue;
			if(!adj.get(node).contains(i))
			{
				flag = false;
				break;
			}
		}

		if(flag) return true;

		return false;

	}
}