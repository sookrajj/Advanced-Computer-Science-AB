package Q1;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class prog705x {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("Langdat/prog705x.txt"));
            Scanner stuff = new Scanner(new File("Langdat/prog512h.dat"));
            ArrayList<Integer> spe = new ArrayList<>();
            ArrayList<String> poem = new ArrayList<>();


            while (s.hasNext()) {
                spe.add((s.nextInt()));
            }
            while (stuff.hasNext()) {
                poem.add(stuff.nextLine());
            }
            int hi = 0;
            for (int ho : spe) {
                if (ho%100 > hi) {
                    hi = ho%100;
                }
            }
//            if (poem.size() < hi) {
//                for (int lcv = 0; lcv <= hi - poem.size(); lcv++) {
//                    if (lcv > poem.size()) {
//                        poem.add(poem.get(lcv%poem.size()));
//                    } else {
//                        poem.add(poem.get(lcv));
//                    }
//                }
//            }
            ArrayList<Integer> line = new ArrayList<>();
            ArrayList<Integer> word = new ArrayList<>();
            ArrayList<Integer> pos = new ArrayList<>();
            for (int lcv = 0; lcv < spe.size(); lcv++) {
                line.add(spe.get(lcv)/100);
                spe.set(lcv, spe.get(lcv)%100);
                word.add(spe.get(lcv)/10);
                spe.set(lcv, spe.get(lcv)%10);
                pos.add(spe.get(lcv));
            }
            String putto = "";
            for (int lcv = 0; lcv < spe.size(); lcv++) {
                String lie = poem.get(line.get(lcv)-1);

                for (int l = 0; l < word.get(lcv)-1; l++) {
                    lie = lie.substring(lie.indexOf(" ")+1);
                }
                putto += lie.substring(pos.get(lcv)-1, pos.get(lcv));
            }
            System.out.println("The word is " + putto);



        } catch (
                IOException e) {
            System.out.println("Can't find data file.");
        }
    }
}
//The word is coolbeans