import java.util.*;

public class RandomSet {

    private Random myRandom = new Random();

    public <T> T getRandomA(Set<T> set) {
        ArrayList<T> list = new ArrayList<>(set);
        Collections.shuffle(list);
        return list.get(0);
    }

    public <T> T getRandomB(Set<T> set) {
        int limit = myRandom.nextInt(set.size());
        for(T value : set) {
            if (limit == 0) {
                return value;
            }
            limit -= 1;
        }
        return null; // never reached
    }
    public <T> T getRandomC(Set<T> set) {
        int count = 1;
        for(T value : set) {
            if (Math.random() <= count*1.0/set.size()) {
                return value;
            }
            count += 1;
        }
        return null; //  never reached
    }

    public void run(){
        Set<String> set = new HashSet<>(Set.of("a", "b", "c", "d"));
        String r = getRandomA(set);
        System.out.println(r);
        r = getRandomB(set);
        System.out.println(r);
        r = getRandomC(set);
        System.out.println(r);
    }
    public static void main(String[] args) {
        RandomSet rs = new RandomSet();
        rs.run();
    }
}
