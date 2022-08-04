package main.apt4;

import java.util.HashMap;

public class Anonymous {
	public int howMany(String[] headlines, String[] messages) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int ret = messages.length;
		
		for(String headline : headlines) {
			String headlineNoSpaces = headline.replaceAll(" ", "").toLowerCase();
			String[] headlineLetters = headlineNoSpaces.split("");
			for(String letter : headlineLetters) {
				if(!map.containsKey(letter)) {
					map.put(letter, 1);
				}
				else {
					map.put(letter, map.get(letter) + 1);
				}
			}
		}
		
		for(String message : messages) {
			String messageNoSpaces = message.replaceAll(" ", "").toLowerCase();
			String[] messageLetters = messageNoSpaces.split("");
			HashMap<String, Integer> copyOfMap = new HashMap<String, Integer>(map);
			if(messageNoSpaces.equals("")) {
				break;
			}
			for(String letter : messageLetters) {
				if(copyOfMap.containsKey(letter) && copyOfMap.get(letter)>0) {
					copyOfMap.put(letter, copyOfMap.get(letter) - 1);
				}
				else {
					ret = ret - 1;
					break;
				}
			}
		}
		
		return ret;
	}

}
