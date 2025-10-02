package Interview150.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class Evaluate_Reverse_Polish_Notation_150 {

	public int evalRPN(String[] tokens) {


		//Edge Cases Handling
		if(tokens == null || tokens.length == 0)
		{
			return  0;
		}

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		//Input: tokens = ["4","13","5","/","+"]
		//Output: 6
		//Explanation: (4 + (13 / 5)) = 6
		for(String str : tokens)
		{
			if(!(str.equals("+") ||  str.equals("-") || str.equals("/") || str.equals("*")))
			{
				stack.push(Integer.parseInt(str));
			}
			else
			{
				int rightOperand = stack.pop();
				int leftOperand  = stack.pop();
				int result=0;

				if(str.equals("+")) {
					result = leftOperand + rightOperand;
				}
				else if(str.equals("-"))
				{
					result = leftOperand - rightOperand;
				}
				else if(str.equals("*"))
				{
					result = leftOperand * rightOperand;
				}
				else if(str.equals("/"))
				{
					result = leftOperand / rightOperand;
				}
				stack.push(result);
			}
		}

		return stack.pop();
	}
}
