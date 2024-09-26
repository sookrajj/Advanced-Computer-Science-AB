package Q1;

import java.util.*;

public class MSOE20071 {
  public static void main(String[] args) {
    var input = new Scanner(System.in);
    System.out.print("What is the length of the first shadow?  ");
    double nums1 = input.nextInt();
    System.out.print("\nWhat is the length of the second shadow?  ");
    double nums2 = input.nextInt();
    System.out.print("\nWhat is the height of the known height?  ");
    double numh1 = input.nextInt();
    if (nums1 < 0 || nums2 < 0 || numh1 < 0) {
      System.out.print("\nThere is an invalid number");
    } else {
        double numh2 = numh1 * nums2 / nums1;
        System.out.print("\nThe height of the unknown height is: " + numh2);
    }
  }
}

