package main.apt3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class StringCuts {
	public String[] filter(String[] list, int minLength) {
		ArrayList<String> filteredList = new ArrayList<String>(Arrays.asList(list));
		
		for(int k = 0; k<filteredList.size();) {
			if(filteredList.get(k).length()<minLength) {
				filteredList.remove(k);
				continue;
			}
			k++;
		}
		
		//TreeSet<String> noDuplicates = new TreeSet<String>(filteredList);
		
		
		Collections.reverse(filteredList);
		for(int k = 0; k<filteredList.size();) {
			if(Collections.frequency(filteredList, filteredList.get(k))>=2) {
				filteredList.remove(k);
				continue;
			}
			k++;
		}
		Collections.reverse(filteredList);
		
		
		String[] ret = new String[filteredList.size()];
		
		for (int k = 0; k<ret.length; k++) {
			ret[k] = filteredList.get(k);
		}

		return ret;
		
		
	}

}
