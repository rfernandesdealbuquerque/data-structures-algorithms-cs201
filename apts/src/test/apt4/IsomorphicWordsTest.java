package test.apt4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt4.IsomorphicWords;

public class IsomorphicWordsTest {
	
	IsomorphicWords isomorphicWords = new IsomorphicWords();

	@Test
	public void test1CountPais() {
		String[] words = {"abca", "zbxz", "opqr"};
		int actual = isomorphicWords.countPairs(words);
		int expected = 1;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test2CountPais() {
		String[] words = {"aa", "ab", "bb", "cc", "cd"};
		int actual = isomorphicWords.countPairs(words);
		int expected = 4;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test3CountPais() {
		String[] words = { "cacccdaabc", "cdcccaddbc", "dcdddbccad", "bdbbbaddcb",
					  		"bdbcadbbdc", "abaadcbbda", "babcdabbac", "cacdbaccad",
					  		"dcddabccad", "cacccbaadb", "bbcdcbcbdd", "bcbadcbbca" };
		int actual = isomorphicWords.countPairs(words);
		int expected = 13;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test4CountPais() {
		String[] words = {"abrrf", "cdaah", "abfhb", "ghmnh", "fagha"};
		int actual = isomorphicWords.countPairs(words);
		int expected = 4;
		Assertions.assertEquals(expected, actual);
	}
	
	

}
