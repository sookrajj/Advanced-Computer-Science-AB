package Algorithms;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings({"unchecked", "unused", "ManualArrayCopy"})
public class SortingAlgorithms {
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) > 0) {
                    var temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key  = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = key;
        }
    }
    //procedure InsertionSort(A)
    //for i ← 1 to length(A) do
    //key ← A[i]
    //j ← i − 1
    //while j >= 0 and A[j] > key do
    //A[j + 1] ← A[j]
    //j ← j − 1
    //end while
    //A[j + 1] ← key
    //end for
    //end procedure
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int low = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[low]) < 0) low =  j;
            }
            T temp = arr[i];
            arr[i] = arr[low];
            arr[low] = temp;
        }
    }

    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int n = arr.length;
        int gap = n/2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                T temp = arr[i];
                int j = i;
                while (j >= gap && arr[j-gap].compareTo(temp) > 0) {
                    arr[j] = arr[j-gap];
                    j = j - gap;

                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }
//procedure ShellSort(A)
//n ← length(A)
//gap ← n/2
//while gap > 0 do
//for i ← gap to n − 1 do
//temp ← A[i]
//j ← i
//while j >= gap and A[j − gap] > temp do
//A[j] ← A[j − gap]
//j ← j − gap
//end while
//A[j] ← temp
//end for
//gap ← gap/2
//end while
//end procedure
}
