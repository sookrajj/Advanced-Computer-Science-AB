package Q1.msoe;

import java.util.Scanner;

public class msoe20076 {
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
        for (int lcv = 0; lcv <= n; lcv++) {
            area += f(a + lcv*h);
        }
        area *= h;
        System.out.println("The area is: " + area);
    }
}
//What is A: -1
//What is B: 2
//The number of panels: 100000
//The area is: 0.818599053519473