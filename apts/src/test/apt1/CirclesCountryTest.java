package test.apt1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.apt1.CirclesCountry;

class CirclesCountryTest {

	CirclesCountry circlesCountry = new CirclesCountry();
	
	@DisplayName("Circles Country Test 1")
	@Test
	void test1LessBorders() {
		int[] x = {0,-6,6};
		int[] y = {0,1,2};
		int[] r = {2,2,2};
		int x1 = -5;
		int y1 = 1;
		int x2 = 5;
		int y2 = 1;
		Assertions.assertEquals(2, circlesCountry.lessBorders(x, y, r, x1, y1, x2, y2), "pass test2");
	}
	
	@DisplayName("Circles Country Test 2")
	@Test
	void test2LessBorders() {
		int[] x = {1,-3,2,5,-4,12,12};
		int[] y = {1,-1,2,5,5,1,1};
		int[] r = {8,1,2,1,1,1,2};
		int x1 = -5;
		int y1 = 1;
		int x2 = 12;
		int y2 = 1;
		Assertions.assertEquals(3, circlesCountry.lessBorders(x, y, r, x1, y1, x2, y2), "pass test2");
	}
	
	@DisplayName("Circles Country Test 3")
	@Test
	void test3LessBorders() {
		int[] x = {-3,2,2,0,-4,12,12,12};
		int[] y = {-1,2,3,1,5,1,1,1};
		int[] r = {1,3,1,7,1,1,2,3};
		int x1 = 2;
		int y1 = 3;
		int x2 = 13;
		int y2 = 2;
		Assertions.assertEquals(5, circlesCountry.lessBorders(x, y, r, x1, y1, x2, y2), "pass test3");
	}
}
