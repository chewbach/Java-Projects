package homework7;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The selectionSort class provides a method for sorting a map of items using the selection sort algorithm.
 */
public class selectionSort {

    private myMap originalMap;
    private myMap sortedMap;
    private ArrayList<String> aux;

    /**
     * Constructs a selectionSort object with the specified originalMap.
     * 
     * @param originalMap the original map to be sorted
     * @throws IllegalArgumentException if the input map is null
     */
    protected selectionSort(myMap originalMap) {
        if (originalMap == null) {
            throw new IllegalArgumentException("Input map cannot be null");
        }
        this.originalMap = originalMap;
        this.sortedMap = new myMap();
        this.aux = new ArrayList<>();
    }

    /**
     * Sorts the originalMap using the selection sort algorithm.
     */
    protected void sort() {
        LinkedHashMap<String, info> map = originalMap.getMap();

        // Copy keys to auxiliary list
        this.aux = new ArrayList<>(map.keySet());

        for (int k = 0; k < originalMap.getMapSize() - 1; k++) {
            int minIndex = k;

            // Find the minimum element in the remaining unsorted part of the list
            for (int j = k + 1; j < originalMap.getMapSize(); j++) {
                String key1 = aux.get(j);
                String key2 = aux.get(minIndex);

                if (originalMap.getMap().get(key1).getCount() < originalMap.getMap().get(key2).getCount()) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            if (minIndex != k) {
                swap(k, minIndex);
            }
        }

        // Create a new sorted map using the sorted keys
        for (String key : aux) {
            sortedMap.getMap().put(key, map.get(key));
        }
    }

    /**
     * Swaps the elements at the specified positions in the auxiliary list.
     * 
     * @param i the index of the first element to be swapped
     * @param j the index of the second element to be swapped
     */
    private void swap(int i, int j) {
        String temp = aux.get(i);
        aux.set(i, aux.get(j));
        aux.set(j, temp);
    }

    /**
     * Prints the sorted map to the standard output in the following format:
     * key: count = <count>, words = [<word1>,<word2>,...]
     */
    protected void printSortedMap() {
        for (String key : sortedMap.getMap().keySet()) {
            System.out.println(key + ": count = " + sortedMap.getMap().get(key).getCount() +
                    ", words = [" + String.join(",", sortedMap.getMap().get(key).getWords()) + "]");
        }
    }

    /**
     * Prints the original map to the standard output in the following format:
     * key: count = <count>, words = [<word1>,<word2>,...]
     */
    protected void printOriginalMap() {
        for (String key : originalMap.getMap().keySet()) {
            System.out.println(key + ": count = " + originalMap.getMap().get(key).getCount() +
                    ", words = [" + String.join(",", originalMap.getMap().get(key).getWords()) + "]");
        }
    }
}

	    

