package test.apt3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt3.PrefixCode;

public class PrefixCodeTest {
	
	PrefixCode prefixCode = new PrefixCode();
	@Test
	public void test1IsOne() {
		String[] words = {"10001", "011", "100", "001", "10"};
		String actual = prefixCode.isOne(words);
		String expected = "No, 2";
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void test2IsOne() {
		String[] words = {"no", "nosy", "neighbors", "needed"};
		String actual = prefixCode.isOne(words);
		String expected = "No, 0";
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void test3IsOne() {
		String[] words = {"1010", "11", "100", "0", "1011"};
		String actual = prefixCode.isOne(words);
		String expected = "Yes";
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void test4IsOne() {
		String[] words = {"No", "not"};
		String actual = prefixCode.isOne(words);
		String expected = "Yes";
		Assertions.assertEquals(expected, actual);
		
	}
	

}
