package main.apt4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MemberCheck {
	public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
		HashSet<String> club1Set = new HashSet<String>();
		HashSet<String> club2Set = new HashSet<String>();
		HashSet<String> club3Set = new HashSet<String>();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(String name : club1) {
			club1Set.add(name);
		}
		for(String name : club2) {
			club2Set.add(name);
		}
		for(String name : club3) {
			club3Set.add(name);
		}
		
		for(String name : club1Set) {
			map.putIfAbsent(name, 1);
		}
		
		for(String name : club2Set) {
			if(map.containsKey(name)) {
				map.put(name, 2);
			}
			else {
				map.put(name, 1);
			}
		}
		for (String name : club3Set) {
			if(map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
		}
			else {
				map.put(name, 1);
			}
		}
		LinkedList<String> preRet = new LinkedList<String>();
		for(String key : map.keySet()) {
			if(map.get(key)>=2) {
				preRet.add(key);
			}
		}
		Collections.sort(preRet);
		String[] ret = new String[preRet.size()];
		for(int i = 0; i<ret.length; i++) {
			ret[i] = preRet.get(i);
		}
		
		return ret;
	}

}
