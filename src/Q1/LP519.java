package Q1;
import java.util.*;
public class LP519 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter a Sentence: ");
        String sent = input.nextLine();
        System.out.print("Enter a word to banish: ");
        String ban = input.nextLine();

        String news = "";
        for (int lcv = 0; lcv < sent.length()-ban.length(); lcv++) {
            if (sent.substring(lcv, lcv+ban.length()).equals(ban)) {
                lcv += ban.length();
            } else {
                news += sent.substring(lcv, lcv+1);
            }
        }
        if (!sent.substring(sent.length()-ban.length()).equals(ban)) {
            news += sent.substring(sent.length()-ban.length());
        }
        System.out.println(news);
    }
}
//Enter a Sentence: I really hope you get an interview
//Enter a word to banish: really
//I hope you get an interview