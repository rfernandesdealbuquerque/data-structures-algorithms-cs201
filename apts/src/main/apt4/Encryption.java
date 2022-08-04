package main.apt4;

import java.util.Arrays;
import java.util.HashMap;

public class Encryption {
	public String encrypt(String message) {
		HashMap<String, String> encodings = new HashMap<String, String>();
		String[] alphabet = new String[122-97+1];
		int a = 97;
		int z = 122;
		int k = 0;
		for(int i = 97; i<=122; i++) {
			alphabet[k] = Character.toString((char) i);
			k++;
		}
		int iter = 0;
		StringBuilder retBuilder = new StringBuilder();
		
		String [] messageLetters = message.split("");
		for(String letter : messageLetters) {
			if(!encodings.containsKey(letter)) {
				encodings.put(letter, alphabet[iter]);
				retBuilder.append(alphabet[iter]);
				iter++;
			}
			else {
				retBuilder.append(encodings.get(letter));
				
			}
		}
		
		String ret = retBuilder.toString();
		
		return ret;
		
	}

}
