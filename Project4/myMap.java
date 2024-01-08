package homework6;




import java.util.LinkedHashMap;

/**

This class represents a custom map implementation that stores the frequency of

letters in a given string and the words that contain each letter.
*/


public class myMap {
	private LinkedHashMap<String,info>map;
	private int mapSize;
	private String str;

	/**
	@return The size of the map.
	*/
	protected int getMapSize() { return mapSize;}
	
	/**
	Constructs a new no-parameter myMap object
	*/
	protected myMap() {
		this.map = new LinkedHashMap<>();
		this.str = "";
		this.mapSize = 0;
		buildMyMap();
	}
	/**
	Constructs a new myMap object with the specified string.
	@param str The string to store in the map.
	*/
	protected myMap(String str) {
	    
	     this.map = new LinkedHashMap<>();
	     this.str = str;
	     this.mapSize = 0;
	     buildMyMap();
	    
	}

	
	/**
	Builds the map by splitting the string into words and adding each letter and the words that contain it to the map.
	*/
	protected void buildMyMap() {
	    String[] strArr = str.split(" ");
	    for (String word : strArr) {
	        for (int i = 0; i < word.length(); i++) {
	            String letter = String.valueOf(word.charAt(i));
	            if (!map.containsKey(letter)) {
	                map.put(letter, new info());
	                mapSize++;
	            }
	            map.get(letter).push(word);
	        }
	    }
	}

	/**
	Prints the contents of the map to the console.
	*/
	protected void printMap() {
		for (String key : map.keySet()) {
            System.out.println(key + ": count = " + map.get(key).getCount() + ", words = [" + String.join(", ", map.get(key).getWords())+"]");
        }
	}
	
	/**
	@return The map.
	*/
	protected LinkedHashMap<String, info> getMap() {
	    return map;
	}
	
	/**
	Tests the myMap object by printing the contents of the map before and after sorting it using the merge sort algorithm.
	*/
	protected void test() {
		System.out.println("String with myMap");
		printMap();
		System.out.println("\n\n");
		mergeSort mergeSorter = new mergeSort(this);
	    mergeSorter.sort();
	    System.out.println("String with mergeSort");
	    mergeSorter.printSortedMap();
	}
		
}
