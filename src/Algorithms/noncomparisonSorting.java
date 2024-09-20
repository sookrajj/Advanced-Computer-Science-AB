package Algorithms;

import java.util.Arrays;

public class noncomparisonSorting {
    public static <T extends Comparable<T>> T[] radixSort(T[] arr, int d) {
        for (int digit = 1; digit < d; digit++) {
            arr = countingSort(arr, d);
        }
        return arr;
    }
    //procedure RadixSort(array, d) ▷ Sorts an array of numbers up to d digits
//2: for digit ← 1 to d do
//3: array ← CountingSortByDigit(array, digit)
//4: end for
//5: return array
//6: end procedure
//7:
    public static <T extends Comparable<T>> void radixSort(T[] arr) {
        int numd = 0;
        for (int lcv = 0; lcv < arr.length; lcv++) {
            for (int l = 0; l < 10; l++) {
                double po = Math.pow(10, l);
                int p = (int) po;
                T num = (T) Integer.valueOf(p);
                if (arr[lcv].compareTo(num) > 0 && l > numd) {
                    numd = l + 1;
                    System.out.println(numd);
                }
            }
        }
        System.out.println(numd);
        radixSort(arr, numd);
    }

    public static <T extends Comparable<T>> T[] countingSort(T[] arr, int d) {
        Integer[] p = new Integer[arr.length];
        T[] output = (T[]) p;
        int[] cnt = new int[10];
        System.out.println("hi");
        for (int i = 0; i < arr.length-1; i++) {
            int index = getDigit(arr[i], d);
            cnt[index] = cnt[index]+1;
        }
        for (int lcv = 0; lcv < output.length; lcv++) {
            System.out.print(output[lcv] + " ");

        }
        for (int i = 1; i < 9; i++) {
            cnt[i] = cnt[i] + cnt[i-1];
        }
        for (int i = arr.length-1; i > -1; i--) {
            int index = getDigit(arr[i], d);
            System.out.println(index);

            output[cnt[index] - 1] = arr[i];
            cnt[index] = cnt[index] - 1;
        }
        for (int lcv = 0; lcv < output.length; lcv++) {
            System.out.print(output[lcv] + " ");

        }
        System.out.println();
        return output;
    }
//8: procedure CountingSortByDigit(array, digit)
//9: output ← new array of size length(array)
//10: count ← new array of size 10 with elements initialized to 0 ▷ Digit range is 0-9 for base 10
//11: for i ← 0 to length(array) − 1 do
//12: index ← GetDigit(array[i], digit)
//13: count[index] ← count[index] + 1
//14: end for
//15: for i ← 1 to 9 do
//16: count[i] ← count[i] + count[i − 1]
//17: end for
//18: for i ← length(array) − 1 down to 0 do
//19: index ← GetDigit(array[i], digit)
//20: output[count[index] − 1] ← array[i]
//21: count[index] ← count[index] − 1
//22: end for
//23: return output
//24: end procedure
//25:
    public static <T extends Comparable<T>> int getDigit(T n, int d) {
        int k = 0;
        Integer l = n.hashCode();
        k = (int) (l/Math.pow(10, d-1)) % 10;
        return k;
    }
//26: procedure GetDigit(number, digit)
//27: return (number/10digit−1
//) mod 10
//
//28: end procedure
}
