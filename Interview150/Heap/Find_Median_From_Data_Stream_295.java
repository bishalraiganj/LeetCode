package Interview150.Heap;

import java.util.PriorityQueue;

public class Find_Median_From_Data_Stream_295 {





}



class MedianFinder {

	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	int maxCount = 0;
	int minCount = 0;
	public MedianFinder()
	{
		maxHeap = new PriorityQueue<>();
		minHeap = new PriorityQueue<>((a,b)->b-a);
	}

	public void addNum(int num)
	{
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		minCount++;

		if(minCount>maxCount)
		{
			maxHeap.offer(minHeap.poll());
			minCount--;
			maxCount++;
		}
	}

	public double findMedian()
	{
		if(maxCount== 0 && minCount==0)
		{
			return 0;
		}

		if(maxCount == minCount)
		{
			return ( maxHeap.peek() + minHeap.peek() ) / 2.0;
		}
		return maxHeap.peek();
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
