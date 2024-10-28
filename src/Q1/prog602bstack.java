package Q1;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class prog602bstack {

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
            var stack = new Stack<filler>();
            while (input.hasNext()) {
                filler temp = new filler(input.nextInt(), input.nextDouble(), input.nextInt());
                stack.add(temp);
            }
            input.close();
            System.out.println("Account Number\tHours Used\tPriority code\tAmount Due");
            for (int lcv = 0; lcv < stack.size(); lcv++) {
                int acc = stack.get(lcv).getAcc();
                double hours = stack.get(lcv).getHours();
                int code = stack.get(lcv).getCode();
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
//Account Number	Hours Used	Priority code	Amount Due
//1825			3.25			0			200.0
//14063			17.06			1			661.8
//17185			7.93			1			396.5
//19111			12.0			2			700.0
//20045			5.0			1			250.0
//21352			5.84			0			242.0
//22841			27.9			2			1087.0
//23051			1.55			2			350.0
//29118			15.02			0			550.6