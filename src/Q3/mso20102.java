package Q3;

import java.util.Scanner;

public class mso20102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var str = new Scanner(System.in).nextLine();
        System.out.println("Does your line have a triple character in a row? " + trip(str));
    }

    public static boolean trip(String str) {
        for (int i = 0; i < str.length()-2; i++) {
            // str.substring(i, i+2).equals(str.substring(i+1, i+3)
            if (str.charAt(i) == str.charAt(i+1) && str.charAt(i) == str.charAt(i+2)) return true;
        }
        return false;
    }
}
//popppppoooo
//Does your line have a triple character in a row? true

//pdpdpdpd
//Does your line have a triple character in a row? false