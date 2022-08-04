package test.apt4;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt4.Anonymous;

public class AnonymousTest {
	
	Anonymous anonymous = new Anonymous();

	@Test
	public void test1HowMany() {
		String[] messages = {"Give me my money back", "I am the best coder", "TOPCODER"};
		String[] headlines = {"Earthquake in San Francisco", "Burglary at musuem in Sweden", "Poverty"};
		int expected = 2;
		int actual = anonymous.howMany(headlines, messages);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test2HowMany() {
		String[] messages = {"AaBbCc","aabbbcc","   ","FADE"};
		String[] headlines = {"abcdef","abcdef"};
		int expected = 3;
		int actual = anonymous.howMany(headlines, messages);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test3HowMany() {
		String[] messages = {"program","programmer","gaming","sing","NO FUN"};
		String[] headlines = {"Programming is fun"};
		int expected = 4;
		int actual = anonymous.howMany(headlines, messages);
		Assertions.assertEquals(expected, actual);
	}

}
