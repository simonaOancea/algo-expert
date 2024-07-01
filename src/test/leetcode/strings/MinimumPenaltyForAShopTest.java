package test.leetcode.strings;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import leetcode.strings.MinimumPenaltyForAShop;

public class MinimumPenaltyForAShopTest {

	@Test
	public void BestClosingTime_AllCustomersY_ReturnsEarliestHour() {
		MinimumPenaltyForAShop shop = new MinimumPenaltyForAShop();

		int result = shop.bestClosingTime("YYYY");

		assertEquals(4, result);
	}

	@Test
	public void BestClosingTime_AllCustomersN_ReturnsEarliestHour() {
		MinimumPenaltyForAShop shop = new MinimumPenaltyForAShop();

		int result = shop.bestClosingTime("NNNN");

		assertEquals(0, result);
	}

	@Test
	public void BestClosingTime_MixedCustomers_ReturnsEarliestHour() {
		MinimumPenaltyForAShop shop = new MinimumPenaltyForAShop();

		int result = shop.bestClosingTime("YYNY");

		assertEquals(2, result);
	}

}
