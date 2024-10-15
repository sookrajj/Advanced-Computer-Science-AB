package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class msoe20075 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Type in a sentence: ");
        var line = input.nextLine();
        var longstr = "";
        var longest = 1;
        var check = 1;
        var strs = new ArrayList<String>();
        for (int lcv = 0; lcv < line.length()-1; lcv++) {
            if (line.substring(lcv, lcv+1).equals(line.substring(lcv+1, lcv+2))) {
                check = 2;
                while (line.substring(lcv, lcv+1).equals(line.substring(lcv+1, lcv+2)) && lcv != line.length()) {
                    lcv++;
                    check++;
                }
                if (check > longest) {
                    longstr = line.substring(lcv-check+1, lcv+1);
                    System.out.println(longstr);
                }
            }
        }
        strs.add("" + longest + "");
        for (int lcv = 0; lcv < line.length()-longest; lcv++) {

        }
    }
}
