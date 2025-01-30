package Q3;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class msoe20145 {
    public static void main(String[] args) {
        var primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};
        //  1,  2, 2, 4,  2,  4,  2,  4,  6, 2,  6,  4,  2,  4,  6,
        var input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        var number = input.nextInt();
//        var totali = 0.0;
//        var n = number / 5.0;
//        for (int i = 0; i < Math.pow(2, n); number++) {
//            var totalj = 0.0;
//
//            for(int j = 0; j < i; j++) {
//                var fact = j-1.0;
//                for (int y = j-2; y > 0; y--) {
//                    fact *= y;
//                }
//                totalj += Math.pow(Math.cos(( fact + 1.0)/j * Math.PI), 2);
//            }
//            if (totalj != 0.0) {
//                totali += Math.pow((n / totalj), 1 / n);
//            }
//        }

        var num = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        var index = 0;
        while (number != 1) {
            if (number % primes[index] == 0) {
                num[index] += 1;
                number /= primes[index];
            } else {
                index++;
            }
        }

        var total = 1;
        var s = "";
        var ns = "";
        for (int l = 0; l < num.length; l++) {
            if (num[l] > 0) {
                var p = primes[l];
                var pow = num[l];
                s += p + "^" + pow + " ";
                ns += p + "^" + (pow-1) + " ";
                total *= Math.pow(p, pow-1);
            }
        }

        System.out.println(s + " -> " + ns + " = " + total);
    }
}
//Enter a number: 44100
//2^2 3^2 5^2 7^2  -> 2^1 3^1 5^1 7^1  = 210