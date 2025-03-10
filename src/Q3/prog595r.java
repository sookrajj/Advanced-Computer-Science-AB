package Q3;

import java.io.File;
import java.io.IOException;
import java.util.*;

import DataStructures.Set;

public class prog595r {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/dale-chall-word-list.txt"));
            var in = new Scanner(System.in);
            Set<String> set = new Set<String>();
            while (input.hasNext()) {
                set.insert(input.nextLine());
            }
            input.close();

            System.out.println("Enter a Text: ");
            var str = in.nextLine();
            var arr = str.split("\\.");
            ArrayList<String> pl = new ArrayList<>();
            for (String s : arr) {
                pl.addAll(Arrays.asList(s.split("\\s+")));
            }
            var better = pl.stream().map(s -> s.toLowerCase()).filter(s -> !s.equalsIgnoreCase("")).toList();
            var count = 0;
            var amount = 0;
            for (String value : better) {
                for (String s : set) {
                    count += s.equalsIgnoreCase(value) ? 1 : 0;
                }
                if (count == 0)  {
                    amount++;
                }
                count = 0;
            }
            var score = 0.1579 * ((double)amount/ better.size() * 100) + 0.0496 * (double)better.size() / arr.length;
            score += (double)amount/better.size() * 100 > 5 ? 3.6365 : 0;
            System.out.println("The Dale-Chall readability grade level is: " + score + " " + (score <= 4.9 ? "Grades K-4" : score <= 5.9 ? "Grades 5-6" : score <= 6.9 ? "Grades 7-8" :
                    score <= 7.9 ? "Grades 9-10" : score <= 8.9 ? "Grades 11-12" : score <= 9.9 ? "Grades 13-15 (College)" :
                    "Grades 16 and above (College Graduate)"));

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//Enter a Text:
//The quick brown fox jumps over the lazy dog. Many installations require thorough understanding.
//The Dale-Chall readability grade level is: 9.622985714285715 Grades 13-15 (College)

//Enter a Text:
//
//The Dale-Chall readability grade level is: NaN Grades 16 and above (College Graduate)

