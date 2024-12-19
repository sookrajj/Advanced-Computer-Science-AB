package Q2.msoe2024;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class newmsoe20249 {
    public static int find(String[][] mat, int r, int c, int check, int num) {
        ArrayList<Integer> poss = new ArrayList<Integer>();
        poss.add(nu(mat, r, c, check, num));
        int min = 10000;
        for (int n : poss) {
            if (n < min) min = n;
        }
        return min;
    }

    public static int nu(String[][] mat, int r, int c, int check, int num) {
        System.out.println(check);
        if (mat[r][c].equalsIgnoreCase("f")) return num;
        if (check == 10) return num;
            check++;
            if (mat[r][c].equalsIgnoreCase("s")) num++;
            if (r-1 < 0 && c-1 < 0) {
                nu(mat, 1, 0, check, num);
                nu(mat, 0, 1, check, num);
                nu(mat, 1, 1, check, num);
            } else if (r+1 >= mat.length && c+1 >= mat[0].length) {
                nu(mat, r-1, c, check, num);
                nu(mat, r, c-1, check, num);
                nu(mat, r-1, c-1, check, num);
            } else if (r-1 < 0 && c+1 < mat[0].length) {
                nu(mat, 1, c, check, num);
                nu(mat, 0, c+1, check, num);
                nu(mat, 1, c+1, check, num);
                nu(mat, 1, c-1, check, num);
                nu(mat, 0, c-1, check, num);
            } else if (c-1 < 0 && r+1 < mat.length) {
                nu(mat, r, 1, check, num);
                nu(mat, r+1, 0, check, num);
                nu(mat, r+1, 1, check, num);
                nu(mat, r-1, 1, check, num);
                nu(mat, r-1, 0, check, num);
            } else if (r+1 >= mat.length && c-1 > 0) {
                nu(mat, r-1, c, check, num);
                nu(mat, r, c-1, check, num);
                nu(mat, r-1, c-1, check, num);
                nu(mat, r-1, c+1, check, num);
                nu(mat, r, c+1, check, num);
            } else if (c+1 >= mat[0].length && r-1 > 0) {
                nu(mat, r, c-1, check, num);
                nu(mat, r-1, c, check, num);
                nu(mat, r-1, c-1, check, num);
                nu(mat, r+1, c-1, check, num);
                nu(mat, r+1, c, check, num);
            } else if (r-1 < 0) {
                nu(mat, 1, c-1, check, num);
                nu(mat, 0, c-1, check, num);
                nu(mat, 1, c, check, num);
            }  else if (c-1 < 0) {
                nu(mat, r, 1, check, num);
                nu(mat, r-1, 1, check, num);
                nu(mat, r-1, 0, check, num);
            } else if (r+1 >= mat.length) {
                nu(mat, r-1, c, check, num);
                nu(mat, r-1, c+1, check, num);
                nu(mat, r, c+1, check, num);
            } else if (c+1 >= mat[0].length) {
                nu(mat, r, c-1, check, num);
                nu(mat, r+1, c-1, check, num);
                nu(mat, r+1, c, check, num);
            } else {
                nu(mat, r-1, c-1, check, num);
                nu(mat, r-1, c, check, num);
                nu(mat, r-1, c+1, check, num);
                nu(mat, r, c-1, check, num);
                nu(mat, r, c+1, check, num);
                nu(mat, r+1, c+1, check, num);
                nu(mat, r+1, c-1, check, num);
                nu(mat, r+1, c, check, num);
            }

        return num;
    }


    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/2024-9a.txt"));
            var strs = new ArrayList<String>();
            while (input.hasNext()) {
                strs.add(input.nextLine());
            }
            var mat = new String[strs.size()][strs.get(0).length()];
            var r = 0;
            var c = 0;
            for (int l = 0; l < strs.size(); l++) {
                for(int lcv = 0 ; lcv < strs.get(l).length(); lcv++) {
                    mat[l][lcv] = strs.get(l).substring(lcv, lcv+1);
                    if (mat[l][lcv].equalsIgnoreCase(">")) {
                        r = l;
                        c = lcv;
                    }
                }
            }
            System.out.println(find(mat, r, c, 0, 0));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
