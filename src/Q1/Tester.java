package Q1;

import java.io.*;
import java.util.*;
public class Tester
{
    public static void main(String args[])
    {
        Scanner kbReader = new Scanner(System.in);
        System.out.print("Generate which term number? ");
        int k = kbReader.nextInt( );
        System.out.println("Term #" + k + " is " + modFibonacci(k));
    }

    public static int modFibonacci(int k) {
        if (k == 0) return 3;
        if (k == 1) return 5;
        if (k == 2) return 8;
        return modFibonacci(k-1) + modFibonacci(k-2) + modFibonacci(k-3);
    }
}
//Generate which term number? 5
//Term #5 is 53
//Generate which term number? 6
//Term #6 is 98