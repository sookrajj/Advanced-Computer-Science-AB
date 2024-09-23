package Q1;
import java.io.File;
import java.io.IOException;
import java.util.*;

import Algorithms.SortingAlgorithms;
import Algorithms.SortingAlgorithms.*;
import org.testng.annotations.Test;

public class prog482s {
    @Test
    public static Integer[] test482i() {
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
            return array;
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
        return null;
    }

    public static void test482j() {
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
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }

    public static void test482h() {
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
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }

    public static void main(String[] args) {
        test482h();
        System.out.println();
        test482i();
        System.out.println();
        test482j();
//        Assertions.assertEquals(1,1);
    }
}
