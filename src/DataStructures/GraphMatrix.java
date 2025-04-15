package DataStructures;

public class GraphMatrix<T extends Comparable<T>> implements Graph<T>{
    private final Dictionary<T, Integer> verts;
    private final int[][] matrix;
    private int vertCount;

    public GraphMatrix(int size) {
        verts = new Dictionary<>();
        matrix = new int[size][size];
        vertCount = 0;
    }
    public void addVertex(T vertex) {
        if (!verts.contains(vertex)) verts.insert(vertex, vertCount++);
    }

    public void addEdge(T source, T destination) {addEdge(source, destination, 1);}
    public void addEdge(T source, T destination, int weight) {
        int sourceIndex = verts.get(source);
        int destIndext = verts.get(destination);
        matrix[sourceIndex][destIndext] = weight;
        matrix[destIndext][sourceIndex] = weight;
    }

    public void addDirectedEdge(T source, T destination) {addDirectedEdge(source, destination, 1);}
    public void addDirectedEdge(T source, T destination, int weight) {
        int sourceIndex = verts.get(source);
        int destIndext = verts.get(destination);
        matrix[sourceIndex][destIndext] = weight;
    }

    public void removeVertex(T vertex) {
        if (!verts.contains(vertex)) return;
        int index = verts.get(vertex);
        for(int i = 0; i < vertCount; i++) {
            matrix[i][index] = 0;
            matrix[index][i] = 0;
        }
        verts.remove(vertex);
        vertCount--;
    }

    public void removeEdge(T source, T destination) {
        int sourceIndex = verts.get(source);
        int destIndext = verts.get(destination);
        matrix[sourceIndex][destIndext] = 0;
        matrix[destIndext][sourceIndex] = 0;
    }

    public void removeDirectedEdge(T source, T destination) {
        int sourceIndex = verts.get(source);
        int destIndext = verts.get(destination);
        matrix[sourceIndex][destIndext] = 0;
    }

    public boolean hasVertex(T vertex) {
        return verts.contains(vertex);
    }

    public boolean hasEdge(T source, T destination) {
        int sourceIndex = verts.get(source);
        int destIndext = verts.get(destination);
        return matrix[sourceIndex][destIndext] != 0;
    }

    public void display() {
        System.out.println("Vertices: ");
        verts.enumerate();
        System.out.println("Matrix");
        for (int i = 0; i < vertCount; i++) {
            for (int j = 0; j < vertCount; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getEdgeWeight(T source, T destination) {
        int sourceIndex = verts.get(source);
        int destIndext = verts.get(destination);
        return matrix[sourceIndex][destIndext];
    }

    public Dictionary<T, Integer> getVertices() {
        return verts;
    }
    public int[][] getMatrix() {
        return matrix;
    }
    public int getVertCount() {
        return vertCount;
    }

    public dynamicArray<T> getNeighbors(T vertex) {
        dynamicArray<T> neighbors = new dynamicArray<>();
        int index = verts.get(vertex);
        for (int i = 0; i < vertCount; i++) {
            if (matrix[index][i] != 0) {
                neighbors.add(verts.getKey(i));
            }
        }
        return neighbors;
    }



}
