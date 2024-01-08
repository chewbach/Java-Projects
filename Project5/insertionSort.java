package homework7;


import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The insertionSort class provides a method for sorting a map of items using the insertion sort algorithm.
 */
public class insertionSort {

    private myMap originalMap;
    private myMap sortedMap;
    private ArrayList<String> aux;

    /**
     * Constructs an insertionSort object with the specified originalMap.
     *
     * @param originalMap the original map to be sorted
     * @throws IllegalArgumentException if the input map is null
     */
    protected insertionSort(myMap originalMap) {
        if (originalMap == null) {
            throw new IllegalArgumentException("Input map cannot be null");
        }
        this.originalMap = originalMap;
        this.sortedMap = new myMap();
        this.aux = new ArrayList<>();
    }

    /**
     * Sorts the originalMap using the insertion sort algorithm.
     */
    protected void sort() {
        LinkedHashMap<String, info> map = originalMap.getMap();

        this.aux = new ArrayList<>(map.keySet());

        for (int i = 1; i < aux.size(); i++) {
            String key = aux.get(i);
            int j = i - 1;

            while (j >= 0 && originalMap.getMap().get(aux.get(j)).getCount() > originalMap.getMap().get(key).getCount()) {
                aux.set(j + 1, aux.get(j));
                j--;
            }

            aux.set(j + 1, key);
        }

        for (String key : aux) {
            sortedMap.getMap().put(key, map.get(key));
        }
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

