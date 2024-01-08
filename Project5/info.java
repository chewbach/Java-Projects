package homework7;



/**

The Info class stores information about a collection of words, including the count of keys
and the words themselves. It provides methods to retrieve the count and words, as well as a
method to add a new word to the collection.
*/
public class info {
	
	private int count;
	private String[] words;
	
	/**
	@return the count of words
	*/
	
	protected int getCount() {
		return count;
	}
	
	/**
	@return an array of the words
	*/
	
	protected String[] getWords() {
		return words;
	}

	/**
	Constructs an empty Info object with a count of 0 and an empty array of words.
	*/
	protected info() {
		this.count = 0;
		this.words = new String[this.count];
	}
	
	
	/**
	Adds a new word to the collection.
	@param word the word to be added
	*/
	protected void push(String word) {
		
		String[] newWords = new String[count+1];
		for (int i = 0; i < count; i++) {
            newWords[i] = words[i];
        }
		newWords[count] = word;
		this.words = newWords;
		this.count++;
	}

}
