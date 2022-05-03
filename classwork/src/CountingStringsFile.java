import java.util.*;
import java.io.*;

public class CountingStringsFile {
	
	private static int HTABLE_SIZE = 5000;
	
	public List<String> readFile(String filename) throws FileNotFoundException {
		ArrayList<String> list = new ArrayList<>();
		Scanner scan = new Scanner(new File(filename));
		while (scan.hasNext()) {
			String s = scan.next().toLowerCase();
			list.add(s);
		}
		scan.close();
		return list;
	}

	public String parallelArraysMax(List<String> list) {
		ArrayList<String> words = new ArrayList<>();
		ArrayList<Integer> counter = new ArrayList<>();
		System.gc();
		for(String w : list) {
			int index = words.indexOf(w);			
			if (index == -1){
				words.add(w);
				counter.add(1);
			}
			else {
				counter.set(index, counter.get(index) + 1);   // already found, increment count
			}
		}
		
		// find largest # occurrences and retain value and string
		int max = 0;
		String maxString = "";
		for(int k=0; k < counter.size(); k += 1){
			if (counter.get(k) > max) {
				max = counter.get(k);
				maxString = words.get(k);
			}
		}
		return maxString+":"+max;
	}
	
	private class Pair {
		String myString;
		int myCount;
		Pair(String s) {
			myString = s;
			myCount = 1;
		}
		
		@Override
		public int hashCode() {
			return myString.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			Pair p = (Pair) o;
			return p.myString.equals(myString);
		}
	}

	public String hashMax(List<String> list) {
		ArrayList<ArrayList<Pair>> hash = new ArrayList<>();
		for(int k=0; k < HTABLE_SIZE; k++) {
			hash.add(new ArrayList<>());
		}
		for(String s : list) {
			Pair p = new Pair(s);
			int hval = Math.abs(p.hashCode()) % hash.size();
			int index = hash.get(hval).indexOf(p);
			if (index == -1) {
				hash.get(hval).add(p);
			}
			else {
				hash.get(hval).get(index).myCount += 1;
			}
		}
		
		// find max
		String maxString = "";
		int max = 0;
		for(ArrayList<Pair> locker : hash) {
			for(Pair p : locker) {
				if (p.myCount > max) {
					max = p.myCount;
					maxString = p.myString;
				}
			}
		}
		return maxString + ":" + max;
	}
	
	public String hashMapMax(List<String> list) {
		HashMap<String,Integer> map = new HashMap<>();
		System.gc();
		for(String w : list) {
			map.putIfAbsent(w, 0);
			map.put(w, map.get(w) + 1);
		}
		int max = Collections.max(map.values());
		String maxString = null;
		for(String word : map.keySet()) {
			if (map.get(word) == max) {
				maxString = word;
				break;
			}
		}
		return maxString+":"+max;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		CountingStringsFile csf = new CountingStringsFile();
		String fname = "data/hawthorne.txt";
		double start = System.nanoTime();
		List<String> list = csf.readFile(fname);
		double end = System.nanoTime();
		double time = (end-start)/1e9;
		
		System.out.printf("%2.3g time for reading %d words\n", time,list.size());
		start = System.nanoTime();
		String max1 = csf.parallelArraysMax(list);
		end = System.nanoTime();
		time = (end-start)/1e9;
		System.out.printf("time = %2.3g, max = %s\n",time,max1);
		
		start = System.nanoTime();
		String max2 = csf.hashMax(list);
		end = System.nanoTime();
		time = (end-start)/1e9;
		System.out.printf("time = %2.3g, max = %s\n",time,max2);
		
		start = System.nanoTime();
		String max3 = csf.hashMapMax(list);
		end = System.nanoTime();
		time = (end-start)/1e9;
		System.out.printf("time = %2.3g, max = %s\n",time,max3);
	}
}
