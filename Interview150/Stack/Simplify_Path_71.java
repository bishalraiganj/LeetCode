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


		System.out.println(simplifyPath(s4));



	}

	public static String simplifyPath(String path) {


		if(path!= null && !path.equals("")) {

			// absolute path "/home/user/Documents/../Pictures"
			//   " /../"
			Deque<Character> stack = new ArrayDeque<>();


			StringJoiner currDirectory = new StringJoiner("");
			char prevChar = '\u0000';
			char currChar = '\u0000';

			int length = path.length();
			int i = 0;

			String[] dirArr = new String[15];
			int counter = 0;

			while (i < length) {
				currChar = path.charAt(i);


				//"/home/user/Documents/../Pictures"
				//   "/../"
				if (prevChar != '/' && currChar == '/')
				{

					String currDirString = currDirectory.toString();
//				if(!currDirectory.toString().equals("/..") )
//				if(  !currDirectory.toString().equals("/.."))
//				{
//					canonicalPath.add(dirArr[counter++]);
//				}
//				else

					System.out.println(currDirString);
					if (currDirString.equals("/..")) {
//					System.out.println(Arrays.toString(dirArr));
//					System.out.println(currDirString);
//					System.out.println(counter + " " + dirArr[counter-1]);
						if(counter!=0) {
							dirArr[--counter] = "";
						}
					}
//					if(currDirString.equals("/.") || currDirString.equals("/.."))
//					{
//						System.out.println(Arrays.toString(dirArr));
//						System.out.println(currDirString);
//						System.out.println(counter + " " + dirArr[counter-1]);
//					}

					if (!currDirString.equals("/..")&& !(currDirString.equals("/.")) && (!currDirString.isEmpty()) && (!currDirString.equals(" "))) {


//					counter++;
						dirArr[counter++] = currDirString;
					}


					stack.push('/');


					currDirectory = new StringJoiner("");

					prevChar = '/';

				} else if (currChar != '/') {
					if (prevChar == '/' && !stack.isEmpty()) {
						char fwdSlash = stack.pop();
						currDirectory.add("/");
					}
					currDirectory.add("" + currChar);
					prevChar = currChar;
				}
				i++;

				if (i == length) {
					if(path.equals("/../"))
					{
						return "/";
					}
					if (currDirectory.toString().equals("/..")) {
						dirArr[--counter] = "";
					} else {
						dirArr[counter] = currDirectory.toString();
					}
				}
			}


			StringJoiner canonicalPath = new StringJoiner("");

			System.out.println(counter + ""+(dirArr[counter].isEmpty()));
			for (int j = 0; j <= counter; j++) {
				canonicalPath.add(dirArr[j]);

			}


		System.out.println(Arrays.toString(dirArr));


			return canonicalPath.toString();
		}

		return "";



	}

}
