package test.leetcode.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import arrays.MissingNumber;

public class MissingNumberTest {

	@Test
	public void testMissingNumber_SimpleCase() {
		int[] nums = {3, 0, 1};
		assertEquals(2, MissingNumber.missingNumber(nums));
	}

	@Test
	public void testMissingNumber_SingleElement() {
		int[] nums = {0};
		assertEquals(1, MissingNumber.missingNumber(nums));
	}

	@Test
	public void testMissingNumber_EmptyArray() {
		int[] nums = {};
		assertEquals(0, MissingNumber.missingNumber(nums));
	}

	@Test
	public void testMissingNumber_LargeArray() {
		int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		assertEquals(8, MissingNumber.missingNumber(nums));
	}

	@Test
	public void testMissingNumber_NoMissingNumber() {
		int[] nums = {0, 1, 2, 3};
		assertEquals(4, MissingNumber.missingNumber(nums));
	}
}
