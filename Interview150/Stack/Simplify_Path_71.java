package Interview150.Stack;

import java.util.*;

public class Simplify_Path_71 {


	public static void main(String... args)
	{
		String s1 = "/home/user/Documents/../Pictures";
		String s2 = "/../";
		String s3 ="/.../a/../../b/c/../d/./";
		String s4 = "/a//b////c/d//././/..";
		String s5 = "/";
		String s6 = "/...";


		System.out.println(simplifyPath(s6));



	}

	public static String simplifyPath(String path) {


		if(path == null || path.length()==0)
		{
			return "";
		}


		//"/home/user/Documents/../Pictures"
		int len = (path).length();
		char curr='\u0000';
		String currDir = "";
		Deque<String> stack  = new ArrayDeque<>();
		String canonicalPath = "";

		for(int i = 0 ; i < len ; i++) {
			curr = path.charAt(i);
			if (curr == '/')
			{
				if(currDir.equals(".."))
				{
					if(!stack.isEmpty()) {
						stack.pop();
					}
				}
				else if(!currDir.equals(".") && !currDir.equals("") )
				{
					stack.push("/"+currDir);

				}
				currDir="";
			}
			else
			{
				currDir= currDir + curr;
			}
		}



//		System.out.println(currDir) ;
		if(stack.isEmpty() && (currDir.equals(".") || currDir.equals("..") ||currDir.equals("")) )
		{
			stack.push("/");
		}
		else if(!currDir.equals("..") && !currDir.equals(".")&& !currDir.equals(""))
		{
			stack.push("/"+currDir);
		}
		else if(currDir.equals(".."))
		{
			if(!stack.isEmpty())
			{
				stack.pop();
				if(stack.isEmpty())
				{
					stack.push("/");
				}
			}
		}

//		while(!stack.isEmpty())
//		{
//			canonicalPath = canonicalPath + "/"+stack.pop();
//		}

		return stack.reversed().stream().collect(()->new StringBuilder(""),(StringBuilder sb,String s)->sb.append(s),
				(StringBuilder a,StringBuilder b)->a.append(b)).toString();


	}

}
