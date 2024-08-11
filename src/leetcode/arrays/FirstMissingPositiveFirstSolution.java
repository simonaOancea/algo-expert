package leetcode.arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * Space & time complexity analysis
 * - space complexity: O(n)
 * - time complexity:O(n) = O(n)
 */
public class FirstMissingPositiveFirstSolution {
	public static void main(String[] args) {
		int[] nums = new int[] {3, 4, -1, 1};
		FirstMissingPositiveFirstSolution firstMissingPositive = new FirstMissingPositiveFirstSolution();

		System.out.println(firstMissingPositive.firstMissingPositive(nums));
	}

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		// array for lookup
		boolean[] seen = new boolean[n + 1];

		// mark the numbers that are present
		for (int num : nums) {
			if (num > 0 && num <= n) {
				seen[num] = true;
			}
		}

		// iterate through integers from 1 to n and return the first number that is not present
		for (int i = 1; i <= n; i++) {
			if (!seen[i]) {
				return i;
			}
		}

		// if all numbers are present, return n + 1
		return n + 1;
	}
}
