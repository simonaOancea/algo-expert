package arrays;


// https://leetcode.com/explore/interview/card/adobe/483/array-and-strings/2501/
// Space complexity: O(1)
// Time complexity: O(n)
public class MissingNumber {

	public static void main(String[] args) {

		int[] nums1 = {3, 0, 1};
		int[] nums2 = {0, 1};
		int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};

		System.out.println("Missing number in nums1: " + missingNumber(nums1)); // Output: 2
		System.out.println("Missing number in nums2: " + missingNumber(nums2)); // Output: 2
		System.out.println("Missing number in nums3: " + missingNumber(nums3)); // Output: 8
	}

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int expectedSum = n * (n + 1) / 2;
		int actualSum = 0;

		for (int num : nums) {
			actualSum += num; // sum of elements in the array
		}

		return expectedSum - actualSum;
	}
}
