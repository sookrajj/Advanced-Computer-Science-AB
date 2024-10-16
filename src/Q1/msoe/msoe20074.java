package Q1.msoe;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class msoe20074 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/Replace.dat"));
            var line = "";
            while (input.hasNext()) {
                line = input.nextLine();
                var ind = line.split(" ");
                var house1 = new int[2];
                var house2 = new int[2];
                var num = Integer.parseInt(ind[0]);
                if (ind[1].equalsIgnoreCase("S")) num *= -1;
                house1[0] = num;
                num = Integer.parseInt(ind[2]);
                if (ind[3].equalsIgnoreCase("W")) num *= -1;
                house1[1] = num;
                num = Integer.parseInt(ind[4]);
                if (ind[5].equalsIgnoreCase("S")) num *= -1;
                house2[0] = num;
                num = Integer.parseInt(ind[6]);
                if (ind[7].equalsIgnoreCase("W")) num *= -1;
                house2[1] = num;
                var distance = Math.pow((Math.pow((double)(house1[0]-house2[0]), 2.0) + Math.pow((double)(house1[1]-house2[1]), 2.0)), .5);
                for (String str : ind) {
                    System.out.print(str + " ");
                }
                System.out.println("= " + distance + " miles");
            }
            input.close();
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
