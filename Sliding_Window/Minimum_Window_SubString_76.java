package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_SubString_76
{
	public String minWindow(String s, String t)
	{
		//Represent the frequency map of chars required
		HashMap<Character, Integer> need = new HashMap<>();
		//Represents the frequency map of char in the current window
		HashMap<Character, Integer> window = new HashMap<>();
		// preprocessing or preloading the need map for use
		for(char c : t.toCharArray())
		{
			need.put(c,need.getOrDefault(c,0)+1);
		}
		int have =0,needCount= need.size(),left=0,minLen=Integer.MAX_VALUE,start=0;


		// Traverse until right reaches end of s string and represents the window traversing pass
		for(int right=0;right<s.length();right++)
		{
			//we keep putting curr char in curr window
			window.put(s.charAt(right),window.getOrDefault(s.charAt(right),0)+1);
			if (need.containsKey(s.charAt(right)) && window.get(s.charAt(right)).intValue()==need.get(s.charAt(right)).intValue())
			{
				have++;
			}

			//whenever requirement met just keep tracking starting point of the substring and decereasing
			//until condition not matching (have==needCount) and also keep tracking the start in this loop
			// because , we can have a big substring that has smaller sub string's satisfying the condition
			// so we keep moving left forward and tracking start as long as have==needCount
			//this is because , we always take every char in curr window whether it is in t or not
			//and by the time we satisfy have==count we have so many substrings satisfying condition
			//and it is not necessary for the substring to start with a char from t ,(other wise logic will become
			//very complex to maintain , and even if we start a substring from a matching char we cannot ignore the chars
			//that are after it and not of t , because we have to consider entire substrings that also contains different chars but
			//satisfies
			while(have==needCount)
			{
				if(right - left + 1 < minLen)
				{
					minLen = right - left + 1;
					start = left;
				}


				char l = s.charAt(left++);
				window.put(l,window.get(l)-1);
				if(need.containsKey(l)&& window.get(l)<need.get(l))
				{
					have--;
				}
			}
		}
		return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
	}



	//-----------------------------------------------------------------------------------------

	/**
	 * Returns the minimum window substring of s that contains all characters of t (including multiplicity).
	 *
	 * Algorithm: sliding window with two frequency maps:
	 *  - need: what counts of characters we need (from t)
	 *  - window: what counts of characters the current window [left..right] has
	 *
	 * We maintain:
	 *  - needCount = number of distinct characters required (size of need map)
	 *  - have = number of distinct characters in 'window' whose counts meet or exceed need's counts
	 *
	 * Expand by moving right and updating window counts, updating 'have' when a character's count
	 * reaches exactly the needed count. When have == needCount the current window contains all required
	 * characters (maybe with extras). Then we try to shrink from left to find a smaller valid window.
	 *
	 * Time complexity: O(|s| + |t|) (each character is visited at most twice - once when right expands and
	 * once when left shrinks).
	 * Space complexity: O(k) where k is number of distinct chars (size of maps) — can be reduced to O(1)
	 * if alphabet is fixed and small by using int arrays.
	 */
	public String minWindow2(String s, String t) {
		// Edge cases: if either is null/empty or s shorter than t, no valid window.
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return "";
		}
		if (s.length() < t.length()) {
			return "";
		}

		// Frequency map for required chars (from t)
		Map<Character, Integer> need = new HashMap<>();
		for (char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		// Frequency map for current window
		Map<Character, Integer> window = new HashMap<>();

		// Number of distinct characters for which window has reached the requested count
		int have = 0;
		// Number of distinct characters required
		int needCount = need.size();

		// Sliding window pointers and best-window tracking
		int left = 0;
		int minLen = Integer.MAX_VALUE;
		int start = 0; // start index of best window found

		// Expand window with right pointer
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right); // current right character
			window.put(c, window.getOrDefault(c, 0) + 1);

			// If this character is required and we've reached exactly the required count for it,
			// we consider this distinct character "satisfied" so increment 'have'.
			// IMPORTANT: compare numeric values, not Integer object references.
			if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
				have++;
			}

			// When all required distinct characters are satisfied (have == needCount),
			// try to shrink from left to reduce window size while keeping it valid.
			while (have == needCount) {
				// Update minimum if current window is smaller
				int windowLen = right - left + 1;
				if (windowLen < minLen) {
					minLen = windowLen;
					start = left;
				}

				// Remove/shift leftmost character from window
				char leftChar = s.charAt(left);
				// Decrement its count in window
				window.put(leftChar, window.get(leftChar) - 1);

				// If leftChar is required and its new count is now less than required,
				// the window is no longer valid -> decrement have.
				// (Note: '<' unboxes to primitive ints)
				if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
					have--;
				}
				left++; // actually shrink the window
			}
		}

		// If minLen was never updated, no valid window was found
		return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
	}



}
