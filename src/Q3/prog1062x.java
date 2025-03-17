package Q3;

import DataStructures.LRUCach;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog1062x {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog1062x.dat"));
            var cache = new LRUCach<Integer, String>(3);
            while (input.hasNext()) {
                var str = input.nextLine().split(" ");
                if (str.length == 1) {
                    cache.report();
                } else if (str.length == 2) {
                    System.out.println(cache.get(Integer.parseInt(str[1])));
                } else {
                    cache.put(Integer.parseInt(str[1]), str[2]);
                }
            }

            input.close();
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
