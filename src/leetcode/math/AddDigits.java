package leetcode.math;

/**
 *  https://leetcode.com/problems/add-digits/
 *  Can be solved using a mathematical approach known as "Digital Root".
 *  The digital root of a non-negative integer is the single digit value obtained by an iterative process of summing digits, on each iteration using the result from the previous iteration to compute the digit sum.
 *  The process continues until a single-digit number is reached.
 */

public class AddDigits {
	public static void main(String[] args) {
		AddDigits ad = new AddDigits();
		int num = 8;
		System.out.println(ad.addDigits(num));
	}

	public int addDigits(int num) {
		if (num == 0) {
			return 0;
		}

		if (num % 9 == 0) {
			return 9;
		}

		return num % 9;
	}
}
