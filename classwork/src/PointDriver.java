import java.util.*;

public class PointDriver {
	
	public static void main(String[] args) {
		
		int size = 10;
		int max = 2;
		Point[] array = PointGenerator.getRandomPointsInt(size, max);
		ArrayList<Point> list = new ArrayList<>();
		HashSet<Point> set = new HashSet<>();

		for(Point p : array) {
			set.add(p);
			list.add(p);
            
		}
		System.out.printf("array = %d, list = %d\n",array.length, list.size());
		System.out.printf("array = %d, set = %d\n",array.length, set.size());
		//for(Point p : list) {
			//System.out.println(p);
		//}
	}
}
