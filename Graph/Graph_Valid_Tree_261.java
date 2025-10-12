package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_Valid_Tree_261 {

	public boolean validTree(int n , int[][] edges)
	{
		if(edges.length!=n-1)
		{
			return false;
		}


		boolean[] visited = new boolean[n];
		int components = 0;
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for(int i = 0 ; i < n ; i++)
		{
			adj.put(i, new ArrayList<>());
		}

		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]); //Both , because undirected Graph
		}

		boolean cycleFound = false;
		for(int i : adj.keySet())
		{
			if(!visited[i] && components<1)
			{
				components++;
				cycleFound = preOrderDFS(-1,i,visited,adj);
			}
			if(components>1)
			{
				return false;
			}
		}
		return components==1 && !cycleFound;
	}

	public boolean preOrderDFS(int parent , int val, boolean[] visited, Map<Integer, List<Integer>> adj)
	{
		visited[val] = true;
		boolean cycleFound = false;
		if(!adj.get(val).isEmpty())
		{
			for(int i : adj.get(val))
			{
				if(i==parent) continue;
				else if(visited[i]) return true;
				else cycleFound = preOrderDFS(val,i,visited,adj);
			}
		}
		return cycleFound;
	}
}
