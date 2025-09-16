package Interview150;

import java.util.HashMap;

public class RansomNote383 {


	public static void main(String... args)
	{

		String r  = "bishaladhikary";

		String m = " bisaahssdsadhikaryl";

		System.out.println(canConstruct(r,m));




	}



	public static boolean canConstruct(String ransomNote, String magazine)
	{
		HashMap<Character, Integer> avlMap = new HashMap<>();

		char[] avlChars = magazine.toCharArray();
		for(Character c : avlChars)
		{
			avlMap.compute(c,(k,v)->{
				if(v== null)
				{
					return 1;
				}
				return v+1;
			});
		}


		for(Character c : ransomNote.toCharArray())
		{
			if(avlMap.get(c)!=null && avlMap.get(c)>=1)
			{
				avlMap.put(c,avlMap.get(c) - 1);
			}
			else
			{
				return false;
			}

		}

return true;
	}
}
