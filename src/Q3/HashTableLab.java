package Q3;

import java.util.LinkedList;

public class HashTableLab {
    static abstract class HashTable<T> {
        protected LinkedList<T>[] table;

        @SuppressWarnings("unchecked")
        public HashTable(int size) {
            table = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new LinkedList<>();
            }
        }

        protected abstract int hash(T key);

        public void insert(T key) {
            int index = hash(key);
            if (!table[index].contains(key)) {
                table[index].add(key);
            }
        }

        public boolean search(T key) {
            int index = hash(key);
            return table[index].contains(key);
        }

        public void display() {
            for (int i = 0; i < table.length; i++) {
                System.out.println("Index " + i + ": " + table[i]);
            }
        }
    }


    static class IntHashTable extends HashTable<Integer> {
        public IntHashTable(int size) {super(size);}

        protected int hash(Integer key) {
            return Math.abs(key) % table.length;
        }
    }

    static class StringHashTable extends HashTable<String> {
        public StringHashTable(int size) {super(size);}

        protected int hash(String key) {
            int hash = 0;
            for(char c : key.toCharArray()) {
                hash = (hash * 31 + c) % table.length;
            }
            return hash;
        }
    }

    public static void main(String[] args) {
        System.out.println("Int hash table:");
        var itable = new IntHashTable(5);
        itable.insert(10);
        itable.insert(15);
        itable.insert(20);
        itable.insert(26);
        itable.insert(30);
        itable.display();
        System.out.println("Has 20: " + itable.search(20));
        System.out.println("Has 50: " + itable.search(50));

        System.out.println("\n\nString hash table:");
        var stable = new StringHashTable(5);
        stable.insert("apple");
        stable.insert("banana");
        stable.insert("orange");
        stable.insert("mango");
        stable.insert("grape");
        stable.display();
        System.out.println("Has orange: " + stable.search("orange"));
        System.out.println("Has starfruit: " + stable.search("starfruit"));
    }

}

//Int hash table:
//Index 0: [10, 15, 20, 30]
//Index 1: [26]
//Index 2: []
//Index 3: []
//Index 4: []
//Has 20: true
//Has 50: false
//
//
//String hash table:
//Index 0: [apple, mango]
//Index 1: [orange]
//Index 2: [grape]
//Index 3: []
//Index 4: [banana]
//Has orange: true
//Has starfruit: false