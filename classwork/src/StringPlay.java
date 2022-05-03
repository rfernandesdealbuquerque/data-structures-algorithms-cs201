
public class StringPlay {
	
	/**
	 * Create s+s+s+ ...+s and return it
	 * @param s is the string to be repeated
	 * @param reps is the number of times to repeat s
	 * @return sssss....ss (there are reps s's
	 */
	public static String concat(String s,
								int reps) {
		String ret = "";
		for(int k=0; k < reps; k++) {
			ret = ret + s;
		}
		return ret;
	}
	
	/**
	 * Create s+s+s+ ...+s and return it, uses StringBuilder internally 
	 * @param s is the string to be repeated
	 * @param reps is the number of times to repeat s
	 * @return sssss....ss (there are reps s's
	 */
	public static
	String builderConcat(String s, int reps) {
		StringBuilder ret = new StringBuilder();
		for(int k=0; k < reps; k++) {
			ret.append(s);
		}
		return ret.toString();
	}
	 
	public static void main(String[] args) {

		String source = "hello";
		int first = 10000;
		int last = 200000;
		int incr = 10000;

		System.out.println("size\tstring\tsize\tbuilder");
		for(int k=first; k <= last; k += incr) {
			double start = System.nanoTime();
			String ss = concat(source, k);
			double end = System.nanoTime();
			double stringTime = (end-start)/1e9;
			System.out.printf("%d\t%1.2f\t",
					ss.length(),
					stringTime);
			start = System.nanoTime();
			String bs = builderConcat(source, k);
			end = System.nanoTime();
			double buildTime = (end-start)/1e9;
			System.out.printf("\t%d\t%1.3f\n",
					          bs.length(),buildTime);
		}
	}
}
