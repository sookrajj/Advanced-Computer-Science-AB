package Q3;

import java.util.Scanner;

public class msoe2007_7 {
    public static void main(String[] args) {
        var t = new Scanner(System.in);
        System.out.println("give a odometer reading");
        int orig = t.nextInt();


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
                if (orig / Math.pow(10, i) != 0) {
                    digits++;
                }
            }
            for (int i = 1; i < Math.round(Math.log10(orig)); i++) {
                if (orig % Math.pow(10, i) < orig % Math.pow(10, i)) {

                }
            }
        }
    }
}
