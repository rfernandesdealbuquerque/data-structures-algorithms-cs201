public class NewStringPlay {
    public static String concat(String s,
                                int reps) {
        String ret = s;
        for(int k=0; k < reps; k++) {
            ret = ret + ret;
        }
        return ret;
    }
    public static
    String builderConcat(String s, int reps) {
        StringBuilder ret = new StringBuilder(s);
        for(int k=0; k < reps; k++) {
            ret.append(ret);
        }
        return ret.toString();
    }
    public static void main(String[] args) {
        String source = "A";
        int first = 10;
        int last = 33;
        int incr = 1;

		System.out.println("size\tstring\tsize\tbuilder");
		for(int k=first; k <= last; k += incr) {
            double start = System.nanoTime();
            String ss = concat(source, k);
            double end = System.nanoTime();
            double stringTime = (end - start) / 1e9;
            System.out.printf("%d\t%1.2f\t",
                    ss.length(),
                    stringTime);
            start = System.nanoTime();
            String bs = ""; //builderConcat(source, k);
            end = System.nanoTime();
            double buildTime = (end - start) / 1e9;
            System.out.printf("\t%d\t%1.3f\n",
                    bs.length(), buildTime);
        }
    }
}
