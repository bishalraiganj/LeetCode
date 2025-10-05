package Interview150.Binary_Search;

public class Search_Insert_Position_35 {


	public static void main(String... args)
	{
		int[] intArr = {1,3,5,6};
		int target = 5;
		Search_Insert_Position_35 bs = new Search_Insert_Position_35();
		System.out.println(intArr.length);
		System.out.println(bs.searchInsert(intArr,target));

	}

	public int searchInsert(int[] nums, int target) {
		if(nums==null || nums.length==0 ) return 0;
		return recursiveBinarySearch(nums,0,nums.length,target);
	}

	public int recursiveBinarySearch(int[] nums,int start , int end,int target)
	{
		if( start >= end) return start;
		int mid = start + (end - start)/2;
		if(nums[mid]==target) return mid;
		return nums[mid]>target?recursiveBinarySearch(nums,start,mid,target):recursiveBinarySearch(nums,mid+1,end,target);
	}
}
