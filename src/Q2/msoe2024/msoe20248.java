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
            System.out.println("hi " + dw);
        }

        var varw = new ArrayList<String>();
        for (int lcv = 0; lcv < word.length(); lcv++) {
            for (int l = lcv+1; l < word.length()+1; l++) {
                var w = word.substring(lcv, l);
                if (!w.equals(word)) {
                    varw.add(w);
                    System.out.println(w);
                }
            }
        }

        var bin = new ArrayList<Integer>();
        while (dictionary.isEmpty()) {
            dw = dictionary.removeFirst();
            var p = 0;
            for  (int lcv = 0; lcv < dw.length(); lcv++) {
                for (int l = lcv+1; l < dw.length()+1; l++) {
                    for (int y = 0; y < varw.size(); y++) {
                        if (dw.substring(lcv, l).equalsIgnoreCase(varw.get(y))) {
                            if (bin.size() > p) {
                                if (bin.get(p) < varw.get(y).length()) {
                                    bin.set(p, varw.get(y).length());
                                }
                            } else {
                                bin.add(p, varw.get(y).length());
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
        int index = 0;

        for (int l = 0; l < bin.size(); l++) {
            var num = bin.get(l);
        }
    }
}
