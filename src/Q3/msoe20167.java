package Q3;

import javax.print.attribute.standard.PrintQuality;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class msoe20167 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var file = input.nextLine();
        var size = 0;
        var clunum = 0;
        var clues = new ArrayList<Integer>();
        try {
            var fi = new Scanner(new File(file));
            size = fi.nextInt();
            clunum = fi.nextInt();
            while (fi.hasNext()) {
                clues.add(fi.nextInt());
            }
            fi.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        var nums = new int[size][size];
        var nex = input.nextLine();
        try {
            var fi = new Scanner(new File(nex));
            int index = 0;
            int pos = 0;
            while (fi.hasNext()) {
                if (pos >= size) {
                    pos = 0;
                    index++;
                    nums[index][pos++] = fi.nextInt();
                } else {
                    nums[index][pos++] = fi.nextInt();
                }
            }
            fi.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    static class helper {
        private int[][] nums;
        private ArrayList<Integer> clues;
        private int clunum = 0;


        public helper(int[][] nums, ArrayList<Integer> clues, int cluenum) {
            this.nums = nums;
            this.clues = clues;
            this.clunum = cluenum;
        }
    }
}
