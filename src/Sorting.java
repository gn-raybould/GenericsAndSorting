import java.util.Arrays;
import java.util.Random;

public class Sorting{

    // Bubble Sort Implementation
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Swap array[j] and array[j + 1]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    // Merge Sort Implementation
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length < 2) {
            return; // Base case: array is already sorted
        }
        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left); // Sort the left half
        mergeSort(right); // Sort the right half
        merge(array, left, right); // Merge the sorted halves
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements of left, if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements of right, if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Method to generate a random integer array
    public static Integer[] generateRandomIntArray(int size, int bound) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound); // Random integers from 0 to bound-1
        }
        return array;
    }

    public static void main(String[] args) {
        // Generate and test Bubble Sort with random integers
        Integer[] intArrayBubble = generateRandomIntArray(10, 100); // 10 random integers from 0 to 99
        System.out.println("Bubble Sort - Original array: " + Arrays.toString(intArrayBubble));
        bubbleSort(intArrayBubble);
        System.out.println("Bubble Sort - Sorted array: " + Arrays.toString(intArrayBubble));

        // Generate and test Merge Sort with random integers
        Integer[] intArrayMerge = generateRandomIntArray(10, 100); // 10 random integers from 0 to 99
        System.out.println("Merge Sort - Original array: " + Arrays.toString(intArrayMerge));
        mergeSort(intArrayMerge);
        System.out.println("Merge Sort - Sorted array: " + Arrays.toString(intArrayMerge));
    }
}