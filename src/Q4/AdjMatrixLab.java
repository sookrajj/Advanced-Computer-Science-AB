package Q4;

import java.util.Arrays;
import DataStructures.Dictionary;
import DataStructures.GraphMatrix;

public class AdjMatrixLab {
    public static <T extends Comparable<T>> void colorGraph(GraphMatrix<T> graph) {
        int vCount = graph.getVertCount();
        int[][] matrix = graph.getMatrix();
        Dictionary<T, Integer> verts = graph.getVertices();

        int[] result = new int[vCount];
        Arrays.fill(result, -1);
        result[0] = 0;
        boolean[] available = new boolean[vCount];

        for (int i = 1; i < vCount; i++) {
            Arrays.fill(available, true);
            for (int j = 0; j < vCount; j++) {
                if (matrix[i][j] != 0 && result[j] != -1) {
                    available[result[j]] = false;
                }
            }
            int color;
            for (color = 0; color < vCount; color++) {
                if (available[color]) break;
            }
            result[i]  = color;
        }

        System.out.println("Vertex Colors: ");
        for (int i = 0; i < vCount; i++) {
            System.out.println("Vertex " + verts.getKey(i) + " --> Color " + result[i]);
        }
    }

    public static void main(String[] args) {
        var graph = new GraphMatrix<String>(6);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "B");
        graph.addEdge("D", "B");
        graph.addEdge("F", "B");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "F");

        graph.display();
        System.out.println();
        colorGraph(graph);
    }
}
