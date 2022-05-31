package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Totality;

public class TotalityTest {
	
	Totality totality = new Totality();
	
	@DisplayName("Totality Test")
	@Test
	public void sumTest() {
		int[] a = {1,2,3,4,5};
		String stype = "even";
		int sum = totality.sum(a, stype);
		Assertions.assertEquals(9, sum);
		
	}
	
}
