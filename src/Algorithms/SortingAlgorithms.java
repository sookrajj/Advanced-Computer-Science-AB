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


    public static <T extends Comparable<T>> void recurmerge(T[] arr) {
        if (arr.length > 1) {
            var middle  = arr.length / 2;
//            System.out.println(middle + " try");
            var L  = (T[]) new Comparable[middle];
            for (int l = 0; l < middle; l++) {
                L[l] = arr[l];
            }
            var R  = (T[]) new Comparable[arr.length-middle];
            for (int l = middle; l < arr.length; l++) {
                R[l-middle] = arr[l];
            }
            recurmerge(L);
            recurmerge(R);
            merge(arr, L, R);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] arr, T[] L, T[] R) {
        var i = 0;
        var j = 0;
        var k = 0;
        while (i < L.length && j < R.length) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //while i < length(L) do ▷ Copy remaining elements of L
    //A[k] ← L[i]
    //i ← i + 1
    //k ← k + 1
    //end while
    //while j < length(R) do ▷ Copy remaining elements of R
    //A[k] ← R[j]
    //j ← j + 1
    //k ← k + 1
    //end while
    //end procedure


    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i = i+1;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
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
//    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
//        if (low < high) {
//            int pivot = Partition(arr, low, high);
//            quickSort(arr, low, pivot-1);
//            quickSort(arr, pivot+1, high);
//        }
//    }
//    public static <T extends Comparable<T>> int Partition(T[] arr, int low, int high) {
//        T pivot = arr[high];
//        int i = low-1;
//        for (int j = low; j <= high-1; j++) {
//            if (arr[j].compareTo(pivot) < 0) {
//                i = i+1;
//                T temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//        T temp = arr[i+1];
//        arr[i+1] = arr[high];
//        arr[high] = temp;
//        return i+1;
//    }

    /* =========== Heap Sort ============ */
    public static <T extends Comparable<T>> void Heapsort(T[] arr) {
        int n = arr.length;
        buildMaxHeap(arr);
        for (int i = n-1; i >= 1; i--) {
            swap(arr, 0, i);
            n -= 1;
            maxHeapify(arr, 0, n);
        }
    }

    private static <T extends Comparable<T>> void buildMaxHeap(T[] arr) {
        int n = arr.length;
        for (int i = n / 2 -1; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }

    }

    private static <T extends Comparable<T>> void maxHeapify(T[] arr, int i, int n) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }
        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }
}
