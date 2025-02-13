package Q3;

import java.util.*;


public class pelican45_3 {
    public static void main(String[] args) {
        var set1 = new HashSet<String>();
        set1.add("Bill");
        set1.add("Larry");
        set1.add("Adolph");
        set1.add("Regina");
        set1.add("Susie");
        var set2 = new HashSet<String>();
        set2.add("Larry");
        set2.add("Jack");
        set2.add("Alice");
        set2.add("June");
        set2.add("Benny");
        set2.add("Susie");
        set1.retainAll(set2);

        var iter = set1.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
//Susie
//Larry