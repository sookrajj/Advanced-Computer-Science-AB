package Q1.msoe;

import java.util.Scanner;

public class msoe20115 {
    private static final double a6 = -0.09;
    private static final double a5 = 1.6108;
    private static final double a4 = -10.9167;
    private static final double a3 = 34.7625;
    private static final double a2 = -52.0433;
    private static final double a1 = 31.1767;
    private static final double a = -4;
    public static double fprime(double x) {
        return (6*a6*Math.pow(x, 5) + 5*a5*Math.pow(x, 4) + 4*a4*Math.pow(x, 3) + 3*a3*Math.pow(x, 2) + 2*a2*x + a1);
    }

    public static double f(double x) {
        return (a6*Math.pow(x, 6) + a5*Math.pow(x, 5) + a4*Math.pow(x, 4) + a3*Math.pow(x, 3) + a2*Math.pow(x, 2) + a1*x + a);
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("What is the X: ");
        var x = input.nextDouble();
        System.out.println("Initial position: f(" + x + ") = " + f(x));
        while (Math.abs(f(x)) > 0.001) {
            x = x - f(x)/fprime(x);
            System.out.println("Refined zero: f(" + x + ") = " + f(x));
        }
    }
}
//What is the X: 4
//Initial position: f(4.0) = -1.0420000000000726
//Refined zero: f(3.5623503717081433) = 0.23991069198689274
//Refined zero: f(3.6428829450291587) = -0.0050482617523499584
//Refined zero: f(3.6412487852135498) = -1.0705302173619202E-6