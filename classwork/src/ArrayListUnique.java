import java.util.*;
import java.io.*;

/**
 * @author Owen Astrachan
 * compare methods for filtering a list of strings/words
 * and returning a sorted list of the unique strings/words
 */
public class ArrayListUnique {
	
	public static ArrayList<String> methodA(ArrayList<String> list) {
		ArrayList<String> ret = new ArrayList<>();
		for(String s : list) {
			boolean done = false;
			for(int k=0; k < ret.size(); k += 1) {
				String current = ret.get(k);
				if (current.equals(s)) {
					done = true;
					break;  // break out of loop looking at ret
				}
				if (current.compareTo(s) > 0) {
					ret.add(k,s);
					done = true;
					break;
				}
			}
			if (! done) {
				ret.add(s);   // add at end, greater than all so far
			}
		}	
		return ret;
	}
	
	public static ArrayList<String> methodB(ArrayList<String> list) {
		ArrayList<String> copy = new ArrayList<>(list);
		Collections.sort(copy);
		ArrayList<String> ret = new ArrayList<>();
		ret.add(copy.get(0));
		for(int k=1; k < copy.size(); k += 1) {
			String current = copy.get(k);
			if (! current.equals(ret.get(ret.size()-1))) {
				ret.add(current);
			}
		}
		return ret;
	}

	public static ArrayList<String> methodC(ArrayList<String> list) {
		ArrayList<String> ret = new ArrayList<>();
		for(String s : list) {
			int loc = Collections.binarySearch(ret,s);
			if (loc < 0) {
				loc = -(loc + 1);
				ret.add(loc,s);
			}
		}
		return ret;
	}

	public static ArrayList<String> methodD(ArrayList<String> list) {
		TreeSet<String> set = new TreeSet<>(list);
		ArrayList<String> ret = new ArrayList<>(set);
		return ret;
	}

	
	public static boolean inOrder(ArrayList<String> list) {
		for(int k=0; k < list.size()-1; k += 1) {
			if (list.get(k).compareTo(list.get(k+1)) > 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s =
				new Scanner(new File("data/hawthorne.txt"));
		ArrayList<String> list = new ArrayList<>();
	
		double start = System.nanoTime();
		while (s.hasNext()) {
			list.add(s.next().toLowerCase());
		}
		double end = System.nanoTime();
	    s.close();
		double time = (end-start)/1e9;

		System.out.printf("total: %d, time %2.3g\n", list.size(),time);

		start = System.nanoTime();
		ArrayList<String> sortedA = methodA(list);
		end = System.nanoTime();
		if (! inOrder(sortedA)) {
			System.out.println("resulting list not sorted");
		}
		time = (end-start)/1e9;
		System.out.printf("sorted size: %d, A time %2.3g\n", sortedA.size(),time);
		
		start = System.nanoTime();
		ArrayList<String> sortedB = methodB(list);
		end = System.nanoTime();
		if (! inOrder(sortedB)) {
			System.out.println("resulting list not sorted");
		}
		time = (end-start)/1e9;
		System.out.printf("sorted size: %d, B time %2.3g\n", sortedB.size(),time);

		start = System.nanoTime();
		ArrayList<String> sortedC = methodC(list);
		end = System.nanoTime();
		if (! inOrder(sortedC)) {
			System.out.println("resulting list not sorted");
		}
		time = (end-start)/1e9;
		System.out.printf("sorted size: %d, C time %2.3g\n", sortedC.size(),time);

		start = System.nanoTime();
		ArrayList<String> sortedD = methodD(list);
		end = System.nanoTime();
		if (! inOrder(sortedD)) {
			System.out.println("resulting list not sorted");
		}
		time = (end-start)/1e9;
		System.out.printf("sorted size: %d, D time %2.3g\n", sortedD.size(),time);
 
	}
}
