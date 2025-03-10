package Q3;

import DataStructures.Dictionary;
import Q1.prog285b.Cl285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog285BMap {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog285b.dat"));
            var map = new Dictionary<Integer, Cl285b>();

            System.out.println("Id\tCode\tSales\tCommission");
            while (input.hasNext()) {
                var id = input.nextInt();
                var code = input.nextInt();
                var sales = input.nextDouble();

                var fred = new Cl285b(id, code, sales);
                map.insert(id, fred);
            }
            input.close();

            var iter = map.valueBag().iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
