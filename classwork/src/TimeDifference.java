import java.util.ArrayList;
import java.util.List;

public class TimeDifference {
	public static int algorithm1(long n) {
		int sum = 0;
		List<String> list = new ArrayList<String>();
		//2n+1 operations
		for(long i=0;i<n;i++) {
			list.add("oi");
		}
		for(long i=0;i<n;i++) {
			list.add("oi");
		}
		list.add("oi");
		
		return sum;
		
	}
	
	public static int algorithm2(long n) {
		int sum=0;
		List<String> list = new ArrayList<String>();
		//3n operations
		for(long i=0;i<n;i++) {
			list.add("oi");
		}
		for(long i=0;i<n;i++) {
			list.add("oi");
		}
		for(long i=0;i<n;i++) {
			list.add("oi");
		}
		return sum;
		
	}
	
	public static void main(String[] args) {
		int n = 1000000;
		
		for(long i= 100; i<n; i=i+100) {
			double start= System.nanoTime();
			int result = algorithm1(i);
			double end = System.nanoTime();
			double time1 = (end-start)/1e9;
			//System.out.printf("Algorithm 1 - size: %d - time: %f\n", i, time1);
			
			start = System.nanoTime();
			result = algorithm2(i);
			end = System.nanoTime();
			double time2 = (end-start)/1e9;
			//System.out.printf("Algorithm 2 - size: %d - time: %f\n", i, time2);
			double timeDiff = time2 - time1;
			System.out.printf("size: %d - timeDiff: %f\n", i, timeDiff);
		}
		
	}

}
