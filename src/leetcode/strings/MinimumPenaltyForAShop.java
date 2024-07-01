package leetcode.strings;

public class MinimumPenaltyForAShop {
	public static void main(String[] args) {
		MinimumPenaltyForAShop minimumPenaltyForAShop = new MinimumPenaltyForAShop();
		System.out.println(minimumPenaltyForAShop.bestClosingTime("YYNY"));
	}
	// Time complexity: O(n)
	// Space complexity: O(1)
	public int bestClosingTime(String customers) {
		int currentPenalty = (int) customers.chars().filter(c -> c == 'Y').count();
		int minPenalty = currentPenalty;
		int earliestHour = 0;

		for (int i = 0; i < customers.length(); i++) {
			currentPenalty += customers.charAt(i) == 'Y' ? -1 : 1;

			if (currentPenalty < minPenalty) {
				earliestHour = i + 1;
				minPenalty = currentPenalty;
			}
		}

		return earliestHour;
	}
}
