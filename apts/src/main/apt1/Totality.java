package main.apt1;

public class Totality {
	public int sum(int[] a, String stype) {
		
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (stype.equals("even") && i%2 == 0) {
				sum += a[i];
				
			}
			else if (stype.equals("odd") && i%2 == 1) {
				sum += a[i];
				
			}
		
		}
		
		
		return sum;
		
	}

}
