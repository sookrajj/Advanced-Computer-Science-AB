package Q3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringInter5 {
    public static void main(String[] args) {
        System.out.println("Enter a String: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        var numpat = Pattern.compile("[0-9]");
        var nums = new boolean[10];
        var sPattern = numpat.matcher(s);
        while (sPattern.find()) {
            char cha = sPattern.group().charAt(0);
            nums[cha - '0'] = true;
        }
        boolean con = s.contains("0") ? s.contains("1") ? s.contains("2") ? s.contains("3") ? s.contains("4") ? s.contains("5") ? s.contains("6") ? s.contains("7") ? s.contains("8") ? s.contains("9") ? true : false : false : false : false : false : false : false : false : false : false;
        System.out.println(con);
        boolean num = nums[0] ? nums[1] ? nums[2] ? nums[3] ? nums[4] ? nums[5] ? nums[6] ? nums[7] ? nums[8] ? nums[9] ? true : false : false : false : false : false : false : false : false : false : false;
        System.out.println(num);
    }
}
