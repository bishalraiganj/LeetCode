package Graph;

import java.util.*;

public class Redundant_Connection_Two_685 {
}




class Solution {
	public int[] findRedundantDirectedConnection(int[][] edges)
	{
		int[] parent = new int[edges.length+1];
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for(int i = 1; i <= edges.length ; i++)
		{
			adj.put(i,new ArrayList<>());
		}

		int[] edge1 = new int[2] ;
		int[] edge2 = new int[2];
		boolean doubleEdge = false;
		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(edge[1]);

			if(parent[edge[1]] != 0 )
			{
				doubleEdge = true;
				edge1[0] = parent[edge[1]];
				edge1[1]  = edge[1];
				edge2[0] = edge[0];
				edge2[1] = edge[1];
			} else
			{
				parent[edge[1]] = edge[0];
			}
		}


		LinkedHashSet<Integer> recursionStack  = new LinkedHashSet<>() ;
		boolean[] visited = new boolean[edges.length+1];


		boolean detectCycleFlag = false;
		int cyclePoint = 0;
		for(int  i = 1 ; i <= edges.length ; i++)
		{

			if(!visited[i]){
				cyclePoint = preOrderDFS(i,visited,recursionStack,adj);
				if(cyclePoint!=0)
				{
					detectCycleFlag  = true;
					break;
				}
			}
		}


		if(!detectCycleFlag )
		{
			for(int i = edges.length-1 ; i >= 0 ; i--)
			{
				if(edges[i][0] == edge1[0] && edges[i][1] == edge1[1] ) return edge1;
				if(edges[i][0] == edge2[0] && edges[i][1] == edge2[1]) return edge2;
			}
		}
		else if(detectCycleFlag && doubleEdge)
		{

			HashSet<String> cycleEdgesSet = new HashSet<>();
			int prev = 0 ;
			boolean startFlag =false;
			for(int node : recursionStack)
			{
				if(cyclePoint == node) startFlag =true;
				if(startFlag)
				{
					if(prev!=0)
						cycleEdgesSet.add(prev+","+node);
					prev = node;

				}
			}
			cycleEdgesSet.add(prev+","+cyclePoint);

			if(cycleEdgesSet.contains(edge1[0]+","+edge1[1])) return edge1;
			return edge2;

		}

		else
		{
			HashSet<String> cycleEdgesSet = new HashSet<>();
			int prev = 0 ;
			boolean startFlag =false;
			for(int node : recursionStack)
			{
				if(cyclePoint == node) startFlag =true;
				if(startFlag)
				{
					if(prev!=0)
						cycleEdgesSet.add(prev+","+node);
					prev = node;

				}
			}
			cycleEdgesSet.add(prev+","+cyclePoint);


			for(int i = edges.length -1 ; i >= 0 ; i--)
			{
				int par = edges[i][0];
				int nei = edges[i][1];
				if(cycleEdgesSet.contains(par+","+nei)) return edges[i];
			}
		}
		return new int[0];

	}



	public int preOrderDFS(int node , boolean[] visited, LinkedHashSet<Integer> recursionStack, Map<Integer,List<Integer>> adj)
	{
		if(recursionStack.contains(node)) return node;
		if(visited[node]) return 0;

		recursionStack.add(node);
		visited[node] = true;

		int cyclePoint = 0;
		for(int neighborNode : adj.get(node))
		{
			cyclePoint = preOrderDFS(neighborNode,visited,recursionStack,adj);
			if(cyclePoint!= 0)
			{
				return cyclePoint;
			}
		}

		if(cyclePoint==0)
		{
			recursionStack.remove(node);
		}
		return cyclePoint;

	}
}
