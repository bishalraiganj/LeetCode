package Adhikary.X;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

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

	public static int compute(int[] ratings)
	{
		int iterationCounter = 1;

		int[] copy = new int[ratings.length];

		Map<Integer, Integer> map = new TreeMap<>();
		for(int i : ratings)
		{
			map.put(ratings[i],i);
		}

		for(Map.Entry<Integer,Integer> e : map.entrySet())
		{
			if(iterationCounter == 1)
			{
				copy[e.getValue()]=1;
			}
			else
			{
				if(e.getValue() == 0 ) {
					if (e.getKey() > ratings[1]) {
						copy[0] = ratings[1] + 1;
						iterationCounter++;
					} else if(e.getKey() <= ratings[1])
					{
						copy[0] = 1;
					}
				}
				else if(e.getValue() == ratings.length - 1)
				{
					if(e.getKey() > ratings[e.getValue() - 1]) {
						copy[e.getValue()] = ratings[e.getValue() - 1] + 1;
					}
					else
					{
						copy[e.getValue()] = 1 ;
					}

				}
				else
				{




				}


			}

		}






	}

}
