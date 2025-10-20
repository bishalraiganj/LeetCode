package Graph;

import java.util.*;

public class Redundant_Connection_684 {


	public static void main(String... args)
	{
		int[][] tree = {{1,2},{1,3},{2,3}};
		int[][] tree2 = {{1,2},{2,3},{3,4},{1,4},{1,5}};

		System.out.println(Arrays.toString(findRedundantConnection(tree)));

	}

	static int cycleIdx = 0;
	public static int[] findRedundantConnection(int[][] edges) {


		Map<Integer, List<Integer>> adj = new HashMap<>();


		for(int[] edge : edges)
		{
		adj.compute(edge[0],(k,v)->{
			if(v==null)
			{
				List<Integer> list = new ArrayList<>();
				list.add(edge[1]);
				return list;
			}
			v.add(edge[1]);
			return v;
		});
		adj.compute(edge[1],(k,v)->{
			if(v==null)
			{
				List<Integer> list = new ArrayList<>();
				list.add(edge[0]);
				return list;
			}
			v.add(edge[0]);
			return v;
		});
		}
//		for(int i = 1 ; i <= n ; i++)       adj.put(i,new ArrayList<>());
//		for(int[] edge :edges)
//		{
//			adj.get(edge[0]).add(edge[1]);
//			adj.get(edge[1]).add(edge[0]);
//		}

		int n = adj.size();
		int[] cycleArr = new int[n+1];
		boolean[] visited = new boolean[n+1];

		int cycleNode =  preOrderDFS(1,-1,cycleArr,0,visited,adj);

		System.out.println(Arrays.toString(cycleArr));
		System.out.println(cycleNode);


		HashSet<String> set = new HashSet<>();
		int prev = 0;

		int k = cycleIdx;
		do{
			if(cycleArr[k]!=0 && prev!=0)
			{
				set.add(cycleArr[k]+","+prev);
				set.add(prev+","+cycleArr[k]);
			}
			prev = cycleArr[k];
			k--;
		}
 			while(cycleArr[k]!=cycleNode );


			for(int i = edges.length -1 ; i>=0; i--)
			{
				if(set.contains(edges[i][0]+","+edges[i][1]) || set.contains(edges[i][1]+","+edges[i][0]))
					return edges[i];
			}

		return new int[0];


	}


	public static int preOrderDFS(int idx,int parent, int[] cycleArr,int cycleArrCounter, boolean[] visited,Map<Integer,List<Integer>> adj)
	{
		cycleArr[cycleArrCounter] = idx;
		if(visited[idx]) {
			cycleIdx=cycleArrCounter;
			return idx;
		}
		visited[idx] = true;


		int cycleNode = 0;
		for(int node : adj.get(idx))
		{
			if(node==parent) continue;
			cycleNode = preOrderDFS(node,idx,cycleArr,cycleArrCounter+1,visited,adj);
			if(cycleNode!=0)
			{
				return cycleNode;
			}
		}

		return cycleNode;
	}
}
