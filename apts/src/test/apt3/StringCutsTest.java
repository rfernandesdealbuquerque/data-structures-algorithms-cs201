package test.apt3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt3.StringCuts;

public class StringCutsTest {
	
	StringCuts stringCuts = new StringCuts();

	@Test
	public void test1Filter() {
		String[] list = {"huge", "enormous", "big", "gigantic"};
		int minLength = 5;
		String[] expected = {"enormous", "gigantic"};
		String[] actual = stringCuts.filter(list, minLength);
		Assertions.assertArrayEquals(expected, actual);

	}
	
	@Test
	public void test2Filter() {
		String[] list = {"compsci", "is", "fun", "sometimes"};
		int minLength = 10;
		String[] expected = {};
		String[] actual = stringCuts.filter(list, minLength);
		Assertions.assertArrayEquals(expected, actual);

	}
	
	@Test
	public void test3Filter() {
		String[] list = {"over", "and", "over", "and", "over"};
		int minLength = 3;
		String[] expected = {"over", "and"};
		String[] actual = stringCuts.filter(list, minLength);
		Assertions.assertArrayEquals(expected, actual);

	}

}
