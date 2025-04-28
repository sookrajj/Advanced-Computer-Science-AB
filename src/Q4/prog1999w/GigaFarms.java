package Q4.prog1999w;

import DataStructures.LinkedList;

public class GigaFarms {
    public static void main(String[] args) {
        var farms = new LinkedList<Farm>();

        for (int i = 0; i < 5; i++) {
            farms.add(new Farm());
        }

        //region Profit
        double mostProfit = 0;
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (mostProfit < farms.get(i).getProfit()) {
                mostProfit = Math.max(farms.get(i).getProfit(), mostProfit);
                index = i + 1;
            }
        }
        System.out.println("Most Profitable Farm is " + index);
        //endregion Profit
        //region milk
        int pounds = 0;
        for (int i = 0; i < farms.size(); i++) {
            var cows = farms.get(i).getCows();
            var keys = cows.keySet();
            for (int h : keys) {
                pounds += cows.get(h).getMilk();
            }
        }
        System.out.println("Total Milk Produced in Pounds " + pounds);
        //endregion milk
        // region turkey weight
        double weigh = 0;
        for (int i = 0; i < farms.size(); i++) {
            var turks = farms.get(i).getTurks();
            var keys = (Turkey[]) turks.toArray();
            for (Turkey h : keys) {
                weigh += h.weight;
            }
        }
        System.out.println("Total Turkey Weight in Pounds " + weigh);
        //endregion turkey weight
        //region Most expensive per farm

        //endregion Most expensive per farm
    }
}
