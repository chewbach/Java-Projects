package homework7;



import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The quickSort class provides a method for sorting a map of items using the quicksort algorithm.
 */
public class quickSort {

    private myMap originalMap;
    private myMap sortedMap;
    private ArrayList<String> aux;

    /**
     * Constructs a quickSort object with the specified originalMap.
     * 
     * @param originalMap the original map to be sorted
     * @throws IllegalArgumentException if the input map is null
     */
    protected quickSort(myMap originalMap) {
        if (originalMap == null) {
            throw new IllegalArgumentException("Input map cannot be null");
        }
        this.originalMap = originalMap;
        this.sortedMap = new myMap();
        this.aux = new ArrayList<>();
    }

    /**
     * A helper method for the quicksort algorithm that recursively sorts the subarray.
     * 
     * @param low  the index of the low end of the subarray
     * @param high the index of the high end of the subarray
     */
    void quickSortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    /**
     * Sorts the originalMap using the quicksort algorithm.
     */
    protected void sort() {
        LinkedHashMap<String, info> map = originalMap.getMap();
        this.aux = new ArrayList<>(map.keySet());
        quickSortHelper(0, originalMap.getMapSize() - 1);
        for (String key : aux) {
            sortedMap.getMap().put(key, map.get(key));
        }
    }

    /**
     * Partitions the subarray and returns the partitioning index.
     * 
     * @param low  the index of the low end of the subarray
     * @param high the index of the high end of the subarray
     * @return the partitioning index
     */
    protected int partition(int low, int high) {
        int pivot = originalMap.getMap().get(aux.get(high)).getCount();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (originalMap.getMap().get(aux.get(j)).getCount() <= pivot) {
                i++;

                String temp = aux.get(i);
                aux.set(i, aux.get(j));
                aux.set(j, temp);
            }
        }

        String temp = aux.get(i + 1);
        aux.set(i + 1, aux.get(high));
        aux.set(high, temp);

        return i + 1;
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
}
