import java.io.PrintStream;
import java.util.Arrays;

public class GroupAnagrams {
	
	
	public static void main(String[] args) {
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		
		for(String s: input) {;
			System.out.println(removeQuotationMarks(s));
		}
		
	}
	
	
	
	private static String removeQuotationMarks(String s) {
		String[] word = s.split("");
		Arrays.sort(word);
		String ret = String.join("", word);
		
		return ret;
	}

}
