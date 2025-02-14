package Q3;

import java.util.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class peli54_7 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/HeapData.in"));
            var hep = new PriorityQueue<String>();
            while (input.hasNext()) {
                hep.add(input.next());
            }
            input.close();

            int num = 0;
            String[] pop = new String[hep.size()];
            int it = 0;
            while(!hep.isEmpty()) {
                pop[it] = hep.remove();
                it++;
            }

            for (int i = 0; i < pop.length; i++) {
                if (i == 1 || i == 3 || i == 7 || i == 15) {
                    System.out.println();
                }
                System.out.print(pop[i] + " ");
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//A
//C D
//G M N P
//Q S T U W Z