package homework05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Map;
import java.util.HashMap;




public class Main {

	public static void main(String[] args) {
		
		TreeFromTxtFile tree = new TreeFromTxtFile();
		tree.execute();
		tree.searchBFS();
		//tree.searchDFS();
		//tree.searchPostOrder();
		tree.moveNode("2022, CSE3521, LECTURE2", "2023");
		tree.print_tree();
	        

	}

}
