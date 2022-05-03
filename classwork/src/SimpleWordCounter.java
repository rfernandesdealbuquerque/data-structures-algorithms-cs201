import java.util.*;
import java.io.*;

public class SimpleWordCounter {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        String fname = "data/bondage.txt";
        Scanner scan = new Scanner(new File(fname));

        while (scan.hasNext()) {
            String s = scan.next().toLowerCase();
            int index = words.indexOf(s);
            if (index == -1){
                words.add(s);
                counts.add(1);
            }
            else {
                counts.set(index, counts.get(index) + 1);   // already found, increment count
            }
        }

        for(int k=0; k < words.size(); k++) {
            int value = counts.get(k);
            if (value > 2000) {
                System.out.printf("%-10s %5d\n", words.get(k),value);
            }
        }
    }
}
