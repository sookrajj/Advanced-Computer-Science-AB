package Q3;

import DataStructures.heap;

public class heaplab {
    public static void main(String[] args) {
        var rand = new java.util.Random();
        var heap = new heap<Integer>(true);
        for (int i = 0; i < 50; i++) {
            heap.insert(rand.nextInt(100));
        }
        System.out.println("Delete: " + heap.deleteMin());
        System.out.println("Peak: " + heap.peak());
        while (!heap.isEmpty()) {
            System.out.println(heap.deleteMin() + " ");
        }
        System.out.println("\n");

        var mheap = new heap<Integer>(false);
        for (int i = 0; i < 50; i++) {
            mheap.insert(rand.nextInt(100));
        }
        System.out.println("Delete: " + mheap.deleteMin());
        System.out.println("Peak: " + mheap.peak());
        while (!mheap.isEmpty()) {
            System.out.println(mheap.deleteMin() + " ");
        }
        System.out.println("\n");
    }
}
