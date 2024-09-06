package Q1;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class prog505b {
  public class prog505bcl {
    private double[] test;
    private double ave;

    public prog505bcl(double[] tests) {
      test = tests;
      calc();
    }

    private void calc() {
      double total = 0;
      for (double i : test) {
        total += i;
      }
      ave = total/test.length;
    }

    public double getAve() {return ave;}
  }
  public class strgrad {
      private String f;
      private String l;
      private double ave;
  }

  public static void main(String[] args) {
    try {
        Scanner s = new Scanner(new File("Langdat/prog505b.dat"));

        String f = "";
        String l = "";

    } catch (IOException e) {
        System.out.println("Can't find data file.");
    }
  }
}
    
