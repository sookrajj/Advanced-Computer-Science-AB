package Q1;
import java.io.File;
import java.io.IOException;
import java.util.*;

import Algorithms.SortingAlgorithms;
import Algorithms.SortingAlgorithms.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class prog482s {
    public static final Integer[] BASE_CASE = bubsort();
    public static Integer[] bubsort() {
        try {
            var input = new Scanner(new File("Langdat/numsort.dat"));
            ArrayList<Integer> sum = new ArrayList<>();
            while (input.hasNext()) {
                sum.add(input.nextInt());
            }
            input.close();
            Integer[] array = new Integer[sum.size()];
            for (int i = 0; i < sum.size(); i++) {
                array[i] = sum.get(i);
            }
            System.out.println("Original: ");
            for (Integer num : array) {
                System.out.print(num + " ");
            }
            SortingAlgorithms.bubbleSort(array);
            System.out.println();
            System.out.println("Sorted: ");
            for (Integer num : array) {
                System.out.print(num + " ");
            }
            return array;
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
        return null;
    }
    @Test
    public void test482i() {
        try {
            var input = new Scanner(new File("Langdat/numsort.dat"));
            ArrayList<Integer> sum = new ArrayList<>();
            while (input.hasNext()) {
            sum.add(input.nextInt());
            }
            input.close();
            Integer[] array = new Integer[sum.size()];
            for (int i = 0; i < sum.size(); i++) {
                array[i] = sum.get(i);
            }
            System.out.println("Original: ");
            for (Integer num : array) {
                System.out.print(num + " ");
            }
            SortingAlgorithms.selectionSort(array);
            System.out.println();
            System.out.println("Sorted: ");
            for (Integer num : array) {
                System.out.print(num + " ");
            }
            for (int i = 0; i < BASE_CASE.length; i++) {
                Assertions.assertEquals(BASE_CASE[i], array[i], "Failed at index " + i);
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
    @Test
    public void test482j() {
        try {
            var input = new Scanner(new File("Langdat/numsort.dat"));
            ArrayList<Integer> sum = new ArrayList<>();
            while (input.hasNext()) {
                sum.add(input.nextInt());
            }
            input.close();
            Integer[] array = new Integer[sum.size()];
            for (int i = 0; i < sum.size(); i++) {
                array[i] = sum.get(i);
            }
            System.out.println("Original: ");
            for (Integer num : array) {
                System.out.print(num + " ");
            }
            SortingAlgorithms.insertionSort(array);
            System.out.println();
            System.out.println("Sorted: ");
            for (Integer num : array) {
                System.out.print(num + " ");
            }
            for (int i = 0; i < BASE_CASE.length; i++) {
                Assertions.assertEquals(BASE_CASE[i], array[i], "Failed at index " + i);
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }

    }
    @Test
    public void test482h() {
        try {
            var input = new Scanner(new File("Langdat/numsort.dat"));
            ArrayList<Integer> sum = new ArrayList<>();
            while (input.hasNext()) {
                sum.add(input.nextInt());
            }
            input.close();
            Integer[] array = new Integer[sum.size()];
            for (int i = 0; i < sum.size(); i++) {
                array[i] = sum.get(i);
            }
            System.out.println("Original: ");
            for (Integer num : array) {
                System.out.print(num + " ");
            }
            SortingAlgorithms.shellSort(array);
            System.out.println();
            System.out.println("Sorted: ");
            for (Integer num : array) {
                System.out.print(num + " ");
            }
            for (int i = 0; i < BASE_CASE.length; i++) {
                Assertions.assertEquals(BASE_CASE[i], array[i], "Failed at index " + i);
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }

//    public static void main(String[] args) {
//        test482h();
//        System.out.println();
//        test482i();
//        System.out.println();
//        test482j();
////        Assertions.assertEquals(1,1);
//        System.out.println();
//        Assertions.assertEquals(test482j(), test482i());
//    }
}
