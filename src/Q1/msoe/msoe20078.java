package Q1.msoe;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class msoe20078 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/problem8.dat"));
            var length = input.nextInt();
            var width = input.nextInt();
            var alts = new int[length][width];
            for (int lcv = 0; lcv < length; lcv++) {
                for (int l = 0; l < width; l++) {
                    alts[lcv][l] = input.nextInt();
                }
            }
            input.close();
            for (int r = 1; r < alts.length; r++) {
                for (int l = 1; l < alts[0].length; l++) {
                    var num = alts[r][l];
                    if (num >= alts[r-1][l-1] && num >= alts[r][l-1] && num >= alts[r+1][l-1] && num >= alts[r-1][l]) {
                        if (num >= alts[r+1][l] && num >= alts[r][l+1] && num >= alts[r+1][l+1] && num >= alts[r-1][l+1]) {
                            System.out.println("At row " + r+1 + " and column " + l+1 + " is a hill of size " + num);
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
