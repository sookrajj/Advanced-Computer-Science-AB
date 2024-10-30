package Q1;

import DataStructures.QueueStack;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class newprog1071h {
    public static class filler implements Comparable<newprog1071h.filler> {
        private Integer type;
        private Integer units;
        private Double cost;
        private Double total;

        public filler(Integer type, Integer units, Double cost, Double  total) {
            this.type = type; this.units = units; this.cost = cost; this.total = total;
        }

        public Double getCost() {
            return cost;
        }

        public Integer getType() {
            return type;
        }

        public Integer getUnits() {
            return units;
        }

        public Double getTotal() {
            return total;
        }
        public void addTotal(double num) {total += num;}

        @Override
        public int compareTo(newprog1071h.filler o) {
            return 0;
        }
    }
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/bginvtry.dat"));
            var file2 = new Scanner(new File("Langdat/bginvtry.dat"));
            var queue = new QueueStack<filler>();
            while (file.hasNext()) {
                var type = file.nextInt();
                var units = file.nextInt();
                var cost = file.nextDouble();
                var totalcost = units*cost;
                queue.push(new filler(type, units, cost, totalcost));
            }
            file.close();

            while (file2.hasNext()) {
                var let = file2.next();
                if (let.equalsIgnoreCase("B")) {
                    var type = file2.nextInt();
                    var units = file2.nextInt();
                    var cost = file.nextDouble();
                    var total = units*cost;
                    var temp = queue;
                    var check = 0;
                    newprog1071h.filler fill = null;
                    for (int l = 0; l < queue.size(); l++) {
                        var t = temp.pop();
                        if (t.getType() == type) {
                            fill = new filler(type, t.getUnits()+units, t.getCost()+cost, t.getTotal()+total);
                            System.out.println(check + " " + fill);
                            temp.push(fill);
                        } else {
                            temp.pop();

                        }
                        check++;
                    }
                    for (int lcv = check; lcv < queue.size(); lcv++) {
                        temp.push(queue.pop());
                    }
                    queue = temp;
                } else if (let.equalsIgnoreCase("S")){
                    var type = file2.nextInt();
                    var units = file2.nextInt();
                }
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
