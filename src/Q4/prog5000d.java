package Q4;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Algorithms.GraphAlgorithms;
import DataStructures.*;

public class prog5000d {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog5000d.txt"));
            var vd = new Dictionary<String, String>();
            var graph = new GraphList<String>();

            boolean fe = false;
            input.nextLine();
            while (input.hasNextLine()) {
                var line = input.nextLine();
                if (line.equals("Edges:")) {
                    fe = true;
                    continue;
                }
                var parts = line.split("\t");
                if (!fe) {
                    graph.addVertex(parts[0]);
                    vd.insert(parts[0], parts[1]);
                } else {
                    graph.addEdge(parts[0], parts[1]);
                }
            }
            input.close();

            graph.display();

            var dists = GraphAlgorithms.shortestPath(graph, "A");
            var closest = "";
            int minDist = Integer.MAX_VALUE;
            for (var entry : dists.entrySet()) {
                if (entry.value < minDist && ! entry.key.equals("A") && !entry.key.startsWith("T")) {
                    minDist = entry.value;
                    closest = entry.key;
                }
            }

            System.out.printf("Closest city to %s: %s", vd.get("A"), vd.get(closest));
            System.out.printf("\nDistances from %s", vd.get("A"));
            System.out.println();
            for (var entry : dists.entrySet()) {
                if (! entry.key.equals("A") && !entry.key.startsWith("T")) {
                    System.out.println(vd.get(entry.key) + " -> " + entry.value);
                }
            }


        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
