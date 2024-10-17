package Q1.msoe;

import java.lang.Math.*;
import java.util.Scanner;

public class msoe20094 {
    public static double f(double x) {
        return Math.exp(-x*x/2)/Math.sqrt(2*Math.PI);
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("What is A: ");
        var a = input.nextInt();
        System.out.print("What is B: ");
        var b = input.nextInt();
        System.out.print("The number of panels: ");
        var n = input.nextInt();
        var h = ((double)b-a)/n;
        var area = 0.0;
        for (int lcv = 0; lcv < n-1; lcv++) {
            area += f(a + lcv*h);
        }
        System.out.println("The area is: " + area);
    }
}
