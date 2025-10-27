package Graph;//package Graph;
//
//import java.util.*;
//
//public class Redundant_Connection_II_685 {
//
//
//	public static void main(String... args)
//	{
//		int[][] graph1 = {{1,2},{1,3},{2,3}};
//		int[][] graph2 = {{1,2},{2,3},{3,4},{4,1},{1,5}};
//		findRedundantDirectedConnection(graph2);
//
//	}
//	static int  n,counter=0;
//	static int[] cycleArr = new int[n];
//	static boolean backtrackFlag = true;
//	public static int[] findRedundantDirectedConnection(int[][] edges) {
//
//		n =edges.length+1+1;
//		Map<Integer, List<Integer>> adj = new HashMap<>();
//		boolean[] children  = new boolean[edges.length+1+1];
//
//		for(int i = 0 ; i<=edges.length+1 ; i++)
//		{
//			adj.put(i+1,new ArrayList<>());
//		}
//		for(int[] edge : edges)
//		{
//			adj.get(edge[0]).add(edge[1]);
//			children[edge[1]] = true;
//		}
//
//
//		int rootNode=0 ;
//
//		for(int i = 1 ; i <= edges.length+1 ; i++)
//		{
//			if(!children[i]) {
//				rootNode = i;
//				break;
//			}
//		}
//		int[] recursionStack  = new int[edges.length+1+1]; //Current active path (Managed by Backtracking)
//
//		boolean[] visited = new boolean[edges.length+1+1];
//
////		adj.forEach((k,v)->System.out.println(k+":"+v));
////		System.out.println(rootNode);
//		int cycleNode = preOrderDFS(1,recursionStack,visited,adj);
//
//
//		System.out.println(Arrays.toString(recursionStack));
//		System.out.println(cycleNode);
//		return new int[0];
//	}
//
//
//	public static  int preOrderDFS(int node, int[] recursionStack,boolean[] visited,Map<Integer,List<Integer>> adj)
//	{
//		// If cycle detected (even though not necessary here , juz visited is enough)
//
//		if(recursionStack[node]!=0)
//		{
//			recursionStack[node] = node;
//			backtrackFlag = false;
//
////			for(int i = 1 ; i<recursionStack.length;i++)
////			{
////				if(recursionStack[i]!=0) cycleArr[counter++ ] = i;
////			}
//			return node;
//		}
//		recursionStack[node] =node;
//		if(visited[node]) return node;
//		visited[node] = true;
//
//		int val = -2;
//		for(int child : adj.get(node))
//		{
//			val = preOrderDFS(child,recursionStack,visited,adj);
//			if(val!=-2) break;
//		}
//		if(backtrackFlag) {
//			recursionStack[node] = 0; //Backtracking
//		}
//		return Math.max(-2,val);
//
//	}
//
//}



public class Redundant_Connection_II_685 {



}