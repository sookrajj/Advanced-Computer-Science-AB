package Q2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Algorithms.SortingAlgorithms;

public class prog575a {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog575a.dat"));
            ArrayList<String> sum = new ArrayList<>();
            while (input.hasNext()) {
                sum.add(input.next());
            }
            input.close();
            String[] array = new String[sum.size()];
            System.out.println("Original: ");
            for (int i = 0; i < sum.size(); i++) {
                array[i] = sum.get(i);
                System.out.println(array[i] + " ");
            }
            SortingAlgorithms.recurmerge(array);
            System.out.println();
            System.out.println("Merge Sorted: ");
            for (String num : array) {
                System.out.println(num + " ");
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//Original:
//ONE
//TWO
//THREE
//FOUR
//FIVE
//SIX
//SEVEN
//EIGHT
//NINE
//TEN
//ELEVEN
//TWELVE
//THIRTEEN
//
//Merge Sorted:
//EIGHT
//ELEVEN
//FIVE
//FOUR
//NINE
//ONE
//SEVEN
//SIX
//TEN
//THIRTEEN
//THREE
//TWELVE
//TWO