package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import DataStructures.Set;

public class prog505a {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("Langdat/prog505a.dat"));
            Set<cl505a> list = new Set<cl505a>();


            while (s.hasNext()) {
                String fName = s.next();
                String lname = s.next();
                int books = s.nextInt();
                String name = fName + " " + lname;

                cl505a wowser = new cl505a(name, books);
                list.insert(wowser);
            }

            var iter = list.iterator();

            while (iter.hasNext()) {
                iter.next().calc();
            }

            for (cl505a x : list) {
                System.out.println(x);
            }

            double tot = 0;
            for (cl505a p : list) { tot += p.getPoints();}
            double avg = tot / list.size();
            System.out.println("\nAverage Points " + avg);
            var ite = list.iterator();
            int bigPoints = ite.next().getPoints();
            int index = 0;

            while (ite.hasNext()) {
                var points = ite.next().getPoints();
                if (points > bigPoints) {
                    bigPoints = points;
                }
            }
//            for (int lcv = 1; lcv < list.size(); lcv++) {
//                if (list.get(lcv).getPoints() > bigPoints) {
//                    bigPoints = list.get(lcv).getPoints();
//                    index = lcv;
//                }
//            }
            var it = list.iterator();
            while (it.hasNext()) {
                var person = it.next();
                if (person.getPoints() == bigPoints) {
                    System.out.println("\nThe person with the biggest points is " + person.toString());
                }
            }



        } catch (
                IOException e) {
            System.out.println("Can't find data file.");
        }
    }
}

//Sam Summer	4	45
//K.C. Master	8	115
//Richie Reader	6	75
//Paul Prodder	5	60
//Linda Lazy	2	20
//
//Average Points 63.0
//
//The person with the biggest points is K.C. Master	8	115