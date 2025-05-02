package strings;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/explore/interview/card/adobe/483/array-and-strings/2490/
// sliding window
public class LongestSubstring {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println("Length of Longest Substring: " + lengthOfLongestSubstring(s));

	}


	public static int lengthOfLongestSubstring(String s) {
		// HashMap to store the last index of each character
		Map<Character, Integer> charIndexMap = new HashMap<>();
		int maxLength = 0; // to store the max length of substring
		int left = 0; // left pointer of the sliding window

		// Iterate through the string with the right pointer
		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);

			// If the character is already in the map and its index is within the current window
			if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
				// Move the left pointer to the right of the last occurrence of the current character
				left = charIndexMap.get(currentChar) + 1;
			}

			// Update the character's index in the map
			charIndexMap.put(currentChar, right);

			// Calculate the length of the current window and update maxLength
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}
}