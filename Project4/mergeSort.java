package homework6;



import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The mergeSort class provides functionality to sort a given myMap object based on the count of its info objects.
 * The sort is performed using the merge sort algorithm.
 */
public class mergeSort {
    private myMap originalMap;
    private myMap sortedMap;
    private ArrayList<String> aux;

    /**
     * Initializes a new instance of the mergeSort class with the specified myMap object to be sorted.
     *
     * @param originalMap The myMap object to be sorted.
     * @throws IllegalArgumentException If the input map is null.
     */
    protected mergeSort(myMap originalMap) {
        if (originalMap == null) {
            throw new IllegalArgumentException("Input map cannot be null");
        }
        this.originalMap = originalMap;
        this.sortedMap = new myMap();
        this.aux = new ArrayList<>();
    }

    /**
     * Sorts the original myMap object and populates the sortedMap object with the sorted data.
     */
    protected void sort() {
        LinkedHashMap<String, info> map = originalMap.getMap();
        aux = new ArrayList<>(map.keySet());

        mergeSortHelper(0, aux.size() - 1);

        for (String key : aux) {
            sortedMap.getMap().put(key, map.get(key));
        }
    }

    /**
     * Sorts the specified subarray using the merge sort algorithm.
     *
     * @param left  The index of the leftmost element of the subarray to be sorted.
     * @param right The index of the rightmost element of the subarray to be sorted.
     */
    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     *
     * @param left  The index of the leftmost element of the left subarray.
     * @param mid   The index of the rightmost element of the left subarray.
     * @param right The index of the rightmost element of the right subarray.
     */
    private void merge(int left, int mid, int right) {
        ArrayList<String> temp = new ArrayList<>();
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            String key1 = aux.get(i);
            String key2 = aux.get(j);

            if (originalMap.getMap().get(key1).getCount() <= originalMap.getMap().get(key2).getCount()) {
                temp.add(aux.get(i));
                i++;
            } else {
                temp.add(aux.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(aux.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(aux.get(j));
            j++;
        }

        for (int k = left; k <= right; k++) {
            aux.set(k, temp.get(k - left));
        }
    }

    /**
     * Prints the sorted myMap object.
     */
    protected void printSortedMap() {
        for (String key : sortedMap.getMap().keySet()) {
            System.out.println(key + ": count = " + sortedMap.getMap().get(key).getCount() + ", words = [" + String.join(",", sortedMap.getMap().get(key).getWords()) + "]");
        }
    }
    
}