package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{




	}


	public static int candy(int[] ratings)
	{
		if(ratings.length > 2 * (Math.pow(10,4)) )
		{
			return -1;
		}

		for(int i : ratings)
		{
			if(i <= -1 || i >= 2 * Math.pow(10,4))
			{
				return -1;
			}
		}






	}

}
