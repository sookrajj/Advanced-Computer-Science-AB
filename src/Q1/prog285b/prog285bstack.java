package Q1.prog285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class prog285bstack {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog285b.dat"));
            var stack = new Stack<Cl285b>();

            System.out.println("Id\tCode\tSales\tCommission");
            while (input.hasNext()) {
                var id = input.nextInt();
                var code = input.nextInt();
                var sales = input.nextDouble();

                var fred = new Cl285b(id, code, sales);
                stack.push(fred);
            }
            input.close();

            while (!stack.isEmpty()) {
                var fred = stack.pop();
                System.out.println(fred);
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
