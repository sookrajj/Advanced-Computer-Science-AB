package Q1.msoe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class msoe20075 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Type in a sentence: ");
        var line = input.nextLine();
        var longstr = new ArrayList<String>();
        var longest = 1;
        var check = 1;
        var strs = "";
        for (int lcv = 0; lcv < line.length()-2; lcv++) {
            if (line.substring(lcv, lcv+1).equals(line.substring(lcv+1, lcv+2)) && line.length()-lcv >= check) {
                check = 2;
                lcv++;
                while (line.substring(lcv, lcv+1).equals(line.substring(lcv+1, lcv+2)) && lcv <= line.length()-2) {
                    lcv++;
                    check++;
                }
                if (check >= longest) {
                    longstr.add(line.substring(lcv-check+1, lcv+1));
                    longest = check;
                    System.out.println(check);
                }
            }
        }
        var last = longstr.get(longstr.size()-1);
        for (int lcv = 0; lcv < longstr.size(); lcv++) {
            if (longstr.get(lcv).length() < last.length()) {
                longstr.remove(lcv);
                lcv--;
            }
        }
        strs = "" + longest + "";
        for (int lcv = 0; lcv < line.length()-longest+1; lcv++) {
            var let = line.substring(lcv, lcv+longest);
            boolean iscombo = false;
//            if (let.equals(line.substring(lcv+1, lcv+2))) {
//                var temp = longest-2;
//                for (int i = lcv+1; i < longest-2 && i < line.length()-1; i++) {
//                    if (let.equals(line.substring(i, i+1))) {
//                        temp--;
//                        System.out.println(temp + "in");
//                    }
//                }
//                if (temp == 0) iscombo = true;
//            }
            if (longstr.isEmpty()) {
                break;
            }
            if (let.equals(longstr.get(0))) {
                iscombo = true;
                longstr.remove(0);
            }
            if (iscombo) strs += " " + let.substring(0, 1);
        }
        System.out.println(strs);
    }
}
