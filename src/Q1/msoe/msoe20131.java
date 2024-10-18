package Q1.msoe;
import java.util.*;

public class msoe20131 {
  public static void main (String[] args) {
    var input = new Scanner(System.in);
    var n1 = input.nextInt();
    var n2 = input.nextInt();
    var n3 = input.nextInt();
    var v = input.nextInt();
    var a1 = (double)v/n1;
    var a2 = (double)v/n2;
    var a3 = (double)v/n3;
    var a = a1+a2+a3;
    System.out.println(v/a + "Ω");
  }
}
