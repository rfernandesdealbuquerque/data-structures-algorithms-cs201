
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author YOUR NAME HERE
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		int i = 0;
		for(int k=start; k<start+size; k++) {
			if(source.length <= k) { 
				myWords[i] = "";
			}
			else myWords[i] = source[k];
			
			i++;
		}
		myToString = null;
		myHash = 0;

	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param other
	 * @return
	 */
	@Override
	public boolean equals(Object other) {
		if (! (other instanceof WordGram) || other == null){
			return false;
		}
		
		WordGram wg = (WordGram) other;
		// TODO: Complete this method
		if(this.toString().equals(other.toString())) return true;
		else return false;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method: assign to myHash as needed
		if(myHash == 0) {
			myHash = toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,1,myWords.length);
		wg.myWords[wg.length()-1] = last;
		// TODO: Complete this method

		return wg;
	}

	@Override
	public String toString(){
		if(myToString == null) {
			myToString = String.join(" ", myWords);
		}
		
		return myToString;
	}
}
