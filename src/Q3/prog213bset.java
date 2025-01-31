package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataStructures.Set;

public class prog213bset {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("Langdat/prog213b.txt"));
            Set<Integer> set = new Set<>();
            var num = 0;
            while (input.hasNext()) {
                set.insert(input.nextInt());
            }
            input.close();

            var iter = set.iterator();
            while (iter.hasNext()) {
                var amount = iter.next();

                if (amount < 100) {
                    double r = amount * 5.95;
                    System.out.println("Enter quantity: " + amount + "\nPrice: " + 5.95 + "\nAmount due: " + r);
                } else if (amount < 200) {
                    double r = amount * 5.75;
                    System.out.println("Enter quantity: " + amount + "\nPrice: " + 5.75 + "\nAmount due: " + r);
                } else if (amount < 300) {
                    double r = amount * 5.40;
                    System.out.println("Enter quantity: " + amount + "\nPrice: " + 5.40 + "\nAmount due: " + r);
                } else {
                    double r = amount * 5.15;
                    System.out.println("Enter quantity: " + amount + "\nPrice: " + 5.15 + "\nAmount due: " + r);
                }
            }
        } catch (IOException e) {
            System.out.println("Can't find data file.");
        }
    }
}
//Enter quantity: 1
//Price: 5.95
//Amount due: 5.95
//Enter quantity: 42
//Price: 5.95
//Amount due: 249.9
//Enter quantity: 45
//Price: 5.95
//Amount due: 267.75
//Enter quantity: 25
//Price: 5.95
//Amount due: 148.75
//Enter quantity: 48
//Price: 5.95
//Amount due: 285.6
//Enter quantity: 31
//Price: 5.95
//Amount due: 184.45000000000002
//Enter quantity: 92
//Price: 5.95
//Amount due: 547.4
//Enter quantity: 115
//Price: 5.75
//Amount due: 661.25
//Enter quantity: 55
//Price: 5.95
//Amount due: 327.25
//Enter quantity: 15
//Price: 5.95
//Amount due: 89.25
//Enter quantity: 75
//Price: 5.95
//Amount due: 446.25
//Enter quantity: 56
//Price: 5.95
//Amount due: 333.2
//Enter quantity: 16
//Price: 5.95
//Amount due: 95.2
//Enter quantity: 58
//Price: 5.95
//Amount due: 345.1
//Enter quantity: 19
//Price: 5.95
//Amount due: 113.05