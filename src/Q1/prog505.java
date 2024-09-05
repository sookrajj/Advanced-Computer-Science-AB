package Q1;
import java.util.*;

public class prog505a {
  public static prog505cl {
    private double[] test;
    private double ave;

    public prog505cl(double[] tests) {
      test = tests;
      calc();
    }

    private void calc() {
      double total = 0;
      for (double i in test) {
        total += i;
      }
      ave = total/test.length;
    }

    public getAve() {return ave;}
  }

  public static void main(String[] args) {
    try {
            Scanner s = new Scanner(new File("Langdat/prog505b.dat"));
            ArrayList<> yay = new ArrayList<>();
            String f = "";
            String l = "";

        } catch (IOException e) {
            System.out.println("Can't find data file.");
        }
  }
}
    
