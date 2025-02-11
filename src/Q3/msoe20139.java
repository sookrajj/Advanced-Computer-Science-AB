package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class msoe20139 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/msoe2013cabs.dat"));
            var cabs = new ArrayList<helper>();
            int size = input.nextInt();
            while (input.hasNext()) {
                var x = input.nextDouble();
                var y = input.nextDouble();
                cabs.add(new helper(x, y));
            }
            input.close();
            var people = new Scanner(new File("Langdat/msoe2013passangers.dat"));
            String alp = "ABCDEFGHIJKLMNO";
            int p = people.nextInt();
            for (int i = 0; i < p; i++) {
                var x = people.nextDouble();
                var y = people.nextDouble();
                int closest = 0;
                double dist = cabs.get(closest).dist(x, y);
                for (int s = 0; s < cabs.size(); s++) {
                    if (dist > cabs.get(s).dist(x, y)) {
                        closest = s;
                        dist = cabs.get(s).dist(x, y);
                    }
                }
                System.out.println("Cab " + (size-cabs.size()) + " dispatched to passenger " + alp.charAt(i) + " at city-block distance " + dist);
                cabs.remove(closest);
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }


    }

    static class helper {
        public double x;
        public double y;

        public helper(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double dist(double ox, double oy) {
            return Math.abs(x-ox) + Math.abs(y-oy);
        }
    }
}
//Cab 0 dispatched to passenger A at city-block distance 8.499999999999996
//Cab 1 dispatched to passenger B at city-block distance 6.299999999999997
//Cab 2 dispatched to passenger C at city-block distance 31.60000000000001
//Cab 3 dispatched to passenger D at city-block distance 30.700000000000003
//Cab 4 dispatched to passenger E at city-block distance 17.5
//Cab 5 dispatched to passenger F at city-block distance 94.3
//Cab 6 dispatched to passenger G at city-block distance 101.4
//Cab 7 dispatched to passenger H at city-block distance 11.9
//Cab 8 dispatched to passenger I at city-block distance 91.0
//Cab 9 dispatched to passenger J at city-block distance 172.89999999999998