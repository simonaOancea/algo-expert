package strings;

import java.util.*;

public class StringAppearanceCounter {
	public static int countSameLetterStrings(String[] strings) {
		// Create a HashMap to store sorted strings and their counts
		Map<String, Integer> appearanceMap = new HashMap<>();

		// Iterate through the array of strings
		for (String str : strings) {
			// Convert the string to a character array and sort it
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = new String(chars);

			// Increment the count for the sorted string in the map
			appearanceMap.put(sortedStr, appearanceMap.getOrDefault(sortedStr, 0) + 1);
		}

		// Initialize a variable to store the total count of same letter appearances
		int totalCount = 0;

		// Iterate through the map to count appearances with more than one occurrence
		for (int count : appearanceMap.values()) {
			if (count > 1) {
				// Increment the total count
				totalCount += count;
			}
		}

		return totalCount;
	}

	public static void main(String[] args) {
		String[] strings = {"aab", "cac", "ac", "ba", "caa", "d", "ab"};
		int appearances = countSameLetterStrings(strings);
		System.out.println("Number of string appearances with the same letters: " + appearances);
	}
}
