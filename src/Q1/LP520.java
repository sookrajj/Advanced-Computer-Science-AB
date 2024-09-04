package Q1;
import java.util.*;

public class LP520 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        int num = 0;
        String[] vowels = new String[5];
        vowels[0] = "a";
        vowels[1] = "e";
        vowels[2] = "i";
        vowels[3] = "o";
        vowels[4] = "u";
        text = text.toLowerCase();
        for (int lcv = 0; lcv < text.length(); lcv++) {
            if (text.substring(lcv, lcv+1).equals(vowels[0]) || text.substring(lcv, lcv+1).equals(vowels[1]) || text.substring(lcv, lcv+1).equals(vowels[2]) || text.substring(lcv, lcv+1).equals(vowels[3]) || text.substring(lcv, lcv+1).equals(vowels[4])) {
                num++;
            }
        }
        System.out.print("The number of vowels in " + text + " is " + num);
    }
}
//Enter text: Java Programming Assignment
//The number of vowels in java programming assignment is 8