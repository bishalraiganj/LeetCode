package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number_Of_Connected_Components_323 {

	public int findComponents(int n , int[][] edges)
	{
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for(int i = 0 ; i < n ; i++) adj.put(i, new ArrayList<>());

		//adjacency list using map + list
		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}


		boolean[] visited = new boolean[n];
		int componentCounter = 0 ;
		for(int i = 0 ; i < n ; i++)
		{
			if(!visited[i])
			{
				componentCounter++;
				preOrderDFS(i,visited,adj);
			}
		}
		return componentCounter;
	}

	public void preOrderDFS(int i ,boolean[] visited, Map<Integer, List<Integer>> adj)
	{
		visited[i] = true;
		for(int val : adj.get(i))
		{
			if(!visited[val]) //In case there are cycles, this condition helps from infinite recursion
			{
				preOrderDFS(val, visited, adj);
			}
		}

	}

}
