package Interview150.HashMap;

import java.util.HashMap;

public class Isomorphic_Strings_205 {

	public boolean isIsomorphic(String s, String t) {

		//Two approaches possible
		//1. keep mapping till the last index of the character
		//if along this process , we find a different possible mapping
		//for any character that is already mapped then immediately return false;
		//this approach is o(n)
		// cause if we reach the end index and there were no different mappings possible
		//then they are isomorphic strings


		//2 .  We complete mapping first
		//then we put the mapped values and then check
		//whether after changing with the mapped values
		//now the changed string is equal to the other string or not
		// but this approach is  0 (n + n)


		HashMap<Character,Character> mapS = new HashMap<>();
		HashMap<Character, Character> mapT = new HashMap<>();
		boolean sStatus = true ;
		boolean tStatus  =true;
		if(s.equals("") && t.equals(""))
		{
			sStatus= true;
		}

		if(s.length() == t.length()) {
			for (int i = 0; i < s.length(); i++) {
				if (!mapS.containsKey(s.charAt(i))) {
					mapS.put(s.charAt(i), t.charAt(i));
				} else {
					if (mapS.get(s.charAt(i)) != t.charAt(i)) {
						sStatus= false;
					}
				}
			}




			for( int i = 0 ; i < t.length() ; i++) {
				if (!mapT.containsKey(t.charAt(i)))
				{
					mapT.put(t.charAt(i),s.charAt(i));
				}
				else
				{
					if(mapT.get(t.charAt(i)) != s.charAt(i))
					{
						tStatus = false;
					}
				}

			}


		}


		return sStatus && tStatus;

	}


}
