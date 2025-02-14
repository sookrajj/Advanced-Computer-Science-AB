package Q3;

import Algorithms.SortingAlgorithms;
import DataStructures.heap;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog485a {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog485a.dat"));
            var hep = new heap<Integer>();
            int inrow = 10;
            System.out.println("Original: ");
            while (input.hasNext()) {
                var num = input.nextInt();
                hep.insert(num);
                if (inrow == 0) {
                    inrow = 10;
                    System.out.println();
                }
                inrow--;
                System.out.print(num + " ");
            }
            input.close();
            System.out.println();
            Integer[] ints = new Integer[hep.size()];
            int i = 0;
            while (!hep.isEmpty()) {
                ints[i] = hep.deleteMin();
                i++;
            }
            SortingAlgorithms.Heapsort(ints);
            inrow = 10;
            System.out.println("Heap Sorted: ");
            for (var num : ints) {
                System.out.print(num + " ");
                if (inrow == 0) {
                    inrow = 10;
                    System.out.println();
                }
                inrow--;
            }
            System.out.println();
            System.out.println("Amount of each number: ");
            int num = 1;
            for (int l = 0; l < ints.length-1; l++) {
                if (ints[l] == ints[l+1]) {
                    num++;
                } else {
                    System.out.println(ints[l] + " " + num);
                    num = 1;
                }
                if (l == ints.length-2) {
                    System.out.println(ints[l-1] + " " + num);
                }
            }
            if (ints[ints.length-2] != ints[ints.length-1]) {
                System.out.println(ints[ints.length-1] + " " + 1);
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//Original:
//80 75 50 50 50 50 60 60 40 40
//25 45 50 45 45 50 50 50 20 20
//10 85 85 100 100 50 50 100 10 90
//10 70 70 70 70 60 60 60 90 90
//80 20 10 40 5 95 50 50 50
//Heap Sorted:
//5 10 10 10 10 20 20 20 25 40 40
//40 45 45 45 50 50 50 50 50 50
//50 50 50 50 50 50 50 60 60 60
//60 60 70 70 70 70 75 80 80 85
//85 90 90 90 95 100 100 100
//Amount of each number:
//5 1
//10 4
//20 3
//25 1
//40 3
//45 3
//50 13
//60 5
//70 4
//75 1
//80 2
//85 2
//90 3
//95 1
//100 3