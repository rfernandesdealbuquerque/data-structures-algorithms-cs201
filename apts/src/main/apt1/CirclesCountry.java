package main.apt1;

public class CirclesCountry {
	
	public int lessBorders(int[] x, int[] y, int[] r,
							int x1, int y1, int x2, int y2) {
		
		int ret = 0;
		boolean point1Inside;
		boolean point2Inside;
		
		for (int i = 0; i<x.length; i++) {
			point1Inside = isInsideCircle(x[i], y[i], r[i], x1, y1);
			point2Inside = isInsideCircle(x[i], y[i], r[i], x2, y2);
			
			if(point1Inside ^ point2Inside) {
				ret +=1;
			}
			
		}
		
		return ret;
	};
	
	public boolean isInsideCircle(int xCircle, int yCircle, int rCircle, int x1, int y1) {
		
		boolean isInside = Math.pow((x1-xCircle),2) + Math.pow((y1-yCircle),2) <= rCircle*rCircle;
		
		return isInside;
				
		
	}
	
	
}
