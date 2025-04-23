package Q4;

import DataStructures.Dictionary;
import DataStructures.GraphList;
import DataStructures.GraphMatrix;
import Q1.prog285b.Cl285b;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class prog285bGraph {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog285b.dat"));
            var graph = new GraphMatrix<Cl285b>(12);

            System.out.println("Id\tCode\tSales\tCommission");
            while (input.hasNext()) {
                var id = input.nextInt();
                var code = input.nextInt();
                var sales = input.nextDouble();

                var fred = new Cl285b(id, code, sales);
                graph.addVertex(fred);
            }
            input.close();
            var p = graph.getVertices().keySet();
            var list = new ArrayList<Cl285b>();
            for (var n : p ) list.add(n);
            for (int i = 0; i < 200; i++) {
                int r1 = (int)(Math.random() * p.size());
                int r2 = (int)(Math.random() * p.size());
                if (r1 != r2) graph.addEdge(list.get(r1), list.get(r2));
            }


            graph.display();

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
