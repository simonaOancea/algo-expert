package leetcode.strings;

public class CountOccurrences {
	public static void main(String[] args) {
		CountOccurrences countOccurrences = new CountOccurrences();
		String str = "GeeksforGeeks A computer science portal for geeks";
		String word = "geeks";
		System.out.println(countOccurrences.countOccurrences(str, word));
	}

	// Time complexity is O(n) where n is the number of words in the string
	// Space complexity is O(n) where n is the number of words in the string
	public int countOccurrences(String str, String word) {
		String a[] = str.split(" ");

		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (word.equals(a[i]));
			count++;
		}

		return count;
	}
}
