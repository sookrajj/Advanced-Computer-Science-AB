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
    public static double proloss = 0;
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
            removeKuwait(records);
            limitUganda(records);
            ridAfricalowprio(records);
            System.out.println("Profit lost in trade war: " + moneyformat.format(proloss));
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
                proloss += Double.parseDouble(records.get(lcv).fields[13]);
                records.remove(lcv);
                lcv--;
            }
        }
    }

    public static void limitUganda(List<SalesRecord> records) {

        for (int lcv = 0; lcv < records.size(); lcv++) {
            if (records.get(lcv).fields[1].equalsIgnoreCase("Uganda")) {
                proloss += Double.parseDouble(records.get(lcv).fields[13]);
                String reg = records.get(lcv).fields[0];
                String cou = records.get(lcv).fields[1];
                String type = records.get(lcv).fields[2];
                String sales = records.get(lcv).fields[3];
                String ordp = records.get(lcv).fields[4];
                String od = records.get(lcv).fields[5];
                String oID = records.get(lcv).fields[6];
                String sd = records.get(lcv).fields[7];
                String u = "100";
                String up = records.get(lcv).fields[9];
                String uc = records.get(lcv).fields[10];
                String ac = records.get(lcv).fields[11];
                String am = records.get(lcv).fields[12];
                String ap = records.get(lcv).fields[13];
                double newtr = 100 * Double.parseDouble(up);
                double newtc = (100 * Double.parseDouble(uc));
                double newtp = newtr - newtc;
                proloss -= newtp;
                String[] newrec = new String[] {reg, cou, type, sales, ordp, od, oID, sd, u, uc, up, String.valueOf(newtr), String.valueOf(newtc), String.valueOf(newtp)};
                records.set(lcv, new SalesRecord(newrec));
            }
        }
    }

    public static void ridAfricalowprio(List<SalesRecord> records) {
        for (int lcv = 0; lcv < records.size(); lcv++) {
            if (records.get(lcv).fields[0].equalsIgnoreCase("Sub-Saharan Africa")) {
                if (records.get(lcv).fields[4].equalsIgnoreCase("L")) {
                    proloss += Double.parseDouble(records.get(lcv).fields[13]);
                    records.remove(lcv);
                    lcv--;
                }
            }
        }
    }
}

//Sales to Europe: 129286
//Cereal bought by Cambodia: 1164596
//Total profit on meat: $11,933,838,488.00
//High priority sales percentage: 24.9974%
//Fruit loss in 2012: $67,345,418.37
//High priority sales shipped more than 3 days late: 115166
//Country with highest profit on Personal Care: Iceland
//Region that bought the most snacks: Sub-Saharan Africa
//Sales to Africa: 130422
//Profit lost in trade war: $14,641,080,493.77