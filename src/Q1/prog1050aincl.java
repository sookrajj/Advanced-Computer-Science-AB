package Q1;
import java.util.*;
import java.io.*;
import java.text.*;

class SalesRecord {
    public String[] fields;
    public SalesRecord (String[] data) {fields = data; }
    public double getProfit() {return Double.parseDouble(fields[13]); }
    public double getUnitsSold() {return Double.parseDouble(fields[8]); }
}
public class prog1050aincl {
    public static List<SalesRecord> loadSalesData(String filepath) {
        var records = new ArrayList<SalesRecord>();
        try {
            var file = new Scanner(new File(filepath));
            file.nextLine();
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] data = line.split(",");
                records.add(new SalesRecord(data));
            }
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return records;
    }

    public static void main(String[] args) {
        var records = loadSalesData("Langdat/Lang1050.csv");
        if (records != null) {
            var moneyformat = new DecimalFormat("$#,###.00");
            System.out.println("Sales to Europe: " + computeCount(records, 0, "Europe"));
            System.out.println("Cereal bought by Cambodia: " + computeUnitsSold(records, 1, "Cambodia", 2, "Cereal"));
            System.out.println("Total profit on meat: " + moneyformat.format(computeSum(records, 2, "Meat", 13)));
            System.out.println("High priority sales percentage: " + computePercentage(records, 4, "H") + "%");
            System.out.println("Fruit loss in 2012: " + moneyformat.format(computeProfitLostIn2012(records, "Fruits")));
            System.out.println("High priority sales shipped more than 3 days late: " + computeHighPrioLate(records));
            System.out.println("Country with highest profit on Personal Care: " + computeHighestProfit(records, 2, "Personal Care"));
            System.out.println("Region that bought the most snacks: " + computeMaxByField(records, 2, "Snacks", 0));
            System.out.println("Sales to Africa: " + computeCount(records, 0, "Sub-Saharan Africa"));

        }
    }

    public static int computeCount(List<SalesRecord> records, int fIndex, String value) {
        int count = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(value)) {
                count++;
            }
        }

        return count;
    }

    public static int computeCount(List<SalesRecord> records, int fIndex1, String value1,
                                                              int fIndex2, String value2) {
        int count = 0;
        for (var record : records) {
            if (record.fields[fIndex1].equalsIgnoreCase(value1) && record.fields[fIndex2].equalsIgnoreCase(value2)) {
                count++;
            }
        }

        return count;
    }

    public static double computeCountdec(List<SalesRecord> records, int fIndex, String value) {
        return ((double) computeCount(records, fIndex, value) / records.size()) *100;
    }
    public static int computeUnitsSold(List<SalesRecord> records, int fIndex1, String value1) {
        int total = 0;
        for (var record : records) {
            if (record.fields[fIndex1].equalsIgnoreCase(value1)) {
                total += (int) record.getUnitsSold();
            }
        }

        return total;
    }

    public static int computeUnitsSold(List<SalesRecord> records, int fIndex1, String value1,
                                   int fIndex2, String value2) {
        int total = 0;
        for (var record : records) {
            if (record.fields[fIndex1].equalsIgnoreCase(value1) && record.fields[fIndex2].equalsIgnoreCase(value2)) {
                total += (int) record.getUnitsSold();
            }
        }

        return total;
    }
    public static double computeSum(List<SalesRecord> records, int fIndex, String value, int sumfIndex) {
        double  sum= 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(value)) {
                sum += Double.parseDouble(record.fields[sumfIndex]);
            }
        }
        return sum;
    }
    public static double computePercentage(List<SalesRecord> records, int fIndex, String value) {
        double  sum= 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(value)) {
                sum++;
            }
        }
        return sum/5000;
    }

//    public static double ComputeProfitLost(List<SalesRecord> records, String itemType) {
//        double lostProfit = 0;
//
//        for (var record : records) {
//            if (record.fields[2].equalsIgnoreCase(itemType) &&
//                record.fields[5].endsWith("2012")) {
//                lostProfit += Double.parseDouble(record.fields[13]);
//
//            }
//        }
//        return lostProfit;
//    }
    public static double computeProfitLostIn2012(List<SalesRecord> records, String itemType) {
        double lostProfit = 0;
        for (var record : records) {
            if (record.fields[2].equalsIgnoreCase(itemType) &&
                    record.fields[5].endsWith("2012"))
                lostProfit += Double.parseDouble(record.fields[13]);
        }
        return lostProfit;

    }

    public static int computeHighPrioLate(List<SalesRecord> records) {
        int count = 0;
        var dateformat = new SimpleDateFormat("M/d/yyyy");
        for (var record: records) {
            if (record.fields[4].equalsIgnoreCase("H")) {
                try {
                    Date od = dateformat.parse(record.fields[5]);
                    Date sd = dateformat.parse(record.fields[7]);

                    //Calc diff in days between ord and ship
                    long diffInMs = Math.abs(sd.getTime() - od.getTime());
                    long diffInDays = diffInMs / (1000*60*60*24);

                    if (diffInDays > 3) count++;
                } catch (ParseException e) {e.printStackTrace();}
            }
        }

        return count;
    }

    public static String computeHighestProfit(List<SalesRecord> records, int fIndex, String itemType) {
        String highestcountry = "N/A";
        double highpro = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(itemType)) {
                double profit = Double.parseDouble(record.fields[13]);
                if (profit > highpro) {
                    highpro = profit;
                    highestcountry = record.fields[1];
                }
            }
        }

        return highestcountry;
    }

    public static String computeMaxByField(List<SalesRecord> records, int fIndex, String itemType, int resultFIndex) {
        String topRegion = "N/A";
        int maxCount = 0;
        var regions = new ArrayList<String>();

        // get list of unique regions
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(itemType)) {
                String region = record.fields[resultFIndex];
                if (!regions.contains(region)) regions.add(region);
            }
        }

        // count occurrences of each region
        for (var region : regions) {
            int temp = 0;

            for (var record : records) {
                if (record.fields[fIndex].equalsIgnoreCase(itemType) && record.fields[resultFIndex].equalsIgnoreCase(region)) {
                    temp++;
                }
            }
            if (maxCount < temp) {maxCount = temp;
                topRegion = region;
            }
        }

        return topRegion;
    }

    public static void removeKuwait(List<SalesRecord> records) {

        for (int lcv = 0 ; lcv < records.size(); lcv++) {
            if (records.get(lcv).fields[1].equalsIgnoreCase("Kuwait")) {
                records.remove(lcv);
                lcv--;
            }
        }
    }

    public static void limitUganda(List<SalesRecord> records) {

        for (int lcv = 0; lcv < records.size(); lcv++) {
            if (records.get(lcv).fields[1].equalsIgnoreCase("Uganda")) {
                String reg = records.get(lcv).fields[0];
                String cou = records.get(lcv).fields[0];
                String type = records.get(lcv).fields[0];
                String sales = records.get(lcv).fields[0];
                String ordp = records.get(lcv).fields[0];
                String od = records.get(lcv).fields[0];
                String oID = records.get(lcv).fields[0];
                String sd = records.get(lcv).fields[0];
                int units = 100;
                String rege = records.get(lcv).fields[0];

                double cost = Double.parseDouble(records.get(lcv).fields[10]);
            }
        }
    }
}

