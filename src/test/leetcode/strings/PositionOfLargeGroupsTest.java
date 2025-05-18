package test.leetcode.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import leetcode.strings.PositionOfLargeGroups;

public class PositionOfLargeGroupsTest {

	@Test
	public void testLargeGroupPositionsMultipleMaxIntervals() {
		PositionOfLargeGroups testee = new PositionOfLargeGroups();
		String input = "abcdddeeeeaabbbcd";

		List<List<Integer>> expectedResult = new ArrayList<>();
		expectedResult.add(List.of(3, 5));
		expectedResult.add(List.of(6, 9));
		expectedResult.add(List.of(12, 14));

		List<List<Integer>> result = testee.largeGroupPositions(input);

		assert result.equals(expectedResult) : "Expected: " + expectedResult + ", but got: " + result;
	}

	@Test
	public void testLargeGroupPositionsMultipleNoMaxIntervals() {
		PositionOfLargeGroups testee = new PositionOfLargeGroups();
		String input = "abc";

		List<List<Integer>> expectedResult = Collections.emptyList();

		List<List<Integer>> result = testee.largeGroupPositions(input);

		assert result.equals(expectedResult) : String.format("Test failed for input '%s'. Expected: %s, but got: %s", input, expectedResult, result);
	}
}
