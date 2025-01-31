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

        public boolean error1() {
            boolean er = false;
            boolean[] nu = new boolean[nums.length];
            for (int[] p : nums) {
                for (int num : p) {
                    if (num != 0) nu[num-1] = true;
                }
                for (boolean t : nu) if (!t) return true;

            }
            nu = new boolean[nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int p = 0; p < nums[0].length; p++) {
                    if (nums[i][p] != 0) nu[nums[i][p]-1] = true;
                }
                for (boolean t : nu) if (!t) return true;
            }

            return false;
        }

        public boolean error2() {
            boolean er = false;
            boolean[] nu = new boolean[nums.length];
            boolean[] b = new boolean[nums[0].length];
            for (int i = 0; i < nums.length; i++) {
                for (int l = 0; l < nums.length; l++) {
                    if (nums[i][l] == 0) {
                        for (int r = 0; r < nums.length; r++) {
                            if (r != l) nu[nums[i][r]-1] = true;
                        }
                        for (int r = 0; r < nums.length; r++) {
                            if (r != i) b[nums[r][l]-1] = true;
                        }
                        for (int r = 0; r < nums.length; r++) {
                            if (nu[r] == b[r] && !nu[r]) return  false;
                        }
                        return true;
                    }
                }

            }
            return false;
        }


        public boolean error3() {
            boolean er = false;

            for (int i = 0; i < clunum; i++) {
                var dir = clues.get(i*3);
                var pos = clues.get(i*3+1);
                var bnum = clues.get(i*3+2);
                boolean[] nu = new boolean[nums.length];
                if (dir%2 == 0) {

                } else {
                    int[] row = nums[pos];

                }
            }
            return false;
        }

    }
}
