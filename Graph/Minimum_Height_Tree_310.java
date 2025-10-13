package Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class Minimum_Height_Tree_310 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		Map<Integer,List<Integer>> adj = new HashMap<>();

		for(int i = 0 ; i < n ; i++)
		{
			adj.put(i,new ArrayList<>());
		}

		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}


		int smallestHeight = Integer.MAX_VALUE;
		Map<Integer,List<Integer>> heightMap = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		for(int i = 0 ; i < n ; i++)
		{
			int l = i;

			int currHeight = preOrderDFS(-1,i,0,adj);

			heightMap.compute(currHeight,(k,v)->{
				if(v==null)
				{
					List<Integer> lst = new ArrayList<>();
					lst.add(l);
					return lst;
				}
				v.add(l);
				return  v;
			});
			if(currHeight <= smallestHeight)
			{
				smallestHeight = currHeight;
			}
		}
		return heightMap.get(smallestHeight);


	}



	public int postOrderDFS(int parent,int node,int currHeight , Map<Integer,List<Integer>> adj)
	{



		if(!adj.get(node).isEmpty())
		{
			int childGreatest=0;

			for(int i : adj.get(node))
			{

				if(i != parent)
				{
					childGreatest = Math.max(childGreatest,preOrderDFS(node,i,currHeight+1,adj));
				}
			}
			if(childGreatest!=0)
			{
				currHeight=childGreatest;
			}
		}
		return currHeight;
	}
}


