public class Looper {
    public static void main(String[] args) {
        int x = 0;
        while ( x < x + 1) {
            x = x + 1;
        }
        // what is x??
        System.out.println("value of x = "+x);
        System.out.println("value of one more"+(x+1));
    }
}
