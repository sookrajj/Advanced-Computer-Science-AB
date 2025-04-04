package Q1;

import DataStructures.QueueStack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog1071h {
    public static class filler implements Comparable<filler> {
        private String type;
        private Double value;
        private Integer code;
        private Double total;

        public filler(String type, Double hours, Integer code, Double  total) {
            this.type = type; this.value = hours; this.code = code; this.total = total;
        }

        public Double getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public Integer getCode() {
            return code;
        }

        public Double getTotal() {
            return total;
        }
        public void addTotal(double num) {total += num;}

        @Override
        public int compareTo(filler o) {
            return 0;
        }
    }
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/bginvtry.txt"));
            var type = new QueueStack<String>();
            var number = new QueueStack<Integer>();
            var value = new QueueStack<Double>();
            var size = 0;
            while (input.hasNext()) {
                type.push(input.next());
                number.push(input.nextInt());
                value.push(input.nextDouble());
                size++;
                System.out.println(type.peek() + " " + number.peek() + " " + value.peek());
            }
            input.close();

            input = new Scanner(new File("Langdat/buysell.txt"));
            while (input.hasNext()) {
                var let = input.next();
                if (let.equals("S")) {
                    type.push(input.next());
                    number.push(-1*input.nextInt());
                    value.push(0.0);
                    size++;
                } else if (let.equals("B")) {
                    type.push(input.next());
                    number.push(input.nextInt());
                    value.push(input.nextDouble());
                    size++;
                }
            }
            input.close();
            var list = new QueueStack<filler>();
            var tep = value.pop();
            var tem = number.pop();
            list.push(new filler(type.pop(), tep, tem, (tep*tem)));
            int lsize = 1;
            while (!type.isEmpty()) {
                var ty = type.pop();
                var num = number.pop();
                var val = value.pop();
                var tot = num*val;
                boolean did = true;
                var place = 0;
                var hold = new QueueStack<filler>();
                for (int lcv = 0; lcv < lsize; lcv++) {
                    if (list.peek().getType().equalsIgnoreCase(ty)) {
                        did = !did;
                        var temp = list.pop();
                        lsize--;
                        var nn = temp.getCode() + num;
                        var nv = val + temp.getValue();
                        tot = temp.getTotal();
                        hold.push(new filler(temp.getType(), nv, nn, tot));
                    } else {
                        var temp = list.pop();
                        lsize--;
                        hold.push(temp);
                        place++;
                    }
                }
                if (did) {
                    list.push(new filler(ty, val, num, tot));
                    lsize++;
                    size++;
                }
                while (!hold.isEmpty()) {
                    list.push(hold.pop());
                    lsize++;
                }
            }
            for (int lcv = 0; lcv < lsize; lcv++) {
                var temp = list.pop();
                System.out.print(temp.getType() + " " + temp.getValue() + " " + temp.getCode() + " " + temp.getTotal());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//5 489.75 20 9795.0
//6 586.24 5 2931.2
//7 84.23 30 2526.9
//8 24.73 600 14838.0
//9 19.99 1500 29984.999999999996
//10 238.99 15 3584.8500000000004
//5 0.0 -10 -0.0
//10 0.0 -6 -0.0
//10 250.0 15 3750.0
//5 0.0 -8 -0.0
//5 510.25 20 10205.0
//1 1298.0 20 64900.0
//9 0.0 -500 -0.0
//3 0.0 -28 -0.0
//2 107.5 30 5375.0
//1 1305.75 25 32643.75
