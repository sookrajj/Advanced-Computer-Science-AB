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
    public static <T extends Comparable<T>> void bubbleSortincl(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        insertionSort(arr, arr.length);
    }
    public static <T extends Comparable<T>> void insertionSort(T[] arr, int n) {
        for (int i = 1; i < n; i++) {
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

//    public static <T extends Comparable<T>> void quickSort(T[] arr, int left, int right) {
//        if (left >= right) return;
//        int k = left;
//        int j = right;
//        var pivotValue = arr[(left+right)/2];
//        while (k < j) {
//            while (arr[k].compareTo(pivotValue) < 0) {
//                k++;
//            }
//            while (arr[j].compareTo(pivotValue) > 0) {
//                j--;
//            }
//            if (k <= j) {
//                T temp = arr[k];
//                arr[k] = arr[j];
//                arr[j] = temp;
//                k++;
//                j--;
//            }
//        }
//        quickSort(arr, left, j);
//        quickSort(arr, k, right);
//    }
    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = Partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    //procedure Quicksort(A, low, high)
    //if low < high then
    //pivot ← Partition(A, low, high)
    //Quicksort(A, low, pivot − 1)
    //Quicksort(A, pivot + 1, high)
    //end if
    //end procedure
    public static <T extends Comparable<T>> int Partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low-1;
        for (int j = low; j <= high-1; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i = i+1;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    //procedure Partition(A, low, high)
    //pivot ← A[high]
    //i ← low − 1
    //for j ← low to high − 1 do
    //if A[j] < pivot then
    //i ← i + 1
    //Swap A[i] and A[j]
    //end if
    //end for
    //Swap A[i + 1] and A[high]
    //return i + 1
    //end procedure
}
