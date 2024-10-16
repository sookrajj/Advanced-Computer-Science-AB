package Q1.msoe;
import java.util.*;

public class msoe20086 {
  public static void main(String args[]) {
    var input = new Scanner(System.in);
    System.out.print("First string: ");
    var fir = input.nextLine();
    System.out.print("Second string: ");
    var sec = input.nextLine();
    var num = 0;
    for (int lcv = 0; lcv < fir.length()-sec.length()+1; lcv++) {
      if (fir.substring(lcv, lcv+sec.length()).equals(sec)) {
        num++;
      }
    }
    System.out.println("The second string was in the first string " + num);
  }
}
//First string: atatatatatatatata
//Second string: ata
//The second string was in the first string 8