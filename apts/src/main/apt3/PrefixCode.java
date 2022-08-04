package main.apt3;

public class PrefixCode {
	public String isOne(String[] words) {
		
		int index = 0;
		boolean isOne = true;
		for (int i = 0; i<words.length; i++) {
			int count = 0;
			for(int k = 0; k<words.length; k++) {
				String word = words[i].length()>words[k].length() ? words[k] : words[k].substring(0, words[i].length());
				if(word.contains(words[i])) {
					count += 1;
				}
			}
			if(count > 1) {
				index = i;
				isOne = false;
				break;
			}
			
		}
		
		if(isOne) {
			return "Yes";
		}
		else {
			return "No, " + index;
		}
	}

}
