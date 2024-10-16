package Q1.msoe;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class msoe_2007_9 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/problem9.dat"));
            int num = 0;
            var histo = new int[5];

            while (input.hasNext()) {
                num = input.nextInt();
                if (num < 2) histo[0]++;
                else if (num < 4) histo[1]++;
                else if (num < 6) histo[2]++;
                else if (num < 8) histo[3]++;
                else if (num < 10) histo[4]++;
            }
            input.close();
            for (int lcv = 0; lcv < histo.length; lcv++) {
                System.out.print(lcv*2 + " - " + lcv*2+1 + " ");
                while (histo[lcv] != 0) {
                    System.out.print("*");
                    histo[lcv]--;
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
