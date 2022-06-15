package main.apt2;

public class DNAMaxNucleotide {
	public String max(String[] strands, String nuc) {
		String ret = "";
		int maxSeen = 0;
		
		for (String strand : strands) {
			int count = count(strand, nuc);
			if(count > maxSeen) {
				maxSeen = count;
				ret = strand;
			}
			
			else if(count == maxSeen && strand.length()>ret.length()) {
				maxSeen = count;
				ret = strand;
			}
			
		}
		
		return ret;
	}
	
	public int count(String strand, String nuc) {
		int count = 0;
		for(char ch : strand.toCharArray()) {
			if(ch == nuc.charAt(0)) {
				count += 1;
			}
			
		}
		return count;
	}
	
	

}
