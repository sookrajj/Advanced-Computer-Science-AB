package Q2.prog1999s;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import DataStructures.*;

public class prog1999s {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog1999s.txt"));
            var bt = new binarySearchTree<recipe>();
            var lines = new ArrayList<String>();
            while (input.hasNext()) {
                lines.add(input.nextLine());
            }
            input.close();

            for (int i = 0; i < Integer.parseInt(lines.get(0)); i++) {
                var line = lines.get(i+1);
                var split = line.split(" ");
                var rec = split[0];
                var i1 = split[1].split(":")[0];
                var i1q = Integer.parseInt(split[1].split(":")[1]);
                var i2 = split[2].split(":")[0];
                var i2q = Integer.parseInt(split[2].split(":")[1]);
                var i3 = split[3].split(":")[0];
                var i3q = Integer.parseInt(split[3].split(":")[1]);
                bt.insert(new recipe(rec, i1, i2, i3, i1q, i2q, i3q));
            }





        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
