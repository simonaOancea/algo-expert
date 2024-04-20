package leetcode.dynamicprogramming;

public class ClimbingStairs {
	public static void main(String[] args) {
		int n = 5;

		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.climbStairs(5));
	}
	// Time complexity is O(2^n) because of the recursion
	// Space complexity is O(n) because the depth of the recursion tree can go up to n
	public int climbStairs(int n) {
		return climb_Stairs(0, n);
	}

	public int climb_Stairs(int i, int n) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
	}
}
