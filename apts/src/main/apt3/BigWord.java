package main.apt3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BigWord {
	public String most(String [] sentences) {
		
		ArrayList<String> words = new ArrayList<String>();
		for (String sentence : sentences) {
			String[] temp = sentence.toLowerCase().split(" ");
			words.addAll(Arrays.asList(temp));
		}
		
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		
		for (String word : words) {
			if(!wordCount.containsKey(word)) {
				wordCount.put(word, 1);
			}
			
			else {
				wordCount.put(word, wordCount.get(word) + 1);
			}
		}
		
		int maxCount = 0;
		String most = null;
		for (String word : wordCount.keySet()) {
			int count = wordCount.get(word);
			if(count>maxCount) {
				maxCount = count;
				most = word;
			}
		}

		return most;
	}

}
