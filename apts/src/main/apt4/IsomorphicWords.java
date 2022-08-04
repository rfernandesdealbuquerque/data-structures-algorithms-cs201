package main.apt4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class IsomorphicWords {
	public int countPairs(String [] words) {
		ArrayList<String[]> isomorphicWords = new ArrayList<String[]>();
		int isomorphic = 0;
		
		for (int i = 0; i < words.length; i++) {
			String [] wordRootLetters = words[i].split("");
			for(int j=i+1; j < words.length; j++) {
				String [] wordCurrLetters = words[j].split("");
				HashMap<String, String> letterMappings = new HashMap<String, String>();
		
				for(int k=0; k<wordRootLetters.length; k++) {
					String rootLetter = wordRootLetters[k];
					String currLetter = wordCurrLetters[k];
					
					if(letterMappings.containsKey(rootLetter)) {
						if(!letterMappings.get(rootLetter).equals(currLetter)) {
							break;
						}
					}
					
					HashSet <String> set = new HashSet<String>(letterMappings.values());
					if(!letterMappings.containsKey(rootLetter) && set.contains(currLetter)) {
						break;
					}
					else {
						letterMappings.put(rootLetter, currLetter);
					}
					
					if(k == wordRootLetters.length - 1) {
						String[] isomorphicPair = new String[2];
						isomorphicPair[0] = words[i];
						isomorphicPair[1] = words[j];
						isomorphicWords.add(isomorphicPair);
						isomorphic +=1;
					}
				}
			}
		}
		
		StringBuilder pairs = new StringBuilder("");
		for(String[] pair : isomorphicWords) {
			pairs.append(Arrays.toString(pair));
			pairs.append(", ");
		}
		System.out.println("Isomorphic Pairs: " + pairs.toString().substring(0,pairs.length()-2));
		return isomorphic;
	}
}
