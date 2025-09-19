package Interview150.Sliding_Window;

import java.util.HashSet;

public class Longest_Sub_String_Without_Repeating_Characters_3 {


	public static void main(String... args)
	{
		String s1 = "abcdaefbgh";

		System.out.println(lengthOfLongestSubstring(s1));
	}

	public static int lengthOfLongestSubstring(String s)
	{


		HashSet<Character> set = new HashSet<>();
		int left = 0;
		int right = 0;
		int maxSubString = 0;




		//"abcdaefbgh"
		while(right < s.length() )
		{


			while(set.contains(s.charAt(right)))
			{
				set.remove(s.charAt(left++));
			}
			set.add(s.charAt(right));

			maxSubString = Math.max(maxSubString, right - left + 1);
			right++;
		}

		return maxSubString;

	}





}
