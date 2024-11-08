package Q2;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog602bqueue {
    public static class filler {
        private Integer acc;
        private Double hours;
        private Integer code;

        public filler(Integer acc, Double hours, Integer code) {
            this.acc = acc; this.hours = hours; this.code = code;
        }

        public Double getHours() {
            return hours;
        }

        public Integer getAcc() {
            return acc;
        }

        public Integer getCode() {
            return code;
        }
    }
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog602b.dat"));
            var queue = new Queue<filler>();
            while (input.hasNext()) {
                filler temp = new filler(input.nextInt(), input.nextDouble(), input.nextInt());
                queue.add(temp);
            }
            input.close();
            System.out.println("Account Number\tHours Used\tPriority code\tAmount Due");
            for (int lcv = 0; lcv < queue.size(); lcv++) {
                var l = queue.peek();
                int acc = l.getAcc();
                double hours = l.getHours();
                int code = l.getCode();
                double amd = 0;
                if (hours <= 5.00) {
                    amd = 200.0;
                } else if (hours <= 15.00) {
                    amd = 200.0 + (hours-5.0) * 50.0;
                } else {
                    amd = 550.0 + (hours-15.0) * 30.0;
                }
                if (code == 1) {
                    amd += 50.0;
                } else if (code == 2) {
                    amd += 150.0;
                }
                System.out.println(acc + "\t\t\t" + hours + "\t\t\t" + code + "\t\t\t" + amd);
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
