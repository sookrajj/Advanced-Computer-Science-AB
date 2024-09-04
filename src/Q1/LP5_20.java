package Q1;

import java.util.*;

public static void main(Strings[] args) {
  System.out.print("Enter text: ");
  String text = input.nextLine()

  int num = 0;
  String[] vowels = new String["a", "e", "i", "o", "u"];
  text.toLowerCase();
  for (int lcv = 0; lcv < text.length(); lcv++) {
    if (text.charAt(lcv).equals(vowels[0]) || text.charAt(lcv).equals(vowels[1]) || text.charAt(lcv).equals(vowels[2]) || text.charAt(lcv).equals(vowels[3]) || text.charAt(lcv).equals(vowels[4])) {
      num++;
    }
  }
  System.out.print("/nThe number of vowels in " + text + " is " + num);
}
