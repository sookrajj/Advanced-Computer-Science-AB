package Q2;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog602bqueue {
    public static class filler implements Comparable<filler>{
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

        @Override
        public int compareTo(filler o) {
            return o.acc.compareTo(acc);
        }
    }
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog602b.dat"));
            Queue<filler> queue = new PriorityQueue<>();
            while (input.hasNext()) {
                filler temp = new filler(input.nextInt(), input.nextDouble(), input.nextInt());
                queue.add(temp);
            }
            input.close();
            var size = queue.size();
//            var temp = new PriorityQueue<filler>();
            System.out.println("Account Number\tHours Used\tPriority code\tAmount Due");
            for (int lcv = 0; lcv < size; lcv++) {
                var l = queue.remove();
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

//            while (!temp.isEmpty()) {
//                var t = temp.remove();
//                int acc = t.getAcc();
//                double hours = t.getHours();
//                int code = t.getCode();
//                double amd = 0;
//                if (hours <= 5.00) {
//                    amd = 200.0;
//                } else if (hours <= 15.00) {
//                    amd = 200.0 + (hours-5.0) * 50.0;
//                } else {
//                    amd = 550.0 + (hours-15.0) * 30.0;
//                }
//                if (code == 1) {
//                    amd += 50.0;
//                } else if (code == 2) {
//                    amd += 150.0;
//                }
//                System.out.println(t.acc + "\t\t\t" + t.hours + "\t\t\t" + t.code + "\t\t\t" + t.amd);
//            };

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//Account Number	Hours Used	Priority code	Amount Due
//29118			15.02			0			550.6
//23051			1.55			2			350.0
//22841			27.9			2			1087.0
//21352			5.84			0			242.0
//20045			5.0			1			250.0
//19111			12.0			2			700.0
//17185			7.93			1			396.5
//14063			17.06			1			661.8
//1825			3.25			0			200.0