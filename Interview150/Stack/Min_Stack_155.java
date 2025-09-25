package Interview150.Stack;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

class MinStack{

	int[][] stack;
	int smallest = Integer.MAX_VALUE;
	int counter = 0;
	public MinStack()
	{
		stack = new int[20][];
	}

	public void push(int x)
	{

		smallest = Math.min(smallest, x);
		stack[counter++] = new int[]{x,smallest};
	}

	public int pop()
	{
		if(counter!= 0) {
			int popValue = stack[counter - 1][0];
			stack[--counter] = null;
			if(counter!=0) {
				smallest = stack[counter - 1][1];
			}
			return popValue;
		}
		throw new NoSuchElementException(" No Element in stack");
	}

	public int top()
	{
		if(counter!=0) {
			return stack[counter - 1][0];
		}
		throw new NoSuchElementException("No Element in stack");
	}

	public int getMin()
	{
		if(counter != 0) {
			int minValue = stack[counter - 1][1];
			return minValue;
		}
		throw new NoSuchElementException(" No element in stack");


	}

	@Override
	public String toString()
	{
		return Arrays.stream(stack).filter((arr)->{
			if(arr==null)
			{
				return false;
			}
			return true;
		}).collect(()->new StringJoiner(",","[","]"),
				(StringJoiner sj,int[] s)->
			sj.add(""+s[0]),
				(sj1,sj2)->{
			sj1.add(sj2.toString());
				}).toString();
	}


	public int[][] getStack()
	{
		return stack;
	}

}






public class Min_Stack_155 {

	public static void main(String... args)
	{
		// 5,3,4,9,0,1,2
		// (5,5),(3,3,(4,3),(9,3),(0,0),(1,0),(2,0)
		MinStack stack1 = new MinStack();
		stack1.push(5);
		stack1.push(3);
		stack1.push(4);
		stack1.push(9);
		stack1.push(0);
		stack1.push(1);
		stack1.push(2);

		System.out.println(stack1);

//		Arrays.stream(stack1.getStack()).forEach((arr)->
//				System.out.println(Arrays.toString(arr)));

		// (5,5),(3,3,(4,3),(9,3),(0,0),(1,0),(2,0)
		System.out.println("-".repeat(50));
//		System.out.println(stack1.getMin() + " " + stack1.getMin() + " " + stack1.pop() + " " + stack1.getMin() + " " + stack1.pop()
//		+ " "  + stack1.getMin() + " " );


		System.out.println(stack1.top() + " " + stack1.pop()+ " "+stack1.pop() + " " +stack1.top());


		System.out.println("-".repeat(50));


		;




	}
}



class MinStack2 {


	int[][] stack;

	int counter = 0;
	public MinStack2() {
		stack = new int[100][];
	}

	public void push(int val) {
		int minSoFar = counter == 0 ? val : Math.min(val,stack[counter - 1][1]);
		stack[counter++] = new int[]{val,minSoFar};

	}

	public void pop() {

		if(counter !=0) {
			counter--; // Resetting is unnecessary since , everything happens using counter field/state only , so did not reset at this index
		}
	}

	public int top() {

		if(counter!=0) {
			return stack[counter - 1 ][0];
		}
		return 0;
	}

	public int getMin()
	{
		if(counter != 0)
		{
			return stack[counter - 1][1];
		}
		return 0;
	}
}


class MinStack3 {

	int[] mainStack;
	int[] minStack;
	int counter=0;



	public MinStack3() {
		mainStack = new int[100];
		minStack = new int[100];
	}

	public void push(int val) {
		if(counter == 0 )
		{
			mainStack[counter] = val;
			minStack[counter++] = val;

		}
		else
		{
			mainStack[counter] = val;
			minStack[counter ] = Math.min(val,minStack[counter - 1]);
			counter++;
		}
	}

	public void pop() {
		if( counter != 0)
		{
			counter--;
		}

	}

	public int top() {

		if(counter != 0)
		{
			return mainStack[counter - 1];
		}

		return 0;
	}

	public int getMin()
	{

		if(counter != 0)
		{
			return minStack[counter - 1];
		}
		return 0;
	}
}



