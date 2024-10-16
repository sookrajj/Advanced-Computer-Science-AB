package Q1.msoe;

import java.util.Scanner;

public class msoe20095 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        var t = input.nextInt();
        boolean div = false;
        for (int lcv = 2; lcv < t; lcv++) {
            if (t%lcv == 0) {
                div = true;
                break;
            }
        }
        if (div) {
            System.out.println("This number is not a prime number.");
        } else {
            System.out.println("This is a prime number.");
        }
    }
}
//Enter a number:
//293
//This is a prime number.
//Enter a number:
//7429
//This number is not a prime number.