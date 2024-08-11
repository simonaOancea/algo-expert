package leetcode.strings;

public class ValidPalindromeStreams {

	public boolean isPalindrome(String s) {
		StringBuilder builder = new StringBuilder();

		s.chars()
				.filter(Character::isLetterOrDigit)
				.mapToObj(c -> Character.toLowerCase((char) c))
				.forEach(builder::append);

		return builder.toString().contentEquals(builder.reverse());
	}
}
