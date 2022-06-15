package main.apt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
	
	public int pointsTotal(String[] player, String[] dictionary) {
		int totalPoints = 0;
		HashSet<String> noDuplicates = new HashSet<String>(Arrays.asList(player));
		ArrayList<String> dictionaryList = new ArrayList<String>(Arrays.asList(dictionary));
		
		for (String word: noDuplicates) {
			totalPoints += pointsWord(word, dictionaryList);
		}
		
		return totalPoints;
	}
	
	public int pointsWord(String word, ArrayList<String> dictionary) {
		int wordPoints = 0;
		if(dictionary.contains(word)) {
			wordPoints = word.length()*word.length();
		}
		return wordPoints;
	}

}
