package test.apt2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import main.apt2.SandwichBar;

public class SandwichBarTest {
	
	SandwichBar sandwichBar = new SandwichBar();

	@DisplayName("SandwichBarTest 1")
	@Test
	public void test1WhichOrder() {
		String[] available = { "cheese", "cheese", "cheese", "tomato" };
		String[] orders = { "ham ham ham", "water", "pork", "bread", "cheese tomato cheese", "beef" }; 
		int actual = sandwichBar.whichOrder(available, orders);
		int expected = 4;
		Assertions.assertEquals(expected, actual, "pass test 1");
	}
	
	@DisplayName("SandwichBarTest 2")
	@Test
	public void test2WhichOrder() {
		String[] available = { "foo", "bar", "baz", "gazonk", "quux", "bat", "xyzzy",
				  "shme", "hukarz", "grault", "waldo", "bleh" };
		String[] orders = { "kalatehas", "spam eggs", "needle haystack", "bleh blarg", "plugh", 
		  "the best sandwich in the universe" }; 
		int actual = sandwichBar.whichOrder(available, orders);
		int expected = -1;
		Assertions.assertEquals(expected, actual, "pass test 2");
	}

}
