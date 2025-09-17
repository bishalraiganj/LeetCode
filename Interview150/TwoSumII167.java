package Interview150;

import java.util.Arrays;

public class TwoSumII167 {


	public static void main(String... args)
	{

		int[] intArr = {-1,2,3,4};
		int[] intArr2 = {-5,-3,-2,0};

		System.out.println(Arrays.toString(twoSum(intArr2,-7)));
	}


	public static int[] twoSum(int[] numbers, int target)
	{
		int index1 = 0; ;
		int index2  = 0;
		if(target >= 0) { // When target is positive then each val in number array will be smaller or equal to target
			for (int i = 0; i < numbers.length; i++) {
				int val = numbers[i];
				if (val <= target && val <= (target - val)) {
					int j = i + 1;
					while (j < numbers.length && numbers[j] <= (target - val)) {
						if (numbers[j] == target - val) {
							return new int[]{i + 1, j + 1};
						}
						j++;
					}
				}

			}
		}
		else
		{
			for (int i = 0; i < numbers.length; i++) {
				int val = numbers[i];
				if ( val <= (target - val)) {
					int j = i + 1;
					while (j < numbers.length && numbers[j] <= (target - val)) {
						if (numbers[j] == target - val) {
							return new int[]{i + 1, j + 1};
						}
						j++;
					}
				}

			}

		}

		return null;

	}



}
