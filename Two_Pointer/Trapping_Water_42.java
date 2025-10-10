package Two_Pointer;

public class Trapping_Water_42 {

	public int trap(int[] height) {

		int len = height.length;
		int total = 0;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];


		leftMax[0] = height[0];
		for(int i = 1 ; i < len ; i++)
		{
			leftMax[i] = Math.max(leftMax[i-1], height[i]);
		}
		rightMax[len - 1 ] = height[len - 1];
		for(int i = len - 2 ; i >= 0 ; i--)
		{
			rightMax[i] = Math.max(rightMax[i+1],height[i]);
		}

		for(int i = 0 ; i < len ; i++)
		{
			total += Math.min(leftMax[i],rightMax[i]) - height[i];
		}

		return total;
	}



	public int trap2(int[] height) {
		//Edge case
		if (height == null || height.length == 0)
		{
			return 0;
		}
		int len = height.length;
		int left =0;
		int right  = len-1;
		int leftMax = 0;
		int rightMax =0;
		int total = 0;

		while(left < right)
		{
			if(height[left] < height[right])
			{
				if(height[left]>=leftMax)
				{
					leftMax= height[left];
				}else
				{
					total+= leftMax-height[left];
				}
				left++;
			}
			else
			{
				if(height[right]>=rightMax)
				{
					rightMax = height[right];
				}
				else
				{
					total+= rightMax - height[right];
				}
				right--;
			}
		}
		return total;
	}
}
