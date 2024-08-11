package test.playground;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.util.List;

import org.junit.Test;

import playground.CustomList;

public class CustomListTest {

	@Test
	public void givenEmptyList_whenIsEmpty_thenTrue() {
		List<Object> list = new CustomList<>();
		assertTrue(list.isEmpty());
	}

	@Test
	public void givenNonEmptyList_whenIsEmpty_thenFalse() {
		List<Object> list = new CustomList<>();
		list.add(null);

		assertFalse(list.isEmpty());
	}

	@Test
	public void givenListWithAnElement_whenSize_thenOneIsReturned() {
		List<Object> list = new CustomList<>();
		list.add(null);

		assertEquals(1,list.size());
	}

	@Test
	public void givenListWithAnElement_whenGet_thenThatElementIsReturned() {
		List<Object> list = new CustomList<>();
		list.add("baeldung");
		Object element = list.get(0);

		assertEquals("baeldung", element);
	}

	@Test
	public void givenEmptyList_whenElementIsAdded_thenGetReturnsThatElement() {
		List<Object> list = new CustomList<>();
		boolean succeeded = list.add(null);

		assertTrue(succeeded);
	}

	@Test
	public void givenListWithAnElement_whenAnotherIsAdded_thenGetReturnsBoth() {
		List<Object> list = new CustomList<>();
		list.add("str1");
		list.add("str2");
		Object element1 = list.get(0);
		Object element2 = list.get(1);

		assertEquals("str1", element1);
		assertEquals("str2", element2);
	}

}
