package Interview150;

import java.util.Arrays;

public class RemoveDuplicatesSorted26 {

	public static void main(String... args)
	{

//		int[] intArr = {0,0,1,1,1,2,2,3,3,4};
//		int[] intArr = {1,1};
//		int[] intArr = {1,2,3};
		int[] intArr = {0,0,0,1,1,2,3,4,4};

		System.out.println(removeDuplicates(intArr));
		System.out.println(Arrays.toString(intArr));




	}




		//0,0,0,1,1,2,3,4,4
		public static int removeDuplicates(int[] nums) {

			int prev = nums[0];
			int counter = 1;

				for (int i = 1; i < nums.length ; i++)
				{
					while( i < nums.length && nums[i] == prev)
					{
						i++;
					}

					if(i < nums.length && nums[i] != prev)
					{
						prev = nums[i];
						nums[counter++] = nums[i];
					}

				}

			return counter;
		}

}
