package Q2.msoe2024;

import java.util.*;

public class msoe20248 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("enter a word:");
        var word = input.nextLine();
        var dictionary = new ArrayList<String>();
        var dw = input.nextLine();
        dictionary.add(dw);
        while (!dw.equals("")) {
            dw = input.nextLine();
            dictionary.add(dw);
        }

        var varw = new ArrayList<String>();
        for (int lcv = 0; lcv < word.length(); lcv++) {
            for (int l = lcv+1; l < word.length()+1; l++) {
                var w = word.substring(lcv, l);
                if (!w.equals(word)) {
                    varw.add(w);
//                    System.out.println(w);
                }
            }
        }
        var p = 0;
        var bin = new ArrayList<Integer>();
        for (int l = 0; l < dictionary.size(); l++) {
            dw = dictionary.get(l);

            for  (int lcv = 0; lcv < dw.length(); lcv++) {
                for (int li = lcv+1; li < dw.length()+1; li++) {
                    for (int y = 0; y < varw.size(); y++) {
                        if (dw.substring(lcv, li).equalsIgnoreCase(varw.get(y))) {
                            if (bin.size() > p) {
                                if (bin.get(p) < varw.get(y).length()) {
                                    bin.set(p, varw.get(y).length()+1);
                                }
                            } else {
                                bin.add(p, varw.get(y).length()+1);
                            }
                        }
                    }
                }
            }
            if (bin.size() == p) {
                bin.add(p, 0);
            }
            p++;
        }
        int max = bin.get(0);
        for (int l = 0; l < bin.size(); l++) {
            var num = bin.get(l);
            if (num > max && num != word.length()) {
                max = num;
            }
        }

        for (int i = 0; i < bin.size(); i++) {
            if (bin.get(i) == max && !dictionary.get(i).contains(word)) {
                System.out.println(dictionary.get(i));
            }
        }
    }
}
/*
grand
are
bandersnatch
bangle
branch
breakfast
grandfather
great
hand
plant
 */
/*
fien
friend
foe
fie
foe
fum

friend
fie
 */
/*
grand
are
bandersnatch
bangle
branch
breakfast
grandfather
great
hand
plant

bandersnatch
branch
hand
 */