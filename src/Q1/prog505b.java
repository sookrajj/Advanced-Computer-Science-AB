package Q1;
import java.io.File;
import java.io.IOException;
import java.util.*;
class strgrad {
    private String f;
    private String l;
    private int[] num = new int[5];
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private double ave;

    public strgrad(String first, String last, int[] nums) {
        f = first;
        l = last;
        num = nums;
        ave = 0;
        calc();
        num1 = num[0];
        num2 = num[1];
        num3 = num[2];
        num4 = num[3];
        num5 = num[4];
    }

    private void calc() {
        double total = 0;
        for (int n : num) {
            total += n;
        }
        ave = total/num.length;
    }

    public String getF() {return f;}

    public String getL() {
        return l;
    }

    public double getAve() {
        return ave;
    }

    public int[] getNum() {
        return num;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }

    public int getNum4() {
        return num4;
    }

    public int getNum5() {
        return num5;
    }
}

public class prog505b {
//  public class prog505bcl {
//    private double[] test;
//    private double ave;
//
//    public prog505bcl(double[] tests) {
//      test = tests;
//      calc();
//    }
//
//    private void calc() {
//      double total = 0;
//      for (double i : test) {
//        total += i;
//      }
//      ave = total/test.length;
//    }
//
//    public double getAve() {return ave;}
//  }


    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("Langdat/prog505b.dat"));
            ArrayList<strgrad> peps = new ArrayList<>();
            String f = "";
            String l = "";
            int[] nums = new int[5];
            while(s.hasNext()) {
                f = s.next();
                l = s.next();
                nums[0] = s.nextInt();
                nums[1] = s.nextInt();
                nums[2] = s.nextInt();
                nums[3] = s.nextInt();
                nums[4] = s.nextInt();
                peps.add(new strgrad(f, l, nums));
            }

            double[] exams = new double[5];
            int[] grades = new int[5];
            for (int lcv = 0; lcv < peps.size(); lcv++) {
                System.out.print(peps.get(lcv).getF() + " " + peps.get(lcv).getL());
                int ex1 = peps.get(lcv).getNum1();
                int ex2 = peps.get(lcv).getNum2();
                int ex3 = peps.get(lcv).getNum3();
                int ex4 = peps.get(lcv).getNum4();
                int ex5 = peps.get(lcv).getNum5();
                System.out.print("\t\t" + ex1 + "\t" + ex2 + "\t" + ex3 + "\t" + ex4 + "\t" + ex5);
                double hi = peps.get(lcv).getAve();
                if (hi > 90) {
                    grades[0]++;
                    System.out.print("\t\t" + hi + "  A\n");
                } else if (hi > 80) {
                    grades[1]++;
                    System.out.print("\t\t" + hi + "  B\n");
                } else if (hi > 70) {
                    grades[2]++;
                    System.out.print("\t\t" + hi + "  C\n");
                } else if (hi > 60) {
                    grades[3]++;
                    System.out.print("\t\t" + hi + "  D\n");
                } else {
                    grades[4]++;
                    System.out.print("\t\t" + hi + "  F\n");
                }
                exams[0] += ex1;
                exams[1] += ex2;
                exams[2] += ex3;
                exams[3] += ex4;
                exams[4] += ex5;
            }

            exams[0] /= 3;
            exams[0] = Math.round(exams[0]*100);
            exams[0] /= 100;
            exams[1] /= 3;
            exams[2] /= 3;
            exams[3] /= 3;
            exams[4] /= 3;
            exams[3] = Math.round(exams[3]*100);
            exams[3] /= 100;
            System.out.println("\nTest 1:\t\t" + exams[0] + "\t\tA: " + grades[0]);
            System.out.println("\nTest 2:\t\t" + exams[1] + "\t\tB: " + grades[1]);
            System.out.println("\nTest 3:\t\t" + exams[2] + "\t\tC: " + grades[2]);
            System.out.println("\nTest 4:\t\t" + exams[3] + "\t\tD: " + grades[3]);
            System.out.println("\nTest 5:\t\t" + exams[4] + "\t\tF: " + grades[4]);

        } catch (IOException e) {
            System.out.println("Can't find data file.");
        }
    }
}
//Sam Lilly		80	77	82	86	90		83.0  B
//Fred Biggie		70	72	88	90	93		82.6  B
//Sally Awesome		92	91	85	99	93		92.0  A
//
//Test 1:		80.67		A: 1
//
//Test 2:		80.0		B: 2
//
//Test 3:		85.0		C: 0
//
//Test 4:		91.67		D: 0
//
//Test 5:		92.0		F: 0

