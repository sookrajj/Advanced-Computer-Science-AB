package Q3;

import DataStructures.Dictionary;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class prog215hMap {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("Langdat/prog215h.txt"));
            var map = new Dictionary<Integer, String>();
            int person = 1;


            while (s.hasNext()) {
                double num1 = s.nextDouble();
                double num2 = s.nextDouble();
                double num3 = s.nextDouble();
                double num4 = s.nextDouble();
                double num5 = s.nextDouble();
                double num6 = s.nextDouble();
                double num7 = s.nextDouble();
                double num8 = s.nextDouble();
                runnerscore hi = new runnerscore(num1, num2, num3, num4, num5, num6, num7, num8);
                hi.calc();
                map.insert(person, hi.toString());
                person++;
            }
            for (int i = 1; i < map.size()+1; i++) {
                System.out.println("Contestant " + i + "\n" + map.get(i));
            }



        } catch (
                IOException e) {
            System.out.println("Can't find data file.");
        }
    }
}
//Contestant 1
//8.4 9.1 8.5 8.4 9.1 8.7 8.8 9.1 =8.7625
//
//Contestant 2
//7.0 7.0 7.0 7.0 7.0 7.0 7.0 7.0 =7.0
//
//Contestant 3
//8.0 7.9 8.0 8.0 8.0 8.0 8.0 8.1 =8.0
//
//Contestant 4
//6.1 7.1 8.1 8.1 8.2 8.2 7.2 6.2 =7.4
//
//Contestant 5
//7.2 7.7 7.8 8.8 7.5 6.3 9.2 7.3 =7.725
//
//Contestant 6
//6.8 6.9 7.3 8.8 6.7 7.7 7.9 6.3 =7.3