package Matrix;

public class Number_Of_Islands_200 {

	int[][] directionVector = {{1,0},{-1,0},{0,1},{0,-1}};
	int m=0,n=0;

	public int numIslands(char[][] grid) {

		int m = grid.length, n  = grid[0].length;
		this.m = m; this.n = n;

		int islandCount = 0;

		for(int i = 0 ; i < m ; i++)
		{
			for(int j = 0 ; j < n ; j++ )
			{
				if(grid[i][j]=='1')
				{
					preOrderDFS(grid,i,j);
					islandCount++;
				}
			}
		}
		return islandCount;
	}


	public void preOrderDFS(char[][] grid, int i, int j)
	{
		//marking visited
		grid[i][j]='0';


		//direction vector used here
		// , to visit every child and call recursive funct on them
		for(int[] direction : directionVector)
		{
			if(0<=i+direction[0] && i+direction[0] < m &&  0<= j+direction[1] && j +direction[1]<n  )
			{
				if (grid[i + direction[0]][j + direction[1]] == '1') {
					preOrderDFS(grid, i + direction[0], j + direction[1]);
				}
			}
		}

	}


}
