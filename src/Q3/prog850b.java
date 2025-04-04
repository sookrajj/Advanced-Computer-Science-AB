package Q3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class prog850b {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog850b.dat"));
            var map = new HashMap<String, Integer>();

            while (input.hasNext()) {
                var line = input.nextLine().split(" ");
                if (line.length == 5) {
                    var name = line[0];
                    var tot = Integer.parseInt(line[4]);
                    if (map.containsKey(name)) map.put(name, (map.get(name) + tot));
                    else map.put(name, tot);
                }
            }
            input.close();
            var keys = map.keySet();
            for (String key : keys) {
                System.out.println(key + " " + map.get(key));
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//Ryan 1243
//Number 1190
//Getka 651
//Taylor 715
//Computer 739
//Sam 279
//Business 583