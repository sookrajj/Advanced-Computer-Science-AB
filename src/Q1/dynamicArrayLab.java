package Q1;
import java.util.*;
import DataStructures.dynamicArray;

public class dynamicArrayLab {
    public static void main(String[] args) {
        System.out.println("============== Dynamic Array ===============");
        var dArray = new dynamicArray<Integer>();
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            dArray.add(i);
        }
        long end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            dArray.remove(0);
        }
        end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        dArray.sort();
        end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms");

        //TODO: check against ArrayList
        System.out.println("============== ArrayList ===============");
        var rray = new ArrayList<Integer>();
        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            rray.add(i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList add: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            rray.remove(0);
        }
        end = System.nanoTime();
        System.out.println("ArrayList add: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        rray.sort(null);
        end = System.nanoTime();
        System.out.println("ArrayList add: " + (end-start)/1e6 + " ms");

    }
}
//============== Dynamic Array ===============
//Dynamic Array add: 6.0502 ms
//Dynamic Array add: 14428.2932 ms
//Dynamic Array add: 0.5217 ms
//============== ArrayList ===============
//ArrayList add: 4.5156 ms
//ArrayList add: 403.8685 ms
//ArrayList add: 0.1632 ms