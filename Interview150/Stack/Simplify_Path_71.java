package Interview150.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Simplify_Path_71 {

	public String simplifyPath(String path) {

		// absolute path "/home/user/Documents/../Pictures"

		if("".equals(path))
		{
			return "";
		}
		Deque<Character> stack = new ArrayDeque<>();

		char[] chars = path.toCharArray();
		char prev ='\u0000';
		String canonicalPath = "";

		int strLength = path.length();

		int i = 0;
		while( i < strLength)
		{
			char curr = path.charAt(i);
			if(prev!=curr && curr =='/')
			{
				stack.push('/');
			}
			else if(   !(65<= (int) prev && (int) prev <=90) &&   !(97<= (int) prev && (int) prev <=122 )
			&&  65<= (int) curr && (int) curr <=90 ||   97<= (int) curr && (int) curr <=122)
			{
				if(!stack.isEmpty()) {
					char fwdSlash = stack.pop();
				}

				canonicalPath+="/"+curr;
				while( ++i < strLength)
				{
					curr = path.charAt(i);
					if(65<= (int) curr && (int) curr <=90 ||   97<= (int) curr && (int) curr <=122)
					{
						canonicalPath+= curr;
					}
					break;
				}


			}

		}


	}

}
