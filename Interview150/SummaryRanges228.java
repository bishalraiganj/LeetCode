package Interview150;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {

 		public static void main(String... args)
		{
			System.out.println(summaryRanges( new int[]{-2,0,1,2,4,5,7}));


		}
   //[0,1,2,4,5,7]
	public  static List<String> summaryRanges(int[] nums)
	{

		List<String> list = new ArrayList<>();
		int startVal = nums[0];
		int endVal=startVal;
		int midVals;

		int prev=startVal;

     for(int i = 1 ; i < nums.length ; i++)
	 {
		 if(nums[i]-prev == 1)
		 {
			 endVal = nums[i];
			 prev = nums[i];
			 if(i == nums.length - 1)
			 {
				 list.add(startVal+"->"+endVal);
			 }
		 }
		 else
		 {

			 if(startVal == endVal)
			 {
				list.add(startVal+"");
			 }
			 else
			 {
				 list.add(startVal+"->"+endVal);
			 }

			 startVal = nums[i];
			 endVal = nums[i];
			 if(i == nums.length - 1)
			 {
					 list.add(startVal+"");
			 }
			 prev = nums[i];
		 }
	 }
		return list;

	}

}
