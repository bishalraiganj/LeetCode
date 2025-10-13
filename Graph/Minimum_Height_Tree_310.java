package Graph;


import java.util.*;


public class Minimum_Height_Tree_310 {
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

			int currHeight = postOrderDFS(-1,i,0,adj);

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
					childGreatest = Math.max(childGreatest,postOrderDFS(node,i,currHeight+1,adj));
				}
			}
			if(childGreatest!=0)
			{
				currHeight=childGreatest;
			}
		}
		return currHeight;
	}





	// Most Optimized : Topological Leaf Trimming
	public List<Integer> findMinimumHeightTrees(int n, int[][] edges)
	{
		Map<Integer,List<Integer>> adj = new HashMap<>();
		int[] degree = new int[n];

		for(int i = 0; i < n ; i++)
		{
			adj.put(i, new ArrayList<>());
		}

		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
			degree[edge[0]]++;
			degree[edge[1]]++;
		}


		Queue<Integer> queue = new ArrayDeque<>();

		for(int i = 0 ; i < n ; i++)
		{
			if(degree[i] == 1)
			{
				queue.offer(i);
			}
		}

		List<Integer> lastLayer = new ArrayList<>();
		while(!queue.isEmpty())
		{
			int size = queue.size();

			lastLayer = new ArrayList<>();
			for(int i = 0 ; i < size ; i++)
			{
				int leaf = queue.poll();

				lastLayer.add(leaf);


				for(int j : adj.get(leaf))
				{
					degree[j]--;
					if(degree[j]==1)
					{
						queue.offer(j);
					}
				}
			}
		}
		return lastLayer;
	}
}






