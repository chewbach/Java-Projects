package homework7;




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
	protected void test(int selected_algorithm) {
		
		
		switch(selected_algorithm) {
		
		case 1:
			System.out.println("String with myMap");
			printMap();
			System.out.println("\n\n");
			mergeSort mergeSorter = new mergeSort(this);
		    mergeSorter.sort();
		    System.out.println("String with mergeSort");
		    mergeSorter.printSortedMap();
		    break;
		    
		case 2:
			System.out.println("String with myMap");
			printMap();
			System.out.println("\n\n");
			selectionSort selectionSorter = new selectionSort(this);
		    selectionSorter.sort();
		    System.out.println("String with selectionSort");
		    selectionSorter.printSortedMap();
		    break;
		    
		case 3:
			System.out.println("String with myMap");
			printMap();
			System.out.println("\n\n");
			insertionSort insertionSorter = new insertionSort(this);
		    insertionSorter.sort();
		    System.out.println("String with insertionSort");
		    insertionSorter.printSortedMap();
		    break;
		    
		case 4:
			System.out.println("String with myMap");
			printMap();
			System.out.println("\n\n");
			bubbleSort bubbleSorter = new bubbleSort(this);
		    bubbleSorter.sort();
		    System.out.println("String with bubbleSort");
		    bubbleSorter.printSortedMap();
		    break;
		    
		case 5:
			System.out.println("String with myMap");
			printMap();
			System.out.println("\n\n");
			quickSort quickSorter = new quickSort(this);
		    quickSorter.sort();
		    System.out.println("String with quickSort");
		    quickSorter.printSortedMap();
		    break;
		    
		case 6:
			System.out.println("String with myMap");
			printMap();
			System.out.println("\n\n");
			mergeSort ms = new mergeSort(this);
		    ms.sort();
		    System.out.println("String with mergeSort");
		    ms.printSortedMap();
		    selectionSort ss = new selectionSort(this);
		    ss.sort();
		    System.out.println("String with selectionSort");
		    ss.printSortedMap();
		    insertionSort is = new insertionSort(this);
		    is.sort();
		    System.out.println("String with insertionSort");
		    is.printSortedMap();
		    bubbleSort bs = new bubbleSort(this);
		    bs.sort();
		    System.out.println("String with bubbleSort");
		    bs.printSortedMap();
		    quickSort qs = new quickSort(this);
		    qs.sort();
		    System.out.println("String with quickSort");
		    qs.printSortedMap();
		    break;
		 default:
			 System.exit(0);
			 break;
		}
		
		System.out.print("\n\n");
	}
		
}
