package Interview150.Heap;

import java.lang.reflect.Array;
import java.util.Arrays;

class MaxHeapSimple{
	private int[] heap;
	private int size;

	public MaxHeapSimple(int capacity) {
		heap = new int[capacity];
		size = 0;
	}

	public void insert(int val) {
		heap[size] = val;
		siftUp(size++);
	}

	public int extractMax() {
		int max = heap[0];
		heap[0] = heap[--size];
		siftDown(0);
		return max;
	}

	private void siftUp(int i) {
		while (i > 0 && heap[i] > heap[(i - 1) / 2]) {
			swap(i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
	}

	private void siftDown(int i) {
		while (2 * i + 1 < size) {
			int j = 2 * i + 1;
			if (j + 1 < size && heap[j + 1] > heap[j]) j++;
			if (heap[i] >= heap[j]) break;
			swap(i, j);
			i = j;
		}
	}

	private void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
}

class MaxHeap {

	int[] heap ;
	int size;
	public MaxHeap(int capacity)
	{
		heap =     new int[capacity] ;
	}



	public void insert(int element)
	{
		if(size == heap.length)
		{
			throw new IndexOutOfBoundsException(" Size is full ");
		}

		heap[size] = element;
		fixHeapAbove(size);
		size++;

	}

	public int extractMax()
	{
		if(isEmpty())
		{
			throw new IndexOutOfBoundsException(" Empty Heap ! ");
		}
		int max = heap[0];
		heap[0] = heap[size - 1];
		fixHeapBelow(0);
		size--;
		return max;
	}

	//Most optimized version amongst the 3 overloaded versions
	public void fixHeapAbove(int i)
	{
		int val = heap[i];
		while(i > 0 )
		{
			int parent = (i -  1)/ 2;
			if(heap[parent] >= val) break;
			heap[i] = heap[parent];
			i = parent;
		}
		heap[i] = val;
	}




	public void fixHeapAbove3(int i)
	{
		while(i > 0 && heap[i] > heap[(i-1)/ 2])
		{
			swap(i,(i-1)/2);
			i = (i - 1 ) / 2;
		}

	}



	public int delete(int i)
	{
		if(isEmpty() || i >= size)
		{
			throw new IndexOutOfBoundsException( " Empty heap ! ");
		}

		int parent = getParent(i);
		int deletedValue = heap[i];
		heap[i] = heap[size - 1];
		if(i == 0 || heap[i] < heap[parent])
		{
			fixHeapBelow(i);
		}
		else
		{
			fixHeapAbove2(i);
		}

		size--;

		return deletedValue;

	}


	public void fixHeapBelow2(int i)
	{
		int childToSwap ;


		while( i < size)
		{
			int leftChild = getChild(i,true);
			int rightChild = getChild(i,false);
			if( leftChild < size )
			{
				if(rightChild< size)
				{
					childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
				}
				else
				{
					childToSwap = leftChild;
				}
				if(heap[i] >= heap[childToSwap]) break;
				swap(i,childToSwap);
				i = childToSwap;
			}
		}
	}


	public void fixHeapBelow(int i)
	{
		while( 2 * i  + 1 < size)
		{
			int j = 2 * i + 1; // childToSwap index
			if(j + 1 < size && heap[j+1] > heap[j]) j++;
			if(heap[i] >= heap[j] ) break;
			swap(i,j);
			i = j;
		}
	}

	public void swap(int i , int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	public void fixHeapAbove2(int index)
	{
		int replacement = heap[index];
		int parentIndex = getParent(index);

		while(index > 0  && replacement > heap[parentIndex])
		{
			heap[index] = heap[parentIndex];
			index = parentIndex;
			parentIndex = getParent(index);

		}
		heap[index] = replacement;
	}

	public int getChild(int index, boolean left)
	{
		return left ? ( ( 2 * index ) +1 ) : (2 * index) + 2;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public int getParent(int index)
	{
		return (index - 1 ) / 2;
	}

}





public class Kth_Largest_Element_In_An_Array_215 {

	public static void main(String... args)
	{
		int[] intArr = {3,2,1,5,6,4};

		System.out.println(findKthLargest(intArr,2));

	}



	public static int findKthLargest(int[] nums, int k)
	{

		MaxHeap heap = new MaxHeap(100);

		for(int val : nums)
		{
			heap.insert(val);
		}

		int kthLargest  = 0;

		for(int i = 0 ; i < k ; i++)
		{
			kthLargest =  heap.extractMax();
		}

		return kthLargest;





	}



}
