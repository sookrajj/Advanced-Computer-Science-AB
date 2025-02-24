package Q3;

import java.util.Scanner;

public class msoe2007_7 {
    public static void main(String[] args) {
        var t = new Scanner(System.in);
        System.out.println("give the number of digits");
        int digits = t.nextInt();
        System.out.println("give a odometer reading");
        int orig = t.nextInt();
        helper he = new helper(orig, digits);
        System.out.println("The distance to next palindrome is " + he.dist);

    }

    public static class helper{
        int orig;
        int digits;
        int dist;

        public helper(int orig, int digits) {
            this.orig = orig;
            this.digits = digits;
            calc();
        }

        public void calc() {
            int cop = orig;
            int dig = digits;
            for (int i = 0; i < dig / 2 + 1; i++) {
                var ro = Math.floor(cop / Math.pow(10, digits-1));
                if (cop % 10 < ro) {
                    dist += (ro - cop % 10) * Math.pow(10, i);
                } else if (cop % 10 > ro) {
                    var mult = Math.pow(10, i);
                    if (i == 0) {
                        mult = 0;
                        dist += (10 + ro - cop % 10) + mult;
                        cop += (10 + ro - cop % 10) + mult;
                    } else if (digits == 2) {
                        dist += (10 + ro - cop % 10) * mult + mult;
                        cop += (10 + ro - cop % 10) * mult + mult;
                    }else {
                        dist += (10 + ro - cop % 10) * mult;
                        cop += (10 + ro - cop % 10);
                    }
                }
                cop %= Math.pow(10, digits-1);
                cop /= 10;
                digits--;
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

//give the number of digits
//4
//give a odometer reading
//14
//The distance to next palindrome is 96