package test.leetcode.graphs;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

import leetcode.graphs.CourseSchedule;

public class CourseScheduleTest {

	@Test
	public void CanFinish_AllCoursesCanBeFinished_ReturnsTrue() {
		CourseSchedule courseSchedule = new CourseSchedule();

		int numCourses = 4;
		int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};

		boolean result = courseSchedule.canFinish(numCourses, prerequisites);

		assertTrue(result);
	}

	@Test
	public void CanFinish_CycleInPrerequisites_ReturnsFalse() {
		CourseSchedule courseSchedule = new CourseSchedule();

		int numCourses = 4;
		int[][] prerequisites = {{1, 0}, {2, 1}, {0, 2}};

		boolean result = courseSchedule.canFinish(numCourses, prerequisites);

		assertFalse(result);
	}

	@Test
	public void CanFinish_NoPrerequisites_ReturnsTrue() {
		CourseSchedule courseSchedule = new CourseSchedule();

		int numCourses = 4;
		int[][] prerequisites = {};

		boolean result = courseSchedule.canFinish(numCourses, prerequisites);

		assertTrue(result);
	}
}
