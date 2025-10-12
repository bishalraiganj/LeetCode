package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course_Schedule_207 {


	public boolean canFinish(int numCourses, int[][] prerequisites) {

		boolean[] recursionStack = new boolean[numCourses];
		boolean[] visited = new boolean[numCourses];

		Map<Integer, List<Integer>> adj = new HashMap<>();
		for(int i = 0 ; i < numCourses ; i++)
		{
			adj.put(i,new ArrayList<>());
		}
		for(int[] i : prerequisites)
		{
			adj.get(i[1]).add(i[0]);
		}


		boolean cycleFound = false;
		for(int i = 0 ; i < numCourses ; i++) // Outer loop for doing DFS/tracking connected components on every node
			// ,so no connected  component or disconnected graphs are missed
		{

			if(!visited[i])
			{
				cycleFound = preOrderDFS(i,recursionStack,visited,adj);
			}

			if(cycleFound)
			{
				return false; // Because, We found cycle in any of the connected components so we cant finish
			}
		}

		return !cycleFound ? true : false;
	}



	public boolean preOrderDFS(int val, boolean[] recursionStack, boolean[] visited , Map<Integer, List<Integer>> adj)
	{
		if(recursionStack[val]) return true;
		if(visited[val]) return false;

		visited[val] = true;
		recursionStack[val] = true;

		boolean cycleFound = false;

		if(!adj.get(val).isEmpty())
		{
			for(int i : adj.get(val))
			{
				if(!cycleFound) {
					cycleFound = preOrderDFS(i, recursionStack, visited, adj);
				}else
				{
					break;
				}
			}
		}

		recursionStack[val] = false; // Similar to popping in order to maintain for current path during backtracking
		return cycleFound;
	}
}


