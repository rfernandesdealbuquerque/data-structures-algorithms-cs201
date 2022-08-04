package test.apt4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt4.Encryption;

public class EncryptionTest {
	
	Encryption encryption = new Encryption();

	@Test
	public void test1Encrypt() {
		String message = "topcoder";
		String actual = encryption.encrypt(message);
		String expected = "abcdbefg";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test2Encrypt() {
		String message = "encryption";
		String actual = encryption.encrypt(message);
		String expected = "abcdefghib";
		Assertions.assertEquals(expected, actual);
	}

}
