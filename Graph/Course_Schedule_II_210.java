package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course_Schedule_II_210 {

	int counter=0;
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> adj = new HashMap<>();
		boolean[] recursionStack = new boolean[numCourses];
		boolean[] visited = new boolean[numCourses];
		counter=numCourses-1;

		for(int i = 0 ; i < numCourses ; i++)
		{
			adj.put(i,new ArrayList<>());
		}
		for(int[] edge : prerequisites)
		{
			adj.get(edge[1]).add(edge[0]);
		}

		boolean  cycleFound = false;
		int[] res = new int[numCourses];

		for(int i = 0 ; i < numCourses ; i++)
		{
			if(!visited[i])
			{
				cycleFound = postOrderDFS(i,res,recursionStack,visited,adj);
			}
			if(cycleFound) break;
		}

		return !cycleFound ? res : new int[0];
	}

	//Since , it's a directed graph it is necessary to check whether a re visited node is on the recursion stack ,if so it is a cycle
	public boolean postOrderDFS(int i ,int[] res, boolean[] recursionStack, boolean[] visited, Map<Integer,List<Integer>> adj)
	{
		if(recursionStack[i]) return true;
		if(visited[i]) return false;

		visited[i]=true;
		recursionStack[i]=true;


		boolean cycleFound = false;
		if(!adj.get(i).isEmpty())
		{

			for(int val : adj.get(i))
			{
				cycleFound = postOrderDFS(val,res, recursionStack, visited, adj);
				if(cycleFound) break;
			}
		}

		res[this.counter--]=i;
		recursionStack[i]=false;
		return cycleFound;
	}
}
