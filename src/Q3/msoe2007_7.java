package Q3;

import java.util.Scanner;

public class msoe2007_7 {
    public static void main(String[] args) {
        var t = new Scanner(System.in);
        System.out.println("give a odometer reading");
        int orig = t.nextInt();
        helper he = new helper(orig);
        System.out.println("The distance to next palindrome is " + he.dist);

    }

    public static class helper{
        int orig;
        int dist;

        public helper(int orig) {
            this.orig = orig;
            calc();
        }

        public void calc() {
            int digits = 0;
            for (int i = 0; i < 10; i++) {
                if (Math.round(orig / Math.pow(10, i)) != 0) {
                    digits++;
                }
            }
            int cop = orig;
            for (int i = 1; i < Math.round(Math.log10(orig)) / 2 + 1; i++) {
                var ro = Math.floor(cop / Math.pow(10, digits-i));
                if (cop % 10 < ro) {
                    dist += (cop / ro - cop % 10) * Math.pow(10, i-1);
                } else if (cop % 10 > ro) {
                    dist += (10 + ro - cop % 10) * Math.pow(10, i-1);
                    cop += (10 + ro - cop % 10) * Math.pow(10, i-1);
                }
                cop %= Math.pow(10, digits-i);
                cop /= 10;
                digits--;
            }



        }

        public int getDist() {
            return dist;
        }
    }
}
//give a odometer reading
//12735
//The distance to next palindrome is 86

//give a odometer reading
//123321
//The distance to next palindrome is 0