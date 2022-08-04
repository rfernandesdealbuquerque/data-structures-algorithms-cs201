package main.apt2;

import java.util.ArrayList;
import java.util.Arrays;

public class Common {
	public int count(String a, String b) {
		
		int count = 0;
		ArrayList<Character> StringA = new ArrayList<Character>();
		for (char ch : a.toCharArray()) {
			StringA.add(ch);
		}
		ArrayList<Character> StringB = new ArrayList<Character>();
		for (char ch : b.toCharArray()) {
			StringB.add(ch);
		}
		
		for (int k = 0; k<StringA.size(); ) {
			Character ch = StringA.get(k);
			if(StringB.contains(ch)) {
				StringB.remove(ch);
				StringA.remove(ch);
				count += 1;
				continue;
			}
			k++;
			
		}
		
		return count;
	}

}
