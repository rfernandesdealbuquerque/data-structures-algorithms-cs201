package main.apt4;

public class SoccerLeagues {
	public int[] points(String[] matches) {
		int[] points = new int[matches.length];
//		for (int i=0; i<points.length; i++) {
			//points[i] = 0;
		//}
		
		for(int i=0; i<matches.length; i++) {
			String[] teamiMatches = matches[i].split("");
			for(int j=0; j<matches.length; j++) {
				if(teamiMatches[j].equals("W")) {
					points[i] += 3;
					points[j] += 0;
				}

				if(teamiMatches[j].equals("D")) {
					points[i] += 1;
					points[j] += 1;
				}
				
				if(teamiMatches[j].equals("L")) {
					points[i] += 0;
					points[j] += 3;
				}
				else continue;
			}
		}
		
		
		return points;
	}

}
