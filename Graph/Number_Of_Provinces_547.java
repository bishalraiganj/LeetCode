package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number_Of_Provinces_547 {


	public int findCircleNum(int[][] isConnected) {

		Map<Integer, List<Integer>> adj = new HashMap<>();
		for(int i = 0 ; i < isConnected.length ; i++)
		{
			adj.put(i,new ArrayList<>());
		}
		for(int i = 0; i<isConnected.length ; i++)
		{
			for(int j = 0 ; j < isConnected.length ; j++)
			{
				if (isConnected[i][j] == 1) adj.get(i).add(j);
			}
		}



		boolean[] visited = new boolean[isConnected.length];

		int provinces = 0;
		for(int i = 0 ; i < isConnected.length;  i++)
		{
			if(!visited[i])
			{
				provinces++;
				preOrderDFS(-1,i,visited,adj);
			}
		}
		return  provinces;

	}

	public void preOrderDFS(int parent,int idx, boolean[] visited,Map<Integer,List<Integer>> adj)
	{
		if(visited[idx]) return;
		visited[idx] = true;

		if(!adj.get(idx).isEmpty())
		{
			for(int val : adj.get(idx))
			{
				preOrderDFS(idx,val,visited,adj);
			}
		}


	}
}
