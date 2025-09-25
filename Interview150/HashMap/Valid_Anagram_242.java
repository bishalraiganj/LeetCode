package Interview150.HashMap;

import java.util.HashMap;

public class Valid_Anagram_242 {



	public boolean isAnagram(String s, String t) {

		if(s.isEmpty() && t.isEmpty())
		{
			return true;
		}
		else if( s.isEmpty() || t.isEmpty() || s.length() != t.length())
		{
			return false;
		}




		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0 ; i < s.length() ; i++)
		{
			if(map.containsKey(s.charAt(i)))
			{
				map.compute(s.charAt(i),(key,val)->{

					return val+1;
			});
			}
			else
			{
				map.put(s.charAt(i),1);
			}
		}

		for(int i = 0 ; i < t.length() ; i++)
		{
			if(!map.containsKey(t.charAt(i)))
			{
				return false;
			}
			else
			{
				if(map.get(t.charAt(i)) == 0)
				{
					return false;
				}
				else
					{
						map.compute(t.charAt(i),(key,val)->{
							return --val;
						});
					}
			}
		}

		return true;
	}

}
