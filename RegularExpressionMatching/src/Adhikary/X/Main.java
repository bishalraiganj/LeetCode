package Adhikary.X;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String... args)
	{

		String s = "aa";
		String p = "a";

		System.out.println(isMatch(s,p));
		System.out.println("-".repeat(50));

		String s1 = "aa";
		String p1 = "a*";
		System.out.println(isMatch(s1,p1));
		System.out.println("-".repeat(50));

		String s3 = "ab";
		String p3 = ".*";
		System.out.println(isMatch(s3,p3));


	}

	public static boolean isMatch(String s, String p)
	{
		Pattern pat = Pattern.compile(p);
		Matcher m  = pat.matcher(s);

		m.find();

		return m.group().equals(s);


	}

}
