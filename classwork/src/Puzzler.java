import java.io.*;
import java.util.*;

public class Puzzler {
    HashSet<String> myWords;
    int myCount;
    public Puzzler(){
        myWords = new HashSet<>();

        File f = new File("/data/wordslower.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {
            myWords.add(s.next());
        }
    }
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }

    public void puzzleThis(String word) {
        char[] a = word.toCharArray();
        char[] vs = {'a','e','i','o','u'};
        for(int k=0; k < a.length; k++) {
            char ch = a[k];
            if (! isVowel(ch)) {
                for(char v : vs) {
                    a[k] = v;
                    String s = new String(a);
                    if (myWords.contains(s)) {
                        myCount++;
                        System.out.printf("%s,%s\n",word,s);
                    }
                }
            }
            a[k] = ch;
        }
    }

    public static void main(String[] args) {
        Puzzler p = new Puzzler();
        for(String s : p.myWords) {
            p.puzzleThis(s);
        }
        System.out.printf("total = %d\n",p.myCount);
    }

}
