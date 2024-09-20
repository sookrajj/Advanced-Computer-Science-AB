package Algorithms;

import java.util.Arrays;

public class noncomparisonSorting {
    public static <T extends Comparable<T>> void radixSort(T[] arr, int d) {

        int t = getDigit(arr[0], d);
        System.out.println(t);
    }

    public static <T extends Comparable<T>> void radixSort(T[] arr) {
        int numd = 0;
        for (int lcv = 0; lcv < arr.length; lcv++) {
            for (int l = 0; l < 10; l++) {
                double po = Math.pow(10, l);
                int p = (int) po;
                System.out.println(p);
                T num = (T) Integer.valueOf(p);
                System.out.println(num);
                if (arr[lcv].compareTo(num) > numd) {
                    break;
                }
            }
        }
        radixSort(arr, numd);
    }
//procedure RadixSort(array, d) ▷ Sorts an array of numbers up to d digits
//2: for digit ← 1 to d do
//3: array ← CountingSortByDigit(array, digit)
//4: end for
//5: return array
//6: end procedure
//7:
    public static <T extends Comparable<T>> void countingSort(T[] arr, int d) {
        T[] output = arr;
        Arrays.fill(output, null);

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
        System.out.println(l);
        return k;
    }
//26: procedure GetDigit(number, digit)
//27: return (number/10digit−1
//) mod 10
//
//28: end procedure
}
