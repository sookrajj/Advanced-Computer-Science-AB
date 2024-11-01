package Q1;

import DataStructures.Queue;
import DataStructures.QueueStack;
import DataStructures.Stack;

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
            var file = new Scanner(new File("Langdat/bginvtry.txt"));
            var file2 = new Scanner(new File("Langdat/buysell.txt"));
            var stack = new QueueStack<filler>();
            var size = 0;
            while (file.hasNext()) {
                var type = file.nextInt();
                var units = file.nextInt();
                var cost = file.nextDouble();
                var totalcost = units*cost;
                stack.push(new filler(type, units, cost, totalcost));
                size++;
                System.out.println(type + " " + units + " " + cost);
            }
            file.close();
            System.out.println(stack);
            var num = 0;
            var temp = new QueueStack<filler>();
            while (file2.hasNext()) {
                var let = file2.next();
                System.out.println(num);
                if (let.equalsIgnoreCase("B")) {
                    var type = file2.nextInt();
                    var units = file2.nextInt();
                    var cost = file2.nextDouble();
                    var total = units*cost;
                    newprog1071h.filler fill = null;
                    while (stack.isEmpty()) {
                        var t = stack.pop();
                        System.out.println(t);
                        if (t.getType() == type) {
                            fill = new filler(type, t.getUnits()+units, t.getCost()+cost, t.getTotal()+total);
                            System.out.println("hi " + fill);
                            stack.push(fill);
                            System.out.println(stack.isEmpty());
                            break;
                        } else {
                            temp.push(t);
                        }
                        System.out.println(stack.isEmpty());
                        System.out.println("ley");
                    }
                    while (!temp.isEmpty()) {
                        var t = temp.pop();
                        stack.push(t);
                        System.out.println("while " + t.getType());
                    }
                    System.out.println();
                } else if (let.equalsIgnoreCase("S")){
                    var type = file2.nextInt();
                    var units = file2.nextInt();
                    newprog1071h.filler fill = null;
                    while (stack.isEmpty()) {
                        var t = stack.pop();
                        if (t.getType() == type) {
                            fill = new filler(type, t.getUnits()-units, t.getCost(), t.getTotal());
                            System.out.println("hi " + fill.getType());
                            stack.push(fill);
                            System.out.println(stack);
                            break;
                        } else {
                            temp.push(stack.pop());

                        }
                    }
                    System.out.println(stack + " " + temp);
                    while (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }
                    System.out.println(size);
                }
                num++;
            }

            filler[] print = new filler[10];
            temp = new QueueStack<filler>();
            for (int lcv = 0; lcv < size; lcv++) {
                var t = stack.pop();
                for (int lc = 0; lc < 10; lc++) {
                    if (t.getType() == lcv+1) {
                        print[lcv] = t;
                        break;
                    } else {
                        temp.push(t);
                        t = temp.pop();
                    }

                }

            }
            System.out.println(print[0]);
            for (filler l : print) {
                System.out.println(l.getType() + " " + l.getUnits() + " " + l.getCost() + " " + l.getTotal());
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
