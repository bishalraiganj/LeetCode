package Adhikary.X;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {

	public static void main(String... args)
	{

		int[] candyArr = {8,6,3,1,7,4,2,9,3};

		System.out.println(candy(candyArr));

		System.out.println("-".repeat(50));

		int[] arr2 = {0,1,2,5,3,2,7};
		System.out.println(candy(arr2));



	}

	//  Example ratingsArr - [8,6,3,1,7,4,2,9,3] candy vals - [4,3,2,1,3,2,1,2,1]
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

		int sum = Arrays.stream(compute(ratings))
				.reduce(0, (a,b) -> a + b);
		return sum;
	}





	public static int[] compute(int[] ratings)
	{
		int iterationCounter = 1;

		int[] copy = new int[ratings.length];
		int[] sorted = Arrays.copyOf(ratings, ratings.length);
		Arrays.sort(sorted);

		Map<Integer, Integer> map = new TreeMap<>();

		Map<Integer, Integer> sortedMap = new TreeMap<>(new Comparator<Integer> () {

			@Override
			public int compare(Integer o1 ,Integer o2)
			{
				if(map.get(o1) > map.get(o2))
				{
					return 1;
				}
				if(map.get(o1) == map.get(o2))
				{
					return 1;
				}

				return -1;
			}
		});


		for(int i = 0; i < ratings.length ; i++)
		{
			map.put(i,ratings[i]);
		}
		for(Map.Entry<Integer,Integer> e : map.entrySet())
		{
			sortedMap.put(e.getKey(),e.getValue());
		}

		sortedMap.forEach((k,v)-> System.out.println("index: " + k + " rating: " + v + " | " ));
		for(Map.Entry<Integer,Integer> e : sortedMap.entrySet())
		{
			if(iterationCounter == 1)
			{
				copy[e.getKey()]=1;
				iterationCounter++;
			}
			else
			{
				if(e.getKey() == 0 ) {
					if (e.getValue() > ratings[1]) {
						copy[0] = copy[1] + 1;
						iterationCounter++;
					} else if(e.getValue() <= ratings[1])
					{
						copy[0] = 1;
						iterationCounter++;
					}
				}
				else if(e.getKey() == ratings.length - 1)
				{
					if(e.getValue() > ratings[e.getKey() - 1]) {
						copy[e.getKey()] = copy[e.getKey() - 1] + 1;
						iterationCounter++;
					}
					else
					{
						copy[e.getKey()] = 1 ;
						iterationCounter++;
					}

				}
				else {
					if (e.getValue() <= ratings[e.getKey() - 1] && e.getValue() <= ratings[e.getKey() + 1])
					{
						copy[e.getKey()] = 1;
					}

					else if(e.getValue() > ratings[e.getKey() - 1 ] && e.getValue() >ratings[e.getKey() + 1 ] )
					{
						if(copy[e.getKey() + 1 ] > copy[e.getKey() -1])
						{
							copy[e.getKey()] = copy[e.getKey() + 1] + 1;
						}
						else
						{
							copy[e.getKey()] = copy[e.getKey() - 1] + 1;
						}
					}
					else
					{
						if(ratings[e.getKey() - 1] > ratings[e.getKey() + 1])
						{
							copy[e.getKey()] = copy[e.getKey() + 1 ] + 1;
						}
						else
						{
							copy[e.getKey() ]  = copy[e.getKey() - 1] + 1;
						}
					}





				}


			}

		}

		System.out.println(Arrays.toString(copy));

		return copy;




	}

}
