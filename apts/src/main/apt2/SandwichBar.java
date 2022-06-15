package main.apt2;

public class SandwichBar {
	public int whichOrder(String[] available, String[] orders) {
		int ret = -1;
		
		for (int i = 0; i<orders.length; i++) {
			if(canMake(orders[i], available)) {
				return i;
			}
		}
	
		return ret;  
	}


public boolean canMake(String sandwich, String[] available) {
	for(String ingredient : available) {
		if(!sandwich.contains(ingredient)) {
			return false;
		}
	}
	
	return true;
	}
}
