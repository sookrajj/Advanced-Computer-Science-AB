package Q1;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public prog705x {

  public static class hold {
    private int series;
    private String cha;

    public hold(int nums, String character) {
      series = nums;
      cha = character;
    }

    public int getSeries() {return series;}
    pubilc String getCha() {return cha;}
  }
  public static void main(String[] args) {
    try {
            Scanner s = new Scanner(new File("Langdat/prog512h.dat"));
            Scanner stuff = new Scanner(new File("Langdat/prog705x.txt"));
            ArrayList<hold> spe = new ArrayList<>();
            ArrayList<String> poem = new ArrayList<>();


            while (s.hasNext()) {

            }



        } catch (
                IOException e) {
            System.out.println("Can't find data file.");
        }
  }
}
