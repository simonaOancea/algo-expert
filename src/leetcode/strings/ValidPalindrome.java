package leetcode.strings;


// Time Complexity: O(N)
// Space Complexity: O(N)
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		StringBuilder builder = new StringBuilder();

		for (char ch : s.toCharArray()) {
			if(Character.isLetterOrDigit(ch)) {
				builder.append(Character.toLowerCase(ch));
			}
		}

		String filteredString = builder.toString();
		String reversedString = builder.reverse().toString();

		return filteredString.equals(reversedString);
	}
}
