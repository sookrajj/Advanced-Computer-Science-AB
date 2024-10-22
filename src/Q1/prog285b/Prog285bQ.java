package Q1.prog285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataStructures.Queue;


public class Prog285bQ {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog285b.dat"));
            var queue = new Queue<Cl285b>();

            System.out.println("Id\tCode\tSales\tCommission");
            while (input.hasNext()) {
                var id = input.nextInt();
                var code = input.nextInt();
                var sales = input.nextDouble();

                var fred = new Cl285b(id, code, sales);
                queue.enqueue(fred);
            }
            input.close();

            while (!queue.isEmpty()) {
                var fred = queue.dequeue();
                System.out.println(fred);
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//Id	Code	Sales	Commission
//101	17	$2250.00	$213.75
//103	5	$4000.00	$300.00
//117	3	$7350.00	$0.00
//118	8	$7350.00	$551.25
//125	5	$6500.00	$487.50
//138	17	$6375.00	$677.50
//192	8	$8125.00	$609.38
//203	8	$3250.00	$243.75
//218	5	$5000.00	$375.00
//235	5	$5250.00	$393.75
//264	17	$4150.00	$410.50
//291	17	$750.00	$71.25