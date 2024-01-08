package homework6;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		 	try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter a string: ");
			String input = scanner.nextLine();
			scanner.close();
			if (input == null || input.isEmpty()) {
	            throw new IllegalArgumentException("Error: String cannot be empty or null!");
	        }
			if (!input.matches(".*[a-zA-Z].*")) {
	            throw new IllegalArgumentException("Error: String must have letter.");
	        }
		 	
			String preprocessedStr = input.toLowerCase().replaceAll("[^a-z\\s]", "");
	        System.out.println("Original String: " + input);
	        System.out.println("Preprocessed String: " + preprocessedStr);
	        System.out.println();
	        myMap map  = new myMap(preprocessedStr);
	        map.test();
		 	} catch (IllegalArgumentException e) {
		        System.err.println(e.getMessage());
		        
		    }
	   	   
	}

}