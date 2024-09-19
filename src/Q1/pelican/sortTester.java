package Q1.pelican;

public class sortTester {
    public static void main(String[] args) {
        int[] theArray = {4,2,5,1,3,18,0,9,6};
        insertionSort(theArray);
        for(int j = 0; j < theArray.length; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println(" ");
    }
    public static void Bubblesort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] > a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

            }
        }
    }
    // Bubble sort
    //0 1 2 3 4 5 6 9 18
    public static void selectionSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int low = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[low]) low =  j;
            }
            int temp = a[i];
            a[i] = a[low];
            a[low] = temp;
        }
    }
    // Selection Sort
    //0 1 2 3 4 5 6 9 18
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {

            for (int j = i-1; j >= 0; j--) {
                if (a[j] > a[i]) {

                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i--;

                } else {break;}
            }
        }
    }
    // Insertion sort
    //0 1 2 3 4 5 6 9 18
}
