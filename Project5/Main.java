package homework7;

import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		 	
		 		
		 	/*NOTE : The test method is included in myMap and prints the results according to the algorithm we choose. 
		 	 * The number written inside shows which algorithm the result is desired to be used for.
		 	 *  1 merge sort, 2 selection sort, 3 Insertion sort, 4 bubble sort, 5 quick sort and 6 print all at once used to do.
		 	 */
		 		
		 	
			
			String bestCaseInput = "xy xy xy";
			String preprocessedStr = bestCaseInput.toLowerCase().replaceAll("[^a-z\\s]", "");
	        System.out.println("Original String: " + bestCaseInput);
	        System.out.println("Preprocessed String: " + preprocessedStr);
	        System.out.println();
	        
	        myMap map  = new myMap(preprocessedStr);
	        map.test(6);
	        
	        String avarageCaseInput = "xyxyxy xyxyxy xyxyxy";
	        preprocessedStr = avarageCaseInput.toLowerCase().replaceAll("[^a-z\\s]", "");
	        System.out.println("Original String: " + avarageCaseInput);
	        System.out.println("Preprocessed String: " + preprocessedStr);
	        System.out.println();
	        
	        myMap map2  = new myMap(preprocessedStr);
	        map2.test(6);
	        
	        String worstCaseInput = "xxxxx yyyyy xxxxx yyyyy xxxxx yyyyy";
	        preprocessedStr = worstCaseInput.toLowerCase().replaceAll("[^a-z\\s]", "");
	        System.out.println("Original String: " + worstCaseInput);
	        System.out.println("Preprocessed String: " + preprocessedStr);
	        System.out.println();
	        
	        myMap map3  = new myMap(preprocessedStr);
	        map3.test(6);
		 		
	        
	        /*NOTE: If you wish, you can remove the code below from the comment line and test it 
	         * easily with the inputs you enter and the algorithm you choose, thanks to a menu.
	         */
		 	
		 	/*	
		
	    	try {
		 		int selected_algorithm = 1;
		 		Scanner scanner = new Scanner(System.in);
		 	
		 		while(selected_algorithm!=0) {
		 			
			
			System.out.print("Please enter a string: ");
			String input = scanner.nextLine();
			
			System.out.println("1. Merge Sort");
			System.out.println("2. Selection Sort");
			System.out.println("3. Insertion Sort");
			System.out.println("4. Bubble Sort");
			System.out.println("5. Quick Sort");
			System.out.println("6. Print with All Sort Algorithms :");
			System.out.println("0. Quit ");
			System.out.print("Please select the algorithm you want to use: ");
			
			selected_algorithm = scanner.nextInt();
			 scanner.nextLine();
			;
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
	        map.test(selected_algorithm);
	        
	        
		 		}
		 		scanner.close();
		 		} catch (IllegalArgumentException e) {
		        System.err.println(e.getMessage());
		        
		    }
		


		 	 */
	
				 	
			   	   
			

		
	   	   
	}

}
