package Q1;
import java.util.*;

public class MSOE20072 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int vowels = 0;
        System.out.print("Enter a sentence: ");
        String hi = input.nextLine();
        hi = hi.toLowerCase(Locale.ROOT);
        for (int lcv = 0; lcv < hi.length(); lcv++) {
            String let = hi.substring(lcv, lcv+1);
            if (let.equals("a") || let.equals("e") || let.equals("i") || let.equals("o") || let.equals("u")) {
                vowels++;
            }
        }

        System.out.println("The number of vowels in your sentence is: " + vowels);
    }
}
//Enter a sentence: man what the heck man I don't know man the man man people are crazy man
//The number of vowels in your sentence is: 19