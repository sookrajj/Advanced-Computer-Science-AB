package Q2.msoe2024;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.ErrorManager;

public class msoe20249 {

    public int recur(String[][] mat, int r, int c) {
        if (mat[r][c].equalsIgnoreCase("f")) return 0;
        try {
            if (mat[r-1][c-1].equals("-")) return recur(mat, r-1, c-1);
            if (mat[r-1][c-1].equals("-")) return recur(mat, r-1, c-1) + 1;
        } catch (IndexOutOfBoundsException e) {
            return 200000000;
        }
        return 1;
    }


    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/2024-9a.txt"));
            var strs = new ArrayList<String>();
            while (input.hasNext()) {
                strs.add(input.nextLine());
            }
            var mat = new String[strs.size()][strs.get(0).length()];
            for (int l = 0; l < strs.size(); l++) {
                for(int lcv = 0 ; lcv < strs.get(l).length(); lcv++) {
                    mat[l][lcv] = strs.get(l).substring(lcv, lcv+1);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
