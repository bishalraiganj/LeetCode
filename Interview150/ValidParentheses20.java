package Interview150;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class ValidParentheses20 {


	public static void main(String... args)
	{
		String s1 = "([{}])[()]{}[]";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		String s5 = "";

		System.out.println(isValid(s1));



	}



	// () is 1
	// {} is 2
	// [] is 3

	// Ex :  ([{}])[()]{}()[]
	//([])u
	//{}{}()[]
	public static boolean isValid(String s)
	{
		char[] cArr = s.toCharArray();
		Deque<Character> stack = new ArrayDeque<>();

		for(char c : cArr)
		{
			if(c == '(' || c == '{' || c == '[')
			{
				stack.push(c);
			}
			else if(c == ')' || c == '}' || c == ']')
			{
				if(stack.isEmpty())
				{
					return false;
				}
				else if(c == ')' && stack.peek() == '(')
				{
					stack.pop();
				}
				else if(c == '}' && stack.peek() == '{')
				{
					stack.pop();
				}
				else if(c == ']' && stack.peek() == '[')
				{
					stack.pop();
				}
				else
				{
					return false;
				}

			}
		}

		return stack.isEmpty();



	}




}
