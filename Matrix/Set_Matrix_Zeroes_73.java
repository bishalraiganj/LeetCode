package Matrix;

public class Set_Matrix_Zeroes_73 {


	public void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];

		for(int i = 0; i < m ; i++)
		{
			for(int j = 0; j < n ; j++)
			{
				if(matrix[i][j]==0)
				{
					row[i]=true;
					col[j]=true;
				}
			}
		}

		for(int i = 0 ; i < m ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				if(row[i] || col[j])
				{
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void setZeroes2(int[][] matrix)
	{
		int m = matrix.length, n = matrix[0].length;

		//First Column Zero Check
		boolean firstRow = false;
		boolean firstCol = false;
		for(int j = 0 ; j < n ; j++)
		{
			if(matrix[0][j]==0)
			{
				firstRow = true;
				break;
			}
		}
		for(int i = 0 ; i < m ; i++)
		{
			if(matrix[i][0]==0)
			{
				firstCol = true;
				break;
			}
		}

		//First pass for setting first row and first col
		for(int i = 1 ; i < m ; i++)
		{
			for(int j = 1 ; j < n ; j++)
			{
				if(matrix[i][j]==0)
				{
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}

		for(int i = 1 ; i < m ; i++)
		{
			for(int j = 1 ; j < n ; j++)
			{
				if(matrix[0][j]==0 || matrix[i][0]==0)
				{
					matrix[i][j]=0;
				}
			}
		}

		if(firstRow)
		{
			for(int j = 0 ; j < n ; j++)
			{
				matrix[0][j]=0;
			}
		}
		if(firstCol)
		{
			for(int i = 0 ; i < m ; i++)
			{
				matrix[i][0]=0;
			}
		}

	}


}
