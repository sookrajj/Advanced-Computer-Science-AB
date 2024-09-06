package Q1;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public prog705x {
  public static void main(String[] args) {
    try {
            Scanner s = new Scanner(new File("Langdat/prog705x.txt"));
            Scanner stuff = new Scanner(new File("Langdat/prog512h.dat"));
            ArrayList<int> spe = new ArrayList<>();
            ArrayList<String> poem = new ArrayList<>();


            while (s.hasNext()) {
                spe.add(new hold(s.nextInt()));
            }
            while (stuff.hasNext()) {
              poem.add(stuff.nextLine());
            }
            int hi = 0;
            for (hold ho : spe) {
              if (ho%100 > hi) {
                hi = ho%100;
              }
            }
            if (poem.size() < hi) {
              for (int lcv = 0; lcv < hi - poem.size(); lcv++) {
                if (lcv > poem.size()) {
                  poem.add(poem.get(lcv%poem.size()));
                } else {
                  poem.add(poem.get(lcv));
                }
              }
            }
            ArrayList<int> line = new ArrayList<>();
            



        } catch (
                IOException e) {
            System.out.println("Can't find data file.");
        }
  }
}
