package Interview150.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Word_Pattern_290 {


	public static void main(String... args)
	{

		System.out.println(wordPattern("abc","a b c"));
		map.entrySet().stream().forEach((e)->{
			System.out.println("Key->"+e.getKey() + " Val->" + e.getValue());
		});


	}


	static HashMap<String, Character> map = new HashMap<>();
	static Set<Character> patternSet  = new HashSet<>();
	 static int wordCounter=0;



	public static  boolean wordPattern(String pattern, String s)
	{

		if(pattern.isEmpty() || s.isEmpty() )
		{
			return false;
		}


		String word = "";
		char prev='\u0000';
		int patternCounter = 0;


		for(int i = 0 ; i < s.length() ; i++) {

			if(patternCounter>=pattern.length())
			{
				return false;
			}
			char ch = s.charAt(i);
//			if (prev != ' ' && (ch == ' ' || i == s.length() - 1)) {
//				if (map.containsKey(word)) {
//					if (patternCounter < pattern.length() && !map.get(word).equals(pattern.charAt(patternCounter))) {
//						return false;
//					}
//
//				}
//				else if(patternCounter < pattern.length())
//				{
//					map.put(word, pattern.charAt(patternCounter));
//				}
//				word = "";
//				prev = ch;
//				patternCounter++;
//			}
//			else {
//				word += ch;
//				prev = ch;
//			}
			if((prev != ' ' && ch==' ') || i==s.length()-1)
			{
				if(i==s.length()-1)
				{
					word+=ch;
				}
				if(patternCounter< pattern.length() && map.containsKey(word) && (!map.get(word).equals(pattern.charAt(patternCounter))))
				{
//					System.out.println(word +"  "+ map.get(pattern.charAt(patternCounter)) + pattern.charAt(patternCounter));
					wordCounter++;
					return false;
				}
				else if(!map.containsKey(word) )
				{
					if(patternCounter< pattern.length() && !patternSet.contains(pattern.charAt(patternCounter)))
					{
						map.put(word, pattern.charAt(patternCounter));
						patternSet.add(pattern.charAt(patternCounter));
					}
					else
					{
						wordCounter++;
						return false;
					}

				}
				prev = ch;
				word = "";
				patternCounter++;
				wordCounter++;

			}
			else
			{
				word +=ch;
				prev=ch;
			}

		}
//		if(wordCounter!=patternCounter || patternCounter!=pattern.length())
//		{
//			return false;
//		}
		return true;
	}

}
