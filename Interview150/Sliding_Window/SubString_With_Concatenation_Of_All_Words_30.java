package Interview150.Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubString_With_Concatenation_Of_All_Words_30 {

	public List<Integer> findSubstring(String s, String[] words)
	{
		List<Integer> res   = new ArrayList<>();
		if(s == null || words == null || words.length == 0)
		{
			return res;
		}


		int wordLen = words[0].length();
		int wordCount = words.length;
		Map<String, Integer> freqMap = new HashMap<>();

		for(String str : words)
		{
			freqMap.put(str, freqMap.getOrDefault(str,0)+1);
		}

		int count = 0;
		Map<String, Integer> currMap = new HashMap<>();

		for(int i = 0 ; i < wordLen ; i++)
		{
			int left = i;

			for(int right = left ; right+wordLen <= s.length() ; right += wordLen)
			{
				String subStr = s.substring(right, right+wordLen);

				if(freqMap.containsKey(subStr))
				{
					currMap.put(subStr, currMap.getOrDefault(subStr,0)+1);
					count++;


					while(currMap.get(subStr) > freqMap.get(subStr))
					{
						String leftStr = s.substring(left,left+wordLen);
						currMap.put(leftStr,currMap.get(leftStr)-1);
						left+=wordLen;
						count--;
					}

					if(count == wordCount)
					{
						res.add(left);
					}
				}
				else
				{
					currMap.clear();
					count=0;
					left=right+wordLen;
				}
			}
			currMap.clear();
			count = 0;
		}
		return res;
	}
}
