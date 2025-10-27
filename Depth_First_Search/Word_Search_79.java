package Depth_First_Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word_Search_79 {
}







class Solution {
	String str = "";
	int rowLen = 0, colLen = 0;
	public boolean exist(char[][] board, String word) {
		str = word;
		rowLen = board.length;
		colLen = board[0].length;
		int[][] dirVector = {{1,0},{-1,0},{0,1},{0,-1}};
		Map<String, List<int[]>> adj = new HashMap<>();
		// for(int  i = 0 ; i < board.length ; i++)
		// {
		//     adj.put(i,new ArrayList<>());
		// }
		int r = board.length, c = board[0].length;
		for(int i = 0 ; i < r ; i++)
		{
			for(int j = 0 ;j < c ; j++)
			{
				for(int[] dir : dirVector)
				{
					int row = i+dir[0] , col = j + dir[1];
					if(row>=0&& row < r  && col >=0 && col < c)
					{
						adj.compute(i+","+j,(k,v)->{
							if(v==null)
							{
								v = new ArrayList<>();
								v.add(new int[] {row,col} );
								return v;
							}
							v.add(new int[]{row,col});
							return v;
						});
					}
				}
			}
		}

		boolean flag = false;
		boolean[] visited = new boolean[board.length * board[0].length];
		for(int i = 0 ; i < r  ; i++)
		{
			for(int j = 0 ; j < c ; j++)
			{
				flag= preOrderDFS(i+","+j,0,board,visited,adj);
				if(flag) return true;
			}
		}

		return flag;
	}


	public boolean preOrderDFS(String coor , int idx, char[][] grid, boolean[] visited, Map<String,List<int[]>> adj)
	{
		if(visited[Integer.parseInt(coor.charAt(0))  * colLen + Integer.parseInt(coor.charAt(1))])  return false;
		visited[Integer.parseInt(coor.charAt(0)) * colLen + Integer.parseInt(coor.charAt(1))] = true;
		boolean flag = false;

		if(str.charAt(idx)==grid[Integer.parseInt(coor.charAt(0))][Integer.parseInt(coor.charAt(1))])  // base case ( only continue dfs traverse if charAt idx matches)
		{
			if(idx==str.length()-1) return true;
			for(int[] neighbor : adj.get(new int[]{Integer.parseInt(coor.charAt(0)),Integer.parseInt(coor.charAt(1))}))
			{
				flag = preOrderDFS(neighbor,idx+1,grid,adj);
				if(flag) return true;
			}
		}
		return flag;
	}

}