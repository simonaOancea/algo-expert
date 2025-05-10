package arrays;

public class ContainerWithMostWater {

	// https://leetcode.com/explore/interview/card/adobe/483/array-and-strings/2491/

	public static void main(String[] args) {
		ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(containerWithMostWater.maxAreaBruteForce(height));
		System.out.println(containerWithMostWater.maxArea(height));
	}

	// Time complexity: O(n)^2
	// Space complexity: O(1)
	public int maxAreaBruteForce(int[] height) {
		int maxArea = 0;
		int n = height.length;

		// try all pairs i, j
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int width = j - i;
				int h = Math.min(height[i], height[j]);
				int area = width * h;
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}

		return maxArea;
	}

	// Time complexity: O(n)
	// Space complexity: O(1)
	public int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int width = right - left;
			int h = Math.min(height[left], height[right]);
			int area = width * h;
			if (area > maxArea) {
				maxArea = area;
			}

			// Move the pointer pointing to the shorter wall
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}
}
