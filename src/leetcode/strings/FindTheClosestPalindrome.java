package leetcode.strings;

public class FindTheClosestPalindrome {
	public static void main(String[] args) {
		String input = "10";
		FindTheClosestPalindrome findTheClosestPalindrome = new FindTheClosestPalindrome();

		System.out.println(findTheClosestPalindrome.nearestPalindromic(input));
	}

	public String nearestPalindromic(String n) {
		int orderOfMagnitude = n.length();
		long num = Long.parseLong(n);
		boolean isOdd = orderOfMagnitude % 2 == 1;
		long firstHalf = Long.parseLong(n.substring(0, (orderOfMagnitude + 1) / 2));

		long smaller = createPalindrome(firstHalf - 1, isOdd);
		long same = createPalindrome(firstHalf, isOdd);
		long larger = createPalindrome(firstHalf + 1, isOdd);

		if (num == same) {
			return String.valueOf(smaller);
		} else if (Math.abs(num - smaller) <= Math.abs(num - larger)) {
			return String.valueOf(smaller);
		} else {
			return String.valueOf(larger);
		}
	}

	private long createPalindrome(long firstHalf, boolean isOdd) {
		String s = Long.toString(firstHalf);
		String reverse = new StringBuilder(s).reverse().toString();
		if (isOdd) {
			s = s.substring(0, s.length() - 1);
		}

		return Long.parseLong(s + reverse);
	}
}
