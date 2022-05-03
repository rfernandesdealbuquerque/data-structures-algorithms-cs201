import java.io.*;
import java.util.*;

public class UniqueWithArrayList {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("data/kjv10.txt"));
        ArrayList<String> set = new ArrayList<>();
        int wcount = 0;
        double start = System.nanoTime();

        while (s.hasNext()) {
            wcount += 1;
            String word = s.next();
        }
        double end = System.nanoTime();
        double time = (end-start)/1e9;
        System.out.printf("total #: %d, unique #: %d\n",
                wcount, set.size());
        System.out.printf("time: %2.3g\n", time);
        s.close();
    }
}
