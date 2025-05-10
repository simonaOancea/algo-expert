package test.leetcode.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import arrays.ContainerWithMostWater;

public class ContainerWithMostWaterTest {

	private final ContainerWithMostWater testee = new ContainerWithMostWater();

	@Test
	public void testMinimalTwoLines() {
		assertEquals(1, testee.maxArea(new int[]{1, 1}));
	}

	@Test
	public void testWithZeroHeight() {
		assertEquals(0, testee.maxArea(new int[]{0, 2}));
		assertEquals(0, testee.maxArea(new int[]{0, 0, 0}));
	}

	@Test
	public void testIncreasingHeights() {
		assertEquals(6, testee.maxArea(new int[]{1, 2, 3, 4, 5}));
	}

	@Test
	public void testDecreasingHeights() {
		assertEquals(6, testee.maxArea(new int[]{5, 4, 3, 2, 1}));
	}

	@Test
	public void testSymmetricPeak() {
		assertEquals(8, testee.maxArea(new int[]{1, 4, 2, 4, 1}));
	}

	@Test
	public void testSampleLeetCode() {
		int[] heights = {1,8,6,2,5,4,8,3,7};

		assertEquals(49, testee.maxArea(heights));
	}

	@Test
	public void testAllEqualHeights() {
		assertEquals(25, testee.maxArea(new int[]{5,5,5,5,5,5}));
	}

	@Test
	public void testSinglePeak() {
		assertEquals(2, testee.maxArea(new int[]{1,3,2}));
	}

	@Test
	public void testRandomCase() {
		int[] h = {2,3,10,5,7,8,9};

		assertEquals(36, testee.maxArea(h));
	}

	@Test
	public void testLargeFlatAndSpike() {
		int[] h = {1,1,1,1,100,1,1};

		assertEquals(6, testee.maxArea(h));
	}
}
