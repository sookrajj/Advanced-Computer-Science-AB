package Q2;

import Algorithms.SortingAlgorithms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class prog910q {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/numsort.dat"));
            var hi = new ArrayList<Integer>();
            while (input.hasNext()) {
                hi.add(input.nextInt());
            }
            input.close();


            var nums = hi.toArray(new Integer[0]);
            SortingAlgorithms.quickSort(nums);
            for (int num : nums) {
                System.out.print(num + " ");
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }

    }
}
