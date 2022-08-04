package test.apt3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt3.TrueSpace;

public class TrueSpaceTest {
	
	TrueSpace trueSpace = new TrueSpace();

	@Test
	public void test1CalculateSpace() {
		int[] sizes = {4096, 33792, 76800};
		int clusterSize = 1024;
		long actual = trueSpace.calculateSpace(sizes, clusterSize);
		long expected = 114688;
		Assertions.assertEquals(expected, actual);

	}
	
	@Test
	public void test2CalculateSpace() {
		int[] sizes = {1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000, 1000000000, 1000000000,
				 1000000000, 1000000000};
		int clusterSize = 1048576;
		long actual = trueSpace.calculateSpace(sizes, clusterSize);
		long expected = 50017075200l;
		Assertions.assertEquals(expected, actual);

	}


}
