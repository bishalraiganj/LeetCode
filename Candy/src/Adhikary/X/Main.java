package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{




	}

	//  Example ratingsArr - [8,6,3,1,7,4,2,9,3] candy vals - [2,3,4,1,3,2,1,2,1]
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
