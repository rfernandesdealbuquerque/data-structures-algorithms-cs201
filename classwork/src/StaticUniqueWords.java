import java.util.*;
import java.io.*;
import java.net.*;


public class StaticUniqueWords {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("data/quran.txt"));
        URL url = new URL("https://www.cs.duke.edu/csed/data/quran.txt");
        s = new Scanner(new BufferedInputStream(url.openStream()));
        HashSet<String> set = new HashSet<>();
        int wcount = 0;
        double start = System.nanoTime();

        while (s.hasNext()) {
            wcount += 1;
            String word = s.next();
            set.add(word);
        }
        double end = System.nanoTime();
        double time = (end-start)/1e9;
        System.out.printf("total #: %d, unique #: %d\n",
                          wcount, set.size());
        System.out.printf("time: %2.3g\n", time);
        s.close();
    }
}
