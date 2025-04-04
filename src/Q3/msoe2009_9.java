package Q3;

import DataStructures.CircularLinkedList;
import DataStructures.Dictionary;
import DataStructures.Set;
import com.sun.security.jgss.GSSUtil;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class msoe2009_9 {
    public static class container {
        int per;
        int[] connections;
        boolean[] used;

        public container(int per, int num) {
            this.per = per;
            connections = new int[num];
            used = new boolean[num];
        }

        public void add(int con) {
            int pos = 0;
            while (connections[pos] != 0) {
                pos++;
            }
            connections[pos] = con;
            used[pos] = false;
        }
        public int[] getConnections() {return connections; }
        public boolean[] getUsed() {return used;}
        public int getPer() {return per;}
        public void setUsed(boolean[] use) {used = use;}
        public void reset() {Arrays.fill(used, false);}
    }
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/seperation1.txt"));
            var num = input.nextInt();
            var people = new ArrayList<container>();
            for (int i = 0; i < num; i++) {
                people.add(new container(i, num));
            }
            while (input.hasNext()) {
                var per1 = input.nextInt();
                var per2 = input.nextInt();
                for (container t : people) {
                    if (t.per == per1) t.add(per2);
                    if (t.per == per2) t.add(per1);
                }
            }
            input.close();

            var user = new Scanner(System.in);
            System.out.println("Who do you want to find the distance of connection with? ");
            var find1 = user.nextInt();
            System.out.println(" And? ");
            var find2 = user.nextInt();
            System.out.println();
            int steps = find(people, find1, find2, 0);
            System.out.println("The amount of steps to the connection is " + (steps == -1 ? "infinite " : steps) + " steps");



        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }

    public static int find(ArrayList<container> persons, int start, int target, int num) {
        if (num > 10) return -1;
        for (int i = 0; i <persons.get(start).connections.length; i++) {
            for (int t : persons.get(start).connections) {
                System.out.println(t + " ");
            }
            System.out.println(persons.get(start).connections[i] + " " + target);
            if (persons.get(start).connections[i] == target) return 1;
            if (persons.get(start).used[i] == false) {
                persons.get(start).used[i] = true;
                return 1 + find(persons, persons.get(start).connections[i], target, num+1);
            }
        }
        return -1;
    }
}
