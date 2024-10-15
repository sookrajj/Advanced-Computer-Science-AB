package Q1;
import DataStructures.DoublyLinkedList;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class prog1061h {
    public static void main(String[] args) {
        var list = new DoublyLinkedList<String>();
        try {
            var input = new Scanner(new File("Langdat/prg1061h.dat"));
            var line = "";
            while (input.hasNext()) {
                line = input.nextLine();
                var fir = line.substring(0, 1);
                line = line.substring(1);
                if (fir.equals("P")) {
                    list.print();
                } else if (fir.equals("A")) {
                    list.addSorted(line);
                } else if (fir.equals("D")) {
                    list.remove(line);
                } else {
                    System.out.println("impossible");
                }
            }

            input.close();
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//
//CONST IF LONG
//LONG
//BREAK CONTINUE LONG SHORT WHILE