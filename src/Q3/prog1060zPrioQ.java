package Q3;

import DataStructures.PriorityQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Job implements Comparable<Job> {
    public int job;
    public char prio;
    public Job(int job, char prio) {
        this.job = job;
        this.prio = prio;
    }

    public String toString() {return prio + "" + job ;}

    @Override
    public int compareTo(Job o) {
        if (this.prio != o.prio) {
            return Character.compare(this.prio, o.prio);
        } else {
            return Integer.compare(this.job, o.job);
        }
    }
}

public class prog1060zPrioQ {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prg1060z.dat"));
            var pq = new PriorityQueue<Job>(true);

            while (input.hasNext()) {
                var line = input.next();
                char command = line.charAt(0);
                if (command == 'W') {

                } else if (command == 'P') {
                    if (!pq.isEmpty()){
                        pq.dequeue();
                    } else {
                        System.out.println("pq is broke");
                    }
                } else {
                    char prio = line.charAt(1);
                    int job = Integer.parseInt(line.substring(2));
                    pq.enqueue(new Job(job, prio));
                }
            }
            input.close();
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
