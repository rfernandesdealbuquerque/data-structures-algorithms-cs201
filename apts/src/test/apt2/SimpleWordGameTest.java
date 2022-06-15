package test.apt2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt2.SimpleWordGame;

public class SimpleWordGameTest {
	
	SimpleWordGame simpleWordGame = new SimpleWordGame();
	
	
	@Test
	public void test1PointsTotal() {
		String[] player = { "apple", "orange", "strawberry" };
		String[] dictionary = { "strawberry", "orange", "grapefruit", "watermelon" };
		int expected = 136;
		int actual = simpleWordGame.pointsTotal(player, dictionary);
		Assertions.assertEquals(expected, actual);

	}
	
	@Test
	public void test2PointsTotal() {
		String[] player = { "lidi", "o", "lidi", "gnbewjzb", "kten",
				  "ebnelff", "gptsvqx", "rkauxq", "rkauxq", "kfkcdn"};
		String[] dictionary = { "nava", "wk", "kfkcdn", "lidi", "gptsvqx",
				  "ebnelff", "hgsppdezet", "ulf", "rkauxq", "wcicx"};
		int expected = 186;
		int actual = simpleWordGame.pointsTotal(player, dictionary);
		Assertions.assertEquals(expected, actual);

	
	}
}
