package Q1.msoe;
import java.util.*;

public class msoe20141 {
  public static void main(String[] args) {
    var input = new Scanner(System.in);
    System.out.print("Enter a word: ");
    var str = input.nextLine();
    str.toLowerCase();
    var num = 0;
    for (int lcv = 0; lcv < str.length()-1; lcv++) {
      if (str.charAt(lcv) == str.charAt(lcv+1)) {
        num++;
      }
    }
    System.out.println("The number of double letters in " + str + " is " + num);
  }
}
