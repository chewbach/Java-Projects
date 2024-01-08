package homework05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;


public class TreeFromTxtFile {

	 private ArrayList<ArrayList<String>> file_arr;	
	 private DefaultMutableTreeNode root;
	 private boolean isFoundedBFS = false;
	 private boolean isFoundedDFS = false;
	 private boolean isFoundPostOrder = false;
	 
	 public void execute() {
		 read_file();
		 build_tree();
		
	   }
	 
	 
	 public void searchBFS() {
		 String input = get_input_from_user();
		  ArrayList<String> searchResult = findInputBFS(input);
	        
	            
	        if(isFoundedBFS) {
	            for(int i =0;i<searchResult.size();i++) {
	            	System.out.printf("Step %d -> ",i+1);
	            	System.out.println(searchResult.get(i));
	            }
	            	System.out.print("(Found!)");
	         }
	        else {
	        	for(int i =0;i<searchResult.size();i++) {
	            	System.out.printf("Step %d -> ",i+1);
	            	System.out.println(searchResult.get(i));
	            	
	            }
	        	System.out.println("Not found.");
	        }
	 }
	 
	
	 
	 private ArrayList<String> findInputBFS(String input) {
		 Queue<DefaultMutableTreeNode> queue = new LinkedList<>();
	     queue.add(root);
	    
	        ArrayList<String> steps = new ArrayList<>();

	        while (!queue.isEmpty()) {
	            DefaultMutableTreeNode currentNode = queue.poll();
	            steps.add( currentNode.getUserObject().toString());
	            if (currentNode.getUserObject().toString().equals(input)) {
	                while (currentNode != null) {
	                    currentNode = (DefaultMutableTreeNode) currentNode.getParent();
	                }
	                isFoundedBFS = true;
	                return steps;
	            }

	            for (int i = 0; i < currentNode.getChildCount(); i++) {
	                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) currentNode.getChildAt(i);
	                queue.add(childNode);
	            }
	        }

	        return steps;
	    }
	 
	 
	 private String get_input_from_user() {
		 	Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the data you want to search: ");
	        String userInput = scanner.nextLine();
	        return userInput;
	 }
	 
	 
	 public void searchDFS() {
		 String input = get_input_from_user();
		    ArrayList<String> searchResult = findInputDFS(input);

		    if (isFoundedDFS) {
		        for (int i = 0; i <searchResult.size(); i++) {
		            System.out.printf("Step %d -> ", i+1);
		            System.out.println(searchResult.get(i));
		        }
		        System.out.print("(Found!)");
		    } else {
		    	for (int i = 0; i <searchResult.size(); i++) {
		            System.out.printf("Step %d -> ", i+1);
		            System.out.println(searchResult.get(i));
		        }
		        System.out.println("Not found.");
		    }
		}

		private ArrayList<String> findInputDFS(String input) {
		    Stack<DefaultMutableTreeNode> stack = new Stack<>();
		    ArrayList<String> steps = new ArrayList<>();

		    stack.push(root);

		    while (!stack.isEmpty()) {
		        DefaultMutableTreeNode currentNode = stack.pop();
		        steps.add(currentNode.getUserObject().toString());

		        if (currentNode.getUserObject().toString().equals(input)) {
		            isFoundedDFS = true;
		            return steps;
		        }

		        for (int i = 0; i < currentNode.getChildCount(); i++) {
		            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) currentNode.getChildAt(i);
		            stack.push(childNode);
		        }
		    }

		    return steps;
		}



		public void searchPostOrder() {
			String input = get_input_from_user();
		    ArrayList<String> searchResult = findInputPostOrder(root, input);

		    if (isFoundPostOrder) {
		        for (int i = 0; i < searchResult.size(); i++) {
		            System.out.printf("Step %d -> ", i + 1);
		            System.out.println(searchResult.get(i));
		        }
		        System.out.print("(Found!)");
		    } else {
		        for (int i = 0; i < searchResult.size(); i++) {
		            System.out.printf("Step %d -> ", i + 1);
		            System.out.println(searchResult.get(i));
		        }
		        System.out.println("Not found.");
		    }
		}

		private ArrayList<String> findInputPostOrder(DefaultMutableTreeNode currentNode, String input) {
		    ArrayList<String> steps = new ArrayList<>();

		    for (int i = 0; i < currentNode.getChildCount(); i++) {
		        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) currentNode.getChildAt(i);
		        ArrayList<String> childSteps = findInputPostOrder(childNode, input);
		        steps.addAll(childSteps);

		        if (isFoundPostOrder) {
		            return steps;
		        }
		    }

		    if (currentNode.getUserObject().toString().equals(input)) {
		    	 steps.add(currentNode.getUserObject().toString());
		        isFoundPostOrder = true;
		    }

		    if (!isFoundPostOrder) {
		        steps.add(currentNode.getUserObject().toString());
		    }

		    return steps;
		}




	 
	
	 
	 
	 

	 
	 private void build_tree() {
		 
		 root = new DefaultMutableTreeNode("Root");
		 for (int i = 0; i < file_arr.size(); i++) {
	            add_to_tree(file_arr.get(i));
	     }
		 	//print_tree();
	 }
	 
	 
	 
	 
	 private void add_to_tree(ArrayList<String> arr) {
		 DefaultMutableTreeNode current_node = root;
		 for (int i = 0; i < arr.size(); i++) {
			 String currentData = arr.get(i);
			 HashMap<String, DefaultMutableTreeNode> childrenMap = new HashMap<>();
			 int num_child = current_node.getChildCount();
			 for (int j = 0; j < num_child; j++) {
		            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) current_node.getChildAt(j);
		            childrenMap.put(childNode.getUserObject().toString(), childNode);
		        }
			 if (childrenMap.containsKey(currentData)) {
	                current_node = childrenMap.get(currentData);
	            } else {
	                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(currentData);
	                childrenMap.put(currentData, newNode);
	                current_node.add(newNode);
	                current_node= newNode;
	            } 
			 
		 }
	 }

		

	 
	 public void moveNode(String source, String destination) {
		    String[] sourcePath = source.split(", ");
		    String destinationYear = destination.trim();

		    DefaultMutableTreeNode sourceNode = findNodeByPath(root, sourcePath);
		    if (sourceNode == null) {
		        System.out.println("Cannot move "+source+" because it doesn't exist in the tree.");
		        return;
		    }

		    DefaultMutableTreeNode destinationYearNode = findOrCreateYearNode(destinationYear);

		    DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sourceNode.getParent();
		    parentNode.remove(sourceNode);
		    removeEmptyNodes(parentNode);

		    destinationYearNode.add(sourceNode);

		    System.out.println("Node moved successfully.");
		   
		}

		private DefaultMutableTreeNode createPath(DefaultMutableTreeNode currentNode, String path) {
		    String[] parts = path.split(", ");
		    for (int i = 1; i < parts.length - 1; i++) {
		        DefaultMutableTreeNode child = findChild(currentNode, parts[i]);
		        if (child == null) {
		            child = new DefaultMutableTreeNode(parts[i]);
		            currentNode.add(child);
		        }
		        currentNode = child;
		    }
		    return currentNode;
		}

		private DefaultMutableTreeNode findChild(DefaultMutableTreeNode node, String userObject) {
		    for (int i = 0; i < node.getChildCount(); i++) {
		        DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
		        if (child.getUserObject().equals(userObject)) {
		            return child;
		        }
		    }
		    return null;
		}

		private DefaultMutableTreeNode findNode(DefaultMutableTreeNode node, String path) {
		    String[] parts = path.split(", ");
		    for (int i = 0; i < parts.length; i++) {
		        DefaultMutableTreeNode child = findChild(node, parts[i]);
		        if (child == null) {
		            return null;
		        }
		        node = child;
		    }
		    return node;
		}


		private DefaultMutableTreeNode findNodeByPath(DefaultMutableTreeNode node, String[] path) {
		    if (path.length == 0) {
		        return node;
		    }

		    for (int i = 0; i < node.getChildCount(); i++) {
		        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
		        if (childNode.getUserObject().toString().equals(path[0])) {
		            return findNodeByPath(childNode, Arrays.copyOfRange(path, 1, path.length));
		        }
		    }

		    return null;
		}

		private DefaultMutableTreeNode findOrCreateYearNode(String year) {
		    for (int i = 0; i < root.getChildCount(); i++) {
		        DefaultMutableTreeNode yearNode = (DefaultMutableTreeNode) root.getChildAt(i);
		        if (yearNode.getUserObject().toString().equals(year)) {
		            return yearNode;
		        }
		    }

		    DefaultMutableTreeNode newYearNode = new DefaultMutableTreeNode(year);
		    root.add(newYearNode);
		    return newYearNode;
		}

		private void removeEmptyNodes(DefaultMutableTreeNode node) {
		    if (node.getParent() != null && node.getChildCount() == 0) {
		        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) node.getParent();
		        parentNode.remove(node);
		        removeEmptyNodes(parentNode);
		    }
		}

		public void print_tree() {
			JTree tree = new JTree(root);
		 	JFrame frame = new JFrame("Tree");
		 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	frame.setSize(800, 600);
		 	frame.setResizable(true);
	        frame.add(tree);
	        frame.setVisible(true);
		}




		private void read_file() {
		     try {
		         int number_of_lines = 0;
		         File dosya = new File("tree.txt");
		         Scanner scanner = new Scanner(dosya);

		         // Count number of lines in file
		         while (scanner.hasNextLine()) {
		             number_of_lines++;
		             scanner.nextLine();
		         }

		         // Initialize 2D ArrayList
		        file_arr = new ArrayList<>(number_of_lines);
		         for (int i = 0; i < number_of_lines; i++) {
		             file_arr.add(new ArrayList<String>());
		         }

		         // Read data from file into 2D ArrayList
		         scanner = new Scanner(dosya);
		         for (int i = 0; i < number_of_lines; i++) {
		             String[] line = scanner.nextLine().split(";");
		             for (int j = 0; j < line.length; j++) {
		                 file_arr.get(i).add(line[j]);
		             }
		         }

		         scanner.close();
		     } catch (FileNotFoundException e) {
		         System.out.println("File not founded: " + e.getMessage());
		     }
		 }

}