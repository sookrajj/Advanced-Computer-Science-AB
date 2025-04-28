package Algorithms;

import DataStructures.*;

@SuppressWarnings("unchecked")
public class GraphAlgorithms {
    public static <T extends Comparable<T>> Dictionary<T, Integer> shortestPath(Graph<T> g, T start) {
        return shortestPath(g, start, start, false);
    }

    public static <T extends Comparable<T>> Dictionary<T, Integer> shortestPath(Graph<T> g, T start, T goal) {
        return shortestPath(g, start, goal, true);
    }
    // Dijkstra's Algorithm

    public static <T extends Comparable<T>> Dictionary<T, Integer> shortestPath(Graph<T> g, T start, T goal, Boolean display) {
        if (!g.hasVertex(start) || !g.hasVertex(goal)) {
            System.out.println("Invalid Start or Goal Vertex");
            return new Dictionary<>();
        }

        PriorityQueue<Tuple> queue = new PriorityQueue<>(true);
        Dictionary<T, Integer> dists = new Dictionary<>();
        Dictionary<T, T> prev = new Dictionary<>();

        for (T v : g.getVertices().keySet()) {
            dists.insert(v, Integer.MAX_VALUE);
        }
        dists.insert(start, 0);
        queue.enqueue(new Tuple(start, 0));

        while (!queue.isEmpty()) {
            Tuple current = queue.dequeue();
            T curvert = (T) current.get(0);
            int curd = (int) current.get(1);

            if (curd > dists.get(curvert)) continue;
            for (T neigh : g.getNeighbors(curvert)) {
                int weight = g.getEdgeWeight(curvert, neigh);
                int nd = curd + weight;
                if (nd < dists.getOrDefault(neigh, Integer.MAX_VALUE)) {
                    dists.insert(neigh, nd);
                    prev.insert(neigh, curvert);
                    queue.enqueue(new Tuple(neigh, nd));
                }
            }
        }

        if (!prev.containsKey(goal)) {
            if (display)
                System.out.println("No path found");
            return dists;
        }

        if (display) {
            reconstructPath(prev, goal);
            System.out.println("\nTotal cost: " + dists.get(goal));
        }

        return dists;
    }

    static <T extends Comparable<T>> void reconstructPath(Dictionary<T, T> cameFrom, T current) {
        if (current == null) return;
        if (cameFrom.containsKey(current)) {
            reconstructPath(cameFrom, cameFrom.get(current));
            System.out.print(" -> ");
        }
        System.out.println(current);
    }
}
