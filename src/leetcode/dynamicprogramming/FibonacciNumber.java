package leetcode.dynamicprogramming;
// Time Complexity: O(N)
// Space Complexity: O(N)

public class FibonacciNumber {
	public static void main(String[] args) {
		FibonacciNumber fibonacciNumber = new FibonacciNumber();
		System.out.println(fibonacciNumber.fib(4));
	}

	public int fib(int n) {
		if (n <= 1) {
			return n;
		}

		int[] cache = new int[n + 1];
		cache[1] = 1;
		for (int i = 2; i <= n; i++) {
			cache[i] = cache[i - 1] + cache[i -2];
		}

		return cache[n];
	}
}
