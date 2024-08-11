package leetcode.arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * Space & time complexity analysis
 * - space complexity: O(n) -> nums is the input array, so the auxiliary space is O(1)
 * - time complexity:O(n) = O(n)
 */

public class FirstMissingPositiveSecondSolution {
	public static void main(String[] args) {
		int[] nums = new int[] {3, 4, -1, 1};
		FirstMissingPositiveSecondSolution firstMissingPositive = new FirstMissingPositiveSecondSolution();

		System.out.println(firstMissingPositive.firstMissingPositive(nums));
	}

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		boolean contains1 = false;

		// Replace negative numbers, zeros, and numbers greater than n with 1
		for (int i = 0; i < n; i++) {
			// check whether 1 is present in the original array
			if (nums[1] == 1) {
				contains1 = true;
			}

			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = 1;
			}
		}

		if (!contains1) {
			return 1;
		}

		// Mark whether integers 1 to n are in nums
		// Use index as a hash key and negative sign as a presence detector.
		for (int i = 0; i < n; i++)  {
			int value = Math.abs(nums[i]);
			if (value == n) {
				nums[0] = -Math.abs(nums[0]);
			} else {
				nums[value] = -Math.abs(nums[value]);
			}
		}

		// First positive in nums is smallest missing positive integer
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0) return i;
		}

		// nums[0] stores whether n is in nums
		if (nums[0] > 0) {
			return n;
		}

		// If nums contains all elements 1 to n
		// the smallest missing positive integer is n + 1
		return n + 1;
	}
}
