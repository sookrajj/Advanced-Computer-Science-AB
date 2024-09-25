package Q1;
import Algorithms.SortingAlgorithms;
import DataStructures.dynamicArray;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class prog481a {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/numsort.dat"));
            var nums = new dynamicArray<Integer>();
            while (input.hasNext()) {
                nums.add(input.nextInt());
            }
            input.close();
            var numsArray = nums.toArray();

            System.out.println("Original list: " + nums);
            SortingAlgorithms.bubbleSortincl(numsArray);
            System.out.println("\nSorted list: " + Arrays.toString(numsArray));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
