package Graph;

import java.util.*;

public class Network_Delay_Time_743 {



	public static void main(String... args)
	{
		int[][] input = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
		Network_Delay_Time_743 graph = new Network_Delay_Time_743();
		System.out.println(graph.dijkstra(input,4,2));

	}
	int nodeCount = 0;

	public int networkDelayTime(int[][] times, int n, int k) {

		Map<Integer, List<int[]>>  adj = new HashMap<>();
		for(int i = 1 ; i <= n ;i++) adj.put(i,new ArrayList<>());
		for(int[] edge : times) adj.get(edge[0]).add(new int[]{edge[1],edge[2]});

		boolean[] visited = new boolean[n+1];
		int[] minimums   = new int[n+1];
		for(int i = 1 ; i < n+1 ; i++)
		{
			minimums[i] = Integer.MAX_VALUE;
		}
		preOrderDFS(new int[]{k,0},0,visited,minimums,adj);

		if(nodeCount!=n) return  -1 ;

		int maxTimeForShortestPaths = Integer.MIN_VALUE;
		for(int i = 1 ; i <= n ; i++)
		{
			if(minimums[i]!=Integer.MAX_VALUE) {
				maxTimeForShortestPaths = Math.max(maxTimeForShortestPaths, minimums[i]);
			}
		}

		System.out.println(Arrays.toString(minimums));
		return maxTimeForShortestPaths;

	}


	public void preOrderDFS(int[] node,int prevTime,boolean[] visited,int[] minimums,Map<Integer, List<int[]>> adj)
	{
		if(!visited[node[0]]) nodeCount++;
		visited[node[0]] = true;

		int currTime = prevTime +  node[1];
		if(minimums[node[0]] <= currTime) return;
		minimums[node[0]] = currTime;
		// if currMinimum less than minimums[node]
		if(!adj.get(node[0]).isEmpty())
		{
			for(int[] edge : adj.get(node[0]))
			{
				preOrderDFS(edge,currTime,visited,minimums,adj);
			}
		}
	}


	//Dijkstra's Optimized
	public int dijkstra(int[][] times,int n,int k)
	{
		Map<Integer, List<int[]>> adj = new HashMap<>();
		boolean[] visited  = new boolean[n+1];
		int nodeCount = 0;
		for(int i = 1 ; i  <= n ; i++)
		{
			adj.put(i,new ArrayList<>());
		}
		for(int[] edge : times) adj.get(edge[0]).add(new int[]{edge[1],edge[2]});

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
		int[] minimums = new int[n+1];
		for(int i  = 1 ; i <= n ; i++)
		{
			minimums[i] =Integer.MAX_VALUE;
		}
		minimums[k] =0;

		minHeap.offer(new int[]{k,0});

		while(!minHeap.isEmpty())
		{
			int[] polledNode = minHeap.poll();

			if(visited[polledNode[0]]) continue;
			visited[polledNode[0]] = true;
			nodeCount++;

			for(int[] edge : adj.get(polledNode[0]))
			{
				if(!visited[edge[0]]) {
					int newTime = polledNode[1] + edge[1];
					if (minimums[edge[0]] > newTime) {
						minimums[edge[0]] = newTime;
						minHeap.offer(new int[]{edge[0], newTime});
					}
				}
			}
		}

		if(nodeCount!=n) return -1;
		int longestOfTheShortestTimes = 0;
		for(int i = 1 ; i <= n ; i++)
		{
			if(minimums[i]!=Integer.MAX_VALUE) {
				longestOfTheShortestTimes = Math.max(minimums[i], longestOfTheShortestTimes);
			}
		}
		return longestOfTheShortestTimes;
	}
}









//class Solution {
//      int nodeCounter = 0 ;
//      int minimumTime  = 0;
//    public int networkDelayTime(int[][] times, int n, int k) {
//        Map<Integer,List<int[]>> adj = new HashMap<>();
//        for(int i = 1 ; i  <= n ; i++)
//        {
//            adj.put(i,new ArrayList<>());
//        }
//        for(int[] edge : times)
//        {
//            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
//        }
//
//
//        boolean[] visited = new boolean[n];
//
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{k,0});
//
//        bfs(queue,visited,adj);
//        if(nodeCounter == n) return minimumTime;
//        return -1;
//    }
//
//        public void bfs(Queue<int[]> queue, boolean[] visited,Map<Integer,List<int[]>> adj)
//        {
//
//            int maxTime = 0;
//            int size =  queue.size();
//
//            while(size-- > 0)
//            {
//
//               int[] currNode =  queue.poll();
//            if(visited[currNode[0]-1]) continue;
//            visited[currNode[0]-1] = true;
//            maxTime= Math.max(maxTime,currNode[1]);
//            nodeCounter++;
//
//            if(!adj.get(currNode[0]).isEmpty())
//            {
//                for(int[] valArr : adj.get(currNode[0]))
//                {
//                    queue.offer(valArr);
//                }
//            }
//
//            }
//            minimumTime +=maxTime;
//        }
//
//
//
//}