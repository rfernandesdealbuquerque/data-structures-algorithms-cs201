import java.util.*;
import java.io.*;

public class Prefix {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("/data/wordslower.txt"));
		Map<String, ArrayList<String>> map =
				new HashMap<>();
		int max = 0;
		String maxs = "";
		while (scan.hasNext()) {
			String s = scan.next();
			if (s.length() >= 3) {
				String prefix = s.substring(0, 3);
				if (! map.containsKey(prefix)) {
					map.put(prefix, new ArrayList<>());
				}
				map.get(prefix).add(s);
				int len = map.get(prefix).size();
				if (len > max) {
					max = len;
					maxs = prefix;
				}
			}
		}
		for (String s : map.get(maxs)) {
			System.out.println(s);
		}
		System.out.printf("total = %d\n", max);
	}
}