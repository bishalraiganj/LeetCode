package Interview150.Heap;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

class MaxHeap1{

	int[] backingArray;
	int size = 0;

	MaxHeap1()
	{
		backingArray=new int[2900];
	}

	public void insert(int val)
	{
		backingArray[size]=val;
		fixHeapAbove(size++);
	}

	public int maxExtract()
	{
		if(size==0)
		{
			throw new NoSuchElementException("Heap is empty!");
		}
		int max = backingArray[0];
		backingArray[0]=backingArray[size-1];
		size--;
		fixHeapBelow(0);
		return max;
	}


	public void delete(int i)
	{
		if(i< 0 || i>=size)
		{
			throw new IndexOutOfBoundsException("Index out of bounds!");
		}

		if(size==1)
		{
			backingArray[0] = 0;
			size--;
		}
		else if(size>1)
		{
			backingArray[i]=backingArray[size-1];
			size--;
			int parentIndex = getParentIndex(i);
			if(parentIndex==-1)
			{
				fixHeapBelow(i);
			}
			else if(backingArray[i]>=backingArray[parentIndex])
			{
				fixHeapAbove(i);

			}
			else
			{
				fixHeapBelow(i);
			}

		}
	}


	public void fixHeapAbove(int i)
	{
		int replacementVal = backingArray[i];
		while(i > 0 && replacementVal > backingArray[getParentIndex(i)])
		{
			backingArray[i] = backingArray[getParentIndex(i)];
			i=getParentIndex(i);
		}
		backingArray[i]=replacementVal;
	}

	//Hole-Insertion Optimization
	public void fixHeapBelow(int i)
	{
		int replacementVal = backingArray[i];
		while((2 * i) + 1 < size)
		{
			int j = 2 * i + 1;
			if(j + 1 < size && backingArray[j] < backingArray[j+1])j+=1;
			if(replacementVal >= backingArray[j]) break;
			backingArray[i] = backingArray[j];
			i=j;
		}
		backingArray[i] = replacementVal;
	}


	public void addAll(MaxHeap1 heap)
	{
		for(int i = 0 ; i < size ; i++)
		{
			this.insert(heap.maxExtract());
		}
	}

	public int getChildIndex(int i,boolean leftChildStatus)
	{
		return leftChildStatus ? (2 * i) + 1 : (2 * i) + 2;
	}

	public int getParentIndex(int i)
	{
		if(i==0)
		{
			return -1;
		}
		return (i-1)/2;
	}

	public void swap(int i, int j)
	{
		int temp  = backingArray[i];
		backingArray[i] = backingArray[j];
		backingArray[j] = temp;
	}

	public boolean isEmpty()
	{
		return size==0;
	}

	public int peek()
	{
		if(size==0)
		{
			throw new NoSuchElementException("Heap is Empty !");
		}
		return backingArray[0];
	}

	public int getSize()
	{
		return size;
	}

}


public class IPO_502 {

	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital)
	{
		if(k==0 || profits.length==0 )
		{
			return 0;
		}

		// if a-b is positive then b is minimum
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0] - b[0]);
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[1]-a[1]);


		for(int i = 0 ; i < capital.length ; i++)
		{
			minHeap.offer(new int[]{capital[i],profits[i]});
		}


		for(int i = 0 ; i < k ; i++)
		{

			while(!minHeap.isEmpty() && minHeap.peek()[0]<=w)
			{
			 	maxHeap.offer(minHeap.poll());
			}

			if(maxHeap.isEmpty())
			{
				break;
			}

			w+=maxHeap.poll()[1];

		}
		return w;
	}





}
