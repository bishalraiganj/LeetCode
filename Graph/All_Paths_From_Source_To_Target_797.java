package Graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class All_Paths_From_Source_To_Target_797 {
}


class Solution34d {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		LinkedHashSet<Integer> recursionStack = new LinkedHashSet<>();
		List<List<Integer>> paths = new ArrayList<>();


		int maxSoFar = Integer.MIN_VALUE;

		for(int i = 0 ; i < graph.length ; i++)
		{
			maxSoFar = Math.max(maxSoFar,i);
			for(int j = 0 ; j < graph[i].length ; j++)
			{
				maxSoFar = Math.max(maxSoFar,graph[i][j]);

			}
		}

		preOrderDFS(0,maxSoFar,paths,recursionStack,graph);
		return paths;


	}


	public void preOrderDFS(int node,int n,List<List<Integer>> paths,LinkedHashSet<Integer> recursionStack, int[][] graph)
	{
		recursionStack.add(node);


		if(node == n) {
			List<Integer> path = new ArrayList<>();
			for(int nei : recursionStack)
			{

				path.add(nei);
			}
			paths.add(path);
		}

		for(int nei : graph[node] )
		{

			preOrderDFS(nei,n,paths,recursionStack,graph);
		}

		//Back-Tracking in order to maintain current active path
		recursionStack.remove(node);
	}
}