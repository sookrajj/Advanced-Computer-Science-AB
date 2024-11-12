package Q2;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.*;

public class prog1060h {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/Replace.dat"));
            Queue<String> que = new PriorityQueue<>();
            while (input.hasNext()) {
                var t = input.next();
                if (t.equalsIgnoreCase("A")) {

                }
            }
            input.close();
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
