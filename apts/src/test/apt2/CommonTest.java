package test.apt2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt2.Common;

public class CommonTest {
	
	Common common = new Common();

	@Test
	public void test1Count() {
		String a = "horse";
		String b = "short";
		int actual = common.count(a, b);
		int expected = 4;
		Assertions.assertEquals(expected, actual);

	}
	
	@Test
	public void test2Count() {
		String a = "horse";
		String b = "seems";
		int actual = common.count(a, b);
		int expected = 2;
		Assertions.assertEquals(expected, actual);

	}
	
	@Test
	public void test3Count() {
		String a = "rodriigo";
		String b = "rodriiiigooooo";
		int actual = common.count(a, b);
		int expected = 8;
		Assertions.assertEquals(expected, actual);

	}


}
