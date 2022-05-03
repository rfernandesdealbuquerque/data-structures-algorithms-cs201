import java.util.*;
import java.io.*;
import java.net.*;

public class MapWordCounter {
    public static void main(String[] args) throws IOException {
        String fname = "data/bondage.txt";
        String urlName = "https://www2.cs.duke.edu/csed/data/hawthorne.txt";
        InputStream buff = new BufferedInputStream(new URL(urlName).openStream());
        //Scanner scan = new Scanner(new File(fname));
        Scanner scan = new Scanner(buff);

        HashMap<String,Integer> map = new HashMap<>();

        while (scan.hasNext()) {
            String s = scan.next().toLowerCase();
            map.putIfAbsent(s,0);
            map.put(s, map.get(s) + 1);
        }

        for(String s : map.keySet()) {
            int value = map.get(s);
            if (value > 2000) {
                System.out.printf("%-10s %5d\n", s,value);
            }
        }
    }
}
