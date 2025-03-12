package Q3.prog402a;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import DataStructures.Dictionary;

public class prog402a {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("Langdat/prg402a.dat"));
            Set<cl402a> set = new HashSet<>();
            int cnt = 0;
            double mean = 0.0;

            double asc = 0.0;
            int[] alsc = new int[100];

            while (input.hasNext()) {
                int id = input.nextInt();
                int scores = input.nextInt();

                if(id != -999) {
                    cl402a yikes = new cl402a(id, scores);
                    set.add(yikes);
                    alsc[cnt] = scores;
                    cnt++;
                }
                asc += scores;
                mean = asc/cnt;

            }

            var iter = set.iterator();
            System.out.println("ID\tScore\tDiff");
            while (iter.hasNext()) {
                var per = iter.next();
                var score = per.getMyid();
                System.out.println(per.toString() + "\t" + Math.round((score-mean) * 100.0) / 100.0);
            }
            System.out.println("Average score = " + Math.round((mean) * 100.0) / 100.0);

        } catch (IOException e) {
            System.out.println("Can't find data file.");
        }
    }
}
//ID	Score	Diff
//207		228	-14.62
//323		245	2.38
//213		229	-13.62
//123		253	10.38
//223		230	-12.62
//208		242	-0.62
//222		223	-19.62
//305		265	22.38
//306		262	19.38
//311		256	13.38
//325		246	3.38
//218		243	0.38
//301		242	-0.62
//113		243	0.38
//104		239	-3.62
//112		239	-3.62
//116		246	3.38
//110		238	-4.62
//321		245	2.38
//115		257	14.38
//203		224	-18.62
//Average score = 242.62