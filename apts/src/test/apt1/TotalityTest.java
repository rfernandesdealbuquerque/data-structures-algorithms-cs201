package test.apt1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.apt1.Totality;

public class TotalityTest {
	
	Totality totality = new Totality();
	
	@DisplayName("Totality Test")
	@Test
	public void testSum() {
		int[] a = {1,2,3,4,5};
		String stype = "even";
		int sum = totality.sum(a, stype);
		Assertions.assertEquals(9, sum);
		
	}
	
}
