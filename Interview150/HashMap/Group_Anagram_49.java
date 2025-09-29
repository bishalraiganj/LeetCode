package Interview150.HashMap;

import java.util.*;

public class Group_Anagram_49 {


	//Input: strs = ["eat","tea","tan","ate","nat","bat"]

	//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	public List<List<String>> groupAnagrams(String[] strs)
	{
		if(strs==null||strs.length==0)
		{
			return new ArrayList<>();
		}
		Map<String,List<String>> map = new HashMap<>();


		for(String str : strs)
		{
			int[] freqArr = new int[26];
			for(int i= 0 ; i < str.length() ; i++)
			{
				freqArr[str.charAt(i)-'a']++;
			}
			StringBuilder keyStr = new StringBuilder();
			for(int val : freqArr)
			{
				keyStr.append(val).append("#");
			}

			String key = keyStr.toString();
			map.computeIfAbsent(key,(e)->new ArrayList<>()).add(str);

//			if(map.containsKey(keyStr))
//			{
//				map.get(keyStr).add(str);
//			}
//			else
//			{
//				List<String> list = new ArrayList<>();
//				list.add(str);
//				map.put(keyStr,list);
//			}

		}



		return new ArrayList<>(map.values());
	}
}
