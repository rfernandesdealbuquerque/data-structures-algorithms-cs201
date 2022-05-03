import java.util.*;

public class Removal {
    public static void safeRemove(HashSet<String> set) {
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.startsWith("a")) {
                iter.remove();
            }
        }
    }
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("apple");
        set.add("artist");
        set.add("banana");
        set.add("attic");
//        for(String s : set) {
//            if (s.startsWith("a")) {
//                set.remove(s);
//            }
//        }
        safeRemove(set);
        System.out.println(set);
    }
}
