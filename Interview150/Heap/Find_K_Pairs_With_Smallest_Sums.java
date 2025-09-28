package Interview150.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Find_K_Pairs_With_Smallest_Sums {




	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		List<List<Integer>> result =  new ArrayList<>();


		//Edge Case
		if(nums1.length == 0 || nums2.length == 0 || k == 0 )
		{
			return  result;
		}

		Queue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

		// pre-loading the nums1 , because first column is required only because every new starts from first pair ,
		//if you imagine a matrix where rows are nums1 , and columns nums2

		for(int i = 0; i < Math.min(nums1.length,k) ; i++)
		{
			minHeap.offer(new int[] {(nums1[i]+nums2[0]),i,0});
		}


		while(k-- > 0 && !minHeap.isEmpty() )
		{
			int[] popped = minHeap.poll();
			int i =  popped[1];
			int j = popped[2];

			result.add(List.of(nums1[i],nums2[j]));

			 if(j + 1 <nums2.length)
			 {
				 minHeap.offer(new int[] {(nums1[i]+nums2[j+1]),i,j+1});
			 }
		}

		return result;
	}




}
