package Interview150;

import java.util.Arrays;

public class RemoveDuplicateII80 {


	public static void main(String... args)
	{


		int[] intArr = {0,0,0,1,1,1,1,2,3,3,3,1,2,2,3,1,1,1};

		System.out.println(removeDuplicates(intArr));
		System.out.println(Arrays.toString(intArr));


	}


	public static int removeDuplicates(int[] nums) {

		int prev = nums[0];
		int prevFreq = 1;
		int counter = 1;

		for(int i = 1 ; i < nums.length; i++)
		{
			while( i < nums.length && nums[i] == prev && prevFreq > 2)
			{
				i++;
//				prevFreq++;
			}

			if( i < nums.length && nums[i] != prev  )
			{
				prev=nums[i];
				prevFreq = 1;
				nums[counter++] = nums[i];
			}
			else if(i < nums.length && prevFreq < 2)
			{
				prevFreq++;
				prev = nums[i];
				nums[counter++] = nums[i];
			}
		}

		return counter;

	}


}
