package Graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class Find_Eventual_Safe_States_802 {
}



class SolutionB12 {
	public List<Integer> eventualSafeNodes(int[][] graph) {


		int numOfNodes = graph.length;

		TreeSet<Integer> resSet = new TreeSet<>(Integer::compare);
		LinkedHashSet<Integer> recursionStack = new LinkedHashSet<>();
		int[] safeState = new int[numOfNodes];
		for(int i = 0 ; i < numOfNodes ; i++)
		{
			safeState[i] = -1;
		}


		for(int i = 0 ; i < numOfNodes; i++)
		{
			if(safeState[i]==-1)
			{
				postOrderDFS(i,resSet,recursionStack,safeState,graph);
			}
		}

		return new ArrayList<>(resSet);


	}


	public boolean postOrderDFS(int node,TreeSet<Integer> resSet,LinkedHashSet<Integer> recursionStack,int[] safeState, int[][] graph)
	{



		//Memoizing using cached values for sub-problems
		if(safeState[node]!=-1 )
		{
			if(safeState[node]==0)
			{
				return false;
			}
			return true;
		}


		if(recursionStack.contains(node))
		{
			safeState[node] = 0;
			return false;
		}



		recursionStack.add(node);

		//Returning true , if it is a terminal node to signal it's parent for checking safe node .
		if(graph[node].length == 0)
		{
			safeState[node] = 1;
			recursionStack.remove(node);
			resSet.add(node);
			return true;
		}

		boolean safeNodeFlag = true;

		for(int nei : graph[node])
		{
			boolean resNei = postOrderDFS(nei,resSet,recursionStack,safeState,graph);
			if(safeNodeFlag && resNei) safeNodeFlag = true;
			else safeNodeFlag = false;
		}



		safeState[node] = safeNodeFlag == true ? 1 : 0;
		recursionStack.remove(node);
		if(safeNodeFlag)
		{
			resSet.add(node);
			return true;
		}

		return false;

	}

}