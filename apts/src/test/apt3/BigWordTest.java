package test.apt3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt3.BigWord;

public class BigWordTest {
	
	BigWord bigWord = new BigWord();
	
	@Test
	public void test1Most() {
		String[] sentences = {"one fish two", "fish red fish blue", "fish this fish is black"};
		String actual = bigWord.most(sentences);
		String expected = "fish";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test2Most() {
		String[] sentences = {"big bad dog", "big bad toy", "big bad cat", "small bad cat"};
		String actual = bigWord.most(sentences);
		String expected = "bad";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test3Most() {
		String[] sentences = {"This is the way", "This is the way", "this is this"};
		String actual = bigWord.most(sentences);
		String expected = "this";
		Assertions.assertEquals(expected, actual);
	}

}
